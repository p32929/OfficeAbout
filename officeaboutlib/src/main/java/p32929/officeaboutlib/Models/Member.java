package p32929.officeaboutlib.Models;

public class Member {
    String imageUrl;
    String name;
    String post;
    String contactUrl;

    public Member(String imageUrl, String name, String post, String contactUrl) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.post = post;
        this.contactUrl = contactUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }
}