package edu.ufp.inf.lp2_aed2.projeto;

import java.util.Vector;
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

  public User user;
    /**
   * 
   * @element-type Itens
   */
  public Vector  itens;

  public void listarItens(Itens i) {
  }

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