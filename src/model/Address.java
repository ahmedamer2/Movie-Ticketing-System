package model;

/**
 * This class represents the address of a person/theatre
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 29, 2020
 */
public class Address {
    private String postalCode;
    private String streetName;
    private int buildingNumber;
    private String city;
    private String state;
    private String country;

    /**
     * This is the constructor of Address which takes in all the components like building number , city
     * and sets the address for that person/theatre
     * @param buildingNumber  building number in the address of a person/theatre
     * @param streetName street name in the address of person/theatre
     * @param postalCode postal code in the address of person/theatre
     * @param city city name where person lives or theatre is located 
     * @param state state where the person lives or the theatre is located 
     * @param country country where the person lives or the theatre is located
     */
    public Address(int buildingNumber, String streetName, String postalCode, String city, String state,
            String country) {
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
    
    @Override
    /**
     * this function returns the address of the person or theatre respectively
     * @return returns address  in type String 
     */
    public String toString() {
        return buildingNumber + " " + streetName + ", " + postalCode + ", " + city + ", " + state + ", " + country
                + ".";
    }
}
