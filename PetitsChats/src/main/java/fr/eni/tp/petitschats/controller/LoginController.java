package fr.eni.tp.petitschats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("membreSession")

    class LoginController {
        @ModelAttribute ("membreSession")
        @GetMapping("/login")
        String login() {
            return "login";
        }


        @GetMapping("/logout")
        String logout() {return "login";}
}
