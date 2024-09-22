package com.project.controller;

import java.io.*;
import java.sql.Connection;

import com.project.dao.UserDAO;
import com.project.db.DBConnection;
import com.project.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "register", value = "/register")
public class RegisterUser extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_name = request.getParameter("user_name");
        String user_mail = request.getParameter("user_mail");
        String user_password = request.getParameter("user_password");

        try{
            Connection conn = DBConnection.getConnection();
            UserDAO userDAO = new UserDAO(conn);

            if(!userDAO.user_nameValid(user_name)){
                request.setAttribute("registerError", "Username can't contain Special Characters");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            UserDTO userDTO = new UserDTO(user_name, user_mail, user_password);
            boolean result = userDAO.registerUser(userDTO);

            if(result){
                request.setAttribute("success", "User registered successfully");
                request.getRequestDispatcher("loginAndRegister.jsp").forward(request, response);
            }
            else{
                request.setAttribute("registerError", "Username or E-mail is already taken");
                request.getRequestDispatcher("loginAndRegister.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}