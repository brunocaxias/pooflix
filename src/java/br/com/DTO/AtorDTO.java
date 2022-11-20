/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DTO;

import java.util.LinkedList;

/**
 *
 * @author Bruno Carvalho Caxias
 */
public class AtorDTO {
    
    private int id;
    private String nome;
    private String nacionalidade;
    private LinkedList<PerformanceDTO> performances;

    public AtorDTO(int id,String nome){
        this.id = id;
        this.nome = nome;
        performances = new LinkedList<PerformanceDTO>();
    }


    public void adPerformance(PerformanceDTO p){
        performances.add(p);
    }

    public void setNacio(String nacionalidade){
    this.nacionalidade = nacionalidade;
    }

    public int getId(){
    return id;
    }

    public String getNome(){
    return nome;
    }

    public String getNacionalidade(){
    return nacionalidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
    
    
    
}
