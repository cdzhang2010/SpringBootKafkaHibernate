package com.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Get error status code
        Object status = request.getAttribute("javax.servlet.error.status_code");

        // Handle different error codes and set appropriate messages
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == 404) {
                model.addAttribute("errorMsg", "Page not found");
            } else if (statusCode == 500) {
                model.addAttribute("errorMsg", "Internal server error");
            } else {
                model.addAttribute("errorMsg", "Something went wrong");
            }
        }
        return "error/error"; // Redirect to your custom error page
    }

   
    public String getErrorPath() {
        return "/error";
    }

}
