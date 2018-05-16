package com.pocket.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;
    
    @Column(name = "network_id")
    private int networkId;
    
     @Column(name = "post_by")
    private int postBy;
    @Column(name = "post_date")
    private Date postDate;
    @Column(name = "post_active")
    private boolean postActive;
    @Column(name = "post_type")
    private String postType;
    @Column(name = "text_data")
    private String textData;
    @Column(name = "media_path")
    private String mediaPath;
    
      public Post() {
    }

    public Post(int postId, int networkId, int postBy, Date postDate, boolean postActive, String postType, String textData, String mediaPath) {
        this.postId = postId;
        this.networkId = networkId;
        this.postBy = postBy;
        this.postDate = postDate;
        this.postActive = postActive;
        this.postType = postType;
        this.textData = textData;
        this.mediaPath = mediaPath;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public int getPostBy() {
        return postBy;
    }

    public void setPostBy(int postBy) {
        this.postBy = postBy;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public boolean isPostActive() {
        return postActive;
    }

    public void setPostActive(boolean postActive) {
        this.postActive = postActive;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    @Override
    public String toString() {
        return "Post{" + "postId=" + postId + ", networkId=" + networkId + ", postBy=" + postBy + ", postDate=" + postDate + ", postActive=" + postActive + ", postType=" + postType + ", textData=" + textData + ", mediaPath=" + mediaPath + '}';
    }

   

  
    
}
