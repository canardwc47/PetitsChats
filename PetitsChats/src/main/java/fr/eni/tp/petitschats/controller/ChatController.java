package fr.eni.tp.petitschats.controller;

import fr.eni.tp.petitschats.bll.ChatService;
import fr.eni.tp.petitschats.bo.Chat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@SessionAttributes("membreSession")

public class ChatController {

    private Chat chat;
    private ChatService chatService;


    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    public String Home(Model model) {
        return "Index";
    }

    @GetMapping("/liste")
    public String afficherChats(Model model) {
        var chats = chatService.getChats();
        model.addAttribute("chats", chats);
        return "Liste";
    }

    @GetMapping("/detail")
    public String afficherUnChat(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("chat", new Chat());
        model.addAttribute("chat", chatService.getChatbyID(id));

        return "detail";
    }

    @GetMapping("/creer")
    public String creerunChat(Model model) {
        model.addAttribute("chat", new Chat());
        return "creer";
    }


    @PostMapping("/creer")
    public String newChat(@ModelAttribute Chat chat, Model model) {
        chatService.addChat(chat);
        System.out.println(chat);
        System.out.println(model);
        return "redirect:/liste";
    }

    @PostMapping("/delete")
    public String deleteChat(@RequestParam(name = "id") int id) {
        chatService.removeChat(id);
        return "redirect:/liste";
    }

    @GetMapping("/modifier")
    public String getmodifyChat(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("chat", new Chat());
        model.addAttribute("chat", chatService.getChatbyID(id));

        return "Modifier";
    }

   @PostMapping("/modifier")
    public String modifyChat(@RequestParam(name = "id") int id, @ModelAttribute Chat chat) {
        var chatModif = chatService.getChatbyID(id);
       System.out.println("Datos del Chat recibidos:");
       System.out.println("ID: " + chat.getId());
       System.out.println("Name: " + chat.getName());
       System.out.println("Color: " + chat.getColor());
       chatService.update(chat);

       return "redirect:/liste";
   }


}