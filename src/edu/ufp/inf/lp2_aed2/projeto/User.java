package edu.ufp.inf.lp2_aed2.projeto;

import java.util.Vector;
import java.lang.String;

public class User {

  public String nome;
  public int idade;
  public String local;
  public Date inscricao;
  public int ownedCaches;
  public int nItens;
  public int id;

  /**
   * 
   * @element-type Cache
   */
  public Vector  caches;
    /**
   * 
   * @element-type Itens
   */
  public Vector  itens;

  public void listarCache(Cache c) { }

  public void foundObject(Itens i, Itens o) { }

  public User findUser(int id) {
  return null;
  }
}