package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.lang.String;

public class Geocache {

  public String id;
  public String tipo;
  public float coordenadasX;
  public float coordenadasY;
  public int n_itens;

  public Geocache(String id, String tipo, float coordenadasX, float coordenadasY, int n_itens) {
    this.id = id;
    this.tipo = tipo;
    this.coordenadasX = coordenadasX;
    this.coordenadasY = coordenadasY;
    this.n_itens = n_itens;
  }

  public Geocache() {
    this.id = "";
    this.tipo = "";
    this.coordenadasX = 0.0f;
    this.coordenadasY = 0.0f;
    this.n_itens = 0;
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


  public void addGeocache(int id, String tipo, float cX, float cY, int n_itens, String itens) {
  }

  public void removeGeocache(int id) {
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
            ", n_itens=" + n_itens +
            '}';
  }
}