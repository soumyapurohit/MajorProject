/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocket.daoimpl;





import com.pocket.dao.MemberProfDao;
import com.pocket.model.MemberProfession;
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
public class MemberProfDaoImpl implements MemberProfDao{
    @Autowired
    private SessionFactory sessionFactory;

    public MemberProfDaoImpl() {
        
    }
    
    @Override
    public boolean save(MemberProfession obj) {
         System.out.println("MemberProfDao-SAVE");
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
            System.err.println("MemberProfDao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
        
    }
     public boolean saveOrUpdate(MemberProfession obj){
        System.out.println("MemberProf-SaveORUpdate");
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
            System.err.println("MemberProf- SaveOrUpdate- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(MemberProfession obj) {
         System.out.println("MemberProfDao-UPDATE");
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
            System.err.println("MemberProfDao- UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    
    }

    @Override
    public boolean delete(MemberProfession obj) {
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
    public List<MemberProfession> list() {
        List<MemberProfession> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from MemberProfession");          
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("MemberprofDao - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;     
    }
    

    @Override
    public MemberProfession getByID(int id) {
        MemberProfession memprof=null;
         try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from MemberProfession where member_id=id");
          
              memprof=(MemberProfession) sess.get(MemberProfession.class, id);
            
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("MemberProfDao -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return memprof;  
    }
    
       public MemberProfession getByMember(int memberId) {
        MemberProfession memberprof=null;
          try{
          Session sess = sessionFactory.openSession();         
          Query qu=sess.createQuery("from MemberProfession where memberId=:id");
          qu.setInteger("id",memberId);
         
          List<MemberProfession> list = qu.list();
          
          if(list.size()>0){
              memberprof = list.get(0);
          }
          
          sess.close();
          
       }
       catch(Exception ex){
            System.err.println("MemberProfessionDao -GetByID- ERROR");
            System.err.println(ex.getMessage());
            
       }
        return memberprof;          
    }


    }
    
    

