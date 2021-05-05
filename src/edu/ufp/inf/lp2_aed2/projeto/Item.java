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

  public String getId_geo() {
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

  public void removeItem(String id_geo, String item) {
  }

  public void addItem(String id_geo, String item, SequentialSearchST itens) {
    if(itens.contains(item)){
      System.out.println("Erro Item\n");
    }
    else{
      Item novo = new Item(id_geo, item);
      int id = Integer.parseInt(id_geo.replace("geocache", ""));
      itens.put(id, novo);
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