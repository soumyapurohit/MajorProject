/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocket.daoimpl;


import com.pocket.dao.PostResponseDao;
import com.pocket.model.PostResponse;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class PostResponseDaoImpl implements PostResponseDao{
 private SessionFactory sessionFactory;
    public PostResponseDaoImpl() {
        
        
    }
   
    @Override
    public boolean save(PostResponse obj) {
     System.out.println("PostResponseDao-SAVE");
        try
        { 
            Session sess = sessionFactory.openSession();
            sess.save(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        }
        catch(Exception ex)
        {
            System.err.println("PostResponseDao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean update(PostResponse obj) {
         System.out.println("PostResponseDao-UPDATE");
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
            System.err.println("PostResponseDao - UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
     
    }

    @Override
    public boolean delete(PostResponse obj) {
        System.out.println("PostResponseDao-DELETE");
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
            System.err.println("PostResponseDao - DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<PostResponse> list() {
    List<PostResponse> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from PostResponse");          
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("PostResponseDao - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;
    }
      public List<PostResponse>listtemp() {
       List<PostResponse> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from PostResponse where user_active=true");
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("PostResponseDao - TempList- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;
    }

    @Override
    public PostResponse getByID(int id) {
       PostResponse user=null;
          try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from PostResponse where member_id=id");
          
            user=(PostResponse) sess.get(PostResponse.class, id);
            
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("PostResponseDao -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return user;   
    }

    
}
