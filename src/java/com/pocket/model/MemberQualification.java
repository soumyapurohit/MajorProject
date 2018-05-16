package com.pocket.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.SessionFactory;

/**
 *
 * @author hp
 */

@Entity
@Table(name="member_qualification")
public class MemberQualification  implements Serializable{
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private int qualification_id;
    private String title,type,stream;
    private int year;
    private String college;
    private float percentage;
    @Column(name="member_id")
    private int memberId;

    public MemberQualification() {
        
    }

    public MemberQualification(int qualification_id, String title, String type, String stream, int year, String college, float percentage, int memberId) {
        this.qualification_id = qualification_id;
        this.title = title;
        this.type = type;
        this.stream = stream;
        this.year = year;
        this.college = college;
        this.percentage = percentage;
        this.memberId = memberId;
    }

    public int getQualification_id() {
        return qualification_id;
    }

    public void setQualification_id(int qualification_id) {
        this.qualification_id = qualification_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberQualification{" + "qualification_id=" + qualification_id + ", title=" + title + ", type=" + type + ", stream=" + stream + ", year=" + year + ", college=" + college + ", percentage=" + percentage + ", memberId=" + memberId + '}';
    }

   
    
    
    
    
}
