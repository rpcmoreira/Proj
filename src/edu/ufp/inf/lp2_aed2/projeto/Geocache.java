package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.lang.String;

public class Geocache {

  public String id;
  public String tipo;
  public float coordenadasX;
  public float coordenadasY;
  public int n_itens;
  public int id_reg;

  public Geocache(String id, String tipo, float coordenadasX, float coordenadasY, int n_itens, int id_reg) {
    this.id = id;
    this.tipo = tipo;
    this.coordenadasX = coordenadasX;
    this.coordenadasY = coordenadasY;
    this.n_itens = n_itens;
    this.id_reg = id_reg;
  }

  public Geocache() {
    this.id = "";
    this.tipo = "";
    this.coordenadasX = 0.0f;
    this.coordenadasY = 0.0f;
    this.n_itens = 0;
    this.id_reg = 0;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public float getCoordenadasX() {
    return coordenadasX;
  }

  public void setCoordenadasX(float coordenadasX) {
    this.coordenadasX = coordenadasX;
  }

  public float getCoordenadasY() {
    return coordenadasY;
  }

  public void setCoordenadasY(float coordenadasY) {
    this.coordenadasY = coordenadasY;
  }

  public int getN_itens() {
    return n_itens;
  }

  public void setN_itens(int n_itens) {
    this.n_itens = n_itens;
  }

  /*public void listGeocache(String id_user, int id_geo, int[] sizes, SequentialSearchST<Integer, Geocache> geo_st, SequentialSearchST<Integer, Regiao> reg_st, RedBlackBST<Integer, HistoricoVisited> h_visited, SequentialSearchST<Integer, User> user_st){
    int i, z = 0;
    int id_reg = geo_st.get(id_geo).id_reg;
    for(int j = 1; j <= sizes[0]; j++){
      if(user_st.get(j+1) != null && user_st.get(j).nome.equals(id_user)){
        z = j;
        break;
      }
    }
    for(i = 0; i < sizes[6]; i++) {
      if (h_visited.get(z).visited[i] == id_geo) break;
    }
    System.out.println("Regiao " + capitalize(reg_st.get(id_reg).nome) + ", " + (capitalize(geo_st.get(id_geo).id)).replace("Geocache", "Geocache ") + " na data " + h_visited.get(id_geo).date[i]);
  }*/

  public void addGeocache(String id, String tipo, float cX, float cY, int id_reg,  int[] sizes, SequentialSearchST<Integer, Geocache> geo, SequentialSearchST<Integer, Regiao> reg) {
    int idgeo = Integer.parseInt(id.replace("geocache", ""));
    if(geo.contains(idgeo)){
      System.out.println("Erro ao adicionar Geocache!");
    }
    else{
      reg.get(id_reg).n_caches++;
      Geocache geocache = new Geocache(id,tipo,cX,cY,0,id_reg);
      geo.put(idgeo, geocache);
      System.out.println("Geocache " + id + " adicionada com sucesso! -> " + geocache);
      sizes[2]++;
    }
  }

  public void removeGeocache(String id, int[] sizes, SequentialSearchST<Integer, Geocache> geo, SequentialSearchST<Integer, Regiao> reg,SequentialSearchST<Integer, Item> item) {
    int idgeo = Integer.parseInt(id.replace("geocache", ""));

    if(geo.contains(idgeo)){

      if(geo.get(idgeo).n_itens > 0){
        int n_itens = geo.get(idgeo).n_itens;
        for(int i = 1; i <= n_itens; i++){
          if(item.get(i) != null && item.get(i).id_geo.equals(id)){
            item.get(i).removeItem(i,sizes,item,geo);
          }else n_itens++;
        }
      }

      reg.get(geo.get(idgeo).id_reg).n_caches--;
      geo.delete(idgeo);
      System.out.println("Geocache " + id + " removida com sucesso!");
      sizes[2]--;
    }
    else{
      System.out.println("Geocache Inválido!");
    }
  }

  public void usersVisitedCache(String geo, int[] sizes, SequentialSearchST<Integer, User> user_st, SequentialSearchST<Integer, Geocache> geo_st, RedBlackBST<Integer, HistoricoVisited> histV_st) {
    int idgeo = Integer.parseInt(geo.replace("geocache", ""));
      // 1 Percorrer todos os users, 2 em cada um verificar nos logs se 3 existe o idgeo e se 4 existir imprimir o user

    System.out.println("Users que pertencem a Geocache " + idgeo + ":");
    for(int i = 1; i <= sizes[0]; i++){                                                                                 // Percorre os users
      if(histV_st.get(i) != null && histV_st.get(i).user.equals(user_st.get(i).nome)){
        for(int j = 0; j < histV_st.get(i).n_visited; j++){                                                             // Percorre as geos que o user visitou
          if(histV_st.get(i).visited[j] == idgeo)                                                                       // Verifica se a geo é a mesma que se pretende
            System.out.println("\t\tUser " + user_st.get(i).nome);
        }
      }
    }
  }



  public void editCache(String tipo, String conteudo, int id, SequentialSearchST<Integer, Geocache> geo_st){
    if(id <= geo_st.size()){
      switch(tipo){
        case "tipo":
          geo_st.get(id).tipo = conteudo;
          break;
        case "coordenadasX":
          geo_st.get(id).coordenadasX = Float.parseFloat(conteudo);
          break;
        case "coordenadasY":
          geo_st.get(id).coordenadasY = Float.parseFloat(conteudo);
          break;
        case "regiao":
          geo_st.get(id).id_reg = Integer.parseInt(conteudo);
          break;
        default:
          System.out.println("Tipo introduzido invalido");
      }
    }else{
      System.out.println("Geocache nao existe");
    }
  }

  public void premiumWithItem(int[] sizes, SequentialSearchST<Integer, Geocache> geo_st){
    for(int i = 0; i <= sizes[2]; i++){
      if(geo_st.get(i) != null && geo_st.get(i).tipo.equals("premium") && geo_st.get(i).n_itens > 0){
        System.out.println(geo_st.get(i).toString());
      }
    }
  }

  @Override
  public String toString() {
    return "Geocache{" +
            "id='" + id + '\'' +
            ", tipo='" + tipo + '\'' +
            ", coordenadasX=" + coordenadasX +
            ", coordenadasY=" + coordenadasY +
            ", Regiao=" + id_reg +
            ", n_itens=" + n_itens +
            '}';
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