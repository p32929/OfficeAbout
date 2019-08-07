package p32929.officeaboutlib.Models;

import java.util.ArrayList;

public class OfficeInfo {
    String officeLogoUrl;
    String googlePlayUrl;
    String facebookUrl;
    String groupUrl;
    String youtubeUrl;
    String githubUrl;
    String webUrl;
    ArrayList<Member> members;

    public String getOfficeLogoUrl() {
        return officeLogoUrl;
    }

    public void setOfficeLogoUrl(String officeLogoUrl) {
        this.officeLogoUrl = officeLogoUrl;
    }

    public String getGooglePlayUrl() {
        return googlePlayUrl;
    }

    public void setGooglePlayUrl(String googlePlayUrl) {
        this.googlePlayUrl = googlePlayUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getGroupUrl() {
        return groupUrl;
    }

    public void setGroupUrl(String groupUrl) {
        this.groupUrl = groupUrl;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public OfficeInfo(String officeLogoUrl, String googlePlayUrl, String facebookUrl, String groupUrl, String youtubeUrl, String githubUrl, String webUrl) {
        this.officeLogoUrl = officeLogoUrl;
        this.googlePlayUrl = googlePlayUrl;
        this.facebookUrl = facebookUrl;
        this.groupUrl = groupUrl;
        this.youtubeUrl = youtubeUrl;
        this.githubUrl = githubUrl;
        this.webUrl = webUrl;
    }

    public OfficeInfo(String officeLogoUrl, String googlePlayUrl, String facebookUrl, String groupUrl, String youtubeUrl, String githubUrl, String webUrl, ArrayList<Member> members) {
        this.officeLogoUrl = officeLogoUrl;
        this.googlePlayUrl = googlePlayUrl;
        this.facebookUrl = facebookUrl;
        this.groupUrl = groupUrl;
        this.youtubeUrl = youtubeUrl;
        this.githubUrl = githubUrl;
        this.webUrl = webUrl;
        this.members = members;
    }
}