package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;
import java.lang.String;

public class Travelbug {

  public String id;
  public String user;
  public String geo_inicial;
  public String geo_destino;

  public Travelbug(String id, String tb_user, String geo_inicial, String geo_destino) {
    this.id = id;
    this.user = tb_user;
    this.geo_inicial = geo_inicial;
    this.geo_destino = geo_destino;
  }

  public Travelbug() {
    this.id = "";
    this.user = "";
    this.geo_inicial = "";
    this.geo_destino = "";
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String tb_user) {
    this.user = tb_user;
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

  public void now() {
  }

  public void addTravelbug(int id, String user, String geo_inicial, String geo_destino) {
  }

  public void removeTravelBug(String id) {
  }

  @Override
  public String toString() {
    return "Travelbug{" +
            "id='" + id + '\'' +
            ", user='" + user + '\'' +
            ", geo_inicial='" + geo_inicial + '\'' +
            ", geo_destino='" + geo_destino + '\'' +
            '}';
  }
}