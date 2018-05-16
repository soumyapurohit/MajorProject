
package com.pocket.daoimpl;

import com.pocket.dao.NetworkCalenderDao;
import com.pocket.model.NetworkCalender;
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
public class NetworkCalenderDaoImpl implements NetworkCalenderDao
{        
     private SessionFactory sessionFactory;

    public NetworkCalenderDaoImpl() {
        
    }

    @Override
    public boolean save(NetworkCalender obj) {
      
         System.out.println("Netcaldao-SAVE");
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
            System.err.println("Netcaldao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(NetworkCalender obj) {
         System.out.println("Netcaldao-UPDATE");
        try
        {
             Session sess = sessionFactory.openSession();
            obj.setMessage("happy bday");
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
    public boolean delete(NetworkCalender obj) {
         System.out.println("Netcaldao-DELETE");
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
            System.err.println("Netcaldao - DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NetworkCalender> list() {
         List<NetworkCalender> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
           Query qu=sess.createQuery("from Networkcalender");          
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("Netcaldao - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NetworkCalender getByID(int id) {
          NetworkCalender ncal=null;
         try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from NetworkCalender where member_id=id");
          
              ncal=(NetworkCalender) sess.get(NetworkCalender.class, id);
            
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("NetworkCalender -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return ncal;  //To change body of generated methods, choose Tools | Templates.
    }
    
}
