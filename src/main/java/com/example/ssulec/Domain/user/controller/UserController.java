package com.example.ssulec.Domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    String one() {
        return "redirect:/";
    }
}
