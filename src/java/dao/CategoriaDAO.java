/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import entidade.Categoria;
import entidade.Musica;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class CategoriaDAO {
    
    public boolean salvar(Categoria c) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "insert into Categoria values ("
                    + "default,"
                    + "'" + c.getCodigo() + "',"
                    + "'" + c.getDescrição()+ "'"
                    + ")";

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar Categoria: " + e);
            return false;
        }
    }
    
}
