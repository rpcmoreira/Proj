package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;
import java.util.ArrayList;
import java.lang.String;

public class Regiao {

  public String nome;
  public int n_caches;

  public Regiao(String nome, int n_caches) {
    this.nome = nome;
    this.n_caches = n_caches;
  }

  public Regiao() {
    this.nome = "";
    this.n_caches = 0;
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

  public void listarCaches(Geocache g) {
  }

  public int addRegiao(int id, String nome, int n_reg, SequentialSearchST<Integer,Regiao> reg_st) {
    if(reg_st.contains(id)){
      System.out.println("Regiao ja definida");
    }
    else{
      Regiao new_reg = new Regiao(nome, 0);
      reg_st.put(id, new_reg);
      System.out.println("Regiao " + id + " adicionado com sucesso! -> " + new_reg);
      n_reg++;
    }
    return n_reg;
  }

  public int removeRegiao(int id, int n_reg, SequentialSearchST<Integer, Regiao> reg_st, SequentialSearchST<Integer, Geocache> geo_st, SequentialSearchST<Integer, Item> item_st){
    if(reg_st.contains(id)){
      for(int i = 1; i <= reg_st.get(id).n_caches; i++){
        if(geo_st.get(i) != null && geo_st.get(i).id_reg == id){
            geo_st.get(i).removeGeocache("geocache" + i, reg_st.get(i).n_caches, geo_st, reg_st);
            reg_st.delete(id);
            n_reg--;
        }
      }
    }
    else{
      System.out.println("Regiao nao encontrada");
    }
    return n_reg;
  }

  @Override
  public String toString() {
    return "Regiao{" +
            "nome='" + nome + '\'' +
            ", n_caches=" + n_caches +
            '}';
  }
}