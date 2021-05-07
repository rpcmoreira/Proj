package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        // Start
        //int n_user = 0, n_reg = 0, n_geo = 0,n_itens = 0, n_tv = 0, n_lig = 0;
        int[] sizes = new int[6];
        for(int i = 0; i < 6; i++) sizes[i] = 0;

        SequentialSearchST<Integer, User> user_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Geocache> geo_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Item> item_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Ligacoes> lig_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Regiao> reg_st = new SequentialSearchST<>();
        SequentialSearchST<Integer, Travelbug> tvb_st = new SequentialSearchST<>();

        RedBlackBST<Integer, Historico> log_st = new RedBlackBST<>();

        // Leitura do ficheiro input.txt
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("data/input.txt")));
            sizes[0] = scan.nextInt();
            scan.nextLine();

            // Leitura do user
            for (int i = 0; i < sizes[0]; i++) {
                User u = new User();

                String[] data = scan.nextLine().split(", ");
                int id = Integer.parseInt(data[0]);
                u.nome = data[1];
                u.tipo = data[2];

                user_st.put(id, u);
            }

            //Leitura da Regiao
            sizes[1] = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < sizes[1]; i++) {
                Regiao reg = new Regiao();

                String[] data = scan.nextLine().split(", ");
                reg.nome = data[0];
                reg.n_caches = Integer.parseInt(data[1]);


                // Leitura da Geocache
                for (int j = 0; j < reg.n_caches; j++) {
                    sizes[2]++;
                    Geocache geo = new Geocache();

                    String[] data1 = scan.nextLine().split(", ");
                    geo.id = data1[0];
                    int idgeo = Integer.parseInt(geo.id.replace("geocache", ""));
                    //System.out.println(idgeo);
                    geo.tipo = data1[1];
                    geo.coordenadasX = Float.parseFloat(data1[2]);
                    geo.coordenadasY = Float.parseFloat(data1[3]);
                    geo.n_itens = Integer.parseInt(data1[4]);
                    geo.id_reg = i+1;

                    // Leitura dos itens
                    for (int k = 1; k <= geo.n_itens; k++) {
                        Item item = new Item();

                        item.item = data1[4 + k];
                        item.id_geo = geo.id;
                        item_st.put(sizes[3]+1, item);
                        sizes[3]++;
                    }
                    geo_st.put(idgeo, geo);
                }
                reg_st.put(i+1, reg);
            }

            // Leitura das ligacoes
            sizes[5] = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < sizes[5]; i++) {
                Ligacoes l = new Ligacoes();

                String[] data = scan.nextLine().split(", ");
                l.id_1 = data[0];
                l.id_2 = data[1];
                l.distancia = Float.parseFloat(data[2]);
                l.tempo = Integer.parseInt(data[3]);

                lig_st.put(i+1, l);
            }

            // Leitura das travelBugs
            sizes[4] = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < sizes[4]; i++) {
                Travelbug tb = new Travelbug();

                String[] data = scan.nextLine().split(", ");
                tb.id = data[0];
                tb.user = data[1];
                tb.geo_inicial = data[2];
                tb.geo_destino = data[3];

                tvb_st.put(i+1, tb);
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

        // TESTES - INSERIR E REMOVER
        // USERS
        /*User user = new User();
        user.addUser(8, "Patricia", "admin", sizes, user_st);
        user.removeUser(2, sizes, user_st);
        user.addUser(40, "Joao Paulo", "basic", sizes, user_st);*/

        // REGIAO
        Regiao regiao = new Regiao();
        regiao.addRegiao(4, "TesteReg", sizes, reg_st);
        regiao.removeRegiao(2, sizes, reg_st, geo_st, item_st);

        // GEOCACHE
        Geocache geocache = new Geocache();
        geocache.addGeocache("geocache19", "basic", -2.07543f, 43.87543f, 4, sizes, geo_st, reg_st);
        for (int i : new int[]{1, 5, 7, 14, 12, 11, 15, 16}) {
            String res = "geocache" + i;
            geocache.removeGeocache(res, sizes, geo_st, reg_st, item_st);
        }

        // ITEM
        Item item = new Item();
        item.addItem(19,"geocache19", "mp3", sizes, item_st, geo_st);
        item.addItem(23,"geocache19", "mp4", sizes, item_st, geo_st);
        item.removeItem(14, sizes, item_st, geo_st);

        // LIGACOES
        /*Ligacoes ligacao = new Ligacoes();
        ligacao.addLigacao("geocache2", "geocache19", 599.6f, 4573, sizes, lig_st);
        ligacao.removeLigacao("geocache17", "geocache18", sizes, lig_st);*/

        // Listar tudo
        //listarUsers(sizes, user_st);
        listarRegiao(sizes, reg_st, geo_st, item_st);
        //listarGeocache(sizes, geo_st, item_st);
        //listarItens(sizes, item_st);
        //listarTravelbug(sizes, tvb_st);
        //listarLigacoes(sizes, lig_st);
    }

    public static boolean geoContainsItem(int id_item, String id_geo, SequentialSearchST<Integer, Item> itens){
        if(itens.contains(id_item)){
            return (itens.get(id_item).id_geo.equals(id_geo));
        }
        return false;
    }

    public static boolean regContainsCache(String id_geo, int regiao, SequentialSearchST<Integer, Geocache> geo){
        int n_geo = Integer.parseInt(id_geo.replace("geocache", ""));
        if(geo.contains(n_geo)){
            return (geo.get(n_geo).id_reg == regiao);
        }
        return false;
    }

    public static void listarUsers(int[] sizes, SequentialSearchST<Integer, User> user_st) {
        int n_users = sizes[0];
        System.out.print("\n");
        for( int i = 0; i < n_users; i++){
            if (user_st.get(i+1) != null) System.out.println(i+1 + " " + user_st.get(i+1));
            else n_users++;
        }
        //System.out.print("\n");
    }

    public static void listarGeocache(int[] sizes, SequentialSearchST<Integer, Geocache> geo_st, SequentialSearchST<Integer, Item> item_st){
        int n_geo = sizes[2];
        System.out.print("\n");
        for( int i = 0; i < n_geo; i++){
            if (geo_st.get(i+1) != null){
                System.out.println(i+1 + " " + geo_st.get(i+1));
                int n_itens = 0;
                if(geo_st.get(i+1).n_itens > 0){ System.out.print("\tItens{");
                for(int id_item = 1; n_itens < geo_st.get(i+1).getN_itens(); id_item++){
                    if(geoContainsItem(id_item, geo_st.get(i+1).id, item_st)){
                        System.out.print(" " + item_st.get(id_item).item);
                        n_itens++;
                        if (n_itens + 1 <= geo_st.get(i+1).getN_itens()) System.out.print(",");
                    }
                }
                    System.out.print("}\n");
                }
            }
            else n_geo++;
        }
        //System.out.print("\n");
    }

    public static void listarLigacoes(int[] sizes, SequentialSearchST<Integer, Ligacoes> lig_st){
        int n_lig = sizes[5];
        System.out.println("\n");
        for(int i = 0; i < n_lig; i++){
            if(lig_st.get(i+1) != null) System.out.println(i+1 + " " + lig_st.get(i+1));
            else n_lig++;
        }
        //System.out.println("\n");
    }

    public static void listarItens(int[] sizes, SequentialSearchST<Integer, Item> item_st){
        int n_itens = sizes[3];
        System.out.println("\n");
        for(int i = 0; i < n_itens; i++){
            if(item_st.get(i+1) != null) System.out.println(i+1 + " " + item_st.get(i+1));
            else n_itens++;
        }
        //System.out.println("\n");
    }

    public static void listarTravelbug(int[] sizes, SequentialSearchST<Integer, Travelbug> tvb_st){
        int n_tv = sizes[4];
        System.out.println("\n");
        for(int i = 0; i < n_tv; i++){
            if(tvb_st.get(i+1) != null) System.out.println(i+1 + " " + tvb_st.get(i+1));
            else n_tv++;
        }
        //System.out.println("\n");
    }

    public static void listarRegiao(int[] sizes, SequentialSearchST<Integer, Regiao> reg_st, SequentialSearchST<Integer, Geocache> geo_st, SequentialSearchST<Integer, Item> item_st) {
        int n_reg = sizes[1];
        System.out.print("\n");
        for (int j = 1; j <= n_reg; j++) {
            if (reg_st.get(j) != null) {
                System.out.println(reg_st.get(j).nome.toUpperCase());
                int n_caches = reg_st.get(j).n_caches;
                for (int i = 1; i <= n_caches; i++) {
                    if (geo_st.get(i) != null && regContainsCache(geo_st.get(i).id, j, geo_st)) {
                        System.out.println("\t" + i + " " + geo_st.get(i));
                        int n_itens = 0;
                        if (geo_st.get(i).n_itens > 0) {
                            System.out.print("\t\tItens{");
                            for (int id_item = 1; n_itens < geo_st.get(i).getN_itens(); id_item++) {
                                if (geoContainsItem(id_item, geo_st.get(i).id, item_st)) {
                                    System.out.print(item_st.get(id_item).item);
                                    n_itens++;
                                    if (n_itens + 1 <= geo_st.get(i).getN_itens()) System.out.print(", ");
                                }
                            }
                            System.out.print("}\n");
                        }
                    } else n_caches++;
                }
                System.out.print("\n");
            } else n_reg++;
        }
    }
}
