/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DTO;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Bruno Carvalho Caxias
 */
public class SerieDTO {

    private int id;
    private String titulo;
    private int classetaria;
    private HashMap<Integer, EpisodioDTO> episodios;
    private LinkedList<Categoria> categorias;

    public SerieDTO(int id, String titulo, int clsetaria) {
        this.id = id;
        this.titulo = titulo;
        classetaria = clsetaria;
        episodios = new HashMap<Integer, EpisodioDTO>();
        categorias = new LinkedList<Categoria>();
    }


    public void adEpisodio(EpisodioDTO e) {
        episodios.put(e.getId(), e);
    }

    public void setCategoria(Categoria cat) {
        categorias.add(cat);
    }

    public String[] getCategorias() {
        String[] array = new String[categorias.size()];

        for (int i = 0; i < categorias.size(); i++) {
            array[i] = String.valueOf(categorias.get(i));
        }

        return array;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getClassetaria() {
        return classetaria;
    }

    
    
    @Override  
    public String toString() {
        String s;
        s = "id: " + id + ";\n";
        s = s + "Titulo: " + titulo + ";\n";
        s = s + "Class etária: " + classetaria + ";\n";
        return s;
    }

}
