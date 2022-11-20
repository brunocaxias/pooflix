/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DAO;

/**
 *
 * @author Bruno Carvalho Caxias
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sala19a
 */
public class ConexaoDAO {
    Connection con=null;
    
    /**
     * Method for returning a connection to the database
     * @return
     * @throws ClassNotFoundException 
     */
    public Connection conexaoBD() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/pooflix?user=root&password=";
            con= DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados");
        }
        
        return con;
}
    
}
    
