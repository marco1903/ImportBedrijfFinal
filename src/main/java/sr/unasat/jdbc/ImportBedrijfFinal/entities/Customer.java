package sr.unasat.jdbc.ImportBedrijfFinal.entities;

public class Customer {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String street_name;
    private String house_number;
    private String identification_number;
    private String mobile_number;

    public Customer(int customer_id,
                    String first_name,
                    String last_name,
                    String street_name,
                    String house_number,
                    String identification_number,
                    String mobile_number) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street_name = street_name;
        this.house_number = house_number;
        this.identification_number = identification_number;
        this.mobile_number = mobile_number;
    }

    public Customer(String mobile_number,
                    int customer_id) {
        this.mobile_number = mobile_number;
        this.customer_id = customer_id;
    }

    public Customer(int customer_id) {
        this.customer_id = customer_id;
    }

    public Customer(int customer_id,
                    String last_name) {
        this.customer_id = customer_id;
        this.last_name = last_name;
    }

    public int getCustomer_id() { return customer_id; }

    public void setCustomer_id(int customer_id) { this.customer_id = customer_id; }

    public String getFirst_name() { return first_name; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getStreet_name() { return street_name; }

    public void setStreet_name(String street_name) { this.street_name = street_name; }

    public String getHouse_number() { return house_number; }

    public void setHouse_number(String house_number) { this.house_number = house_number; }

    public String getIdentification_number() { return identification_number; }

    public void setIdentification_number(String identification_number) { this.identification_number = identification_number; }

    public String getMobile_number() { return mobile_number; }

    public void setMobile_number(String mobile_number) { this.mobile_number = mobile_number; }

    @Override
    public String toString() {
        return  "\nCustomer ID: " + customer_id +
                "\nFirst Name: " + first_name +
                "\nLast Name: " + last_name +
                "\nStreet Name: " + street_name +
                "\nHouse Number: " + house_number +
                "\nID Number: " + identification_number +
                "\nMobile Number: " + mobile_number;
    }
}
