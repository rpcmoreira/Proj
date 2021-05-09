package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;

import java.lang.String;
import java.util.Arrays;

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

  /**
   * Funcao que cria um User e o adiciona na sua ST
   * @param id - id do user a adicionar
   * @param nome - nome do user a adicionar
   * @param tipo - tipo do user a adicionar (basic, premium, admin)
   * @param sizes - array com o numero total das variaveis (sendo a posicao 0 o numero de users
   * @param user_st - ST dos users
   */
  public void addUser(int id, String nome, String tipo, int[] sizes, SequentialSearchST<Integer, User> user_st){
      if(user_st.contains(id)){
        System.out.println("User ID ja definido!");
      }
      else{
        User new_u = new User(nome, tipo);
        user_st.put(id,new_u);
        System.out.println("User " + id + " adicionado com sucesso! -> " + new_u);
        sizes[0]++;
      }
  }

  /**
   * Funcao que remove o User, usando o id, da ST
   * @param id - id do user a remover
   * @param sizes - array com o numero total das variaveis (sendo a posicao 0 o numero de users)
   * @param user_st - ST dos users
   */
  public void removeUser(int id, int[] sizes, SequentialSearchST<Integer, User> user_st) {
    if(user_st.contains(id)){
      user_st.delete(id);
      sizes[0]--;
      System.out.println("User " + id + " removido com sucesso!");
    }
    else{
      System.out.println("User Inválido!");
    }
  }

  /**
   * Funcao que edita um parametro do user, recebendo o parametro a alterar
   * @param tipo - parametro que se vai alterar
   * @param conteudo - conteudo com o qual se vai alterar
   * @param id - id do user
   * @param user_st - ST dos Users
   */
  public void editUser(String tipo, String conteudo, int id, SequentialSearchST<Integer, User> user_st){
    if(id <= user_st.size()){
      switch(tipo){
        case "nome":
          user_st.get(id).nome = conteudo;
          break;
        case "tipo":
          user_st.get(id).tipo = conteudo;
          break;
        case "travelbug":
          user_st.get(id).travelbug = Integer.parseInt(conteudo);
          break;
        default:
          System.out.println("Tipo introduzido invalido");
      }
    }else{
      System.out.println("User nao existe");
    }
  }

  /**
   * funcao que lista as caches que um user visitou, de uma forma geral
   * @param nome - nome do user a procurar
   * @param sizes
   * @param geo_st
   * @param reg_st
   * @param log
   */
  public void searchVisitedCacheGlobal(String nome, int[] sizes,SequentialSearchST<Integer, Geocache> geo_st, SequentialSearchST<Integer, Regiao> reg_st, RedBlackBST<Integer, HistoricoVisited> log){
      for(int i = 0; i <= sizes[6]; i++){
        if(log.get(i) != null && log.get(i).user.equals(nome)){
          System.out.println("Caches visitadas por " + nome + " :");
          for(int j = 0; j < log.get(i).n_visited; j++){
            int z = log.get(i).visited[j];
            System.out.println("\t\t" + log.get(i).date[j] + "\t--> Geocache " + z + "\tpertencente a Regiao " + capitalize(reg_st.get(geo_st.get(z).id_reg).nome));
          }
          return;
        }
      }
      System.out.println("User nao encontrado/existe!");
    }

  public void searchVisitedCacheRegiao(String nome, int id_reg, int[] sizes, SequentialSearchST<Integer, Geocache> geo_st,  SequentialSearchST<Integer, Regiao> reg_st, RedBlackBST<Integer, HistoricoVisited> log){
    for(int i = 0; i <= sizes[6]; i++){
    if(log.get(i) != null && log.get(i).user.equals(nome)) {
      System.out.println("Caches visitadas por " + nome + " na Regiao " + capitalize(reg_st.get(id_reg).nome));
        for (int j = 0; j < log.get(i).n_visited; j++) {
          if (geo_st.get(log.get(i).visited[j]).id_reg == id_reg) {
            int z = log.get(i).visited[j];
            System.out.println("\t\t" + log.get(i).date[j] + "\t--> Geocache " + z);
          }
        }
        return;
      }
    }
    System.out.println("User nao encontrado/existe!");
  }

  public void searchMissingCacheGlobal(String nome, int[] sizes,SequentialSearchST<Integer, Geocache> geo_st, SequentialSearchST<Integer, Regiao> reg_st, RedBlackBST<Integer, HistoricoVisited> log){
    for(int i = 1; i <= sizes[6]; i++){

      if(log.get(i) != null && log.get(i).user.equals(nome)){
        int[] aux = new int[log.get(i).n_visited];
        int[] inverso = new int[sizes[2] - log.get(i).n_visited];

        System.out.println("Caches que faltam visitar por " + nome + " :");
        for(int j = 0; j < log.get(i).n_visited; j++){
          aux[j] = log.get(i).visited[j];
        }

        int current = 0, existe = 0;
        for(int j = 1; j <= sizes[2]; j++){
          for(int z = 0 ; z < log.get(i).n_visited; z++){
            if(aux[z] == j){
              existe = 1;
              break;
            }
          }
          if(existe != 1){
              inverso[current] = j;
              current++;
            }
            existe = 0;
          }
        for(int b : inverso){
          System.out.println("\t\tGeocache " + b + "\tpertencente a Regiao " + capitalize(reg_st.get(geo_st.get(b).id_reg).nome));
        }
        return;
      }
    }
    System.out.println("User nao encontrado/existe!");
  }

  public void searchMissingCacheRegiao(String nome, int id_reg, int[] sizes,SequentialSearchST<Integer, Geocache> geo_st, SequentialSearchST<Integer, Regiao> reg_st, RedBlackBST<Integer, HistoricoVisited> log){
    for(int i = 1; i <= sizes[6]; i++){

      if(log.get(i) != null && log.get(i).user.equals(nome)){
        int[] aux = new int[log.get(i).n_visited];
        int[] inverso = new int[sizes[2] - log.get(i).n_visited];

        System.out.println("Caches que faltam visitar por " + nome + " :");
        for(int j = 0; j < log.get(i).n_visited; j++){
          aux[j] = log.get(i).visited[j];
        }

        int current = 0, existe = 0;
        for(int j = 1; j <= sizes[2]; j++){

          for(int z = 0 ; z < log.get(i).n_visited; z++){
            if(aux[z] == j){
              existe = 1;
              break;
            }
          }
          if(existe != 1){
            inverso[current] = j;
            current++;
          }
          existe = 0;
        }
        for(int b : inverso){
          if(geo_st.get(b).id_reg == id_reg)
          System.out.println("\t\tGeocache " + b + "\tpertencente a Regiao " + capitalize(reg_st.get(geo_st.get(b).id_reg).nome));
        }
        return;
      }
    }
    System.out.println("User nao encontrado/existe!");
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

  public static String capitalize(String str) {
    int strLen;
    if (str == null || (strLen = str.length()) == 0) {
      return str;
    }
    return new StringBuffer(strLen)
            .append(Character.toTitleCase(str.charAt(0)))
            .append(str.substring(1))
            .toString();
  }
}