package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.lang.String;

public class Ligacoes {

  public String id_1;
  public String id_2;
  public float distancia;
  public int tempo;

  public Ligacoes(String id_1, String id_2, float distancia, int tempo) {
    this.id_1 = id_1;
    this.id_2 = id_2;
    this.distancia = distancia;
    this.tempo = tempo;
  }

  public Ligacoes() {
    this.id_1 = "";
    this.id_2 = "";
    this.distancia = 0.0f;
    this.tempo = 0;
  }

  public String getId_1() {
    return id_1;
  }

  public void setId_1(String id_1) {
    this.id_1 = id_1;
  }

  public String getId_2() {
    return id_2;
  }

  public void setId_2(String id_2) {
    this.id_2 = id_2;
  }

  public float getDistancia() {
    return distancia;
  }

  public void setDistancia(float distancia) {
    this.distancia = distancia;
  }

  public int getTempo() {
    return tempo;
  }

  public void setTempo(int tempo) {
    this.tempo = tempo;
  }

  public void listarLigacao(String id_1, String id_2) {
  }

  public void listarligacoes(String id_1) {
  }

  public void addLigacao(String id_1, String id_2, float distancia, int tempo) {
  }

  public void removeLigacao(String id_1, String id_2) {
  }

}