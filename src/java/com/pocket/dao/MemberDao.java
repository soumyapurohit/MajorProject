package com.pocket.dao;

import com.pocket.model.Member;
import java.util.List;


public interface MemberDao 
{
    int save(Member obj);
    boolean update(Member obj);
    boolean delete(Member obj);
    List <Member> list();
     boolean checkemail(String username);
    List<Member>list(int memberId, int networkId);
    Member getByID(int id);    
    public List<Member>listByNetwork(int networkId);
}
