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
@Table(name="network_drive")
public class NetworkDrive  implements Serializable {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "drive_id")
   
    private int driveId;
     @Column(name = "post_id")
     private int postId;
    @Column(name = "post_size")
    private float postSize;
    
    @Column(name = "post_type")
    private String postType;
    @Column(name = "post_path")
     private String postPath;

    public int getDriveId() {
        return driveId;
    }

    public void setDriveId(int driveId) {
        this.driveId = driveId;
    }

    public NetworkDrive() {
    }

    public NetworkDrive(int driveId, int postId, float postSize, String postType, String postPath) {
        this.driveId = driveId;
        this.postId = postId;
        this.postSize = postSize;
        this.postType = postType;
        this.postPath = postPath;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostid(int postId) {
        this.postId = postId;
    }

    public float getPostsize() {
        return postSize;
    }

    public void setPostSize(float postSize) {
        this.postSize = postSize;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostPath() {
        return postPath;
    }

    public void setPostPath(String postPath) {
        this.postPath = postPath;
    }

    @Override
    public String toString() {
        return "Networkdrive{" + "driveId=" + driveId + ", postId=" + postId + ", postSize=" + postSize + ", postType=" + postType + ", postPath=" + postPath + '}';
    }

    

    
}
