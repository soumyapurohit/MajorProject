package com.pocket.dao;


import com.pocket.model.Network;
import com.pocket.model.NetworkDrive;
import com.pocket.model.NetworkMember;

import java.util.List;


public interface NetworkMemberDao
{
    int save(NetworkMember obj);
    boolean update(NetworkMember obj);
    boolean delete(NetworkMember obj);
    List <NetworkMember> list();
    public List<NetworkMember>listTemp();
    NetworkMember getByID(int id);  
    NetworkMember getByMemberNetworkId(int memberId,int networkId);
}
