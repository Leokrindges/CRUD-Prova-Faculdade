<%-- 
    Document   : categoria
    Created on : Aug 23, 2023, 10:18:34 AM
    Author     : Usuario
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.MusicaDAO"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="entidade.Musica"%>
<%@page import="entidade.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>
        <link rel="stylesheet" href="./css/style.css">

    </head>

    <%@include file="menu.jsp" %>

    <%
        Musica m = (Musica) request.getAttribute("musica_cadastro");

        if (m == null) {
            m = new Musica();
        }      

    %>
    
    <%
    Categoria c = (Categoria) request.getAttribute("categoria_cadastro");

        if (c == null) {
            c = new Categoria();
        }
    %>

    <body>
        <h1>Cadastro de Musicas</h1>

        <div class="container">
            <form method="post" action="acao?a=salvarMusica">
                <div class="mb-3">
                    <label for="codigo" class="form-label">Código</label>
                    <input type="text" class="form-control" id="codigo" required="true" name="codigo" readonly="" value="<%= m.getCodigo() %>">
                </div>
                    <select class="form-select" aria-label="Default select example" id="id_categoria" required="true" name="id_categoria" value="<%= c.getCodigo() %>" >
                    <option value="">Selecione o Estilo</option>
                    <option value="1">Rock</option>
                    <option value="2">Reggae</option>
                    <option value="3">Jazz</option>
                </select>
                <div class="mb-3">
                    <label for="titulo" class="form-label">Titulo</label>
                    <input type="text" class="form-control" id="titulo"  name="titulo" required="true" value="<%= m.getTitulo() %>" >
                </div>
                <div class="mb-3">
                    <label for="data_lancamento" class="form-label">Data de lançamento</label>
                    <input type="date" class="form-control" id="data_lancamento" name="data_lancamento" required="true">
                </div>

                <div>
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </div>
            </form>
        </div>    
    </body>
</html>
