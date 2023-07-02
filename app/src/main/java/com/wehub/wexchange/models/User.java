package com.wehub.wexchange.models;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    String _id;//primary id
    String name;
    String profilePic;
    ArrayList<Ads> ads;
    String password;
    String telephone;//unique id
    String address;
    String about;

    public User(String _id, String name, String profilePic, ArrayList<Ads> ads, String password, String telephone, String address, String about) {
        this._id = _id;
        this.name = name;
        this.profilePic = profilePic;
        this.ads = ads;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
        this.about = about;
    }

    public User(String name, String profilePic, ArrayList<Ads> ads, String password, String telephone, String address, String about) {
        this.name = name;
        this.profilePic = profilePic;
        this.ads = ads;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
        this.about = about;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public ArrayList<Ads> getAds() {
        return ads;
    }

    public void setAds(ArrayList<Ads> ads) {
        this.ads = ads;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
