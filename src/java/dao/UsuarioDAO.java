/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import entidade.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {

    public Usuario autenticar(String usuario, String senha) {

        Usuario u = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM usuario WHERE usuario = '" + usuario + "' AND senha = '" + senha + "'";

            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                // Autenticação bem-sucedida
                u = new Usuario();
                u.setUsuario(resultado.getString("usuario"));
                u.setSenha(resultado.getString("senha"));
                System.out.println("Autenticação bem-sucedida.");

            } else {
                // Autenticação falhou
                System.out.println("Autenticação falhou.");
            }

            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar Usuario: " + e);

        }
        return u;
    }
}
