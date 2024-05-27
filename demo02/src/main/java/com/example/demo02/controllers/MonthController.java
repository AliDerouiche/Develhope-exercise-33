package com.example.demo02.controllers;

import com.example.demo02.entities.MonthEntity;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/month")
@AllArgsConstructor
public class MonthController {

    @GetMapping("/get")
    public ResponseEntity<MonthEntity> getMonth(HttpServletRequest request) {
        MonthEntity month = (MonthEntity) request.getAttribute("month");
        return ResponseEntity.ok(month);
    }


}