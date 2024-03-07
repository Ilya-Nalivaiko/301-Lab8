package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }


    @Test
    public void testHasCity(){
        list = MockCityList();
        City newCity = new City("TestCity", "testProvince");
        assertFalse(list.hasCity(newCity));
        list.addCity(newCity);
        assertTrue(list.hasCity(newCity));
    }

    @Test
    public void testDeleteCity(){
        list = MockCityList();
        City newCity = new City("TestCity", "testProvince");
        list.addCity(newCity);
        list.delete(newCity);
        assertFalse(list.hasCity(newCity));

        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(newCity);
        });

    }

    @Test
    public void testCountCities(){
        list = MockCityList();
        assertEquals(0, list.getCount());
        City c1 = new City("a", "e");
        City c2 = new City("b", "f");
        City c3 = new City("c", "g");
        City c4 = new City("d", "h");
        list.addCity(c1);
        list.addCity(c2);
        list.addCity(c3);
        list.addCity(c4);
        assertEquals(4, list.getCount());
    }
}
