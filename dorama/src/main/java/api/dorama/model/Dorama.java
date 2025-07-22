package api.dorama.model;

import api.dorama.model.enuns.StatusDorama;

public class Dorama {
    private String title;
    private String gender;
    private String broadcast_network;
    private String country;
    private StatusDorama statusDorama;

    public Dorama(){

    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getGender() {
        return gender;
    }

    public String getBroadcast_network() {
        return broadcast_network;
    }

    public String getCountry() {
        return country;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setBroadcast_network(String broadcast_network) {
        this.broadcast_network = broadcast_network;
    }

    public void setCountry(String Country) {
        this.country = Country;
    }

    public StatusDorama getStatusDorama() {
        return statusDorama;
    }

    public void setStatusDorama(StatusDorama statusDorama) {
        this.statusDorama = statusDorama;
    }

}
