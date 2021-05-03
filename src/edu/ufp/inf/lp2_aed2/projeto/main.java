package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        start();

    }

    public static void start(){
        BinarySearchST <Integer, String> users = new BinarySearchST<Integer, String>();
        BinarySearchST <Integer, String> caches = new BinarySearchST<Integer, String>();
        BinarySearchST <Integer, String> itens = new BinarySearchST<Integer, String>();

        try{
            File file = new File("data/input.txt");
            Scanner scan = new Scanner(file);
            int x = scan.nextInt();
            for(int i = 0; i < x; i++){
                users.put(i, scan.next());
                users.get(1);
            }
            //System.out.println(x);
        }catch (FileNotFoundException erro){
            System.out.println(erro.toString());
        }

    }
}
