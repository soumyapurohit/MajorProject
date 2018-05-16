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
@Table(name="network_chat")
public class NetworkChat  implements Serializable {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "chat_id")
    private int chatId;
     @Column(name = "network_id")
     private int networkId;
    @Column(name = "chat_date")
    private Date chatDate;
    
    @Column(name = "chat_msg")
    private String chatMsg;
    @Column(name = "sent_by")
     private int sentBy;
     @Column(name = "chat_active")
      private boolean chatActive;

    public NetworkChat() {
    }

    public NetworkChat(int chatId, int networkId, Date chatDate, String chatMsg, int sentBy, boolean chatActive) {
        this.chatId = chatId;
        this.networkId = networkId;
        this.chatDate = chatDate;
        this.chatMsg = chatMsg;
        this.sentBy = sentBy;
        this.chatActive = chatActive;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public Date getChatDate() {
        return chatDate;
    }

    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
    }

    public String getChatMsg() {
        return chatMsg;
    }

    public void setChatMsg(String chatMsg) {
        this.chatMsg = chatMsg;
    }

    public int getSentBy() {
        return sentBy;
    }

    public void setSentBy(int sentBy) {
        this.sentBy = sentBy;
    }

    public boolean isChaAactive() {
        return chatActive;
    }

    public void setChatActive(boolean chatActive) {
        this.chatActive = chatActive;
    }

    @Override
    public String toString() {
        return "Networkchat{" + "chatid=" + chatId + ", networkId=" + networkId + ", chatDate=" + chatDate + ", chatMsg=" + chatMsg + ", sentBy=" + sentBy + ", chatActive=" + chatActive + '}';
    }

   
   
}
