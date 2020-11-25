public class Address {
    private String postalCode;
    private String streetName;
    private int buildingNumber;
    private String city;
    private String state;
    private String country;

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
    public String toString() {
        return buildingNumber + " " + streetName + ", " + postalCode + ", " + city + ", " + state + ", " + country
                + ".";
    }
}
