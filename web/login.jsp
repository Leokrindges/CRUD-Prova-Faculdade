<%-- 
    Document   : index
    Created on : 7 de set. de 2023, 09:08:02
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">  
        <link rel="stylesheet" href="./css/style.css">
        <style>
            #login {
                background: linear-gradient(120deg, #808080 44.9%, #C0C0C0 45%) no-repeat fixed;
            }

            .button-login {
                border-radius: 10px;
                background-color: #808080;
                color: #ffffff;
                width:  50%;
                margin: 0 25%;
            }

            .button-login:hover, .button-default:hover {
                background: #696969;
                color: #ffffff;


            </style>
        </head>
        <body id="login">
            <main>
                <div class="container">
                    <div class="row vh-100">
                        <div class="col d-flex justify-content-center my-5 flex-column">
                            <div class="logo_cadastro">
                                <img src="./assets/logo_login.png" style="width: 40%;
                                     height: 90%;
                                     margin-top: 05px;" alt="Cadastro de Clientes">
                            </div>
                            <div class="text-login">
                                <p>Tenha os Principais dados dos seus clientes.</p>
                                <p>Interface amigável e intuitiva.</p>
                            </div>

                        </div>
                        <div class="col d-flex justify-content-center my-5 flex-column">
                            <div class="container">
                                <div class="row">
                                    <div class="col text-center mb-5" >
                                        <svg xmlns="http://www.w3.org/2000/svg"  width="100" height="100" fill="currentColor"  class="bi bi-person-circle" viewBox="0 0 16 16">
                                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                        <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                        </svg>
                                    </div>
                                    <p style="text-align: center;
                                       font-size: 30px;">Bem vindo!</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <form id="login-form" action="acao?a=login" method="post">
                                        <div class="mb-3">
                                            <label for="user" class="form-label">Usuário</label>
                                            <input type="text" class="form-control" name="user" id="user"
                                                   aria-describedby="emailHelp">
                                            <div id="emailHelp" class="form-text">Utilize seu usuário para realizar o
                                                login.</div>
                                        </div>
                                        <div class="mb-3">
                                            <label for="password" class="form-label">Senha</label>
                                            <input type="password" class="form-control" name="password" id="password">
                                        </div>
                                        <button type="submit" class="btn button-login">Entrar</button>
                                        <%-- Exibe a mensagem na página --%>
                                        <% String mensagem = (String) request.getAttribute("mensagem"); %>
                                        <% if (mensagem != null) { %>
                                        <div class="mensagem" style="color: red;
                                             font-size: 18px;
                                             margin-top: 10px;">
                                            <%= mensagem %>
                                        </div>
                                        <% } %>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </body>
    </html>
