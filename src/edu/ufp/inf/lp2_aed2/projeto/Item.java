package edu.ufp.inf.lp2_aed2.projeto;
import edu.princeton.cs.algs4.*;
import java.lang.String;

public class Item {

  public String id_geo;
  public String item;

  public Item(String id_geo, String item) {
    this.id_geo = id_geo;
    this.item = item;
  }

  public Item() {
    this.id_geo = "";
    this.item = "";
  }

  public String getId_geo(int i) {
    return id_geo;
  }

  public void setId_geo(String id_geo) {
    this.id_geo = id_geo;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public void removeItem(int id, int[] sizes,  SequentialSearchST<Integer, Item> itens, SequentialSearchST<Integer, Geocache> geocache) {
    if (itens.contains(id)){
      int n_geo = Integer.parseInt(itens.get(id).id_geo.replace("geocache", ""));
      itens.delete(id);
      sizes[3]--;
      geocache.get(n_geo).n_itens--;
    }
    else{
      System.out.println("Item nao existe!");
    }
  }

  public void addItem(int id, String id_geo, String item, int[] sizes, SequentialSearchST<Integer, Item> itens, SequentialSearchST<Integer, Geocache> geocache){
    if(itens.contains(id)){
      System.out.println("Item ja presente\n");
    }
    else{
      int n_geo = Integer.parseInt(id_geo.replace("geocache", ""));
      if(geocache.contains(n_geo)){
        Item novo = new Item(id_geo, item);
        itens.put(id, novo);
        sizes[3]++;
        geocache.get(n_geo).n_itens++;
      }
    }
  }

  public void editItem(String tipo, String conteudo, int id, SequentialSearchST<Integer, Item> item_st) {
    if (id <= item_st.size()) {
      switch (tipo) {
        case "item":
          item_st.get(id).item = conteudo;
          break;
        default:
          System.out.println("Tipo introduzido invalido");
      }
    }else {
      System.out.println("Item nao existe");
    }
}

  @Override
  public String toString() {
    return "Item{" +
            "id_geo='" + id_geo + '\'' +
            ", item='" + item + '\'' +
            '}';
  }
}