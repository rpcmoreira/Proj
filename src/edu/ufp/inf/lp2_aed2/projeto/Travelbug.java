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

  public void addTravelbug(String id, String user, String geo_inicial, String geo_destino, int[]sizes, SequentialSearchST<Integer, Travelbug> tvb_st) {
    int id_tb = Integer.parseInt(id.replace("travelbug", ""));
    if(tvb_st.contains(id_tb)){
      System.out.println("TravelBug ID ja definido!");
    }
    else{
      Travelbug new_tb = new Travelbug(id, user, geo_inicial, geo_destino);
      tvb_st.put(id_tb,new_tb);
      System.out.println("TravelBug " + id + " adicionado com sucesso! -> " + new_tb);
      sizes[4]++;
    }
  }

  public void removeTravelBug(int id, int[] sizes, SequentialSearchST<Integer, Travelbug> tvb_st) {
    if(tvb_st.contains(id)){
      tvb_st.delete(id);
      sizes[4]--;
      System.out.println("Travelbug " + id + " removido com sucesso!");
    }
    else{
      System.out.println("Travelbug Inválido!");
    }
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