/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocket.daoimpl;


import com.pocket.dao.PostDao;
import com.pocket.model.Post;
import java.io.Serializable;
import static java.util.Collections.list;
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
public class PostDaoImpl implements PostDao{
    @Autowired 
 private SessionFactory sessionFactory;
    public PostDaoImpl() {
        
        
    }
   
    @Override
    public int save(Post obj) {
     System.out.println("PostDao-SAVE");
        try
        { 
            Session sess = sessionFactory.openSession();
            sess.save(obj);
            Serializable ss =  sess.save(obj);
            int id = (int)ss;
            sess.beginTransaction().commit();
            sess.close();
            return id;
        }
        catch(Exception ex)
        {
            System.err.println("PostDao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return -1;
        }
        
    }

    @Override
    public boolean update(Post obj) {
         System.out.println("PostDao-UPDATE");
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
            System.err.println("PostDao - UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
     
    }

    @Override
    public boolean delete(Post obj) {
        System.out.println("PostDao-DELETE");
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
            System.err.println("PostDao - DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Post> list() {
    List<Post> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from Post");          
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("PostDao - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;
    }
      public List<Post>listtemp() {
       List<Post> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from Post where user_active=true");
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("PostDao - TempList- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;
    }

    @Override
    public Post getByID(int id) {
       Post user=null;
          try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from Post where member_id=id");
          
            user=(Post) sess.get(Post.class, id);
            
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("PostDao -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return user;   
    }

    @Override
    public List<Post> listByNetwork(int networkId) 
    {
         List<Post> list = null;
        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Post where networkId=:network");
            qu.setInteger("network", networkId);         
            list = qu.list();
            sess.close();
            return list;
        } catch (Exception ex) {
            System.err.println("List By Network- ERROR");
            System.err.println(ex.getMessage());
        }
        return list;
    }

    
}
