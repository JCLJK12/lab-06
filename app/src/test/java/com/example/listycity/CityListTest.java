package com.example.listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import androidx.annotation.OpenForTesting;
import org.junit.Test;


public class CityListTest {
    public City mockCity() {
        return new City("Edmonton", "AB");
    }

    public CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }


    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City c = new City("CharlotteTown", "PEI");
        cityList.add(c);
        assertEquals(0, c.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));

    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City Toronto = new City("Toronto", "ON");
        cityList.add(Toronto);

        // ensure city is added
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(Toronto));

        // delete the city
        cityList.delete(Toronto);

        // verify city was deleted
        assertFalse(cityList.getCities().contains(Toronto));
        assertEquals(1, cityList.getCities().size());
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        // add Toronto to city list
        City Toronto = new City("Toronto", "ON");
        cityList.add(Toronto);

        // test if city list has Toronto and size of cityList = 2
        assertEquals(true, cityList.hasCity(Toronto));
        assertEquals(2, cityList.countCities());

        // test if Vancouver is not in cityList
        City Vancouver = new City("Vancouver", "BC");
        assertEquals(false, cityList.hasCity(Vancouver));
        assertEquals(2, cityList.countCities());

    }


    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City Toronto = new City("Toronto", "ON");
        // not in list yet — should throw
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(Toronto);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList(); // has 1 city initially
        assertEquals(1, cityList.countCities());

        City Toronto = new City("Toronto", "ON");
        cityList.add(Toronto);
        assertEquals(2, cityList.countCities());

        cityList.delete(Toronto);
        assertEquals(1, cityList.countCities());
    }

}
