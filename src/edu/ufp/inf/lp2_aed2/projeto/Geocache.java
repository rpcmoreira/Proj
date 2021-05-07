package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.lang.String;

public class Geocache {

  public String id;
  public String tipo;
  public float coordenadasX;
  public float coordenadasY;
  public int n_itens;
  public int id_reg;

  public Geocache(String id, String tipo, float coordenadasX, float coordenadasY, int n_itens, int id_reg) {
    this.id = id;
    this.tipo = tipo;
    this.coordenadasX = coordenadasX;
    this.coordenadasY = coordenadasY;
    this.n_itens = n_itens;
    this.id_reg = id_reg;
  }

  public Geocache() {
    this.id = "";
    this.tipo = "";
    this.coordenadasX = 0.0f;
    this.coordenadasY = 0.0f;
    this.n_itens = 0;
    this.id_reg = 0;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public float getCoordenadasX() {
    return coordenadasX;
  }

  public void setCoordenadasX(float coordenadasX) {
    this.coordenadasX = coordenadasX;
  }

  public float getCoordenadasY() {
    return coordenadasY;
  }

  public void setCoordenadasY(float coordenadasY) {
    this.coordenadasY = coordenadasY;
  }

  public int getN_itens() {
    return n_itens;
  }

  public void setN_itens(int n_itens) {
    this.n_itens = n_itens;
  }


  public int addGeocache(String id, String tipo, float cX, float cY, int id_reg,  int n_geo, SequentialSearchST<Integer, Geocache> geo, SequentialSearchST<Integer, Regiao> reg) {
    int idgeo = Integer.parseInt(id.replace("geocache", ""));
    if(geo.contains(idgeo)){
      System.out.println("Erro ao adicionar Geocache!");
    }
    else{
      reg.get(id_reg).n_caches++;
      Geocache geocache = new Geocache(id,tipo,cX,cY,0,id_reg);
      geo.put(idgeo, geocache);
      System.out.println("Geocache " + id + " adicionada com sucesso! -> " + geocache);
      n_geo++;
    }
    return n_geo;
  }

  public int removeGeocache(String id, int n_geo, SequentialSearchST<Integer, Geocache> geo, SequentialSearchST<Integer, Regiao> reg) {
    int idgeo = Integer.parseInt(id.replace("geocache", ""));
    if(geo.contains(idgeo)){
      reg.get(geo.get(idgeo).id_reg).n_caches--;
      geo.delete(idgeo);
      System.out.println("Geocache " + id + " removida com sucesso!");
      n_geo--;
    }
    else{
      System.out.println("Geocache Inválido!");
    }
    return n_geo;
  }

  public void listarItens(int id) {
  }

  @Override
  public String toString() {
    return "Geocache{" +
            "id='" + id + '\'' +
            ", tipo='" + tipo + '\'' +
            ", coordenadasX=" + coordenadasX +
            ", coordenadasY=" + coordenadasY +
            ", Regiao=" + id_reg +
            ", n_itens=" + n_itens +
            '}';
  }
}