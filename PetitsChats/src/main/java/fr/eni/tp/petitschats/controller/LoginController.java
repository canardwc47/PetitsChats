package fr.eni.tp.petitschats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



    @Controller
    class LoginController {
        @GetMapping("/login")
        String login() {
            return "login";
        }


        @GetMapping("/logout")
        String logout() {return "login";}
}
