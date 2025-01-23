package fr.eni.tp.petitschats.dal;

import fr.eni.tp.petitschats.bo.Chat;

import java.util.List;

public interface DaoChat {

    List<Chat> read();
    Chat read(int id);
    int create(Chat chat);
    void update(Chat chat);
    void delete(Chat chat);
    void delete(int id);

}
