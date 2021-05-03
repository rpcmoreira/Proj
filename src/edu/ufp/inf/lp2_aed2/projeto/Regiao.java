package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.lang.String;

public class Regiao {

  public String nome;
  public int n_caches;

  public ArrayList<Geocache>   geocache;

  public Regiao(String nome, int n_caches, ArrayList<Geocache> geocache) {
    this.nome = nome;
    this.n_caches = n_caches;
    this.geocache = geocache;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getN_caches() {
    return n_caches;
  }

  public void setN_caches(int n_caches) {
    this.n_caches = n_caches;
  }

  public ArrayList<Geocache> getGeocache() {
    return geocache;
  }

  public void setGeocache(ArrayList<Geocache> geocache) {
    this.geocache = geocache;
  }

  public void listarCaches(Geocache g) {
  }

  public void addRegiao(String nome, int n_caches) {
  }

  public void removeRegiao(String r) {
  }

}