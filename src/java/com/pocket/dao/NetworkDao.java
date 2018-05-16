package com.pocket.dao;


import com.pocket.model.Network;

import java.util.List;


public interface NetworkDao
{
    int save(Network obj);
    boolean update(Network obj);
    boolean delete(Network obj);
    List <Network> list();
    List <Network> lists(int memberID);
    List<Network>joinedNetwork(int memberId);
    List <Network> list(int memberID,boolean isActive);
    Network getByID(int id);    
}
