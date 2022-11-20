/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DAO;

import br.com.DTO.PersonagemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bruno Carvalho Caxias
 */
public class PersonagemDAO {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PersonagemDTO> lista;
    
    /**
     * Method for inserting information in the database (create from CRUD)
     * @param objPersonagemDTO
     * @throws ClassNotFoundException 
     */
    public void create(PersonagemDTO objPersonagemDTO) throws ClassNotFoundException{
        String sql = "insert into personagem(nome) values(?) ";
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,objPersonagemDTO.getNome());
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir personagem");
        }
    }
    
    /**
     * Method for reading information in the database (read from CRUD)
     * @return
     * @throws ClassNotFoundException 
     */
    public ArrayList<PersonagemDTO> read() throws ClassNotFoundException{
        String sql = "select * from personagem";
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                PersonagemDTO objPersonagemDTO = new PersonagemDTO(rs.getInt("id"),rs.getString("nome"));
                lista.add(objPersonagemDTO);
                
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao ler personagem");
        }
        return lista;
    }
    
    /**
     * Method for updating information in the database (update from CRUD)
     * @param objPersonagemDTO
     * @throws ClassNotFoundException 
     */
    public void update(PersonagemDTO objPersonagemDTO) throws ClassNotFoundException{
        String sql = "update personagem set nome where id = ?";
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,objPersonagemDTO.getId());
            pstm.execute();
            pstm.close();
            
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar personagem");
        }
        
    }
    
    /**
     * Method for deleting information in the database (delete from CRUD)
     * @param objPersonagemDTO
     * @throws ClassNotFoundException 
     */
    public void delete(PersonagemDTO objPersonagemDTO) throws ClassNotFoundException{
        String sql = "delete from personagem where id= ?";
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,objPersonagemDTO.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar personagem");
        }
        
    }
    
}
