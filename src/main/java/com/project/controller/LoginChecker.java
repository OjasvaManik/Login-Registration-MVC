package com.project.controller;

import java.io.*;
import java.sql.Connection;

import com.project.dao.UserDAO;
import com.project.db.DBConnection;
import com.project.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class LoginChecker extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("loginAndRegister.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_identifier = request.getParameter("user_identifier");
        String user_password = request.getParameter("user_password");

        try{
            Connection conn = DBConnection.getConnection();
            UserDAO userDAO = new UserDAO(conn);

            if(user_identifier.contains("@") || userDAO.user_nameValid(user_identifier)){
                UserDTO userDTO = userDAO.getUser(user_identifier, user_password);
                if(userDTO != null){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user_name", userDTO.getUser_name());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("loginError", "Invalid username or password");
                    request.getRequestDispatcher("loginAndRegister.jsp").forward(request, response);
                }
            }
            else{
                request.setAttribute("loginError", "Username can't contain Special Characters");
                request.getRequestDispatcher("loginAndRegister.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}