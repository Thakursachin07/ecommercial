package com.example.Frontend.service;

import com.example.Frontend.entity.Product;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.List;

@Service
public class AdminService {

    private WebClient webClient;

    AdminService(WebClient.Builder webClientBuilder)
    {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082/product").build();
    }


    public Mono<List<Product>>  getAdminProduct()
    {
        return this.webClient
                .get()
                .uri("/get-all")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList();
    }


    public Mono<Void> saveProduct(Product product, FilePart singleFile, List<FilePart> multipleFiles) {
        String tempDir = System.getProperty("java.io.tmpdir");
        String primaryFilePath = tempDir + File.separator + singleFile.filename();

        // Save the primary file temporarily
        return singleFile.transferTo(new File(primaryFilePath))
                .thenMany(Flux.fromIterable(multipleFiles) // Process multiple files
                        .flatMap(filePart -> {
                            String tempFilePath = tempDir + File.separator + filePart.filename();
                            return filePart.transferTo(new File(tempFilePath))
                                    .thenReturn(tempFilePath); // Return saved file path
                        })
                        .collectList() // Collect all file paths into a List
                )
                .flatMap(tempFilePaths -> {
                    // Set product image details
                    product.setImage(primaryFilePath); // Set single file path
                    product.setImages(String.valueOf(tempFilePaths)); // Set list of file paths

                    // Prepare multipart body
                    MultipartBodyBuilder builder = new MultipartBodyBuilder();
                    builder.part("product", product, MediaType.APPLICATION_JSON);
                    builder.part("file", new FileSystemResource(primaryFilePath), MediaType.APPLICATION_OCTET_STREAM);
                    tempFilePaths.forEach(path ->
                            builder.part("files", new FileSystemResource(path), MediaType.APPLICATION_OCTET_STREAM)
                    );

                    // Send data to backend using WebClient
                    return webClient.post()
                            .uri("/save-product") // Backend API endpoint
                            .contentType(MediaType.MULTIPART_FORM_DATA)
                            .bodyValue(builder.build())
                            .retrieve()
                            .bodyToMono(Void.class)
                            .doFinally(signal -> {
                                // Cleanup temporary files
                                new File(primaryFilePath).delete();
                                tempFilePaths.forEach(path -> new File(path).delete());
                            });
                }).then();
    }



   /* public Mono<Void> saveProduct(Product product, FilePart filePart) {
        // Save the image to a temporary file
        return filePart.transferTo(new java.io.File( filePart.filename()))
                .then(Mono.defer(() -> {
                    // After the file is saved, set the image file name to the product
                    product.setImage(filePart.filename());

                    // Send the product and file to the backend service
                    MultipartBodyBuilder builder = new MultipartBodyBuilder();
                    builder.part("product", product);
                    builder.part("file", new FileSystemResource(filePart.filename()));

                    return webClient.post()
                            .uri("/save-product")
                            .contentType(MediaType.MULTIPART_FORM_DATA)
                            .bodyValue(builder.build())
                            .retrieve()
                            .bodyToMono(Void.class);
                }));
    }*/

    public Mono<Void> deleteAllProducts() {
        return this.webClient
                .delete()
                .uri(uriBuilder -> uriBuilder.path("/delete-all-product")
                        .build())
                .retrieve()
                .bodyToMono(Void.class) // Expect no response body
                .doOnSuccess(unused -> System.out.println(" Cart deleted successfully "))
                .doOnError(error -> System.err.println("Error deleting cart for  " + ": " + error.getMessage()));
    }


public Mono<Void> deleteById(int productId)
{
    return this.webClient
            .delete()
            .uri(uriBuilder -> uriBuilder.path("/delete")
                    .queryParam("productId",productId)
                    .build())
            .retrieve()
            .bodyToMono(Void.class);

}


}
