package com.synnlabz.seist.Cards;

public class cards {
    private String userId;
    private String name;
    private String intake;
    private String profileImageUrl;
    public cards (String userId,String name , String intake , String profileImageUrl){
        this.userId = userId;
        this.name = name;
        this.intake = intake;
        this.profileImageUrl = profileImageUrl;
    }

    public String getUserId(){
        return userId;
    }
    public void setUserID(String userID){
        this.userId = userId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getIntake(){
        return intake;
    }
    public void setIntake(String intake){
        this.intake = intake;
    }

    public String getProfileImageUrl(){
        return profileImageUrl;
    }
    public void setProfileImageUrl(String profileImageUrl){
        this.profileImageUrl = profileImageUrl;
    }
}
