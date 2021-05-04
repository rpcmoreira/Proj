package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        SequentialSearchST<Integer, Historico> log_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Historico> log_tb_st = new SequentialSearchST<>();


        // Leitura do ficheiro input.txt
        try{
            int itens = 0;

            Scanner scan = new Scanner(new BufferedReader(new FileReader("data/input.txt")));
            int x = scan.nextInt();
            scan.nextLine();

            // Leitura do user
            for(int i = 0; i < x; i++) {
                User u = new User();

                String[] data = scan.nextLine().split(", ");
                int id = Integer.parseInt(data[0]);
                u.nome = data[1];
                u.tipo = data[2];

                user_st.put(id, u);
            }

            //Leitura da Regiao
            x = scan.nextInt();
            scan.nextLine();

            for(int i = 0; i < x; i++){
                Regiao reg = new Regiao();

                String[] data = scan.nextLine().split(", ");
                reg.nome = data[0];
                reg.n_caches = Integer.parseInt(data[1]);

                // Leitura da Geocache
                for(int j = 0; j < reg.n_caches; j++){
                    Geocache geo = new Geocache();

                    String[] data1 = scan.nextLine().split(", ");
                    geo.id = data1[0];
                    int idgeo = Integer.parseInt(geo.id.replace("geocache", ""));
                    //System.out.println(idgeo);
                    geo.tipo = data1[1];
                    geo.coordenadasX = Float.parseFloat(data1[2]);
                    geo.coordenadasY = Float.parseFloat(data1[3]);
                    geo.n_itens = Integer.parseInt(data1[4]);

                    // Leitura dos itens
                    for(int k = 1; k <= geo.n_itens; k++){
                        Item item = new Item();

                        item.item = data1[4+k];
                        item.id_geo = geo.id;
                        item_st.put(itens, item);
                        itens++;
                    }
                    geo_st.put(idgeo, geo);
                }
                reg_st.put(i+1, reg);
            }

            // Leitura das ligacoes
            x = scan.nextInt();
            scan.nextLine();

            for(int i = 0; i < x; i++){
                Ligacoes l = new Ligacoes();

                String[] data = scan.nextLine().split(", ");
                l.id_1 = data[0];
                l.id_2 = data[1];
                l.distancia = Float.parseFloat(data[2]);
                l.distancia = Integer.parseInt(data[3]);

                lig_st.put(i,l);
            }

            // Leitura das travelBugs
            x = scan.nextInt();
            scan.nextLine();

            for(int i = 0; i < x; i++){
                Travelbug tb = new Travelbug();

                String[] data = scan.nextLine().split(", ");
                tb.id = data[0];
                tb.user = data[1];
                tb.geo_inicial = data[2];
                tb.geo_destino = data[3];

                tvb_st.put(i,tb);
            }

            Scanner scan2 = new Scanner(new BufferedReader(new FileReader("data/logs.txt")));
            x = scan2.nextInt();
            scan2.nextLine();

            for(int i = 0; i < x; i++){
                Historico hist = new Historico();

                String[] data = scan2.nextLine().split(", ");
                hist.user = data[0];
                hist.n_visited = Integer.parseInt(data[1]);
                for(int y = 0; y <= hist.n_visited; y++){
                    hist.visited[y] = data[2];
                }
                for(int y = 0; y <= hist.n_visited; y++){
                    hist.date[y] = data[3];
                }
                log_st.put(i, hist);
                System.out.println(log_st.get(i).toString());
            }


            x = scan2.nextInt();
            scan2.nextLine();

            for(int z = 0; z < x; z++){
                Historico hist1 = new Historico();

                String[] data2 = scan2.nextLine().split(", ");
                hist1.user = data2[0];
                hist1.n_tb =  Integer.parseInt(data2[1]);
                hist1.tb_start =  Integer.parseInt(data2[2]);
                hist1.tb_end =  Integer.parseInt(data2[3]);

                log_tb_st.put(z, hist1);
            }

        }catch (FileNotFoundException erro){
            System.out.println(erro.toString());
        }

        System.out.println(log_tb_st.get(1).toString2());
    }
}
