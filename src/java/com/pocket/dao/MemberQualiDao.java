package com.pocket.dao;

import com.pocket.model.MemberQualification;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface MemberQualiDao
{
    boolean save(MemberQualification obj);
    boolean update(MemberQualification obj);
    boolean saveOrUpdate(MemberQualification obj);
    boolean delete(MemberQualification obj);
    List <MemberQualification> list();
    MemberQualification getByID(int id);    
    MemberQualification getByMember(int memberId);  
}
