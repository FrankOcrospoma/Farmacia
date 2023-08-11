
package Vista;

import Conexion.ConexionBD;
import Metodos.Metodos_Productos;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BuscarProductosCompras extends javax.swing.JInternalFrame {
    
    private final Metodos_Productos CP = new Metodos_Productos();
    DefaultTableModel tabla;

    static ResultSet rs=null;
    DefaultTableModel dtm=new DefaultTableModel();

    String criterio,busqueda,Total;
    /** Creates new form Productos */
    public BuscarProductosCompras() {
        initComponents();
        listar();
        rbtDescripcion.setVisible(false);
        
    }
    private void listar() {
        tbProductos.setModel(CP.CargarDatosBusquedaCompra());
    }
     

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnenviarpro = new javax.swing.JMenuItem();
        rbtDescripcion = new javax.swing.JRadioButton();
        btnRegresar = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new jtextfieldround.JTextFieldRound();
        btnmostrar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProductos = new rojerusan.RSTableMetro();
        btnAgregar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        mnenviarpro.setText("Enviar a Factura");
        mnenviarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnenviarproActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnenviarpro);

        setBackground(new java.awt.Color(251, 248, 248));
        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(607, 373));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbtDescripcion.setSelected(true);
        rbtDescripcion.setText("Buscar por Desc.");
        rbtDescripcion.setBorder(null);
        rbtDescripcion.setContentAreaFilled(false);
        rbtDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(rbtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 337, 0, -1));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/v1.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setFocusPainted(false);
        btnRegresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegresar.setIconTextGap(0);
        btnRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/v2.png"))); // NOI18N
        btnRegresar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, -1, 44));

        btnCancelar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ca1.png"))); // NOI18N
        btnCancelar1.setText("Cancelar");
        btnCancelar1.setContentAreaFilled(false);
        btnCancelar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar1.setFocusPainted(false);
        btnCancelar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar1.setIconTextGap(0);
        btnCancelar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ca3.png"))); // NOI18N
        btnCancelar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 75));

        jPanel1.setBackground(new java.awt.Color(251, 248, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar Producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11), new java.awt.Color(0, 51, 102))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Buscar por Descripción:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 35, -1, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 27, 240, -1));

        btnmostrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/to1.png"))); // NOI18N
        btnmostrar.setText("Todo");
        btnmostrar.setContentAreaFilled(false);
        btnmostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmostrar.setFocusPainted(false);
        btnmostrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/to3.png"))); // NOI18N
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, 42));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 490, 70));

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {"cscdc", "cdcdc", null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Presentacion", "Concentracion", "Title 3", "Title 4"
            }
        ));
        tbProductos.setAltoHead(25);
        tbProductos.setColorBackgoundHead(new java.awt.Color(0, 51, 102));
        tbProductos.setColorFilasBackgound2(new java.awt.Color(240, 240, 240));
        tbProductos.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        tbProductos.setColorFilasForeground2(new java.awt.Color(51, 51, 51));
        tbProductos.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbProductos.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbProductos.setGrosorBordeFilas(0);
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbProductos);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 570, 190));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/m1.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setIconTextGap(0);
        btnAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/m2.png"))); // NOI18N
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
    listar();
    txtBuscar.setText("");
}//GEN-LAST:event_btnmostrarActionPerformed

private void mnenviarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnenviarproActionPerformed

}//GEN-LAST:event_mnenviarproActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        frmCompras.txtCodigoProducto.setText("");
        frmCompras.txtNombreProducto.setText("");
        frmCompras.txtPresentacionProducto.setText("");
        frmCompras.txtConcentracionProducto.setText("");
        frmCompras.txtCantidad.setText("");
        frmCompras.txtPrecioProducto.setText("");
        frmCompras.txtPrecioProducto.requestFocus();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        BuscarProductos();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
       int row = tbProductos.getSelectedRow();
        frmCompras.txtCodigoProducto.setText(tbProductos.getValueAt(row, 0).toString());
        frmCompras.txtPresentacionProducto.setText(tbProductos.getValueAt(row, 1).toString());
        frmCompras.txtNombreProducto.setText(tbProductos.getValueAt(row, 2).toString());
        frmCompras.txtConcentracionProducto.setText(tbProductos.getValueAt(row, 3).toString());
        frmCompras.txtCantidad.setText(tbProductos.getValueAt(row, 4).toString());
        frmCompras.txtPrecioProducto.setText(tbProductos.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tbProductosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        frmProductos nuevo = new frmProductos();
        CentrarVentana(nuevo);
    }//GEN-LAST:event_btnAgregarActionPerformed

    public void CentrarVentana(JInternalFrame internalFrame) {
        int x = (frmPrincipal.tbn_escritorio.getWidth() / 2) - internalFrame.getWidth() / 2;
        int y = (frmPrincipal.tbn_escritorio.getHeight() / 2) - internalFrame.getHeight() / 2;
        if (internalFrame.isShowing()) {
            internalFrame.setLocation(x, y);
        } else {
            frmPrincipal.tbn_escritorio.add(internalFrame);
            internalFrame.setLocation(x, y);
            internalFrame.show();
        }
    }
    void BuscarProductos(){
        String titulos[]={"ID","Presentación","Descripción","Concentración","Stock","Costo"};
        dtm.setColumnIdentifiers(titulos);
        
        Metodos_Productos categoria=new Metodos_Productos();
        busqueda=txtBuscar.getText();
        if(rbtDescripcion.isSelected()){
            criterio="Buscar";
        }
        try{
            rs=categoria.listarProductos(criterio,busqueda);
            boolean encuentra=false;
            String Datos[]=new String[6];
            int f,i;
            f=dtm.getRowCount();
            if(f>0){
                for(i=0;i<f;i++){
                    dtm.removeRow(0);
                }
            }
            while(rs.next()){
                Datos[0]=(String) rs.getString(1);
                Datos[1]=(String) rs.getString(2);
                Datos[2]=(String) rs.getString(3);
                Datos[3]=(String) rs.getString(4);
                Datos[4]=(String) rs.getString(5);
                Datos[5]=(String) rs.getString(6);

                dtm.addRow(Datos);
                encuentra=true;

            }
            if(encuentra=false){
                JOptionPane.showMessageDialog(null, "¡No se encuentra!");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        tbProductos.setModel(dtm);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnmostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mnenviarpro;
    private javax.swing.JRadioButton rbtDescripcion;
    private rojerusan.RSTableMetro tbProductos;
    private jtextfieldround.JTextFieldRound txtBuscar;
    // End of variables declaration//GEN-END:variables
ConexionBD cc= new ConexionBD();
Connection cn = cc.conectar();
//Factura fac= new Factura();

}
