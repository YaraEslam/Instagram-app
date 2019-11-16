package com.example.instagram.model;

import java.io.Serializable;

public class images implements Serializable {

    private String profileImage;
    private String ProfileName;
    private String home_image;

    public images(String profileImage) {

        this.profileImage = profileImage;
    }

    public images(String profileImage, String ProfileName, String home_image) {

        this.profileImage = profileImage;
        this.ProfileName = ProfileName;
        this.home_image = home_image;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileName() {
        return ProfileName;
    }

    public void setProfileName(String profileName) {
        ProfileName = profileName;
    }

    public String getHome_image() {
        return home_image;
    }

    public void setHome_image(String home_image) {
        this.home_image = home_image;
    }
}
