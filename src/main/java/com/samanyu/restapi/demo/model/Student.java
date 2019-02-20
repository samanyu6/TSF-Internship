package com.samanyu.restapi.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

//used for annotating as a java persistence class
@Entity

//Used to map table from database
@Table(name = "stud")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"},
        allowGetters = true)

public class Student implements Serializable {

    //@Id Used for pk definition
    @javax.persistence.Id
    //Used to show how primary key is generated (autoincrement here)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @NotBlank
    private String name;

    @NotBlank
    private int grade;

    @NotBlank
    private int marks;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)

    @CreatedDate
    private Date createdAt;

    //define properties for the column
    @Column(nullable = false)

    //Used to covert java objects into db readable notation
    @Temporal(TemporalType.TIMESTAMP)


    @LastModifiedBy
    private Date modifiedAt;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
