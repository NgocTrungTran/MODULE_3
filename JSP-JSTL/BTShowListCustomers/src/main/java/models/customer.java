package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class customer {
    private String name;
    private String birth;
    private String address;
    private String image;
    private static final DateFormat df = new SimpleDateFormat ( "yyyy/MM/dd" );

    public customer(String name, String birth, String address, String image) {
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
