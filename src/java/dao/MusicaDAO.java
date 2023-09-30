/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import entidade.Musica;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MusicaDAO {

    public boolean salvar(Musica m) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "insert into musica values ("
                    + "default,"
                    + "'" + m.getCategoriaID() + "',"
                    + "'" + m.getTitulo() + "',"
                    + "'" + m.getDataLancamento() + "'"
                    + ")";

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar Musica: " + e);
            return false;
        }
    }

    public ArrayList consultar() {
        ArrayList<Musica> musicas = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * from musica";

            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Musica m = new Musica();

                m.setCodigo(resultado.getInt("id"));
                m.setCategoriaID(resultado.getString("Categoria_id"));
                m.setTitulo(resultado.getString("titulo"));

                m.setDataLancamento(resultado.getDate("data_lancamento"));
                musicas.add(m);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consular Musica: " + e);
        }

        return musicas;
    }

    public Musica consultar(int codigo) {
        Musica musica = new Musica();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * from musica "
                    + "where "
                    + "id = " + codigo;

            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            resultado.next();

            musica.setCodigo(resultado.getInt("id"));
            musica.setCategoriaID(resultado.getString("Categoria_id"));
            musica.setTitulo(resultado.getString("titulo"));

            musica.setDataLancamento(resultado.getDate("data_lancamento"));

        } catch (Exception e) {
            System.out.println("Erro ao consular UMA Musica: " + e);
        }

        return musica;
    }

    public boolean excluir(int codigo) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "delete from musica "
                    + "where "
                    + "id = " + codigo;

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Musica: " + e);
            return false;
        }
    }

    public boolean atualizar(Musica m) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "update musica "
                    + "set "
                    + "titulo = '" + m.getTitulo() + "', "
                    + "Categoria_id = '" + m.getCategoriaID() + "', "
                     + "data_lancamento = '" + m.getDataLancamento() + "' "
                    + "where id = " + m.getCodigo();

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Musica: " + e);
            return false;
        }
    }
}
