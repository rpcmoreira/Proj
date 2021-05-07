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

  public int addLigacao(String id_1, String id_2, float distancia, int tempo, int n_lig, SequentialSearchST<Integer,Ligacoes> lig_st) {
    for(int i = 1; i <= n_lig; i++){
      if(lig_st.get(i).id_1.equals(id_1) && lig_st.get(i).id_2.equals(id_2)){
        System.out.println("Ligacao ja existe!");
        return n_lig;
      }
    }
    n_lig++;
    Ligacoes ligacao = new Ligacoes(id_1, id_2, distancia, tempo);
    lig_st.put(n_lig, ligacao);
    System.out.println("Ligacao entre " + id_1 + "e " + id_2 + " adicionada com sucesso! -> " + ligacao);
    return n_lig;
  }

  public int removeLigacao(String id_1, String id_2,int n_lig, SequentialSearchST<Integer,Ligacoes> lig_st) {
    for(int i = 1; i <= n_lig; i++) {
      if (lig_st.get(i).id_1.equals(id_1) && lig_st.get(i).id_2.equals(id_2)) {
        lig_st.delete(i);
        System.out.println("Ligacao " + id_1 + " - " + id_2 + " removida!");
        n_lig--;
        return n_lig;
      }
    }
    System.out.println("Ligacao nao existe!");
    return n_lig;
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