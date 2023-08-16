/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_Consultas;

import Conexion.ConexionBD;
import Gestion.*;
import Metodos.Metodos_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisT
 */
public class CntcargaImpl extends Metodos_sql implements  Int_Cntcarga<ObCntcarga> {

    private ObCntcarga cntcarga;


    @Override
    public List<ObCntcarga> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        ConexionBD conectar = new ConexionBD();
        ArrayList<ObCntcarga> listaCnt_carga = new ArrayList<ObCntcarga>();
        try {
            
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from cntcarga where estado='1' order by cantidad ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_cntcarga = rs.getInt(1);
                int cantidad = rs.getInt(2);
                int estado = rs.getInt(3);
                listaCnt_carga.add(new ObCntcarga(id_cntcarga, cantidad, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Cnt_carga" + e);
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
        return listaCnt_carga;
    }

    @Override
    public List<ObCntcarga> listarCnt(int cntcarga) {
        Connection con = null;
        PreparedStatement pst = null;
        ConexionBD conectar = new ConexionBD();
        ArrayList<ObCntcarga> listaCnt_carga = new ArrayList<ObCntcarga>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from cntcarga where estado='1' "
                    + "order by cantidad limit 0," + cntcarga);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_cntcarga = rs.getInt(1);
                int cantidad = rs.getInt(2);
                int estado = rs.getInt(3);
                listaCnt_carga.add(new ObCntcarga(id_cntcarga, cantidad, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Cnt_carga" + e);
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
        return listaCnt_carga;
    }

    @Override
    public void registrar(ObCntcarga obj) {
        String consulta = "INSERT INTO cntcarga(cantidad, estado ) "
                + "VALUES ('" + obj.getCantidad() + "','" + obj.getEstado() + "' )";
        grabarTabla(consulta);
    }

    @Override
    public void actualizar(ObCntcarga obj) {
        String consulta = "UPDATE cntcarga SET cantidad='" + obj.getCantidad() + "' "
                + " WHERE id_cntcarga='" + obj.getIdcant_carga() + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void eliminar(int id) {
        String consulta = "UPDATE cntcarga SET estado='0' "
                + "WHERE id_cntcarga='" + id + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObCntcarga buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        ConexionBD conectar = new ConexionBD();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from cntcarga where id_cntcarga='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_cntcarga = rs.getInt(1);
                int cantidad = rs.getInt(2);
                int estado = rs.getInt(3);
                cntcarga = new ObCntcarga(id_cntcarga, cantidad, estado);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en buscar_por_id " + e);
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
        return cntcarga;
    }

    public ObCntcarga getCnt_carga() {
        return cntcarga;
    }

    public void setCnt_carga(ObCntcarga cntcarga) {
        this.cntcarga = cntcarga;
    }

}
