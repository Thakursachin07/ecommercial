package com.example.Frontend.controller;

//import com.example.Frontend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/payment")
public class PaymentController {
/*

    @Autowired
    private PaymentService paymentService;
*/

    @GetMapping("/")
    public String paymentForm()
    {

        return "paymentForm";
    }



   /* @GetMapping("/create-checkout-session")
    public String createCheckoutSession(@RequestParam String productName, @RequestParam long amount) {
        try {
            String successUrl = "http://localhost:8080/payment-success";
            String cancelUrl = "http://localhost:8080/payment-cancel";

            String checkoutUrl = paymentService.createCheckoutSession(productName, amount, "usd", successUrl, cancelUrl);
            return "redirect:" + checkoutUrl;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }*/
}
