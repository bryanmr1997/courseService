package com.learnar.courseService.models;


import javax.persistence.*;

@Entity
public class Activity_Question {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activity_id",referencedColumnName = "id")
    private  Activities activities;

    @ManyToOne
    @JoinColumn(name = "question_id",referencedColumnName = "id")
    private Questions questions;




}
