package edu.project.yevhenaudit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping({"/", "home"})
    public String home() {
        return "home";
    }
}
