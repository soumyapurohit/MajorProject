package com.pocket.daoimpl;

import com.pocket.dao.MemberDao;
import com.pocket.model.Member;
import com.pocket.model.Network;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDaoImpl implements MemberDao
{ 
    @Autowired
    private SessionFactory sessionFactory;
    
    public MemberDaoImpl() 
    {
        
    }   
    
    @Override
    public int save(Member obj) 
    {
        System.out.println("MemberDao-SAVE");
        try
        { 
            obj.setIsActive(true);
            
            Session sess = sessionFactory.openSession();
            
            Serializable ss =  sess.save(obj);
            int id = (int)ss;
            
            sess.beginTransaction().commit();
            sess.close();
            return id;
        }
        catch(Exception ex)
        {
            System.err.println("MemberDao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return -1;
        }        
    }

    @Override
    public boolean update(Member obj) {
        System.out.println("MemberDao-UPDATE");
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
            System.err.println("MemberDao - UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Member obj) {
        System.out.println("MemberDao-DELETE");
        try
        {
             Session sess = sessionFactory.openSession();
             obj.setIsActive(false);
            sess.update(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        }
        catch(Exception ex)
        {
            System.err.println("MemberDao - DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Member>list() {
       List<Member> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from Member");          
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("MemberDao - List- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;
    }

    public List<Member>listtemp() {
       List<Member> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from Member where isActive=true");
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

    public List<Member> list(int memberId, int networkId) {
        List<Member> list = new ArrayList<>();
        try {
            Session sess = sessionFactory.openSession();
            //  Query qu=sess.createQuery("from Member where memberId!=memberId and not in()")
            
            
            SQLQuery qu = sess.createSQLQuery("select * from member where member_id!=:memberId and member_id not in(select member_id from network where network_id=:networkId) and member_id in (select member_id from user where user_active=true)");
            qu.setInteger("memberId", memberId);
            qu.setInteger("networkId", networkId);
            List<Object[]> data = qu.list();
            for (Object obj[] : data) {
                
                Integer memId = Integer.parseInt(String.valueOf(obj[0]));
                String fname = String.valueOf(obj[1]);
                String lname = String.valueOf(obj[2]);
                String phone = String.valueOf(obj[3]);
                String email = String.valueOf(obj[4]);
                String pic = String.valueOf(obj[5]);
                               
                Member mem=new Member(memId, fname, lname, phone, email, pic, null, null, null, true);
                list.add(mem);
           }
           

            sess.close();
            return list;
        } catch (Exception ex) {
            System.err.println("MemberDao - List- ERROR");
            System.err.println(ex.getMessage());

        }
        return list;

    }
    
    

    @Override
    public Member getByID(int id) {
        Member member=null;
          try{
          Session sess = sessionFactory.openSession();    
          member=(Member) sess.get(Member.class, id);
          sess.close();
       }
       catch(Exception ex){
            System.err.println("MemberDao -GetByID- ERROR");
            System.err.println(ex.getMessage());
       }
        return member;
    }
   
    @Override
    public boolean checkemail(String email)
    {
        try{
              Session sess = sessionFactory.openSession();   
              List<Member> list=null;
              Query qu = sess.createQuery("from Member where email=:email");
              qu.setString("email",email);
              list = qu.list();
              if(list.size()>0){
                  return true;
              }
       }
       catch(Exception ex){
            System.err.println("Member checkmail -GetByID- ERROR");
            System.err.println(ex.getMessage());
       }
        return false;
    }
    
    public List<Member>listByNetwork(int networkId) {
       List<Member> list=null;
       try{
          Session sess = sessionFactory.openSession();         
           
          Query qu=sess.createQuery("from Member where memberId in(select memberId from NetworkMember where networkId=:netId and isActive=true)");
          qu.setInteger("netId", networkId);
          list=qu.list();
            
          sess.close();
          return list;
       }
       catch(Exception ex){
            System.err.println("MemberDao - ListByNetwork- ERROR");
            System.err.println(ex.getMessage());
            
       }
       return list;
    }
    
}
