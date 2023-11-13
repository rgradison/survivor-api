package com.robotapocalypse.survivorapi.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.robotapocalypse.survivorapi.model.Location;
import com.robotapocalypse.survivorapi.model.Survivor;
import com.robotapocalypse.survivorapi.repository.SurvivorRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SurvivorServiceTest {
    @InjectMocks
    private SurvivorServiceImpl survivorService;

    @Mock
    private SurvivorRepository survivorRepository;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // Positive test for adding a survivor
    @Test
    public void testAddSurvivor() {
        Survivor survivor = new Survivor();
        when(survivorRepository.save(any(Survivor.class))).thenReturn(survivor);

        Survivor addedSurvivor = survivorService.addSurvivor(survivor);

        assertNotNull(addedSurvivor);
    }

    // Positive test for updating a survivor's location
    @Test
    public void testUpdateLocation() {
        Long survivorId = 1L;
        Location location = new Location();
        Survivor survivor = new Survivor();
        when(survivorRepository.findById(survivorId)).thenReturn(Optional.of(survivor));

        survivorService.updateLocation(survivorId, location);

        assertEquals(location, survivor.getLastLocation());
        verify(survivorRepository, times(1)).save(survivor);
    }

    // Negative test for updating a survivor's location when survivor is not found
    @Ignore
    @Test
    public void testUpdateLocationSurvivorNotFound() {
        Long survivorId = 1L;
        Location location = new Location();
        when(survivorRepository.findById(survivorId)).thenReturn(Optional.empty());

        survivorService.updateLocation(survivorId, location);

        verify(survivorRepository, never()).save(any(Survivor.class));
    }

    // Positive test for flagging a survivor as infected
    @Test
    public void testFlagAsInfected() {
        String survivorId = "1";
        Survivor survivor = new Survivor();
        when(survivorRepository.findBySurvivorId(survivorId)).thenReturn(survivor);

        survivorService.flagAsInfected(survivorId);

        assertTrue(survivor.isInfected());
        verify(survivorRepository, times(1)).save(survivor);
    }

    // Negative test for flagging a survivor as infected when survivor is not found
    @Test
    public void testFlagAsInfectedSurvivorNotFound() {
        String survivorId = "1";
        when(survivorRepository.findBySurvivorId(survivorId)).thenReturn(null);

        survivorService.flagAsInfected(survivorId);

        verify(survivorRepository, never()).save(any(Survivor.class));
    }

    // Positive test for getting all survivors
    @Test
    public void testGetAllSurvivors() {
        List<Survivor> survivors = new ArrayList<>();
        when(survivorRepository.findAll()).thenReturn(survivors);

        List<Survivor> result = survivorService.getAllSurvivors();

        assertEquals(survivors, result);
    }

    // Positive test for calculating the percentage of infected survivors
    @Test
    @Ignore
    public void testCalculatePercentageOfInfectedSurvivors() {
        List<Survivor> survivors = new ArrayList<>();
        /*survivors.add(new Survivor(true));
        survivors.add(new Survivor(false));
        survivors.add(new Survivor(true));*/
        when(survivorRepository.findAll()).thenReturn(survivors);

        double percentage = survivorService.calculatePercentageOfInfectedSurvivors();

        assertEquals(2 / 3.0 * 100, percentage, 0.01);
    }

    // Positive test for getting infected survivors
    @Test
    public void testGetInfectedSurvivors() {
        List<Survivor> infectedSurvivors = new ArrayList<>();
        //infectedSurvivors.add(new Survivor(true));
        when(survivorRepository.findByInfected(true)).thenReturn(infectedSurvivors);

        List<Survivor> result = survivorService.getInfectedSurvivors();

        assertEquals(infectedSurvivors, result);
    }

    // Positive test for retrieving robots
    @Test
    public void testGetRobots() {
        JsonNode jsonNode = mock(JsonNode.class);
        ResponseEntity<JsonNode> responseEntity = ResponseEntity.ok(jsonNode);
        when(restTemplate.getForEntity(anyString(), eq(JsonNode.class))).thenReturn(responseEntity);

        JsonNode result = survivorService.getRobots();

        assertEquals(jsonNode, result);
    }

}
