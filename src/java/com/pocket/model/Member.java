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
@Table (name="member")
public class Member  implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    
    private int memberId;
   
    private String fname,lname,phone,email;
    
    @Column(name = "profile_pic")
    private String profilePic;
    
    private String gender,city;
   
    @Column(name="dob")
    private Date dateOfBirth;
    
    @Column(name="is_active")
    private boolean isActive;
    
    public Member(){
        
    }

    public Member(int memberId, String fname, String lname, String phone, String email, String profilePic, String gender, String city, Date dateOfBirth, boolean isActive) {
        this.memberId = memberId;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.profilePic = profilePic;
        this.gender = gender;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.isActive = isActive;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Member{" + "memberId=" + memberId + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", email=" + email + ", profilePic=" + profilePic + ", gender=" + gender + ", city=" + city + ", dateOfBirth=" + dateOfBirth + ", isActive=" + isActive + '}';
    }
    
}

   