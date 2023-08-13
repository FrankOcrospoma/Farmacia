
package Vista;

import Conexion.ConexionBD;
import Metodos.Metodos_Presentacion;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.*;

public class frmPresentacion extends javax.swing.JInternalFrame {

    private final Metodos_Presentacion CP = new Metodos_Presentacion();
    int num = 0;

    DefaultTableModel model;

    public frmPresentacion() {
        initComponents();
        btnCancelar.setVisible(false);
        btnGReporte.setVisible(false);
        txtEstado.setVisible(false);
        
        jrdEstado.setVisible(false);
        jrdDes.setVisible(false);
        listar();
    }
    Metodos_Presentacion metodos = new Metodos_Presentacion();

    private void listar() {
        jtbPresentacion.setModel(CP.getDatos());
    }

    private void limpiar() {
        txtId.setText("");
        txtDescripcion.setText("");
        txtEstado.setText("");
        jchEstado.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jrdDes = new javax.swing.JRadioButton();
        txtId = new jtextfieldround.JTextFieldRound();
        txtDescripcion = new jtextfieldround.JTextFieldRound();
        txtEstado = new jtextfieldround.JTextFieldRound();
        lblDescripcion = new javax.swing.JLabel();
        jchEstado = new javax.swing.JCheckBox();
        jrdEstado = new javax.swing.JRadioButton();
        lblEstado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbPresentacion = new javax.swing.JTable();
        btnGReporte = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(682, 492));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setForeground(new java.awt.Color(0, 0, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registro de Presentación de Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 19, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 20, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(251, 248, 248));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la presentación:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11), new java.awt.Color(0, 102, 0))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 102, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Id:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jrdDes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrdDes.setText("Descripción:");
        jrdDes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jrdDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdDesActionPerformed(evt);
            }
        });
        jPanel3.add(jrdDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtId.setEditable(false);
        jPanel3.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 87, 25));
        jPanel3.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 200, 25));
        jPanel3.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 125, 25));

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion.setText("Descripción:");
        jPanel3.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jchEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jchEstado.setForeground(new java.awt.Color(0, 102, 51));
        jchEstado.setText("Activo");
        jchEstado.setContentAreaFilled(false);
        jchEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jchEstado.setFocusPainted(false);
        jPanel3.add(jchEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, 20));

        jrdEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrdEstado.setText("Estado:");
        jrdEstado.setContentAreaFilled(false);
        jrdEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jrdEstado.setFocusPainted(false);
        jrdEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdEstadoActionPerformed(evt);
            }
        });
        jPanel3.add(jrdEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEstado.setText("Estado:");
        jPanel3.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jtbPresentacion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtbPresentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbPresentacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbPresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbPresentacionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbPresentacion);

        btnGReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (87).png"))); // NOI18N
        btnGReporte.setContentAreaFilled(false);
        btnGReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGReporte.setFocusPainted(false);
        btnGReporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (94).png"))); // NOI18N
        btnGReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGReporteActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (89).png"))); // NOI18N
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (91).png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (97).png"))); // NOI18N
        btnVolver.setContentAreaFilled(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVolver.setFocusPainted(false);
        btnVolver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (95).png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(251, 248, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (84).png"))); // NOI18N
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (90)_1.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (86).png"))); // NOI18N
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (92).png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (88).png"))); // NOI18N
        btnReporte.setContentAreaFilled(false);
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReporte.setFocusPainted(false);
        btnReporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (96).png"))); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (85).png"))); // NOI18N
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (93).png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnReporte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVolver)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGReporte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addGap(122, 122, 122))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbPresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPresentacionMouseClicked
        int row = jtbPresentacion.getSelectedRow();
        txtId.setText(jtbPresentacion.getValueAt(row, 0).toString());
        txtDescripcion.setText(jtbPresentacion.getValueAt(row, 1).toString());
        txtEstado.setText(jtbPresentacion.getValueAt(row, 2).toString());
        String est = jtbPresentacion.getValueAt(row, 2).toString();
        if (est.equals("Activo")) {
            jchEstado.setSelected(true);
        } else {
            jchEstado.setSelected(false);
        }
        num = 1;
    }//GEN-LAST:event_jtbPresentacionMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        //--------------------------------------------------
        if (txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
            //--------------------------------------------------
        } else {

            String ID = txtId.getText();
            String Descripcion = txtDescripcion.getText();
            String Estado;
            if (jchEstado.isSelected()) {
                Estado = "Activo";
            } else {
                Estado = "Inactivo";
            }
            if (num == 0) {
                int respuesta = metodos.guardarPresentacion(Descripcion, Estado);
                if (respuesta > 0) {
                    listar();

                    limpiar();
                }
            } else {
                int respuesta = metodos.ActualizarDatos(ID, Descripcion, Estado);
                if (respuesta > 0) {
                    listar();
                    num = 0;
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jtbPresentacion.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        
        }else if(fila==1){
        int result = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            if (CP.EliminarDatos(jtbPresentacion.getValueAt(jtbPresentacion.getSelectedRow(), 0).toString()) > 0) {
                limpiar();
                listar();
            }
        }
        if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Registro no Eliminado!");
        }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed

        jrdDes.requestFocus();
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setVisible(true);
        btnReporte.setEnabled(false);
        btnGReporte.setVisible(true);
        jchEstado.setVisible(false);
        jrdDes.setVisible(true);
        lblEstado.setVisible(false);
        txtEstado.setVisible(true);
        jrdEstado.setVisible(true);
        txtEstado.setEditable(false);
        lblDescripcion.setVisible(false);
        txtDescripcion.setEditable(false);
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnGReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGReporteActionPerformed
        JRReporte cr = new JRReporte();
        Connection con = null;
        if(jrdDes.isSelected()==false && jrdEstado.isSelected()==false)
        {
            try {
                con = ConexionBD.conectar();
                String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Presentacion.jrxml";
                cr.abrirReporte(ruta, con);
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Empleados", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
        if(jrdDes.isSelected()==true)
        {
            if (txtDescripcion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "por favor complete el campo vacío");
                txtDescripcion.requestFocus();
                //--------------------------------------------------
            } else {
                try {
                    con = ConexionBD.conectar();
                    Map parametros = new HashMap();
                    parametros.put("Descripcion", txtDescripcion.getText());
                    String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\PresDes.jrxml";
                    cr.abrirReporte(ruta, con, parametros);
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Empleados", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        if(jrdEstado.isSelected()==true)
        {
            if (txtEstado.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "por favor complete el campo vacío");
                txtEstado.requestFocus();
                //--------------------------------------------------
            } else {
                try {
                    con = ConexionBD.conectar();
                    Map parametros = new HashMap();
                    parametros.put("Estado", txtEstado.getText());
                    String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\PresEstado.jrxml";
                    cr.abrirReporte(ruta, con, parametros);
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Empleados", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }//GEN-LAST:event_btnGReporteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelar.setVisible(false);
        btnReporte.setEnabled(true);
        jrdDes.setVisible(false);
        btnGReporte.setVisible(false);
        jchEstado.setVisible(true);
        jrdDes.setSelected(false);
        jrdEstado.setVisible(false);
        jrdEstado.setSelected(false);
        lblEstado.setVisible(true);
        lblDescripcion.setVisible(true);
        txtDescripcion.setEditable(true);
        txtEstado.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jrdEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdEstadoActionPerformed
        jrdDes.setSelected(false);
        txtDescripcion.setEditable(false);
        txtDescripcion.setText("");
        txtId.setText("");
        txtEstado.setText("");
        txtEstado.setEditable(true);
        txtEstado.requestFocus();
    }//GEN-LAST:event_jrdEstadoActionPerformed

    private void jrdDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdDesActionPerformed
        jrdEstado.setSelected(false);
        txtDescripcion.setEditable(true);
        txtDescripcion.requestFocus();
        txtEstado.setEditable(false);
        txtEstado.setText("");
        txtId.setText("");
        txtDescripcion.setText("");
    }//GEN-LAST:event_jrdDesActionPerformed
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGReporte;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btnReporte;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jchEstado;
    private javax.swing.JRadioButton jrdDes;
    private javax.swing.JRadioButton jrdEstado;
    private javax.swing.JTable jtbPresentacion;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private jtextfieldround.JTextFieldRound txtDescripcion;
    private jtextfieldround.JTextFieldRound txtEstado;
    private jtextfieldround.JTextFieldRound txtId;
    // End of variables declaration//GEN-END:variables
ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
}
