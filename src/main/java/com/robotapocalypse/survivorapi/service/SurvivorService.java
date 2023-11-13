package com.robotapocalypse.survivorapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.robotapocalypse.survivorapi.model.Location;
import com.robotapocalypse.survivorapi.model.Survivor;

import java.util.List;
import java.util.Optional;

public interface SurvivorService {
    double calculatePercentageOfInfectedSurvivors();
    public double calculatePercentageOfNonInfectedSurvivors();

    public List<Survivor> getInfectedSurvivors();

    public List<Survivor> getNonInfectedSurvivors() ;

    public JsonNode getRobots();


    public Survivor addSurvivor(Survivor survivor) ;

    public void updateLocation(Long id, Location location);

    public void flagAsInfected(String  id);

    List<Survivor> getAllSurvivors();

    Survivor getSurvivorById(String id);

    List<Survivor> searchSurvivorByName(String name);
}
