package com.example.demo.tests;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "c_no")
    private String cNo;

    @Column(name = "title")
    private String title;

    @Column(name = "hours")
    private int hours;

    // Геттеры и сеттеры
    public String getCNo() {
        return cNo;
    }

    public void setCNo(String cNo) {
        this.cNo = cNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
