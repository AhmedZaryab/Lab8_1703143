package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * Create a mock list for testing city list functionalities.
     * @return CustomList instance
     */
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @BeforeEach
    public void setUp() {
        list = MockCityList();
    }

    @Test
    public void hasCityTest() {
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(true, list.hasCity(city));  // Expecting true after adding the city

        City nonExistingCity = new City("Calgary", "AB");
        assertEquals(false, list.hasCity(nonExistingCity));  // Expecting false for a city not in the list
    }

    @Test
    public void deleteCityTest() {
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        list.deleteCity(city);
        assertEquals(false, list.hasCity(city));  // Expecting false since the city is deleted
    }

    @Test
    public void countCitiesTest() {
        assertEquals(0, list.countCities());  // Initially, the list should be empty

        list.addCity(new City("Edmonton", "AB"));
        assertEquals(1, list.countCities());  // After adding a city, count should be 1
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SM"));
        assertEquals(list.getCount(), listSize + 1);  // Expecting the count to increase by 1
    }
}
