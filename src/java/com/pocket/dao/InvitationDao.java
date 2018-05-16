package com.pocket.dao;

import com.pocket.model.Invitation;
import com.pocket.modelweb.NetworkInvitation;
import java.util.List;


public interface InvitationDao
{

    boolean save(Invitation obj);
    boolean update(Invitation obj);
    boolean delete(Invitation obj);
    public List<Invitation> list();
    public List<Invitation> list(int memberId);
    public List<NetworkInvitation>inviteList(int memberId);
    public boolean isInvite(int memberId,int networkid);
    Invitation getByID(int id);    
}
