package com.savsh.entity;

public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private Favorite favorite = new Favorite();
    private Busket busket = new Busket();

    public Customer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {

    }

    public Busket getBusket() {
        return busket;
    }

    public void setBusket(Busket busket) {
        this.busket = busket;
    }

}
