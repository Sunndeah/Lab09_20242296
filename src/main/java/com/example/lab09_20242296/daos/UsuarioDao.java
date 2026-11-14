package com.example.lab09_20242296.daos;
import java.util.ArrayList;
import java.sql.*;
import com.example.lab09_20242296.beans.Usuario;

public class UsuarioDao extends BaseDao {

    public void registrarUsuario(Usuario usuario, String password){
        String sql = "INSERT INTO usuario" +
                "(nombre, apellidos, email, password_hash, rol, estado)" +
                "VALUES (?,?,?,SHA2(?,256), 'LECTOR, 'ACTIVO')";

        try (Connection conn = this.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getEmail());
            ps.setString(4,password);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean existeCorreo(String email){
        String sql = "SELECT id_usuario FROM usuario where email = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1,email);

            try (ResultSet rs = ps.executeQuery()){
                return rs.next();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public Usuario validarUsuarui (String email, String password) throws SQLException {

        Usuario usuario = null;

        String sql = "SELECT id_usuario, nombres, apellidos, email, rol, estado " +
                "FROM usuario WHERE email = ? AND password_hash = SHA2(?,256) AND estado = 'ACTIVO' ";

        try (Connection conn = this.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,email);
            ps.setString(2,password);

            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    usuario = new Usuario();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setEstado(rs.getString("estado"));

                }

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuario;


    }
}
