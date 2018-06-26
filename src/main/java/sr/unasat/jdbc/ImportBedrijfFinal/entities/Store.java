package sr.unasat.jdbc.ImportBedrijfFinal.entities;

public class Store {
    private int store_id;
    private String name;
    private String website;
    private String email;
    private String street_name;

    public Store(int store_id) {
        this.store_id = store_id;
    }

    public Store(String name) {
        this.name = name;
    }



    public Store(int store_id,
                 String name,
                 String website,
                 String email,
                 String street_name) {
        this.store_id = store_id;
        this.name = name;
        this.website = website;
        this.email = email;
        this.street_name = street_name;
    }

    public Store(int store_id,
                 String name) {
        this.store_id = getStore_id();
        this.name = getName();
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    @Override
    public String toString() {
        return  "\nStore ID: " + store_id +
                "\nName: " + name +
                "\nWebsite: " + website +
                "\nEmail: " + email +
                "\nStreet Name: " + street_name;
    }
}
