package com.robotapocalypse.survivorapi.controller;


import com.robotapocalypse.survivorapi.model.Survivor;
import com.robotapocalypse.survivorapi.service.SurvivorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class SurvivorControllerTest {

    @InjectMocks
    private SurvivorController survivorController;

    @Mock
    private SurvivorService survivorService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddSurvivor_Positive() {
        Survivor survivor = new Survivor();
        Mockito.when(survivorService.addSurvivor(any(Survivor.class))).thenReturn(survivor);

        ResponseEntity<Survivor> response = survivorController.addSurvivor(survivor);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(survivor, response.getBody());
    }




//    @Test
//    public void testUpdateLocation_Negative() {
//        Survivor survivor = null;
//        Mockito.when(survivorService.getSurvivorById(anyString())).thenReturn(survivor);
//
//        ResponseEntity response = survivorController.updateLocation(null);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//    }

    @Test
    public void testFlagInfected_Positive() {
        String survivorId = "1";
        Mockito.doNothing().when(survivorService).flagAsInfected(survivorId);
        ResponseEntity expectedResponse = ResponseEntity.ok("survivor status updated");

        ResponseEntity response = survivorController.flagInfected(survivorId);

        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());
        assertEquals(expectedResponse.getBody(), response.getBody());
    }

//    @Test
//    public void testFlagInfected_Negative() {
//        String survivorId = "2";
//        Mockito.doThrow(new RuntimeException("Survivor not found")).when(survivorService).flagAsInfected(survivorId);
//
//        ResponseEntity response = survivorController.flagInfected(survivorId);
//
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//        assertEquals("Error: Survivor not found", response.getBody());
//    }

    @Test
    public void testGetAllSurvivors_Positive() {
        List<Survivor> survivors = Collections.singletonList(new Survivor());
        Mockito.when(survivorService.getAllSurvivors()).thenReturn(survivors);

        ResponseEntity<List<Survivor>> response = survivorController.getAllSurvivors();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(survivors, response.getBody());
    }

//    @Test
//    public void testGetAllSurvivors_Negative() {
//        Mockito.when(survivorService.getAllSurvivors()).thenReturn(Collections.emptyList());
//
//        ResponseEntity<List<Survivor>> response = survivorController.getAllSurvivors();
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//    }

    @Test
    public void testGetSurvivorById_Positive() {
        Survivor survivor = new Survivor();
        Mockito.when(survivorService.getSurvivorById(anyString())).thenReturn(survivor);

        ResponseEntity<Survivor> response = survivorController.getSurvivorById("1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(survivor, response.getBody());
    }

//    @Test
//    public void testGetSurvivorById_Negative() {
//        String nonExistentSurvivorId = "99";
//        Mockito.when(survivorService.getSurvivorById(nonExistentSurvivorId)).thenReturn(null);
//
//        ResponseEntity<Survivor> response = survivorController.getSurvivorById(nonExistentSurvivorId);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertNull(response.getBody());
//    }

    @Test
    public void testSearchSurvivorByName_Positive() {
        String name = "John";
        List<Survivor> survivors = Collections.singletonList(new Survivor());
        Mockito.when(survivorService.searchSurvivorByName(name)).thenReturn(survivors);

        ResponseEntity<List<Survivor>> response = survivorController.searchSurvivorByName(name);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(survivors, response.getBody());
    }

//    @Test
//    public void testSearchSurvivorByName_Negative() {
//        String nonExistentName = "NonExistentName";
//        Mockito.when(survivorService.searchSurvivorByName(nonExistentName)).thenReturn(Collections.emptyList());
//
//        ResponseEntity<List<Survivor>> response = survivorController.searchSurvivorByName(nonExistentName);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//    }
}
