package com.pocket.dao;
import com.pocket.model.Post;
import com.pocket.model.PostResponse;
import com.pocket.model.User;
        

import java.util.List;


public interface PostResponseDao 
{
    boolean save(PostResponse obj);
    boolean update(PostResponse obj);
    boolean delete(PostResponse obj);
    List <PostResponse> list();
    PostResponse getByID(int id);    
}
