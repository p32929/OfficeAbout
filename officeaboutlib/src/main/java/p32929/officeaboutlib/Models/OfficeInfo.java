package p32929.officeaboutlib.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class OfficeInfo implements Parcelable {
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

    protected OfficeInfo(Parcel in) {
        officeLogoUrl = in.readString();
        googlePlayUrl = in.readString();
        facebookUrl = in.readString();
        groupUrl = in.readString();
        youtubeUrl = in.readString();
        githubUrl = in.readString();
        webUrl = in.readString();
        if (in.readByte() == 0x01) {
            members = new ArrayList<Member>();
            in.readList(members, Member.class.getClassLoader());
        } else {
            members = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(officeLogoUrl);
        dest.writeString(googlePlayUrl);
        dest.writeString(facebookUrl);
        dest.writeString(groupUrl);
        dest.writeString(youtubeUrl);
        dest.writeString(githubUrl);
        dest.writeString(webUrl);
        if (members == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(members);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<OfficeInfo> CREATOR = new Parcelable.Creator<OfficeInfo>() {
        @Override
        public OfficeInfo createFromParcel(Parcel in) {
            return new OfficeInfo(in);
        }

        @Override
        public OfficeInfo[] newArray(int size) {
            return new OfficeInfo[size];
        }
    };
}