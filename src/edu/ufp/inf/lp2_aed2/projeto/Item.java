package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;
import java.lang.String;

public class Item {

  public String id_geo;
  public String item;
  public Geocache Geocache;

  public Item(String id_geo, String item, edu.ufp.inf.lp2_aed2.projeto.Geocache geocache) {
    this.id_geo = id_geo;
    this.item = item;
    Geocache = geocache;
  }

  public String getId_geo() {
    return id_geo;
  }

  public void setId_geo(String id_geo) {
    this.id_geo = id_geo;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public edu.ufp.inf.lp2_aed2.projeto.Geocache getGeocache() {
    return Geocache;
  }

  public void setGeocache(edu.ufp.inf.lp2_aed2.projeto.Geocache geocache) {
    Geocache = geocache;
  }

  public void removeItem(String id_geo, String item) {
  }

  public void addItem(String id_geo, String item) {
  }

}