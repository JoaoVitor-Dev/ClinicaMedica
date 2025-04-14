package com.ifto.clinicamedica.controller;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
