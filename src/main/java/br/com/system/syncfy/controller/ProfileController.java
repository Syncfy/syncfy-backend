package br.com.system.syncfy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myProfile")
public class ProfileController {
    @GetMapping
    public String myProfile() {
        return "myProfile";
    }
}
