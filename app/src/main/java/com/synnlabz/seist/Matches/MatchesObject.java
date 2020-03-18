package com.synnlabz.seist.Matches;

public class MatchesObject {
    private String userId;
    private String name;
    private String intake;
    private String degree;
    private String status;
    private String profileImageUrl;
    public MatchesObject (String userId, String name, String intake , String degree , String status,String profileImageUrl){
        this.userId = userId;
        this.name = name;
        this.intake = intake;
        this.degree = degree;
        this.status = status;
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

    public String getDegree(){
        return degree;
    }
    public void setDegree(String degree){
        this.degree = degree;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getProfileImageUrl(){
        return profileImageUrl;
    }
    public void setProfileImageUrl(String profileImageUrl){
        this.profileImageUrl = profileImageUrl;
    }
}