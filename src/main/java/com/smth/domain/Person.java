package com.smth.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "person", schema = "test")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @Column(name = "first_name")
    String first_name;

    @Column(name = "last_name")
    String last_name;

    @Column(name = "middle_name")
    String middle_name;
//    Date birth_date;
//    String comment;
//    Timestamp update_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public void setMiddleName(String middleName) {
        this.middle_name = middleName;
    }

//    public Date getBirthDate() {
//        return birth_date;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birth_date = birthDate;
//    }

//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public Timestamp getUpdateDate() {
//        return update_date;
//    }
//
//    public void setUpdateDate(Timestamp updateDate) {
//        this.update_date = updateDate;
//    }
}
