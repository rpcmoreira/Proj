package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        SequentialSearchST<Integer, User> user_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Geocache> geo_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Item> item_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Ligacoes> lig_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Regiao> reg_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Travelbug> tvb_st = new SequentialSearchST<>();

        // Leitura do ficheiro input.txt
        try{
            int itens = 0;

            Scanner scan = new Scanner(new BufferedReader(new FileReader("data/input.txt")));
            int x = scan.nextInt();
            scan.nextLine();

            for(int i = 0; i < x; i++) {
                User u = new User();

                String[] data = scan.nextLine().split(", ");
                int id = Integer.parseInt(data[0]);
                u.nome = data[1];
                u.tipo = data[2];

                user_st.put(id, u);
            }

            x = scan.nextInt();
            scan.nextLine();

            for(int i = 0; i < x; i++){
                Regiao reg = new Regiao();
                Geocache geo = new Geocache();
                Item item = new Item();

                String[] data = scan.nextLine().split(", ");
                reg.nome = data[0];
                reg.n_caches = Integer.parseInt(data[1]);

                for(int j = 0; j < reg.n_caches; j++){
                    String[] data1 = scan.nextLine().split(", ");
                    geo.id = data1[0];
                    int idgeo = Integer.parseInt(geo.id.replace("geocache", ""));
                    System.out.println(idgeo);
                    geo.tipo = data1[1];
                    geo.coordenadasX = Float.parseFloat(data1[2]);
                    geo.coordenadasY = Float.parseFloat(data1[3]);
                    geo.n_itens = Integer.parseInt(data1[4]);
                    for(int k = 1; k <= geo.n_itens; k++){

                        item.item = data1[4+k];
                        item.id_geo = geo.id;
                        item_st.put(itens, item);
                        itens++;
                    }
                    geo_st.put(idgeo, geo);
                }

                reg_st.put(i+1, reg);

            }
            for(int q = 1; q <= 18; q++){
                System.out.println(geo_st.get(q).toString());
            }
            //System.out.println(reg_st.get(1).toString() + " " + reg_st.get(2).toString() + " " + reg_st.get(3).toString());

        }catch (FileNotFoundException erro){
            System.out.println(erro.toString());
        }
    }
}
