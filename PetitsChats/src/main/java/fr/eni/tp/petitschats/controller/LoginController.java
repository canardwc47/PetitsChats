package fr.eni.tp.petitschats.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller


    class LoginController {
        protected final Log logger = LogFactory.getLog(getClass());
        @GetMapping("/login")
        String login() {
            logger.info("Affichage du formulaire de login");
            return "login";
        }


        @GetMapping("/logout")
        String logout() {return "login";}
}
