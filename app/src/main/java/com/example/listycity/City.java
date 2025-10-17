package com.example.listycity;


/**
* This class represents a city
*/

public class City implements Comparable<City>{
    private String city;
    private String province;
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }
    String getCity() {
        return city;
    }
    String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method compares City objects based on their city name field
     * @param o the object to be compared.
     * @return 0, less than 1 or greater than 1 if two values are equal , a is less than b, or a is greater than b
     */
    @Override
    public int compareTo(City o) {
        // City city = (City) o;
        return this.city.compareTo(o.getCity());
    }

}
