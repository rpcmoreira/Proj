package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.lang.String;
import java.util.Locale;

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

  /**
   * Cria uma nova ligacao entre duas geocaches
   * @param id_1 - Geocache 1
   * @param id_2 - Geocache 2
   * @param distancia - Distancia entre as duas Geocaches
   * @param tempo - Tempo de Viagem entre as Geocaches
   * @param sizes - Array com o numero total de Ligacoes
   * @param lig_st - St das Ligacoes
   */
  public void addLigacao(String id_1, String id_2, float distancia, int tempo, int[] sizes, SequentialSearchST<Integer,Ligacoes> lig_st) {
    for(int i = 1; i <= sizes[5]; i++){
      if(lig_st.get(i).id_1.equals(id_1) && lig_st.get(i).id_2.equals(id_2)){
        System.out.println("Ligacao ja existe!");
        return;
      }
    }
    sizes[5]++;
    Ligacoes ligacao = new Ligacoes(id_1, id_2, distancia, tempo);
    lig_st.put(sizes[5], ligacao);
    System.out.println("Ligacao entre " + id_1 + "e " + id_2 + " adicionada com sucesso! -> " + ligacao);
  }

  /**
   * Remove uma ligacao entre duas geocaches
   * @param id_1 - Geocache 1
   * @param id_2 - Geocache 2
   * @param sizes - Array com o numero total de Ligacoes
   * @param lig_st - St das Ligacoes
   */
  public void removeLigacao(String id_1, String id_2,int[] sizes, SequentialSearchST<Integer,Ligacoes> lig_st) {
    for(int i = 1; i <= sizes[5]; i++) {
      if (lig_st.get(i).id_1.equals(id_1) && lig_st.get(i).id_2.equals(id_2)) {
        lig_st.delete(i);
        System.out.println("Ligacao " + id_1 + " - " + id_2 + " removida!");
        sizes[5]--;
        return;
      }
    }
    System.out.println("Ligacao nao existe!");
  }

  /**
   * Edita o parametro de uma ligacao, alterando-o para o conteudo recebido
   * @param tipo - @param tipo - Parametro a alterar, baseado nas variaveis da classe
   * @param conteudo - Valor para qual se mudara o parametro
   * @param id - Id da ligacao
   * @param lig_st - ST das Ligacoes
   */
  public void editLigacao(String tipo, String conteudo, int id, SequentialSearchST<Integer, Ligacoes> lig_st) {
    if (id <= lig_st.size()) {
      switch (tipo) {
        case "id1":
          lig_st.get(id).id_1 = conteudo;
          break;
        case "id2":
          lig_st.get(id).id_2 = conteudo;
          break;
        case "distancia":
          lig_st.get(id).distancia = Float.parseFloat(conteudo);
          break;
        case "tempo":
          lig_st.get(id).tempo = Integer.parseInt(conteudo);
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
    return "Ligacoes{" +
            "id_1='" + id_1 + '\'' +
            ", id_2='" + id_2 + '\'' +
            ", distancia=" + distancia +
            ", tempo=" + tempo +
            '}';
  }
}