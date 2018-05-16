
package com.pocket.daoimpl;

import com.pocket.dao.NetworkMemberDao;
import com.pocket.model.Network;
import com.pocket.model.NetworkMember;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkMemberDaoImpl implements NetworkMemberDao
{   
    @Autowired    
    private SessionFactory sessionFactory;

    public NetworkMemberDaoImpl() {
        
    }

    @Override
    public int save(NetworkMember obj) {
      
         System.out.println("Network Member dao-SAVE");
        try
        { 
            Session sess = sessionFactory.openSession();
            sess.save(obj);
            sess.beginTransaction().commit();
            Serializable ss =  sess.save(obj);
            int id = (int)ss;
            sess.close();
            return id;
        }
        catch(Exception ex)
        {
            System.err.println("(\"Network Member dao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return -1;
        }
    }

    @Override
    public boolean update(NetworkMember obj) {
         System.out.println("Netcaldao-UPDATE");
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
    public boolean delete(NetworkMember obj) {
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
    public List<NetworkMember> list() {
         List<NetworkMember> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
           Query qu=sess.createQuery("from NetworkMembercalender");          
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
    public NetworkMember getByID(int id) {
          NetworkMember netwMember=null;
         try{
          Session sess = sessionFactory.openSession();         
          
          netwMember = (NetworkMember) sess.get(NetworkMember.class, id);
            
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("Network_Member_Dao -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return netwMember;  
    }
    
       public List<NetworkMember>listTemp() {
       List<NetworkMember> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from NetworkMember where isActive=true");
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("MemberDao - TempList- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;
    }
    
    

    @Override
    public NetworkMember getByMemberNetworkId(int memberId,int networkId) 
    {
        NetworkMember nmember = null;
       try{
          Session sess = sessionFactory.openSession();         
           
           Query qu=sess.createQuery("from NetworkMember where memberId=:memid and networkId=:netid");          
           qu.setInteger("memid", memberId);
           qu.setInteger("netid", networkId);
           List<NetworkMember> list = qu.list();
           
           if(list.size()>0){
               nmember = list.get(0);
           }
            
          sess.close();
          return nmember;
       }
       catch(Exception ex){
            System.err.println("Net MEM Dao - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return nmember;     //To change body of generated methods, choose Tools | Templates.

    }
    
}
