package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.SequentialSearchST;

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

  public User(String nome, String tipo) {
    this.nome = nome;
    this.tipo = tipo;
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

  public void addUser(int id, String nome, String tipo, SequentialSearchST user){
      if(user.contains(id)){
        System.out.println("User ID ja definido\n");
      }
      else{
        User new_u = new User(nome, tipo);
        user.put(id,new_u);
      }
  }

  public void removeUser(int id, SequentialSearchST user) {
    if(user.contains(id)){
      user.delete(id);
    }
    else{
      System.out.println("User Inválido!\n");
    }
  }

  public void logUser(int id) {
  }

  @Override
  public String toString() {
    return "User{" +
            "nome = '" + nome + '\'' +
            ", tipo = '" + tipo + '\'' +
            //", travelbug=" + travelbug +
            '}';
  }
}