package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        // Start
        int n_user = 0, n_reg = 0, n_geo = 0, n_lig = 0, n_tv = 0, n_itens = 0;

        SequentialSearchST<Integer, User> user_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Geocache> geo_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Item> item_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Ligacoes> lig_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Regiao> reg_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Travelbug> tvb_st = new SequentialSearchST<>();

        BinarySearchST<Integer, Historico> log_st = new BinarySearchST<>();

        // Leitura do ficheiro input.txt
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("data/input.txt")));
            n_user = scan.nextInt();
            scan.nextLine();

            // Leitura do user
            for (int i = 0; i < n_user; i++) {
                User u = new User();

                String[] data = scan.nextLine().split(", ");
                int id = Integer.parseInt(data[0]);
                u.nome = data[1];
                u.tipo = data[2];

                user_st.put(id, u);
            }

            //Leitura da Regiao
            n_reg = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < n_reg; i++) {
                Regiao reg = new Regiao();

                String[] data = scan.nextLine().split(", ");
                reg.nome = data[0];
                reg.n_caches = Integer.parseInt(data[1]);


                // Leitura da Geocache
                for (int j = 0; j < reg.n_caches; j++) {
                    n_geo++;
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
                    for (int k = 1; k <= geo.n_itens; k++) {
                        Item item = new Item();

                        item.item = data1[4 + k];
                        item.id_geo = geo.id;
                        item_st.put(n_itens, item);
                        n_itens++;
                    }
                    geo_st.put(idgeo, geo);
                }
                reg_st.put(i + 1, reg);
            }

            // Leitura das ligacoes
            n_lig = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < n_lig; i++) {
                Ligacoes l = new Ligacoes();

                String[] data = scan.nextLine().split(", ");
                l.id_1 = data[0];
                l.id_2 = data[1];
                l.distancia = Float.parseFloat(data[2]);
                l.distancia = Integer.parseInt(data[3]);

                lig_st.put(i, l);
            }

            // Leitura das travelBugs
            n_tv = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < n_tv; i++) {
                Travelbug tb = new Travelbug();

                String[] data = scan.nextLine().split(", ");
                tb.id = data[0];
                tb.user = data[1];
                tb.geo_inicial = data[2];
                tb.geo_destino = data[3];

                tvb_st.put(i, tb);
            }

            // Leitura dos logs
            scan = new Scanner(new BufferedReader(new FileReader("data/logs.txt")));
            int x = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < x; i++) {
                Historico hist = new Historico();

                String[] data = scan.nextLine().split(", ");
                hist.user = data[0];
                hist.n_visited = Integer.parseInt(data[1]);
                hist.visited = new int[hist.n_visited];
                hist.date = new Date[hist.n_visited];
                for (int y = 0; y < hist.n_visited; y++) {
                    hist.visited[y] = Integer.parseInt(data[2 + y]);
                }
                String[] data1 = scan.nextLine().split(", ");
                for (int y = 0; y < hist.n_visited; y++) {
                    String[] aux = data1[y].split("-");
                    hist.date[y] = new Date(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
                }
                log_st.put(i, hist);
                //System.out.println(log_st.get(i).toString());
            }
        } catch (FileNotFoundException erro) {
            System.out.println(erro.toString());
        }
        // Fim da leitura dos ficheiros

        // Inserir e remover
        User user = new User();
        n_user =  user.addUser(8, "Patricia", "admin", n_user, user_st);
        n_user =  user.removeUser(2, n_user, user_st);
        n_user =  user.addUser(40, "TESTE", "admin", n_user, user_st);

        Geocache geocache = new Geocache();
        n_geo = geocache.addGeocache("geocache19", "basic", -2.07543f, 43.87543f, 5, n_geo, geo_st);
        for (int i : new int[]{1, 5, 7, 9, 12, 14, 15, 16}) {
            String res = "geocache" + i;
            n_geo = geocache.removeGeocache(res, n_geo, geo_st);
        }


        //Item it = new Item();

        //it.addItem("geocache4", "pa", item_st);  //not working, adicionar um item remove o que ja la estava
        //System.out.println(item_st.get(4).toString());

        // Listar tudo
        listarUsers(n_user, user_st);
        listarGeocache(n_geo, geo_st);
    }

    public static void listarUsers(int n_users, SequentialSearchST<Integer, User> user_st) {
        System.out.print("\n");
        for( int i = 0; i < n_users; i++){
            if (user_st.get(i+1) != null) System.out.println(i+1 + " " + user_st.get(i+1));
            else n_users++;
        }
        System.out.print("\n");
    }

    public static void listarGeocache(int n_geo, SequentialSearchST<Integer, Geocache> geo_st) {
        System.out.print("\n");
        for( int i = 0; i < n_geo; i++){
            if (geo_st.get(i+1) != null) System.out.println(i+1 + " " + geo_st.get(i+1));
            else n_geo++;
        }
        System.out.print("\n");
    }
}
