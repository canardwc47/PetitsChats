package fr.eni.tp.petitschats.bll;

import fr.eni.tp.petitschats.bo.Chat;
import fr.eni.tp.petitschats.dal.DaoChat;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ChatServiceImpl implements ChatService {

    private DaoChat daoChat;

    public ChatServiceImpl(DaoChat daoChat) {
        this.daoChat = daoChat;
    }

    @Override
    public void addChat(Chat chat) {
        daoChat.create(chat);
    }

    @Override
    public void removeChat(int id) {
        daoChat.delete(id);
    }

    @Override
    public List<Chat> getChats() {
        return daoChat.read();
    }


    @Override
    public Chat getChatbyID(int id) {
        return daoChat.read(id);
    }

    @Override
    public void update(Chat chat) {
        daoChat.update(chat);
    }
}
