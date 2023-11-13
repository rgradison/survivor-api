//package com.robotapocalypse.survivorapi.repository;
//
//import com.robotapocalypse.survivorapi.model.Location;
//import com.robotapocalypse.survivorapi.model.Survivor;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.when;
//
//@DataJpaTest
//@RunWith(SpringRunner.class)
//public class SurvivorRepositoryTest {
//
//    @Mock
//    private SurvivorRepository survivorRepository;
//
//    @BeforeEach
//    public void setup() {
//        Survivor survivor1 = new Survivor();
//        survivor1.setSurvivorId("123");
//        survivor1.setInfected(false);
//        survivor1.setAge(30);
//        survivor1.setGender("male");
//        survivor1.setName("Ralph");
//        survivor1.setLastLocation(new Location(10.0, 20.0));
//        survivor1.setId(1L);
//
//        Survivor survivor2 = new Survivor();
//        survivor2.setSurvivorId("123");
//        survivor2.setInfected(false);
//        survivor2.setAge(30);
//        survivor2.setGender("male");
//        survivor2.setName("Ralph");
//        survivor2.setLastLocation(new Location(10.0, 20.0));
//        survivor2.setId(1L);
//
//        List<Survivor> allSurvivors = new ArrayList<>();
//        allSurvivors.add(survivor1);
//        allSurvivors.add(survivor2);
//
//        when(survivorRepository.findByInfected(false)).thenReturn(allSurvivors);
//        when(survivorRepository.findBySurvivorId("1")).thenReturn(survivor1);
//        when(survivorRepository.findBySurvivorId("3")).thenReturn(null);
//        when(survivorRepository.findSurvivorByName("John")).thenReturn(List.of(survivor1));
//    }
//
//    @Test
//    public void testFindByInfectedPositive() {
//        List<Survivor> survivors = survivorRepository.findByInfected(false);
//        assertEquals(2, survivors.size());
//    }
//
//    @Test
//    public void testFindBySurvivorIdPositive() {
//        Survivor survivor = survivorRepository.findBySurvivorId("1");
//        assertEquals("1", survivor.getSurvivorId());
//    }
//
//    @Test
//    public void testFindBySurvivorIdNegative() {
//        Survivor survivor = survivorRepository.findBySurvivorId("3");
//        assertEquals(null, survivor);
//    }
//
//    @Test
//    public void testFindSurvivorByNamePositive() {
//        List<Survivor> survivors = survivorRepository.findSurvivorByName("John Doe");
//        assertTrue(!survivors.isEmpty());
//    }
//
//    @Test
//    public void testFindSurvivorByNameNegative() {
//        List<Survivor> survivors = survivorRepository.findSurvivorByName("NonExistentName");
//        assertTrue(survivors.isEmpty());
//    }
//}