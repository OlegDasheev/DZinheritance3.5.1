package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product{
    private String name;
    private String manufacturer;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.name = name;
        this.manufacturer = manufacturer;
    }

//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, manufacturer);
    }

}
