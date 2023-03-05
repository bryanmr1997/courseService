package com.learnar.courseService.models;



import javax.persistence.*;

@Entity
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private String description;


    private String state;


    @ManyToOne
    private Experiences experienceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Experiences getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Experiences experienceId) {
        this.experienceId = experienceId;
    }

    public Activities() {
    }

    public Activities(String name, String description, String state, Experiences experienceId) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.experienceId = experienceId;
    }


}
