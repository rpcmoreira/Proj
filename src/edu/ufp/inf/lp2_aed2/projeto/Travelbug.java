package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;
import java.lang.String;

public class Travelbug {

  public String id;
  public String tb_user;
  public String geo_inicial;
  public String geo_destino;
  public Geocache Geocache;
  public User user;

  public Travelbug(String id, String tb_user, String geo_inicial, String geo_destino, edu.ufp.inf.lp2_aed2.projeto.Geocache geocache, User user) {
    this.id = id;
    this.tb_user = tb_user;
    this.geo_inicial = geo_inicial;
    this.geo_destino = geo_destino;
    Geocache = geocache;
    this.user = user;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTb_user() {
    return tb_user;
  }

  public void setTb_user(String tb_user) {
    this.tb_user = tb_user;
  }

  public String getGeo_inicial() {
    return geo_inicial;
  }

  public void setGeo_inicial(String geo_inicial) {
    this.geo_inicial = geo_inicial;
  }

  public String getGeo_destino() {
    return geo_destino;
  }

  public void setGeo_destino(String geo_destino) {
    this.geo_destino = geo_destino;
  }

  public edu.ufp.inf.lp2_aed2.projeto.Geocache getGeocache() {
    return Geocache;
  }

  public void setGeocache(edu.ufp.inf.lp2_aed2.projeto.Geocache geocache) {
    Geocache = geocache;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void now() {
  }

  public void addTravelbug(int id, String user, String geo_inicial, String geo_destino) {
  }

  public void removeTravelBug(String id) {
  }

}