package com.pocket.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="postresponse")
public class PostResponse  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    
    
     
    private int responseid;
     @Column(name = "post_id")
    private int postid;
      @Column(name = "response_by")
    private int responseby;
    @Column(name = "response_date")
    
    private Date responsedate;
  
    
      public PostResponse() {
    }

    public PostResponse(int responseid, int postid, int responseby, Date responsedate) {
        this.responseid = responseid;
        this.postid = postid;
        this.responseby = responseby;
        this.responsedate = responsedate;
    }

    public int getResponseid() {
        return responseid;
    }

    public void setResponseid(int responseid) {
        this.responseid = responseid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getResponseby() {
        return responseby;
    }

    public void setResponseby(int responseby) {
        this.responseby = responseby;
    }

    public Date getResponsedate() {
        return responsedate;
    }

    public void setResponsedate(Date responsedate) {
        this.responsedate = responsedate;
    }

    @Override
    public String toString() {
        return "postresponse{" + "responseid=" + responseid + ", postid=" + postid + ", responseby=" + responseby + ", responsedate=" + responsedate + '}';
    }

          
}
  
    
    
    

