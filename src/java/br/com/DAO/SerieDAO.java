/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DAO;

import br.com.DTO.SerieDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bruno Carvalho Caxias
 */
public class SerieDAO{
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<SerieDTO> lista;
    
    /**
     * Method for inserting information in the database (create from CRUD)
     * @param objSerieDTO
     * @throws ClassNotFoundException 
     */
    public void create(SerieDTO objSerieDTO)throws ClassNotFoundException{
        String sql = "insert into serie(titulo, idade)values(?, ?)";
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, objSerieDTO.getTitulo());
            pstm.setInt(2, objSerieDTO.getClassetaria());
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir serie");
        }
        
    }
    
    /**
     * Method for reading information in the database (read from CRUD)
     * @return
     * @throws ClassNotFoundException 
     */
    public ArrayList<SerieDTO> read() throws ClassNotFoundException{
        String sql = "select * from serie";
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery(sql);
            
            while(rs.next()){
                SerieDTO objSerieDTO = new SerieDTO(rs.getInt("id"),rs.getString("titulo"),rs.getInt("classetaria"));
                lista.add(objSerieDTO);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao ler serie");
        }
        return lista;
    }
    
    /**
     * Method for updating information in the database (update from CRUD)
     * @param objSerieDTO
     * @throws ClassNotFoundException 
     */
    public void update(SerieDTO objSerieDTO) throws ClassNotFoundException{
        String sql = "update serie set titulo = ?, classetaria = ? where id = ?";
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,objSerieDTO.getTitulo());
            pstm.setInt(2,objSerieDTO.getClassetaria());
            pstm.setInt(3,objSerieDTO.getId());
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar serie");
        }
        
    }
    
    /**
     * Method for deleting information in the database (delete from CRUD)
     * @param objSerieDTO
     * @throws ClassNotFoundException 
     */
    public void delete(SerieDTO objSerieDTO) throws ClassNotFoundException{
        String sql = "delete from serie where id = ?";
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, objSerieDTO.getId());
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            System.out.println("Erro ao deletar serie");
        }
        
    }
    
}
