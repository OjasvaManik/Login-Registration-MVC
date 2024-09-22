package com.project.dao;

import com.project.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    public UserDTO getUser(String user_identifier, String user_password) {

        String query = "SELECT * FROM user_details WHERE (user_name = ? OR user_mail = ?) AND user_password = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user_identifier);
            ps.setString(2, user_identifier);
            ps.setString(3, user_password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new UserDTO(rs.getString("user_name"), rs.getString("user_mail"), rs.getString("user_password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;

    }

    public boolean registerUser(UserDTO userDTO) {

        String checkQuery = "SELECT * FROM user_details WHERE user_name = ? OR user_mail = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(checkQuery);
            ps.setString(1, userDTO.getUser_name());
            ps.setString(2, userDTO.getUser_email());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String query = "INSERT into user_details (user_name, user_mail, user_password) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userDTO.getUser_name());
            ps.setString(2, userDTO.getUser_email());
            ps.setString(3, userDTO.getUser_password());
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean user_nameValid(String user_name){

        return user_name.matches("^[a-zA-Z0-9]*$");

    }

}
