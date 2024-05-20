package com.example.demo02.controllers;

import com.example.demo02.entities.MonthEntity;
import com.example.demo02.interceptors.MonthInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/month")
@AllArgsConstructor
public class MonthController {

    @GetMapping("/get")
    public Object getMonth(HttpServletRequest request) {
        return request.getAttribute("month");
    }

}