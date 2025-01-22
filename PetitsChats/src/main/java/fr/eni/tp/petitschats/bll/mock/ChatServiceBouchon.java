package fr.eni.tp.petitschats.bll.mock;

import fr.eni.tp.petitschats.bll.ChatService;
import fr.eni.tp.petitschats.bo.Chat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceBouchon implements ChatService {

    private static List<Chat> lstchats = new ArrayList<Chat>();
    private static int id = 0;

    public ChatServiceBouchon() {
        simulerDALetDB();
    }

    @Override
    public void addChat(Chat chat) {
        chat.setId(id++);
        lstchats.add(chat);

    }

    ;

    @Override
    public void removeChat(int id) {
        lstchats.removeIf(chat -> chat.getId() == id);
    }

    @Override
    public List<Chat> getChats() {
        return lstchats;
    }


    @Override
    public Chat getChatbyID(int id) {
        return lstchats.stream().filter(item -> item.getId() == id).findAny().orElse(null);

    }

    @Override
    public void update(Chat chat) {
        for (int i = 0; i < lstchats.size(); i++) {
            if (lstchats.get(i).getId() == chat.getId()) {
                Chat existingChat = lstchats.get(i);
                existingChat.setName(chat.getName());  // Ejemplo de actualización de campos específicos
                existingChat.setColor(chat.getColor());
                // Actualiza otros campos necesarios
                break;
            }
        }
    }


    public void simulerDALetDB() {

        Chat Felix = new Chat(id++, "Félix", "Noir");
        lstchats.add(Felix);
        Chat Luna = new Chat(id++, "Luna", "Blanc");
        lstchats.add(Luna);
        Chat Tiger = new Chat(id++, "Tiger", "Orange");
        lstchats.add(Tiger);
        Chat Bella = new Chat(id++, "Bella", "Gris");
        lstchats.add(Bella);
        Chat Simba = new Chat(id++, "Simba", "Jaune");
        lstchats.add(Simba);
        Chat Misty = new Chat(id++, "Misty", "Bleu");
        lstchats.add(Misty);
        Chat Oreo = new Chat(id++, "Oreo", "Noir et Blanc");
        lstchats.add(Oreo);
        Chat Charlie = new Chat(id++, "Charlie", "Roux");
        lstchats.add(Charlie);
        Chat Max = new Chat(id++, "Max", "Marron");
        lstchats.add(Max);
        Chat Zoe = new Chat(id++, "Zoe", "Crème");
        lstchats.add(Zoe);


    }
}
