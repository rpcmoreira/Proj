package edu.ufp.inf.lp2_aed2.projeto;

import edu.princeton.cs.algs4.*;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.lang.String;

public class Geocache {

    public String id;
    public String tipo;
    public float coordenadasX;
    public float coordenadasY;
    public int n_itens;
    public int id_reg;

    public Geocache(String id, String tipo, float coordenadasX, float coordenadasY, int n_itens, int id_reg) {
        this.id = id;
        this.tipo = tipo;
        this.coordenadasX = coordenadasX;
        this.coordenadasY = coordenadasY;
        this.n_itens = n_itens;
        this.id_reg = id_reg;
    }

    public Geocache() {
        this.id = "";
        this.tipo = "";
        this.coordenadasX = 0.0f;
        this.coordenadasY = 0.0f;
        this.n_itens = 0;
        this.id_reg = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCoordenadasX() {
        return coordenadasX;
    }

    public void setCoordenadasX(float coordenadasX) {
        this.coordenadasX = coordenadasX;
    }

    public float getCoordenadasY() {
        return coordenadasY;
    }

    public void setCoordenadasY(float coordenadasY) {
        this.coordenadasY = coordenadasY;
    }

    public int getN_itens() {
        return n_itens;
    }

    public void setN_itens(int n_itens) {
        this.n_itens = n_itens;
    }

    /**
     * Cria uma geocache, recebendo os parametros, na ST das geocaches, e adiciona-a a região
     *
     * @param id     - Id da geocache a adicionar
     * @param tipo   - Tipo da geocache (basic ou premium)
     * @param cX     - Latitude onde a geocache se encontra
     * @param cY     - Longitude onde a geocache se encontra
     * @param id_reg - Id da regiao onde esta geocache se encontra
     * @param sizes  - Array com o numero total de geocaches
     * @param geo    - ST das geocaches
     * @param reg    - ST das Regioes
     */
    public void addGeocache(String id, String tipo, float cX, float cY, int id_reg, int[] sizes, SequentialSearchST<Integer, Geocache> geo, SequentialSearchST<Integer, Regiao> reg) {
        int idgeo = Integer.parseInt(id.replace("geocache", ""));

        if (reg.get(id_reg) != null && geo.get(idgeo) == null) {
            if (geo.contains(idgeo)) {
                System.out.println("Erro na Inserção da GEOCACHE:\tO ID " + id + " já existe!");
            } else {
                reg.get(id_reg).n_caches++;
                Geocache geocache = new Geocache(id, tipo, cX, cY, 0, id_reg);
                geo.put(idgeo, geocache);
                System.out.println("Geocache " + id + " adicionada com sucesso! -> " + geocache);
                sizes[2]++;
            }
        } else {
            System.out.print("Erro na criaçao da Geocache! --> ");
            if (reg.get(id_reg) != null) System.out.println("A regiao não existe!");
            else System.out.println("A Geocache já existe. Tente remove-la ou edita-la!");
        }
    }

    /**
     * Remove uma geocache, usando o id da mesma, da ST das geocaches, removendo tambem os seus itens da ST dos Itens, e removendo-a da região
     *
     * @param id    - ID da geocache
     * @param sizes - Array com o numero total de Geocaches
     * @param geo   - ST das Geocahces
     * @param reg   - ST das Regioes
     * @param item  - ST dos Itens
     */
    public void removeGeocache(String id, int[] sizes, SequentialSearchST<Integer, Geocache> geo, SequentialSearchST<Integer, Regiao> reg, SequentialSearchST<Integer, Item> item) {
        int idgeo = Integer.parseInt(id.replace("geocache", ""));

        if (geo.contains(idgeo)) {
            System.out.println("Geocache " + id + " removida com sucesso!");
            if (geo.get(idgeo).n_itens > 0) {
                int n_itens = geo.get(idgeo).n_itens;
                for (int i = 1; i <= n_itens; i++) {
                    if (item.get(i) != null && item.get(i).id_geo.equals(id)) {
                        System.out.print("\t\t --> ");
                        item.get(i).removeItem(i, sizes, item, geo);
                    } else n_itens++;
                }
            }
            reg.get(geo.get(idgeo).id_reg).n_caches--;
            geo.delete(idgeo);
            sizes[2]--;
        } else {
            System.out.println("Erro na Remoção da GEOCACHE:\tO ID " + id + " não existe!");
        }
    }

    /**
     * Edita o parametro recebido de uma Geocache, para o conteudo recebido
     *
     * @param tipo     - Parametro a alterar, baseado nas variaveis da classe
     * @param conteudo - Conteudo que sera o novo parametro
     * @param id       - Id da Geocache
     * @param geo_st   - ST das Geocaches
     */
    public void editCache(String tipo, String conteudo, int id, SequentialSearchST<Integer, Geocache> geo_st) {
        if (geo_st.get(id) != null && id <= geo_st.size()) {
            switch (tipo) {
                case "tipo" -> {
                    geo_st.get(id).tipo = conteudo;
                    System.out.println("Geocache " + id + " editada com sucesso! -> " + geo_st.get(id));
                }
                case "coordenadasX" -> {
                    geo_st.get(id).coordenadasX = Float.parseFloat(conteudo);
                    System.out.println("Geocache " + id + " editada com sucesso! -> " + geo_st.get(id));
                }
                case "coordenadasY" -> {
                    geo_st.get(id).coordenadasY = Float.parseFloat(conteudo);
                    System.out.println("Geocache " + id + " editada com sucesso! -> " + geo_st.get(id));
                }
                case "regiao" -> {
                    geo_st.get(id).id_reg = Integer.parseInt(conteudo);
                    System.out.println("Geocache " + id + " editada com sucesso! -> " + geo_st.get(id));
                }
                default -> System.out.println("Tipo introduzido invalido na ediçao da Geocache");
            }
        } else {
            System.out.println("Erro na Edição do GEOCACHE:\tO ID " + id + " não existe!");
        }
    }

    /**
     * Lista todos os Users que visitaram a Geocache recebida, usando os logs
     *
     * @param geo      - Id da Geocache
     * @param sizes    - Array com o numero total de Geocaches
     * @param user_st  - ST dos Users
     * @param geo_st   - ST das Geocaches
     * @param histV_st - ST dos Logs do User
     */
    public void usersVisitedCache(String geo, int[] sizes, SequentialSearchST<Integer, User> user_st, SequentialSearchST<Integer, Geocache> geo_st, RedBlackBST<Integer, HistoricoVisited> histV_st) {
        int idgeo = Integer.parseInt(geo.replace("geocache", ""));
        // 1 Percorrer todos os users, 2 em cada um verificar nos logs se 3 existe o idgeo e se 4 existir imprimir o user

        System.out.println("Users que visitaram a Geocache " + idgeo + ":");
        for (int i = 1; i <= sizes[0]; i++) {                                                                                 // Percorre os users
            if (histV_st.get(i) != null && user_st.get(i) != null && histV_st.get(i).user.equals(user_st.get(i).nome)) {
                for (int j = 0; j < histV_st.get(i).n_visited; j++) {                                                             // Percorre as geos que o user visitou
                    if (histV_st.get(i).visited[j] == idgeo)                                                                       // Verifica se a geo é a mesma que se pretende
                        System.out.println("\t\t" + user_st.get(i).nome);
                }
            }
        }
        System.out.println();
    }

    /**
     * Lista todas as Geocaches premium que possuem pelo menos 1 Item
     *
     * @param sizes  - Array com o numero total de Geocaches
     * @param geo_st - ST das Geocaches
     */
    public void premiumWithItem(int[] sizes, SequentialSearchST<Integer, Geocache> geo_st) {
        for (int i = 1; i <= sizes[2]; i++) {
            if (geo_st.get(i) != null && geo_st.get(i).tipo.equals("premium") && geo_st.get(i).n_itens > 0) {
                System.out.println(geo_st.get(i).toString());
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Geocache{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", coordenadasX=" + coordenadasX +
                ", coordenadasY=" + coordenadasY +
                ", Regiao=" + id_reg +
                ", n_itens=" + n_itens +
                '}';
    }

    /**
     * Coloca uma String com a primeira letra em maiuscula
     *
     * @param str - String para por com maiuscula
     * @return - Da return a string com a primeira letra maiuscula
     */
    public static String capitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen)
                .append(Character.toTitleCase(str.charAt(0)))
                .append(str.substring(1))
                .toString();
    }
}