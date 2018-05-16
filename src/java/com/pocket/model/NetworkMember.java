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
@Table(name="network_member")
public class NetworkMember  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "network_member_id")
    
    private int networkMemberId;
   
    @Column(name = "network_id")
    private int networkId;

    @Column(name = "member_id")
    private int memberId;
    @Column(name = "join_date")
    private Date joinDate;
     @Column(name = "is_active")
    private boolean isActive;
      @Column(name = "network_member_type")
     private String networkMemberType;

    public NetworkMember() {
    }

    public NetworkMember(int networkMemberId, int networkId, int memberId, Date joinDate, boolean isActive, String networkMemberType) {
        this.networkMemberId = networkMemberId;
        this.networkId = networkId;
        this.memberId = memberId;
        this.joinDate = joinDate;
        this.isActive = isActive;
        this.networkMemberType = networkMemberType;
    }
       
    public int getNetworkMemberId() {
        return networkMemberId;
    }

    public void setNetworkMemberId(int networkMemberId) {
        this.networkMemberId = networkMemberId;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getNetworkMemberType() {
        return networkMemberType;
    }

    public void setNetworkMemberType(String networkMemberType) {
        this.networkMemberType = networkMemberType;
    }

    @Override
    public String toString() {
        return "NetworkMember{" + "networkMemberId=" + networkMemberId + ", networkId=" + networkId + ", memberId=" + memberId + ", joinDate=" + joinDate + ", isActive=" + isActive + ", networkMemberType=" + networkMemberType + '}';
    }    

}