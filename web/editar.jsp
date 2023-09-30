<%-- 
    Document   : listar_excluir
    Created on : 3 de set. de 2023, 20:03:11
    Author     : Usuario
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MusicaDAO"%>
<%@page import="entidade.Musica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
        <link rel="stylesheet" href="./css/style.css">
        <style>
        h1{
            color: #4c79d3;
        }
    </style>
    </head>
    
    
    <%@include file="menu.jsp" %>
    
    <body>
        <h1>Editar!</h1>
        <div class="container">
            
    <%            ArrayList<Musica> music = new MusicaDAO().consultar();
    %>

    <table class="table">
        <th>Código</th>
        <th>ID Categoria</th>
        <th>Titulo</th>
        <th>Data Lanç.</th>
        <th>Editar</th>
        <th>Excluir</th>
            <%
                for (int i = 0; i < music.size(); i++) {
            %>
        <tr>
            <td><%= music.get(i).getCodigo()%></td>
            <td><%= music.get(i).getCategoriaID()%></td>
            <td><%= music.get(i).getTitulo()%></td>
            <td><%= music.get(i).getDataLancamento()%></td>
            
            <td><a href="acao?a=editarMusica&id=<%= music.get(i).getCodigo()%>" class="btn btn-success">Editar</a></td>
            <td><a href="acao?a=excluirMusica&id=<%= music.get(i).getCodigo()%>" class="btn btn-danger">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>
        </div>

    </body>
</html>
