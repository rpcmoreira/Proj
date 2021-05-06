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

  public void listarUser(int id, SequentialSearchST<Integer, User> user) {

  }

  public int addUser(int id, String nome, String tipo, int n_user, SequentialSearchST<Integer, User> user){
      if(user.contains(id)){
        System.out.println("User ID ja definido!");
      }
      else{
        User new_u = new User(nome, tipo);
        user.put(id,new_u);
        System.out.println("User " + id + " adicionado com sucesso! -> " + new_u);
        n_user++;
      }
    return n_user;
  }

  public int removeUser(int id, int n_user, SequentialSearchST<Integer, User> user) {
    if(user.contains(id)){
      user.delete(id);
      n_user--;
      System.out.println("User " + id + " removido com sucesso!");
    }
    else{
      System.out.println("User Inválido!");
    }
    return n_user;
  }

  public void editUser(){
  }

  public void searchUser(SequentialSearchST user, String nome) {
  }

  public void logUser(int id) {
  }

  @Override
  public String toString() {
    return "User {" +
            "nome = '" + nome + '\'' +
            ", tipo = '" + tipo + '\'' +
            //", travelbug=" + travelbug +
            "}";
  }
}