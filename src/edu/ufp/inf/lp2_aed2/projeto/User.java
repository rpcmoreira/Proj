package edu.ufp.inf.lp2_aed2.projeto;

import java.lang.String;

public class User {

  public String nome;
  public String tipo;
  public int travelbug;

  public User(String nome, String tipo, int travelbug) {
    this.nome = nome;
    this.tipo = tipo;
    this.travelbug = travelbug;
  }

  public User() {
    this.nome = "";
    this.tipo = "";
    this.travelbug = 0;
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

  public int getTravelbug() {
    return travelbug;
  }

  public void setTravelbug(int travelbug) {
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