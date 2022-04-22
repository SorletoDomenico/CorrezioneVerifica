/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correzioneverifica;

/**
 *
 * @author palazzolo_thomas
 */
public class Place {

    private double lat, lon;
    private String city, town, street, country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    

    public Place(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Place() {
        town="";
    }
    

    public String toString() {
        return "latitude: " + lat + ", longitude: " + lon;
    }
    
    /*public double distanzaDa(Place p2)
    {
        
    }*/

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    
}
