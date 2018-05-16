/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocket.daoimpl;

import com.pocket.dao.InvitationDao;
import com.pocket.model.Invitation;
import com.pocket.modelweb.NetworkInvitation;
import com.pocket.util.PocketConstant;
import java.util.ArrayList;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvitationDaoImpl implements InvitationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public InvitationDaoImpl() {

    }

    @Override
    public boolean save(Invitation obj) {
        System.out.println("InvitationDao-SAVE");
        try {
            Session sess = sessionFactory.openSession();
            sess.save(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            System.err.println("InvitationDao - SAVE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Invitation obj) {
        System.out.println("InvitationDao-UPDATE");
        try {
            Session sess = sessionFactory.openSession();

            sess.update(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            System.err.println("InvitationDao - UPDATE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Invitation obj) {
        System.out.println("InvitationDao-DELETE");
        try {
            Session sess = sessionFactory.openSession();
            //obj.set(false);
            sess.update(obj);
            sess.beginTransaction().commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            System.err.println("InvitationDao - DELETE- ERROR");
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Invitation> list() {
        List<Invitation> list = null;
        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Invitation");
            list = qu.list();

            sess.close();
            return list;
        } catch (Exception ex) {
            System.err.println("Invitation - List- ERROR");
            System.err.println(ex.getMessage());

        }
        return list;
    }

    public List<Invitation> list(int memberId) {
        List<Invitation> list = null;
        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Invitation where memberId=:member");
            qu.setInteger("member", memberId);
            list = qu.list();

            sess.close();
            return list;
        } catch (Exception ex) {
            System.err.println("Invitation - List- ERROR");
            System.err.println(ex.getMessage());

        }
        return list;
    }

    @Override
    public List<NetworkInvitation> inviteList(int memberId) {
        List<NetworkInvitation> list = new ArrayList<>();

        try {
            Session sess = sessionFactory.openSession();

            SQLQuery qu = sess.createSQLQuery("select inv.invite_id,mem.member_id,net.network_id,net.title,net.profile_pic npic,mem.profile_pic mpic,mem.fname,mem.lname,inv.sent_by from network net,member mem,invitation  inv where net.network_id=inv.network_id and mem.member_id=inv.sent_by and inv.invite_id in(select inv.invite_id from invitation inv where inv.member_id=:member and inv.invite_status=:status)");
            qu.setInteger("member", memberId);
            qu.setString("status", PocketConstant.INVITE_PENDING);
            List<Object[]> data = qu.list();
            for (Object obj[] : data)
            {
                Integer inviteId = Integer.parseInt(String.valueOf(obj[0]));
                Integer memId = Integer.parseInt(String.valueOf(obj[1]));
                Integer networkId = Integer.parseInt(String.valueOf(obj[2]));

                String title = String.valueOf(obj[3]);
                String profilePicNetwork = String.valueOf(obj[4]);
                String profilePicMember = String.valueOf(obj[5]);
                String fname = String.valueOf(obj[6]);
                String lname = String.valueOf(obj[7]);
                Integer sentBy = Integer.parseInt(String.valueOf(obj[8]));

                NetworkInvitation ni = new NetworkInvitation(inviteId, networkId, memId, sentBy, title, profilePicMember, profilePicNetwork, fname, lname);
                list.add(ni);
                sess.close();             
            }
               return list;
        } catch (Exception ex) {
            System.err.println("InvitationDetails - List- ERROR");
            System.err.println(ex.getMessage());

        }
        return list;

    }

    public List<Invitation> listtemp() {
        List<Invitation> list = null;
        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Invitation where user_active=true");
            list = qu.list();

            sess.close();
            return list;
        } catch (Exception ex) {
            System.err.println("InvitationDao - TempList- ERROR");
            System.err.println(ex.getMessage());

        }
        return list;
    }

    @Override
    public Invitation getByID(int id) {
        Invitation invit = null;
        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Invitation where Invitation_id=id");

            invit = (Invitation) sess.get(Invitation.class, id);

            sess.close();

        } catch (Exception ex) {
            System.err.println("InvitationDao -GetByID- ERROR");
            System.err.println(ex.getMessage());

        }
        return invit;

    }

    public boolean isInvite(int memberId, int networkid) {

        try {
            Session sess = sessionFactory.openSession();

            Query qu = sess.createQuery("from Invitation where memberId=:member and networkId=:network");
            qu.setInteger("member", memberId);
            qu.setInteger("network", networkid);
            List<Invitation> list = qu.list();
            System.out.println("List size - " + list.size());
            sess.close();
            if (list.size() > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.err.println("List Boolean Invitation- ERROR");
            System.err.println(ex.getMessage());

        }
        return false;
    }
}
