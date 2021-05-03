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

  public Regiao regiao;
  public ArrayList<Item>  Item;
  public ArrayList<Travelbug>   Travelbug;
  //public ArrayList<Ligacoes>   ligacoes;

  public Geocache(String id, String tipo, float coordenadasX, float coordenadasY, int n_itens, Regiao regiao) {
    this.id = id;
    this.tipo = tipo;
    this.coordenadasX = coordenadasX;
    this.coordenadasY = coordenadasY;
    this.n_itens = n_itens;
    this.regiao = regiao;
  }

  public Geocache(String id, String tipo, float coordenadasX, float coordenadasY, int n_itens, ArrayList<edu.ufp.inf.lp2_aed2.projeto.Item> item, Regiao regiao) {
    this.id = id;
    this.tipo = tipo;
    this.coordenadasX = coordenadasX;
    this.coordenadasY = coordenadasY;
    this.n_itens = n_itens;
    this.regiao = regiao;
    Item = item;
  }

  public Geocache(String id, String tipo, float coordenadasX, float coordenadasY, int n_itens, Regiao regiao, ArrayList<edu.ufp.inf.lp2_aed2.projeto.Travelbug> travelbug) {
    this.id = id;
    this.tipo = tipo;
    this.coordenadasX = coordenadasX;
    this.coordenadasY = coordenadasY;
    this.n_itens = n_itens;
    this.regiao = regiao;
    Travelbug = travelbug;
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

  public Regiao getRegiao() {
    return regiao;
  }

  public void setRegiao(Regiao regiao) {
    this.regiao = regiao;
  }

  public ArrayList<edu.ufp.inf.lp2_aed2.projeto.Item> getItem() {
    return Item;
  }

  public void setItem(ArrayList<edu.ufp.inf.lp2_aed2.projeto.Item> item) {
    Item = item;
  }

  public ArrayList<edu.ufp.inf.lp2_aed2.projeto.Travelbug> getTravelbug() {
    return Travelbug;
  }

  public void setTravelbug(ArrayList<edu.ufp.inf.lp2_aed2.projeto.Travelbug> travelbug) {
    Travelbug = travelbug;
  }

  public void addGeocache(int id, String tipo, float cX, float cY, int n_itens, String itens) {
  }

  public void removeGeocache(int id) {
  }

  public void listarItens(int id) {
  }

}