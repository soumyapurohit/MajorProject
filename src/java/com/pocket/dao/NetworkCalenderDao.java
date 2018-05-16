package com.pocket.dao;

import com.pocket.model.NetworkCalender;
import java.util.List;

public interface NetworkCalenderDao
{
    boolean save(NetworkCalender obj);
    boolean update(NetworkCalender obj);
    boolean delete(NetworkCalender obj);
    List <NetworkCalender> list();
    NetworkCalender getByID(int id);    
}
