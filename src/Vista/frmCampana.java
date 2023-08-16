package Vista;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class frmCampana extends javax.swing.JInternalFrame {

    public frmCampana() throws Exception {
        initComponents();
        //---------------------ANCHO Y ALTO DEL FORM----------------------
        this.setSize(566, 548);
        CrearTabla(); 

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        tblCampana = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 248, 248));
        setClosable(true);
        setIconifiable(true);
        setTitle("Alerta Almacen");

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        tblCampana = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblCampana.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCampana.setRowHeight(22);
        jScrollPane5.setViewportView(tblCampana);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("PRÓXIMOS A VENCER:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//-----------------------------------------------------------------------------------------------
//--------------------------------------METODOS--------------------------------------------------
//-----------------------------------------------------------------------------------------------
    public void CrearTabla() throws Exception {
        //--------------------PRESENTACION DE JTABLE----------------------

            DefaultTableModel tabla = new DefaultTableModel();
            String[] titulos = {"CODIGO", "DESCRIPCIÓN", "STOCK", "FECHA VENCIMIENTO"};
            tabla.setColumnIdentifiers(titulos);
            this.tblCampana.setModel(tabla);
            String consulta = "SELECT * FROM producto WHERE fechavencimiento >= CURDATE() AND fechavencimiento <= DATE_ADD(CURDATE(), INTERVAL 6 MONTH)";
            String[] Datos = new String[7];
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(consulta);
                while (rs.next()) {
                    Datos[0] = rs.getString("idProducto");
                    Datos[1] = rs.getString("Descripcion");
                    Datos[2] = rs.getString("stock");
                    Datos[3] = rs.getString("fechavencimiento");
                    tabla.addRow(Datos);
                }
                tblCampana.setModel(tabla);
            }catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblCampana;
    // End of variables declaration//GEN-END:variables
ConexionBD cc= new ConexionBD();
Connection cn = cc.conectar();
}
