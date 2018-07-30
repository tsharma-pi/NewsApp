package app.com.practiceapplication.model;

public class NewsModel {

  String imageURL;
  String headline;
  String date;
  String author;

  public NewsModel(String imageURL, String headline, String date, String author) {
    this.imageURL = imageURL;
    this.headline = headline;
    this.date = date;
    this.author = author;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
