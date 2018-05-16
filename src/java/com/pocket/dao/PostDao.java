package com.pocket.dao;
import com.pocket.model.Invitation;
import com.pocket.model.Post;
import com.pocket.model.User;
        

import java.util.List;


public interface PostDao 
{
    int save(Post obj);
    boolean update(Post obj);
    boolean delete(Post obj);
    List <Post> list();
    List<Post> listByNetwork(int networkId);
    Post getByID(int id);    
}
