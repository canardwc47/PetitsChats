package fr.eni.tp.petitschats.bll;

import fr.eni.tp.petitschats.bo.Chat;
import org.springframework.stereotype.Service;

import java.util.*;


public interface  ChatService {

    void addChat(Chat chat);

    void removeChat(int id);

    List<Chat> getChats();
    Chat getChatbyID(int id);

    void update (Chat chat);

}
