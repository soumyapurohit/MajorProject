package com.pocket.dao;


import com.pocket.model.Network;
import com.pocket.model.NetworkDrive;

import java.util.List;


public interface NetworkDriveDao
{
    boolean save(NetworkDrive obj);
    boolean update(NetworkDrive obj);
    boolean delete(NetworkDrive obj);
    List <NetworkDrive> list();
    NetworkDrive getByID(int id);    
}
