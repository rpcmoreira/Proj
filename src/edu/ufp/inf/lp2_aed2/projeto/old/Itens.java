package edu.ufp.inf.lp2_aed2.projeto.old;

import java.lang.String;

public class Itens {
  public String nome;
  public Date dateAdd;
  public int itemID;
  public Cache cache;
  public User user;

  public Itens(String nome, Date dateAdd, int itemID, Cache cache) {
    this.nome = nome;
    this.dateAdd = dateAdd;
    this.itemID = itemID;
    this.cache = cache;
  }

  public Itens(String nome, Date dateAdd, int itemID, User user) {
    this.nome = nome;
    this.dateAdd = dateAdd;
    this.itemID = itemID;
    this.user = user;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getDateAdd() {
    return dateAdd;
  }

  public void setDateAdd(Date dateAdd) {
    this.dateAdd = dateAdd;
  }

  public int getItemID() {
    return itemID;
  }

  public void setItemID(int itemID) {
    this.itemID = itemID;
  }

  public Cache getCache() {
    return cache;
  }

  public void setCache(Cache cache) {
    this.cache = cache;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Itens findItem(int i) {
  return null;
  }

}