package com.pocket.daoimpl;

import com.pocket.dao.MemberQualiDao;
import com.pocket.model.MemberQualification;
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
public class MemberQualiDaoImpl implements MemberQualiDao
{
    @Autowired
    private SessionFactory sessionFactory;
    public MemberQualiDaoImpl() {
       
    }
    
    @Override
    public boolean save(MemberQualification obj) {
        System.out.println("MemberQualification-SAVE");
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
            System.err.println("MemberQuali - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
        
    }
    public boolean saveOrUpdate(MemberQualification obj){
        System.out.println("MemberQuali-SaveORUpdate");
         try
        {
             Session sess = sessionFactory.openSession();
            
            sess.saveOrUpdate(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        }
        catch(Exception ex)
        {
            System.err.println("MemberQuali- SaveOrUpdate- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(MemberQualification obj) {
         System.out.println("MemberQuali-UPDATE");
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
            System.err.println("MemberQuali- UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    

    }

    @Override
   
    public boolean delete(MemberQualification obj) {
        return false;
      /*  System.out.println("MemberQuali-DELETE");
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
            System.err.println("MemberQuali - DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
        */
    }
   
    

    @Override
    public List<MemberQualification> list() {
      List<MemberQualification> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from MemberQualification");          
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("Memberquali - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;     
    }

    @Override
    public MemberQualification getByID(int id) {
        MemberQualification memberqu=null;
          try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from MemberQualification where member_id=id");
          
              memberqu=(MemberQualification) sess.get(MemberQualification.class, id);
            
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("MemberDao -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return memberqu;  
    }

    @Override
    public MemberQualification getByMember(int memberId)
    {
          MemberQualification memberqu=null;
          try{
          Session sess = sessionFactory.openSession();         
          Query qu=sess.createQuery("from MemberQualification where memberId=:id");
          qu.setInteger("id",memberId);
         
          List<MemberQualification> list = qu.list();
          
          if(list.size()>0){
              memberqu = list.get(0);
          }
          
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("MemberDao -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return memberqu;          
    }

   
}
