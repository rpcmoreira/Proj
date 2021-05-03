package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;

import java.lang.String;

public class User {

  public int id;
  public String nome;
  public String tipo;
  public Travelbug travelbug;

  public User(int id, String nome, String tipo, Travelbug travelbug) {
    this.id = id;
    this.nome = nome;
    this.tipo = tipo;
    this.travelbug = travelbug;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Travelbug getTravelbug() {
    return travelbug;
  }

  public void setTravelbug(Travelbug travelbug) {
    this.travelbug = travelbug;
  }

  public void listarUser(int id) {
  }

  public void addUser(int id, String nome, String tipo) {
  }

  public void removeUser(int id) {
  }

  public void logUser(int id) {
  }

}