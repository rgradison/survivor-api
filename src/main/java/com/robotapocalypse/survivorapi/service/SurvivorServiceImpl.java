package com.robotapocalypse.survivorapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.robotapocalypse.survivorapi.model.Location;
import com.robotapocalypse.survivorapi.model.Survivor;
import com.robotapocalypse.survivorapi.repository.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
class SurvivorServiceImpl implements SurvivorService {
    @Autowired
    private SurvivorRepository survivorRepository;
    private static final String ROBOTS_ENDPOINT = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
    @Autowired
    private RestTemplate restTemplate;


    public Survivor addSurvivor(Survivor survivor) {

        return survivorRepository.save(survivor);
    }

    public void updateLocation(Long id, Location location) {
        // Implement the logic to update the location of a survivor here
        Optional<Survivor> survivor = survivorRepository.findById(id);
        if (survivor.get() != null) {
            survivor.get().setLastLocation(location);
            survivorRepository.save(survivor.get());
        }
        else {
            System.out.println("Survivor not found");
        }
    }

    public void flagAsInfected(String  id) {
        // Implement the logic to flag a survivor as infected here
        Survivor survivor = survivorRepository.findBySurvivorId(id);
        if (survivor != null) {
            survivor.setInfected(true);
            survivorRepository.save(survivor);
        }
        else {
            System.out.println("Survivor not found");
        }

    }

    @Override
    public List<Survivor> getAllSurvivors() {
        return survivorRepository.findAll();
    }

    @Override
    public Survivor getSurvivorById(String id) {
        return survivorRepository.findBySurvivorId(id);
    }

    @Override
    public List<Survivor> searchSurvivorByName(String name) {
        return survivorRepository.findSurvivorByName(name);
    }

    public double calculatePercentageOfInfectedSurvivors() {
        // Implement the logic to calculate the percentage of infected survivors
        List<Survivor> allSurvivors = survivorRepository.findAll();
        long infectedCount = allSurvivors.stream().filter(Survivor::isInfected).count();
        return (double) infectedCount / allSurvivors.size() * 100;
    }

    public double calculatePercentageOfNonInfectedSurvivors() {
        // Implement the logic to calculate the percentage of non-infected survivors
        return 100 - calculatePercentageOfInfectedSurvivors();
    }

    public List<Survivor> getInfectedSurvivors() {
        return survivorRepository.findByInfected(true);
    }

    public List<Survivor> getNonInfectedSurvivors() {
        return survivorRepository.findByInfected(false);
    }

    public JsonNode getRobots() {
        ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity(ROBOTS_ENDPOINT, JsonNode.class);
        return responseEntity.getBody();
    }
}






