package Vista;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmCampana extends javax.swing.JInternalFrame {

    public frmCampana() throws Exception {
        initComponents();
        //---------------------ANCHO Y ALTO DEL FORM----------------------
        this.setSize(528, 548);

        CrearTablaVencer();
        CrearTablaTerminar();
//        CrearTablaTerminar();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tbPanel = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTerminar = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblVencer = new javax.swing.JTable();

        setBackground(new java.awt.Color(251, 248, 248));
        setClosable(true);
        setIconifiable(true);
        setTitle("Alerta Almacen");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("PRODUCTOS A CAMBIAR:");

        tbPanel.setBackground(new java.awt.Color(255, 255, 255));
        tbPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbPanel.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        tbPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPanelMouseClicked(evt);
            }
        });

        jScrollPane6.setBackground(new java.awt.Color(102, 255, 255));

        tblVencer = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblTerminar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "DESCRIPCIÓN", "STOCK", "VENCIMIENTO"
            }
        ));
        tblTerminar.setRowHeight(22);
        jScrollPane6.setViewportView(tblTerminar);

        tbPanel.addTab("PRÓXIMOS A TERMINARSE", jScrollPane6);

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        tblVencer = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblVencer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "DESCRIPCIÓN", "STOCK", "VENCIMIENTO"
            }
        ));
        tblVencer.setRowHeight(22);
        jScrollPane7.setViewportView(tblVencer);

        tbPanel.addTab("PRÓXIMOS A VENCERCE", jScrollPane7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPanelMouseClicked

    }//GEN-LAST:event_tbPanelMouseClicked

//-----------------------------------------------------------------------------------------------
//--------------------------------------METODOS--------------------------------------------------
//-----------------------------------------------------------------------------------------------
    public void CrearTablaVencer() throws Exception {
        //--------------------PRESENTACION DE JTABLE----------------------
        String consulta1;
        DefaultTableModel tabla = new DefaultTableModel();
        String[] titulos = {"CÓDIGO", "DESCRIPCIÓN", "STOCK", "FECHA VENCIMIENTO"};
        tabla.setColumnIdentifiers(titulos);

         consulta1 = "SELECT * FROM producto WHERE fechavencimiento >= CURDATE() AND fechavencimiento <= DATE_ADD(CURDATE(), INTERVAL 6 MONTH)";

        String[] Datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta1);
            while (rs.next()) {
                Datos[0] = rs.getString("idProducto");
                Datos[1] = rs.getString("Descripcion");
                Datos[2] = rs.getString("stock");
                Datos[3] = rs.getString("fechavencimiento");
                tabla.addRow(Datos);
            }

            tblVencer.setModel(tabla);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void CrearTablaTerminar() throws Exception {
        //--------------------PRESENTACION DE JTABLE----------------------
        String consulta;
        DefaultTableModel tabla2 = new DefaultTableModel();
        String[] titulos = {"CÓDIGO", "DESCRIPCIÓN", "STOCK", "FECHA VENCIMIENTO"};
        tabla2.setColumnIdentifiers(titulos);

        consulta = "SELECT * FROM producto WHERE stock<=10";

        String[] Datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                Datos[0] = rs.getString("idProducto");
                Datos[1] = rs.getString("Descripcion");
                Datos[2] = rs.getString("stock");
                Datos[3] = rs.getString("fechavencimiento");
                tabla2.addRow(Datos);
            }

            tblTerminar.setModel(tabla2);

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane tbPanel;
    public static javax.swing.JTable tblTerminar;
    public static javax.swing.JTable tblVencer;
    // End of variables declaration//GEN-END:variables
ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
}
