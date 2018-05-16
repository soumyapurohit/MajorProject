package com.pocket.dao;
import com.pocket.model.User;
        

import java.util.List;


public interface UserDao 
{
    int save(User obj);
    boolean update(User obj);
    boolean delete(User obj);
   public boolean updatePass(int id,String oldPass,String newPass);
    List <User> list();
    User getByID(int id);  
    User login(String mail,String pass);
}
