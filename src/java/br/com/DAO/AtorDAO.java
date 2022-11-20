/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DAO;

import br.com.DTO.AtorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bruno Carvalho Caxias
 */
public class AtorDAO{
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AtorDTO> lista;
    
    /**
     * Method for inserting information in the database (create from CRUD)
     * @param objAtorDTO
     * @throws ClassNotFoundException 
     */
    public void create(AtorDTO objAtorDTO) throws ClassNotFoundException{
        String sql = "insert into ator(nome, nacionalidade, idUsuario)values(?, ?, ?)";
        con = new ConexaoDAO().conexaoBD();

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, objAtorDTO.getNome());
            pstm.setString(2, objAtorDTO.getNacionalidade());
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir ator");
        }
    }
    
    /**
     * Method for reading information in the database (read from CRUD)
     * @return
     * @throws ClassNotFoundException 
     */
    public ArrayList<AtorDTO> read() throws ClassNotFoundException{
        String sql = "select * from ator";
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery(sql);

            while (rs.next()) {
                AtorDTO objAtorDTO = new AtorDTO(rs.getInt("id"),rs.getString("nome"));
                objAtorDTO.setNacionalidade(rs.getString("nacionalidade"));

                lista.add(objAtorDTO);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao ler ator");

        }
        return lista;
    }
    
    /**
     * Method for updating information in the database (update from CRUD)
     * @param objAtorDTO
     * @throws ClassNotFoundException 
     */
    public void update(AtorDTO objAtorDTO) throws ClassNotFoundException {
        String sql = "update ator set nome= ?, nacionalidade = ? where id= ?";
        con = new ConexaoDAO().conexaoBD();

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, objAtorDTO.getNome());
            pstm.setString(2, objAtorDTO.getNacionalidade());
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
             System.out.println("Erro ao atualizar ator");
        }
    }
    
    /**
     * Method for deleting information in the database (delete from CRUD)
     * @param objAtorDTO
     * @throws ClassNotFoundException 
     */
    public void delete(AtorDTO objAtorDTO) throws ClassNotFoundException {
        String sql = "delete from ator where id = ?";
        con = new ConexaoDAO().conexaoBD();

        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, objAtorDTO.getId());
            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            System.out.println("Erro ao excluir ator");
        }
    }

    
  
    
}
