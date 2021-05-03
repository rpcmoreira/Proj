package edu.ufp.inf.lp2_aed2.projeto.old;

import java.util.ArrayList;
import java.lang.String;

public class User {

  public String nome;
  public int idade;
  public String local;
  public Date inscricao;
  public int ownedCaches;
  public int nItens;
  public int id;
  public ArrayList<Cache> myCache = new ArrayList<>();
  public ArrayList<Itens> myItens = new ArrayList<>();

  public User(String nome, int idade, String local, Date inscricao, int ownedCaches, int id, ArrayList<Cache> myCache) {
    this.nome = nome;
    this.idade = idade;
    this.local = local;
    this.inscricao = inscricao;
    this.ownedCaches = ownedCaches;
    this.id = id;
    this.myCache = myCache;
  }

  public User(String nome, int idade, String local, Date inscricao, int id, ArrayList<Itens> myItens, int nItens) {
    this.nome = nome;
    this.idade = idade;
    this.local = local;
    this.inscricao = inscricao;
    this.id = id;
    this.myItens = myItens;
    this.nItens = nItens;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public Date getInscricao() {
    return inscricao;
  }

  public void setInscricao(Date inscricao) {
    this.inscricao = inscricao;
  }

  public int getOwnedCaches() {
    return ownedCaches;
  }

  public void setOwnedCaches(int ownedCaches) {
    this.ownedCaches = ownedCaches;
  }

  public int getnItens() {
    return nItens;
  }

  public void setnItens(int nItens) {
    this.nItens = nItens;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ArrayList<Cache> getMyCache() {
    return myCache;
  }

  public void setMyCache(ArrayList<Cache> myCache) {
    this.myCache = myCache;
  }

  public ArrayList<Itens> getMyItens() {
    return myItens;
  }

  public void setMyItens(ArrayList<Itens> myItens) {
    this.myItens = myItens;
  }

  public void listarCache(Cache c) { }

  public void foundObject(Itens i, Itens o) { }

  public User findUser(int id) {
  return null;
  }

}