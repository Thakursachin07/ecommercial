package com.ecom_project_backend.controller;

import com.ecom_project_backend.entity.DeliveryAddress;
import com.ecom_project_backend.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery-address")
public class DeliveryAddressController {

    @Autowired
   private DeliveryAddressService deliveryAddressService;



    @GetMapping("/get-all-delivery-address")
    public List<DeliveryAddress> getAllDeliveryAddress()
    {
        return deliveryAddressService.getALlDeliveryAddress();}



    @GetMapping("/get-delivery-address")
    public DeliveryAddress getDeliveryAddressById( @RequestParam int id)
    {
        return deliveryAddressService.getDeliveryAddressById(id);}


    @PutMapping("/update-address")
    public  DeliveryAddress updateAddress(@RequestParam int id,@RequestBody DeliveryAddress deliveryAddress)
    {
        return deliveryAddressService.updateAddress(deliveryAddress,id);
    }

    @PostMapping("/add-address")
    public  DeliveryAddress deliveryAddressCreate(@RequestBody DeliveryAddress deliveryAddress)
    {
        return  deliveryAddressService.deliveryAddressCreate(deliveryAddress);
    }

    @DeleteMapping
    public void  deleteDeliveryAddressById(int id)
    {
        deliveryAddressService.deleteDeliveryAddressById(id);
    }



}
