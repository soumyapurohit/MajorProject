package com.pocket.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="user")
public class User  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    
    private int user_id;
    
    private int otp;

    @Column(name="member_id")    
    private int memberId;
    
    private String user_Type,login_id,password;
    
    private boolean user_active;
    
    public User(){
        
    }

    public User(int user_id, int otp, int memberId, String user_Type, String login_id, String password, boolean user_active) {
        this.user_id = user_id;
        this.otp = otp;
        this.memberId = memberId;
        this.user_Type = user_Type;
        this.login_id = login_id;
        this.password = password;
        this.user_active = user_active;
    }

    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getUser_Type() {
        return user_Type;
    }

    public void setUser_Type(String user_Type) {
        this.user_Type = user_Type;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getUser_active() {
        return user_active;
    }

    public void setUser_active(boolean user_active) {
        this.user_active = user_active;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", otp=" + otp + ", memberId=" + memberId + ", user_Type=" + user_Type + ", login_id=" + login_id + ", password=" + password + ", user_active=" + user_active + '}';
    }
}
    
