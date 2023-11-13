package com.robotapocalypse.survivorapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

@Entity
public class Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private int age;

    private String gender;

    @Embedded
    private Location lastLocation;

    @ElementCollection
    @CollectionTable(name = "survivor_resources")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<ResourceType, Integer> resources;
    
    @NotBlank
    @Column(name = "survivor_id",unique = true)
    private String survivorId;
    
    private boolean infected;

    // Getters and setters

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }

    public Map<ResourceType, Integer> getResources() {
        return resources;
    }

    public void setResources(Map<ResourceType, Integer> resources) {
        this.resources = resources;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public String getSurvivorId() {
        return survivorId;
    }

    public void setSurvivorId(String survivorId) {
        this.survivorId = survivorId;
    }

    @Override
    public String toString() {
        return "Survivor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", lastLocation=" + lastLocation +
                ", resources=" + resources +
                ", survivorId='" + survivorId + '\'' +
                ", infected=" + infected +
                '}';
    }
}
