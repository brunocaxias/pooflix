/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DTO;

/**
 *
 * @author Bruno Carvalho Caxias
 */
public class PerformanceDTO {
    private EpisodioDTO episodio;
    private PersonagemDTO personagem;
    private AtorDTO ator;

    public PerformanceDTO(EpisodioDTO epi,PersonagemDTO person,AtorDTO ator){
        episodio = epi;
        personagem = person;
        this.ator = ator;
    }

    public EpisodioDTO getIdep(){
        return episodio;
    }

    public PersonagemDTO getIdperson(){
        return personagem;
    }

    public AtorDTO getAtor(){
        return ator;
    }
    
}
