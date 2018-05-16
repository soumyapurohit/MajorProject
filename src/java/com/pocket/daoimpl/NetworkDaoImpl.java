package com.pocket.daoimpl;

import com.pocket.dao.NetworkDao;
import com.pocket.model.Member;
import com.pocket.model.Network;
import com.pocket.model.NetworkMember;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkDaoImpl implements NetworkDao {

    @Autowired
    private SessionFactory sessionFactory;

    public NetworkDaoImpl() {

    }

    @Override
    public int save(Network obj) {

        System.out.println("Networkdao-SAVE");
        System.out.println("network obj values in dao" + obj);

        try {
            Session sess = sessionFactory.openSession();
            Serializable ss = sess.save(obj);
            int id = (int) ss;
            sess.beginTransaction().commit();
            sess.close();
            return id;
        } catch (Exception ex) {
            System.err.println("Networkdao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return -1;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Network obj) {
        System.out.println("Networkdao-UPDATE");
        try {
            Session sess = sessionFactory.openSession();
            sess.update(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            System.err.println("NetworkDao- UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Network obj) {
        System.out.println("NetworkDao-DELETE");
        try {
            Session sess = sessionFactory.openSession();
            //obj.setIsActive(false);
            sess.update(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            System.err.println("NetworkDao- DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Network> list() {
        List<Network> list = null;
        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Network");
            list = qu.list();

            sess.close();
            return list;
        } catch (Exception ex) {
            System.err.println("NetworkDao - List- ERROR");
            System.err.println(ex.getMessage());

        }
        return list;     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Network> lists(int memberId) {
        List<Network> list = null;
        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Network where member_id=?");
            qu.setInteger(0, memberId);
            list = qu.list();

            sess.close();
            return list;
        } catch (Exception ex) {
            System.err.println("NetworkDao - List- ERROR");
            System.err.println(ex.getMessage());

        }
        return list;     //To change body of generated methods, choose Tools | Templates.
    }
   
    public List<Network>joinedNetwork(int memberId){
          List<Network> list = null;
          System.out.println("in joined n/w");
        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Network where networkId in(select networkId from NetworkMember where memberId=:member and networkMemberType='member' and isActive=1)");
            qu.setInteger("member", memberId);
            list = qu.list();
                System.out.println("SSSSSSSSSSSSS>>>>>>>>>>>> " + list.size());
            sess.close();
            return list;
        } catch (Exception ex) {
            System.err.println("NetworkDao - JoinedList- ERROR");
            System.err.println(ex.getMessage());

        }
        return list;    
    }

    @Override
    public List<Network> list(int memberId, boolean isActive) {
        List<Network> list = null;
        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Network where memberId=:mid and networkActive=:act");
            qu.setInteger("mid", memberId);
            qu.setBoolean("act", isActive);
            list = qu.list();

            sess.close();
            return list;
        } catch (Exception ex) {
            System.err.println("NetworkDao - List- ERROR");
            System.err.println(ex.getMessage());

        }
        return list;     //To change body of generated methods, choose Tools | Templates.
    }

  
    
    @Override
    public Network getByID(int id) {
        Network ncal = null;
        try {
            Session sess = sessionFactory.openSession();

            ncal = (Network) sess.get(Network.class, id);

            sess.close();

        } catch (Exception ex) {
            System.err.println("NetworkDao -GetByID- ERROR");
            System.err.println(ex.getMessage());

        }
        return ncal;  //To change body of generated methods, choose Tools | Templates.
    }

}
