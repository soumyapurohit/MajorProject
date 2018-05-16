package com.pocket.dao;

import com.pocket.model.MemberProfession;
import java.util.List;


public interface MemberProfDao
{
    boolean save(MemberProfession obj);
    boolean saveOrUpdate(MemberProfession obj);

    boolean update(MemberProfession obj);
    boolean delete(MemberProfession obj);
    List <MemberProfession> list();
    MemberProfession getByMember(int memberId);
    MemberProfession getByID(int id);    
}
