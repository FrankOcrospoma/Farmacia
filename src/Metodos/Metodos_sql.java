package Metodos;

import Conexion.ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;


public class Metodos_sql {

    public static ConexionBD conexion = new ConexionBD();

    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;

    public int guardar(String Dni, String nombres, String apellidos, String email, String nusuario, String clave, String TipoUsuario, String estado) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = ("INSERT INTO Usuario (Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado) VALUES (?,?,?,?,?,?,?,?)");

        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, nombres);
            sentencia_preparada.setString(2, apellidos);
            sentencia_preparada.setString(3, Dni);
            sentencia_preparada.setString(4, email);
            sentencia_preparada.setString(5, nusuario);
            sentencia_preparada.setString(6, clave);
            sentencia_preparada.setString(7, TipoUsuario);
            sentencia_preparada.setString(8, estado);
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();

            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public static String buscarNombre(String nusuario) {

        String busqueda_nombre = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String nombres = resultado.getString("nombres");
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombres + " " + apellidos);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_nombre;
    }
    
    public static String buscarUsuario(String nusuario) {

        String busquedaUsuario = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT Nombres, Apellidos, Usuario FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Usuario = resultado.getString("Usuario");
                busquedaUsuario = (Usuario );
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busquedaUsuario;
    }
    
    public static String buscarTipoUsuario(String nusuario) {

        String busqueda_Rol = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT Nombres, Apellidos, TipoUsuario FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Tipo_Usuario = resultado.getString("TipoUsuario");
                busqueda_Rol = (Tipo_Usuario);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_Rol;
    }
    
    public static String buscarId(String nusuario) {

        String busqueda_Id = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT Nombres, Apellidos, TipoUsuario, idUsuario FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Id = resultado.getString("idUsuario");
                busqueda_Id = (Id);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_Id;
    }
    public static String buscarUsuarioRegistrado(String nusuario, String clave) {
        String busqueda_usuario = null;
        Connection conexion = null;
        String tipo ="Administrador";
        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar_usuario = ("SELECT Nombres, Usuario, Contraseña FROM usuario WHERE Usuario = '" + nusuario + "' && Contraseña = '" + clave + "' && TipoUsuario = '" + tipo + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                busqueda_usuario = "USUARIO ENCONTRADO";
            } else {
                busqueda_usuario = "USUARIO NO ENCONTRADO";

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_usuario;
    }

    public static String UsuarioInvitado(String user, String pass) {
        String buscarUsuario = null;
        Connection conexion = null;
        
        
       String tipo ="Vendedor";
        
        try {
            conexion = ConexionBD.conectar();
            String buscarInvitado = ("SELECT Nombres, Usuario, Contraseña, TipoUsuario  FROM usuario WHERE Usuario = '" + user + "' && Contraseña = '" + pass + "' && TipoUsuario = '" + tipo + "'");
            sentencia_preparada = conexion.prepareStatement(buscarInvitado);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                buscarUsuario = "USUARIO ENCONTRADO";
            }else {
                buscarUsuario = "USUARIO NO ENCONTRADO";
            }
            conexion.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
    return buscarUsuario;
    }
    
    ////
     public void grabarTabla(String sql) {
        ConexionBD cc = new ConexionBD();
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = cc.getConexion();
            //RECIBE EL PARAMETRO DE LA SENTENCIA SQL
            pst = con.prepareStatement(sql);
            int rs = pst.executeUpdate();//devulve la cantidad de filas añadidas
        } catch (Exception ex) {
            System.out.println("Error en la sentencia Insertar www" + ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
    }

    public boolean valida_Campos(String consulta) {
        Connection con = null;
        PreparedStatement pst = null;
        ConexionBD cc = new ConexionBD();
        try {
            con = conexion.getConexion();
            String sql = consulta;
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//recorre haver si SI HUVO REGISTRO con ese ID Y ESA CLAVE
                return true;   //retorna lo q encontro en la BD
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error en la conexión " + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }

        return false;
    } 

    /**
     * Actualiza*
     */
    public boolean actualizaTabla(String sql) {
        ConexionBD cc = new ConexionBD();
        try {
            Statement st = cc.getConexion().createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

    public int obtenerEntero(String sql) {
        Connection con = null;
        PreparedStatement pst = null;
        int valor = 0;
        ConexionBD cc = new ConexionBD();

        try {
            con = cc.getConexion();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) { // mientras aya informacion almacenarl en el listado
                valor = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en obtener_entero " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return valor;
    }

    public String obtenerCadena(String sql) {
        Connection con = null;
        ConexionBD cc = new ConexionBD();
        PreparedStatement pst = null;
        String cadena = null;

        try {
            con = cc.getConexion();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) { // mientras aya informacion almacenarl en el listado
                cadena = rs.getString(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en obtener_cadena " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return cadena;
    }

    public double obtenerDouble(String sql) {
        Connection con = null;
        PreparedStatement pst = null;
        double valor = 0.0;
        ConexionBD cc = new ConexionBD();

        try {
            con = cc.getConexion();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) { // mientras aya informacion almacenarl en el listado
                valor = rs.getDouble(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en obtener_double " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return valor;
    }

    public java.util.Date obtenerFecha(String sql) {

        Connection con = null;
        ConexionBD cc = new ConexionBD();
        PreparedStatement pst = null;
        java.util.Date fecha = null;

        try {
            con = cc.getConexion();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) { // mientras aya informacion almacenarl en el listado
                fecha = rs.getDate(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en obtener_fecha " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return fecha;
    }
}

