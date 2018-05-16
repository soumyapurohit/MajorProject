/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table (name="invitation")
public class Invitation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invite_id")
    
    private int inviteId;
   
    @Column(name = "network_id")
    private int networkId;

    @Column(name = "member_id")
    private int memberId;
    
     @Column(name = "sent_by")
     private int sentBy;
     @Column(name = "sent_date")
     private Date sentDate;
     @Column(name = "invite_status")
     private String inviteStatus;

    public Invitation() {
    }

    public Invitation(int inviteId, int networkId, int memberId, int sentBy, Date sentDate, String inviteStatus) {
        this.inviteId = inviteId;
        this.networkId = networkId;
        this.memberId = memberId;
        this.sentBy = sentBy;
        this.sentDate = sentDate;
        this.inviteStatus = inviteStatus;
    }

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
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

    

    public int getSentBy() {
        return sentBy;
    }

    public void setSentBy(int sentBy) {
        this.sentBy = sentBy;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

    @Override
    public String toString() {
        return "Invitation{" + "inviteId=" + inviteId + ", networkId=" + networkId + ", memberId=" + memberId + ", sentBy=" + sentBy + ", sentDate=" + sentDate + ", inviteStatus=" + inviteStatus + '}';
    }

    

}