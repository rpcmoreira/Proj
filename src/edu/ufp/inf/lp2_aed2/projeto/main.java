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
        BinarySearchST <String, Integer> users = new BinarySearchST<String, Integer>();
        BinarySearchST <String, Integer> caches = new BinarySearchST<String, Integer>();
        BinarySearchST <String, Integer> itens = new BinarySearchST<String, Integer>();

        try{
            File file = new File("data/input.txt");
            Scanner scan = new Scanner(file);
            int x = scan.nextInt();
            for(int i = 0; i < x; i++){
                scan.useDelimiter(",");


            }
            //System.out.println(x);
        }catch (FileNotFoundException erro){
            System.out.println(erro.toString());
        }

    }
}
