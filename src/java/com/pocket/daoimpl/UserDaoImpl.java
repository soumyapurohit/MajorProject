/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocket.daoimpl;


import com.pocket.dao.UserDao;
import com.pocket.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class UserDaoImpl implements UserDao
{
    @Autowired
    private SessionFactory sessionFactory;
     
    public UserDaoImpl() {
        
    }
   
    @Override
    public int save(User obj) {
     System.out.println("UserDao-SAVE");
        try
        { 
            Session sess = sessionFactory.openSession();
            Serializable ss =  sess.save(obj);
            sess.beginTransaction().commit();
            sess.close();
            return (int)ss;
        }
        catch(Exception ex)
        {
            System.err.println("UserDao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return -1;
        }        
    }

    @Override
    public boolean update(User obj) {
         System.out.println("UserDao-UPDATE");
        try
        {
             Session sess = sessionFactory.openSession();
            sess.update(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        }
        catch(Exception ex)
        {
            System.err.println("UserDao - UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
     
    }

    @Override
    public boolean delete(User obj) {
        System.out.println("UserDao-DELETE");
        try
        {
             Session sess = sessionFactory.openSession();
            obj.setUser_active(false);
            sess.update(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        }
        catch(Exception ex)
        {
            System.err.println("UserDao - DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<User> list() {
    List<User> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from User");          
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("UserDao - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;
    }
      public List<User>listtemp() {
       List<User> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from User where user_active=true");
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("UserDao - TempList- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;
    }

    @Override
    public User getByID(int id) {
       User user=null;
          try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from User where member_id=id");
          
            user=(User) sess.get(User.class, id);
            
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("UserDao -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return user;   
    }

    @Override
    public User login(String mail, String pass) 
    {
        User user = null;
        System.out.println("UserDao Login Start ..");
        try
        {
            Session sess = sessionFactory.openSession();
            
            Query query = sess.createQuery("from User where login_id=:mail and password=:pass");
            query.setString("mail", mail);
            query.setString("pass", pass);
            
            List<User> list = query.list();
            
            if(list.size()>0){
                user = list.get(0);
            }            
            
            sess.close();
        }catch(Exception ex){
            System.err.println("UserDao Login error : " + ex.getMessage());
        }
        return user;
    }
   public boolean updatePass(int id,String oldPass,String newPass){
       
        try
        {
            
           
           Session session = sessionFactory.openSession();
           User user=(User) session.get(User.class, id);
           user.setPassword(newPass);
           session.saveOrUpdate(user);
           
           
            session.beginTransaction().commit();
            
            
            //sess.close();
            return true;
        }catch(Exception ex){
            System.err.println("UserDao Update Password error : " + ex.getMessage());
            return false;
        }
        
    }
   }
    

