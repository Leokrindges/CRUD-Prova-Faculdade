/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.MusicaDAO;
import dao.UsuarioDAO;
import entidade.Musica;
import entidade.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class acao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String a = request.getParameter("a");

        if (a.equals("editarMusica")) {
            String id = request.getParameter("id");
            int codigo = Integer.parseInt(id);

            Musica musica = new MusicaDAO().consultar(codigo);

            request.setAttribute("musica_cadastro", musica);

            encaminharPagina("musica_cadastro.jsp", request, response);
        }

        if (a.equals("excluirMusica")) {
            String id = request.getParameter("id");
            int codigo = Integer.parseInt(id);

            if (new MusicaDAO().excluir(codigo)) {
                encaminharPagina("sucesso.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String a = request.getParameter("a");

        if (a.equals("salvarMusica")) {
            String codigo = request.getParameter("codigo");
            String idcategoria = request.getParameter("id_categoria");
            String titulo = request.getParameter("titulo");
            String dataLancamentoStr = request.getParameter("data_lancamento"); // Obtenha a data como String

            Musica musica = new Musica();
            int id = Integer.parseInt(codigo);
            musica.setCodigo(id);
            musica.setCategoriaID(idcategoria);
            musica.setTitulo(titulo);
            

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date datalancamento = null;

            try {
                datalancamento = sdf.parse(dataLancamentoStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Lida com a exceção, caso ocorra um problema na conversão
            }
            musica.setDataLancamento(datalancamento);

            if (id == 0) {
                if (new MusicaDAO().salvar(musica)) {
                    encaminharPagina("sucesso.jsp", request, response);
                } else {
                    encaminharPagina("erro.jsp", request, response);
                }
            } else {
                if (new MusicaDAO().atualizar(musica)) {
                    encaminharPagina("sucesso.jsp", request, response);
                } else {
                    encaminharPagina("erro.jsp", request, response);
                }
            }

        }

        if (a.equals("login")) {
            // logica do login
            // pegar usuario
            // pegar senha
            // autenticar = verificar
            // sucesso = vai pro sistema || erro = login de novo

            String user = request.getParameter("user");
            String password = request.getParameter("password");

            System.out.println("User: " + user);
            System.out.println("Password: " + password);

            Usuario usuario = new UsuarioDAO().autenticar(user, password);

            if (usuario != null) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("user", usuario);

                encaminharPagina("musica_cadastro.jsp", request, response);
            } else {
                request.setAttribute("mensagem", "Por favor, verifique seu usuario e senha!!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        }

        if (a.equals("logout")) {
            HttpSession sessao = request.getSession();
            sessao.invalidate();

            response.sendRedirect("login.jsp");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao encaminhar: " + e);
        }
    }

}
