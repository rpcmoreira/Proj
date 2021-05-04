package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
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

        // Leitura do ficheiro input.txt
        try{

            Scanner scan = new Scanner(new BufferedReader(new FileReader("data/input.txt")));
            int x = scan.nextInt();

            for(int i = 0; i < x; i++){
                User u = new User();

                // Leitura id user
                String token = scan.next();
                String str = token.replace(',','\0');
                int id = Integer.parseInt(str.trim());

                // Leitura nome user
                token = scan.next();
                str = token.replace(',','\0');
                u.nome = str.trim();

                // Leitura do tipo de user
                token = scan.next();
                u.tipo = token;
                System.out.println(id + u.nome + u.tipo);

                user_st.put(id,u);
            }


            /*File file = new File("data/input.txt");
            Scanner scan = new Scanner(file);
            int x = scan.nextInt();
            scan.nextLine();
            System.out.println(x);


            for(int i = 0; i < x; i++){

                User u = new User();
                int id = scan.nextInt();

                u.nome = scan.next();
                u.tipo = scan.next();

                System.out.println(id + u.nome + u.tipo);

                }*/

            //System.out.println(x);
        }catch (FileNotFoundException erro){
            System.out.println(erro.toString());
        }

    }
}
