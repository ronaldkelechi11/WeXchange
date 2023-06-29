package com.wehub.wexchange.models;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    String _id;
    String name;
    String profilePic;
    ArrayList<Ads> ads;
    String password;
    String telephone;
    String address;
    String about;
}
