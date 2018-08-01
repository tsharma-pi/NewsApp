package app.com.practiceapplication.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result <T> {

  private String url;
  private String adxKeywords;
  private String column;
  private String section;
  private String byline;
  private String type;
  private String title;
  private String _abstract;
  private String publishedDate;
  private String source;
  private Integer views;
  private List<String> desFacet = null;
  private List<String> orgFacet = null;
  private List<String> perFacet = null;
  private String geoFacet;
  private List<Medium> media = null;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAdxKeywords() {
    return adxKeywords;
  }

  public void setAdxKeywords(String adxKeywords) {
    this.adxKeywords = adxKeywords;
  }

  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public String getSection() {
    return section;
  }

  public void setSection(String section) {
    this.section = section;
  }

  public String getByline() {
    return byline;
  }

  public void setByline(String byline) {
    this.byline = byline;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAbstract() {
    return _abstract;
  }

  public void setAbstract(String _abstract) {
    this._abstract = _abstract;
  }

  public String getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(String publishedDate) {
    this.publishedDate = publishedDate;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Integer getViews() {
    return views;
  }

  public void setViews(Integer views) {
    this.views = views;
  }

  public List<String> getDesFacet() {
    return desFacet;
  }

  public void setDesFacet(List<String> desFacet) {
    this.desFacet = desFacet;
  }

  public List<String> getOrgFacet() {
    return orgFacet;
  }

  public void setOrgFacet(List<String> orgFacet) {
    this.orgFacet = orgFacet;
  }

  public List<String> getPerFacet() {
    return perFacet;
  }

  public void setPerFacet(List<String> perFacet) {
    this.perFacet = perFacet;
  }

  public String getGeoFacet() {
    return geoFacet;
  }

  public void setGeoFacet(String geoFacet) {
    this.geoFacet = geoFacet;
  }

  public List<Medium> getMedia() {
    return media;
  }

  public void setMedia(List<Medium> media) {
    this.media = media;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
