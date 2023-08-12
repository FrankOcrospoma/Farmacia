package Vista;

import Conexion.ConexionBD;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;


public class BuscarEmpleados extends javax.swing.JInternalFrame {

    int nums = 0;

    DefaultTableModel modelo;

    /**
     * Creates new form ClientesB
     */
    public BuscarEmpleados() {
        initComponents();
        mostrarclientes("");
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnenviar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbEmpleados = new rojerusan.RSTableMetro();
        txtBuscar = new jtextfieldround.JTextFieldRound();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        mnenviar.setText("Enviar Datos");
        mnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnenviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnenviar);

        setClosable(true);
        setIconifiable(true);
        setTitle("Empleados");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Buscar Empleado:");

        btnbus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new7.png"))); // NOI18N
        btnbus.setText("Mostrar Todo");
        btnbus.setContentAreaFilled(false);
        btnbus.setFocusPainted(false);
        btnbus.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new8.png"))); // NOI18N
        btnbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusActionPerformed(evt);
            }
        });

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tbEmpleados.setAltoHead(20);
        tbEmpleados.setColorBackgoundHead(new java.awt.Color(0, 102, 51));
        tbEmpleados.setColorFilasBackgound2(new java.awt.Color(240, 240, 240));
        tbEmpleados.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        tbEmpleados.setColorFilasForeground2(new java.awt.Color(51, 51, 51));
        tbEmpleados.setFuenteFilas(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tbEmpleados.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbEmpleados.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tbEmpleados.setGrosorBordeFilas(0);
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbEmpleados);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 51, 0));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new6.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIconTextGap(0);
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new5.png"))); // NOI18N
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnbus)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 580, 233));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 51, 0));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new1.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setIconTextGap(0);
        btnAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new2.png"))); // NOI18N
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 51, 0));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new3.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setFocusPainted(false);
        btnRegresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegresar.setIconTextGap(0);
        btnRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new4.png"))); // NOI18N
        btnRegresar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusActionPerformed
// TODO add your handling code here:
    mostrarclientes("");
}//GEN-LAST:event_btnbusActionPerformed

private void mnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnenviarActionPerformed

}//GEN-LAST:event_mnenviarActionPerformed

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        int row = tbEmpleados.getSelectedRow();
        frmUsuarios.txtDni.setText(tbEmpleados.getValueAt(row, 3).toString());;
        frmUsuarios.txtApellidos.setText(tbEmpleados.getValueAt(row, 2).toString());
        frmUsuarios.txtNombres.setText(tbEmpleados.getValueAt(row, 1).toString());
        frmUsuarios.txtEmail.setText(tbEmpleados.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        mostrarclientes(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        frmEmpleados emp = new frmEmpleados();
        CentrarVentana(emp);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Ventas.txtNombre.setText("");
        Ventas.txtRuc.setText("");
        Ventas.txtDni.setText("");
        Ventas.txtIdCliente.setText("");
        Ventas.txtDireccion.setText("");
        Ventas.txtNombre.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed
    public void CentrarVentana(JInternalFrame internalFrame) {
        int x = (frmPrincipal.contenedor.getWidth() / 2) - internalFrame.getWidth() / 2;
        int y = (frmPrincipal.contenedor.getHeight() / 2) - internalFrame.getHeight() / 2;
        if (internalFrame.isShowing()) {
            internalFrame.setLocation(x, y);
        } else {
            frmPrincipal.contenedor.add(internalFrame);
            internalFrame.setLocation(x, y);
            internalFrame.show();
        }
    }    
    void mostrarclientes(String buscar) {
        String[] titulos = {"Id", "Nombres", "Apellidos", "DNI", "Email"};
        String[] Registros = new String[6];
        modelo = new DefaultTableModel(null, titulos);
        String Sql = "SELECT * FROM empleado WHERE CONCAT(Nombres, Apellidos,Dni) LIKE '%" + buscar + "%'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            while (rs.next()) {
                Registros[0] = rs.getString("idEmpleado");
                Registros[1] = rs.getString("Nombres");
                Registros[2] = rs.getString("Apellidos");
                Registros[3] = rs.getString("Dni");
                Registros[4] = rs.getString("Email");
                modelo.addRow(Registros);
            }
            tbEmpleados.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnbus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnenviar;
    private rojerusan.RSTableMetro tbEmpleados;
    private jtextfieldround.JTextFieldRound txtBuscar;
    // End of variables declaration//GEN-END:variables
ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
}
