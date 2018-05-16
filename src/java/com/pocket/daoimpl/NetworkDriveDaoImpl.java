
package com.pocket.daoimpl;

import com.pocket.dao.NetworkDriveDao;
import com.pocket.model.NetworkDrive;
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
public class NetworkDriveDaoImpl implements NetworkDriveDao
{        
     private SessionFactory sessionFactory;

    public NetworkDriveDaoImpl() {
        
    }

    @Override
    public boolean save(NetworkDrive obj) {
      
         System.out.println("NetworkDrive-SAVE");
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
            System.err.println("NetworkDrive - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(NetworkDrive obj) {
         System.out.println("NetworkDrive-UPDATE");
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
            System.err.println("NetworkDrive- UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(NetworkDrive obj) {
         System.out.println("NetworkDrive-DELETE");
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
            System.err.println("NetworkDrive - DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NetworkDrive> list() {
         List<NetworkDrive> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
           Query qu=sess.createQuery("from NetworkDrive");          
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("NetworkDrive - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NetworkDrive getByID(int id) {
          NetworkDrive ncal=null;
         try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from NetworkDrive where member_id=id");
          
              ncal=(NetworkDrive) sess.get(NetworkDrive.class, id);
            
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("NetworkDrive -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return ncal;  //To change body of generated methods, choose Tools | Templates.
    }
    
}
