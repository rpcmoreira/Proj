package edu.ufp.inf.lp2_aed2.projeto;

import java.util.Arrays;

public class Historico {
    public String user;
    public int n_visited;
    //public int[] visited;
    public String[] visited;
    public String[] date;
    //public Date[] date;
    public int n_tb;
    public int tb_start;
    public int tb_end;

    public Historico(String user, int n_visited, String[] visited,/*int[] visited, Date[] date*/ String[] date) {
        this.user = user;
        this.n_visited = n_visited;
        this.visited = visited;
        this.date = date;
    }

    public Historico(String user, int n_tb, int tb_start, int tb_end) {
        this.user = user;
        this.n_tb = n_tb;
        this.tb_start = tb_start;
        this.tb_end = tb_end;
    }

    public Historico() {
        this.user = "";
        this.n_visited = 0;
        this.visited = new String[17];
        this.date = new String[17];
        this.n_tb = 0;
        this.tb_start = 0;
        this.tb_end = 0;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "user='" + user + '\'' +
                ", n_visited=" + n_visited +
                ", visited=" + Arrays.toString(visited) +
                ", date=" + Arrays.toString(date) +
                '}';
    }

    public String toString2() {
        return "Historico{" +
                "user='" + user + '\'' +
                ", n_tb=" + n_tb +
                ", tb_start=" + tb_start +
                ", tb_end=" + tb_end +
                '}';
    }
}
