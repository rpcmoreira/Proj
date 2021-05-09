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

  public void addRegiao(int id, String nome, int[] sizes, SequentialSearchST<Integer,Regiao> reg_st) {
    if(reg_st.contains(id)){
      System.out.println("Regiao ja definida");
    }
    else{
      Regiao new_reg = new Regiao(nome, 0);
      reg_st.put(id, new_reg);
      System.out.println("Regiao " + id + " adicionado com sucesso! -> " + new_reg);
      sizes[1]++;
    }
  }

  public void removeRegiao(int id, int[] sizes, SequentialSearchST<Integer, Regiao> reg_st, SequentialSearchST<Integer, Geocache> geo_st, SequentialSearchST<Integer, Item> item_st){
      if(reg_st.contains(id)){

      if(reg_st.get(id).n_caches > 0){
        int n_geo = reg_st.get(id).n_caches;
        for(int i = 1; i <= n_geo; i++){
          if(geo_st.get(i) != null && geo_st.get(i).id_reg == id){
            geo_st.get(i).removeGeocache("geocache"+i,sizes,geo_st,reg_st,item_st);
          }else n_geo++;
        }
      }
      reg_st.delete(id);
      System.out.println("Regiao " + id + " removida com sucesso!");
      sizes[1]--;
    }
    else{
      System.out.println("Regiao Inválida!");
    }
  }

  public void editRegiao(String tipo, String conteudo, int id, SequentialSearchST<Integer, Regiao> reg_st) {
    if (id <= reg_st.size()) {
      switch (tipo) {
        case "nome":
          reg_st.get(id).nome = conteudo;
          break;
        default:
          System.out.println("Tipo introduzido invalido");
      }
    }else{
      System.out.println("Regiao nao existe");
    }
  }

  @Override
  public String toString() {
    return "Regiao{" +
            "nome='" + nome + '\'' +
            ", n_caches=" + n_caches +
            '}';
  }
}