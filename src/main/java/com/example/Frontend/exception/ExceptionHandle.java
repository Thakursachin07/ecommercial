package com.example.Frontend.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    private String exception(Exception ex , Model model)
    {
        model.addAttribute("exception",ex);
        return "Exception";
    }
}
