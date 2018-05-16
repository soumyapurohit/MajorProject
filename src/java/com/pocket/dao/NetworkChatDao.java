package com.pocket.dao;


import com.pocket.model.NetworkChat;
import java.util.List;


public interface NetworkChatDao
{
    boolean save(NetworkChat obj);
    boolean update(NetworkChat obj);
    boolean delete(NetworkChat obj);
    List <NetworkChat> list();
    NetworkChat getByID(int id);    
}
