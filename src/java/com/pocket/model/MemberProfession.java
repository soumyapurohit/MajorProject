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
 * @author hp
 */

@Entity
@Table(name="member_profession")
public class MemberProfession  implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profession_id")
    
    private int professionId;
     
    private String title;
     @Column(name = "company_name")
    private String companyName;
    private String designation;
    @Column(name = "package")
    private String pack;
    @Column(name = "join_date")
    private Date joinDate;
    @Column(name = "end_date")
    private Date endDate;
    private String city;
    @Column(name = "member_id")
    private int memberId;

    public MemberProfession() {
    }

    public MemberProfession(int professionId, String title, String companyName, String designation, String pack, Date joinDate, Date endDate, String city, int memberId) {
        this.professionId = professionId;
        this.title = title;
        this.companyName = companyName;
        this.designation = designation;
        this.pack = pack;
        this.joinDate = joinDate;
        this.endDate = endDate;
        this.city = city;
        this.memberId = memberId;
    }

    public int getProfessionId() {
        return professionId;
    }

    public void setProfessionId(int professionId) {
        this.professionId = professionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberProfession{" + "professionId=" + professionId + ", title=" + title + ", companyName=" + companyName + ", designation=" + designation + ", pack=" + pack + ", joinDate=" + joinDate + ", endDate=" + endDate + ", city=" + city + ", memberId=" + memberId + '}';
    }
    
    
     
    
}
