package com.example.lab09_20242296.servlet;
import com.example.lab09_20242296.beans.Usuario;
import com.example.lab09_20242296.daos.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RegistrosServlet")
public class RegistrosServlet extends HttpServlet {

    @Override protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("/registro.jsp").forward(req,resp);
    }
    @Override protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException{

        UsuarioDao usuarioDao = new UsuarioDao();

        String nombres = req.getParameter("nombres");
        String apellidos = req.getParameter("apellidos");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (usuarioDao.existeCorreo(email)){
            req.setAttribute("Error","El correo ya se uso");
            req.getRequestDispatcher("/registro.jsp").forward(req,resp);

            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);

        usuarioDao.registrarUsuario(usuario,password);


    }

}
