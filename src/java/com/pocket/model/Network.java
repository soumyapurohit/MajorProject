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
@Table (name="network")
public class Network  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "network_id")
    
    private int networkId;
     @Column(name="create_date")
     private Date createDate;
     @Column(name="network_type")
    private String networkType;
    private String title;
    @Column(name="profile_pic")
    private String profilePic;
    @Column(name="network_active")
    private boolean networkActive;
    @Column(name="network_deleted")
    private boolean networkDeleted;
    @Column(name = "member_id")
    private int memberId;

    public Network() {
    }

    public Network(int networkId, Date createDate, String networkType, String title, String profilePic, boolean networkActive, boolean networkDeleted, int memberId) {
        this.networkId = networkId;
        this.createDate = createDate;
        this.networkType = networkType;
        this.title = title;
        this.profilePic = profilePic;
        this.networkActive = networkActive;
        this.networkDeleted = networkDeleted;
        this.memberId = memberId;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public boolean isNetworkActive() {
        return networkActive;
    }

    public void setNetworkActive(boolean networkActive) {
        this.networkActive = networkActive;
    }

    public boolean isNetworkDeleted() {
        return networkDeleted;
    }

    public void setNetworkDeleted(boolean networkDeleted) {
        this.networkDeleted = networkDeleted;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Network{" + "networkId=" + networkId + ", createDate=" + createDate + ", networkType=" + networkType + ", title=" + title + ", profilePic=" + profilePic + ", networkActive=" + networkActive + ", networkDeleted=" + networkDeleted + ", memberId=" + memberId + '}';
    }

}