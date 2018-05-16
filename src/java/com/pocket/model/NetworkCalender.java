package com.pocket.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lenovo_win_10
 */
@Entity
@Table(name="network_calender")
public class NetworkCalender  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "network_calender_id")
    private int networkCalenderId;
     @Column(name = "network_id")
     private int networkId;
    @Column(name = "post_by")
    private int postBy;
    
    @Column(name = "post_date")
    private Date postDate;
    @Column(name = "calender_date ")
     private Date calenderDate;
    private String message;
     @Column(name = "reminder_active")
      private boolean reminderActive;

    public NetworkCalender() {
    }

    public NetworkCalender(int networkCalenderId, int networkId, int postBy, Date postDate, Date calenderDate, String message, boolean reminderActive) {
        this.networkCalenderId = networkCalenderId;
        this.networkId = networkId;
        this.postBy = postBy;
        this.postDate = postDate;
        this.calenderDate = calenderDate;
        this.message = message;
        this.reminderActive = reminderActive;
    }

    public int getNetworkCalenderId() {
        return networkCalenderId;
    }

    public void setNetworkCalenderId(int networkCalenderId) {
        this.networkCalenderId = networkCalenderId;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkid(int networkId) {
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

    public Date getCalenderDate() {
        return calenderDate;
    }

    public void setCalenderDate(Date calenderDate) {
        this.calenderDate = calenderDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReminderActive() {
        return reminderActive;
    }

    public void setReminderActive(boolean reminderActive) {
        this.reminderActive = reminderActive;
    }

    @Override
    public String toString() {
        return "NetworkCalender{" + "networkCalenderId=" + networkCalenderId + ", networkId=" + networkId + ", postBy=" + postBy + ", postDate=" + postDate + ", calenderDate=" + calenderDate + ", message=" + message + ", reminderActive=" + reminderActive + '}';
    }

    

    
}
