/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DTO;

/**
 *
 * @author Bruno Carvalho Caxias
 */
    
import java.util.LinkedList;

public class EpisodioDTO {
    private int id;
    private String temporada;
    private String titulo;
    private SerieDTO serie;
    public String resumo;
    private LinkedList<PerformanceDTO> perfomances;

    public EpisodioDTO(int id, String titulo, String temporada, String resumo){
        this.id = id;
        this.titulo = titulo;
        this.temporada = temporada;
        this.resumo = resumo;
    }

    public void adperformance(PerformanceDTO p){
        perfomances.add(p);
    }

    public SerieDTO getSerie(){
        return serie;
    }

    public void setSerie(SerieDTO s){
        if(serie == null){
            serie = s;
        }
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public int getId(){
        return id;
    }

    public String getTemporada(){ 
        return temporada;
    }

    public String getTitulo(){
        return titulo;
    } 

    public String getResumo(){ 
        return resumo;
    }

    @Override
    public String toString(){ 
        String s;
        s = "id: " + id + ";\n";
        s = s + "Titulo: " + titulo + ";\n";
        s = s + String.valueOf(temporada);
        return s;
    }
}
