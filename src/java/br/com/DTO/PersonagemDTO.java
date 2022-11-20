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
public class PersonagemDTO {
    
    private int id;
    private String nome;
    private LinkedList<PerformanceDTO> perfomances;

    public PersonagemDTO(int id,String nome){
    this.id = id;
    this.nome = nome;
    }

    public void adPerformance(PerformanceDTO p){
    perfomances.add(p);
    }

    public int getId(){
    return id;
    }

    public String getNome(){
    return nome;
    }
    
}
