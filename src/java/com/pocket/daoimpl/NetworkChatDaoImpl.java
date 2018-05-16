
package com.pocket.daoimpl;

import com.pocket.dao.NetworkChatDao;
import com.pocket.model.NetworkChat;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo_win_10
 */
@Service
public class NetworkChatDaoImpl implements NetworkChatDao
{        
     private SessionFactory sessionFactory;

    public NetworkChatDaoImpl() {
        
    }

    @Override
    public boolean save(NetworkChat obj) {
      
         System.out.println("Networkchatdao-SAVE");
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
            System.err.println("Networkchatdao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(NetworkChat obj) {
         System.out.println("NetworkChatDao-UPDATE");
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
            System.err.println("Netcaldao- UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(NetworkChat obj) {
         System.out.println("NetworkChatDao-DELETE");
        try
        {
             Session sess = sessionFactory.openSession();
             //obj.setIsActive(false);
            sess.update(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        }
        catch(Exception ex)
        {
            System.err.println("NetworkChatDao - DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NetworkChat> list() {
         List<NetworkChat> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
           Query qu=sess.createQuery("from NetworkChat");          
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("NetworkChat - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NetworkChat getByID(int id) {
          NetworkChat ncal=null;
         try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from NetworkChat where member_id=id");
          
              ncal=(NetworkChat) sess.get(NetworkChat.class, id);
            
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("NetworkChatDao -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return ncal;  //To change body of generated methods, choose Tools | Templates.
    }
    
}
