package edu.ufp.inf.lp2_aed2.projeto;

import java.util.ArrayList;
import java.lang.String;
import edu.princeton.cs.algs4.*;

public class Cache {

  public String local;
  public int nItens;
  public int cacheID;
  public Date dateAdd;
  public String type;
  public int diff;
  public float coordenadasX;
  public float coordenadasY;
  public ArrayList<Itens> itens = new ArrayList<>();

  public Cache(String local, int nItens, int cacheID, Date dateAdd, String type, int diff, float coordenadasX, float coordenadasY) {
    this.local = local;
    this.nItens = nItens;
    this.cacheID = cacheID;
    this.dateAdd = dateAdd;
    this.type = type;
    this.diff = diff;
    this.coordenadasX = coordenadasX;
    this.coordenadasY = coordenadasY;
  }

  public Cache(String local, int nItens, int cacheID, Date dateAdd, String type, int diff, float coordenadasX, float coordenadasY, ArrayList<Itens> itens) {
    this.local = local;
    this.nItens = nItens;
    this.cacheID = cacheID;
    this.dateAdd = dateAdd;
    this.type = type;
    this.diff = diff;
    this.coordenadasX = coordenadasX;
    this.coordenadasY = coordenadasY;
    this.itens = itens;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public void setnItens(int nItens) {
    this.nItens = nItens;
  }

  public void setCacheID(int cacheID) {
    this.cacheID = cacheID;
  }

  public void setDateAdd(Date dateAdd) {
    this.dateAdd = dateAdd;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setDiff(int diff) {
    this.diff = diff;
  }

  public void setCoordenadasX(float coordenadasX) {
    this.coordenadasX = coordenadasX;
  }

  public void setCoordenadasY(float coordenadasY) {
    this.coordenadasY = coordenadasY;
  }

  public void setItens(ArrayList<Itens> itens) {
    this.itens = itens;
  }

  public void listarItens(Itens i) {}

  public boolean hasTB(travelBug t) {
  return false;
  }

  public boolean hasItens(Itens i) {
  return false;
  }

  public Cache findCache(int c) {
  return null;
  }

  public boolean isPrem(Cache c) {
  return false;
  }
}