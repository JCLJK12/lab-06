package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
*  This class holds the City type objects in a list
*/

public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a city object to the cities list
     * @param city
     * This is a city object we want to add to the list
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This removes a city object from the cities list
     * @param city
     * This is the city object we want to delete from the list
     *  @throws IllegalArgumentException if the city doesn't exist in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This method sorts the list of cities
     * @return
     *  Return a sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method checks if the cityList contains the city
     * @param city
     * @return
     *  true if the city exists, false if it doesn't
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This method counts how many cities are in the cityList
     * @return
     *  the number of cities in the cityList
     */
    public int countCities() {
        return cities.size();
    }

}
