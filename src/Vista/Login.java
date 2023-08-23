package Vista;
//Diseño y Animación
import Conexion.ConexionBD;
import Metodos.Metodos_User;
import java.awt.Color;
import org.jdesktop.animation.timing.*;
//Conexión a la BD
import Metodos.Metodos_sql;
import static Vista.Login.*;
import com.formdev.flatlaf.FlatDarkLaf;
//import com.sun.awt.AWTUtilities;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Login extends javax.swing.JFrame {

    private Animator animatorLogin;
    private Animator animatorBody;
    private boolean signIn;
    DefaultTableModel model;
    private final Metodos_User CP = new Metodos_User();

    public Login() {
        //Da aspecto a botones, tablas y submenus segun la version de Windows instalada en el equipo
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //
      
        initComponents();
        getContentPane().setBackground(new Color(245, 245, 245));
        TimingTarget targetLogin = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    background1.setAnimate(fraction);
                } else {
                    background1.setAnimate(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn) {
                    panelLogin.setVisible(false);
                    background1.setShowPaint(true);
                    panelBody.setAlpha(0);
                    panelBody.setVisible(true);
                    animatorBody.start();
                } else {
                    enableLogin(true);
                    txtUsuario.grabFocus();
                }
            }
        };
        TimingTarget targetBody = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    panelBody.setAlpha(fraction);
                } else {
                    panelBody.setAlpha(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn == false) {
                    panelBody.setVisible(false);
                    background1.setShowPaint(false);
                    background1.setAnimate(1);
                    panelLogin.setVisible(true);
                    animatorLogin.start();
                }
            }
        };

        animatorLogin = new Animator(1500, targetLogin);
        animatorBody = new Animator(500, targetBody);
        animatorLogin.setResolution(0);
        animatorBody.setResolution(0);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setViewportBorder(null);

    }

    private void listar() {
        tbUsuario.setModel(CP.getDatos());
    }
    Metodos_sql metodos = new Metodos_sql();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.raven.swing.Background();
        panelLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnIngresar = new com.raven.swing.Button();
        txtUsuario = new com.raven.swing.TextField();
        txtContraseña = new com.raven.swing.PasswordField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        panelBody = new com.raven.swing.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        header1 = new com.raven.component.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        background1.setLayout(new java.awt.CardLayout());

        panelLogin.setOpaque(false);

        jPanel1.setOpaque(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maternatal-fondo_Login.png"))); // NOI18N

        btnIngresar.setBackground(new java.awt.Color(157, 153, 255));
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setEffectColor(new java.awt.Color(199, 196, 255));
        btnIngresar.setFont(new java.awt.Font("Comfortaa SemiBold", 0, 16)); // NOI18N
        btnIngresar.setLabel("Iniciar Sesión");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        txtUsuario.setBackground(new java.awt.Color(245, 245, 245));
        txtUsuario.setFont(new java.awt.Font("Comfortaa", 0, 14)); // NOI18N
        txtUsuario.setLabelText("Usuario");
        txtUsuario.setLineColor(new java.awt.Color(131, 126, 253));
        txtUsuario.setSelectionColor(new java.awt.Color(157, 153, 255));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        txtContraseña.setBackground(new java.awt.Color(245, 245, 245));
        txtContraseña.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        txtContraseña.setLabelText("Contraseña");
        txtContraseña.setLineColor(new java.awt.Color(131, 126, 253));
        txtContraseña.setSelectionColor(new java.awt.Color(157, 153, 255));
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/profile.jpg"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jLabel2))))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        background1.add(panelLogin, "card2");

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuario);

        jButton1.setLabel("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        background1.add(panelBody, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (txtUsuario.getText().isEmpty() || txtContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
        } else {

            String busqueda_usuario = metodos.buscarUsuarioRegistrado(txtUsuario.getText(), txtContraseña.getText());
            String buscarUsuario = metodos.UsuarioInvitado(txtUsuario.getText(), txtContraseña.getText());

            if (busqueda_usuario.equals("USUARIO ENCONTRADO")) {
                String busqueda_nombre = metodos.buscarNombre(txtUsuario.getText());
                JOptionPane.showMessageDialog(this, "Bienvenido(a): \n" + busqueda_nombre + "\nRol: Administrador", "Ingreso Exitoso",
                        JOptionPane.PLAIN_MESSAGE, icono("/Iconos/usss1.png", 60, 60));
                frmPrincipal ventana = new frmPrincipal();

                String busquedaUsuario = metodos.buscarUsuario(txtUsuario.getText());
                ventana.lblNombreUsuario.setText(busquedaUsuario);

                String busqueda_Rol = metodos.buscarTipoUsuario(txtUsuario.getText());
                ventana.lblRol.setText(busqueda_Rol);

                String busqueda_Id = metodos.buscarId(txtUsuario.getText());
                ventana.lblId.setText(busqueda_Id);
                ventana.setVisible(true);
                //frmPrincipal.mnuInvitado.setVisible(false);
                this.dispose();
                //AdministrarPerfil.jpInvitado.setVisible(false);
            } else if (buscarUsuario.equals("USUARIO ENCONTRADO")) {
                String busqueda_nombre = metodos.buscarNombre(txtUsuario.getText());
                JOptionPane.showMessageDialog(this, "Bienvenido(a): \n" + busqueda_nombre + "\nRol: Vendedor", "Ingreso Exitoso",
                        JOptionPane.PLAIN_MESSAGE, icono("/Iconos/Vend1.png", 60, 60));
                frmPrincipal ventana = new frmPrincipal();

                String busquedaUsuario = metodos.buscarUsuario(txtUsuario.getText());
                ventana.lblNombreUsuario.setText(busquedaUsuario);

                String busqueda_Rol = metodos.buscarTipoUsuario(txtUsuario.getText());
                ventana.lblRol.setText(busqueda_Rol);

                String busqueda_Id = metodos.buscarId(txtUsuario.getText());
                ventana.lblId.setText(busqueda_Id);

                ventana.setVisible(true);
//                frmProductos.btnReporte.setVisible(false);
//                frmClientes.btnImprimir.setVisible(false);

                frmPrincipal.MnuAdministrador.setVisible(false);
                frmPrincipal.mniEmpleado.setVisible(false);
                frmPrincipal.mniReportes.setVisible(false);
                frmPrincipal.jmuEmpleados.setVisible(false);
                frmPrincipal.mnuComprobante.setVisible(false);
                frmPrincipal.mnuCompra.setVisible(false);

                this.dispose();
                //AdministrarPerfil.jpAdmin.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "USUARIO NO REGISTRADO");
                txtUsuario.requestFocus();
            }
        }
        if (!animatorLogin.isRunning()) {
            signIn = true;
            String user = txtUsuario.getText().trim();
            String pass = String.valueOf(txtContraseña.getPassword());
            boolean action = true;
            if (user.equals("")) {
                txtUsuario.setHelperText("Por favor ingrese el Nombre de usuario");
                txtUsuario.grabFocus();
                action = false;
            }
            if (pass.equals("")) {
                txtContraseña.setHelperText("Por favor ingrese la contraseña");
                if (action) {
                    txtContraseña.grabFocus();
                }
                action = false;
            }
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        signIn = false;
        animatorBody.start();
        clearLogin();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        // TODO add your handling code here:
        //Pasar al siguiente campo al pulsar Enter
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtContraseña.requestFocus();

        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            btnIngresar.requestFocus();

        }
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //Animación

        if (!animatorLogin.isRunning()) {
            signIn = true;
            boolean action = true;
            if (action = true) {
                animatorLogin.start();
                listar();
                enableLogin(false);
            }

        }
        //Fin de la Animación

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseClicked
        // TODO add your handling code here:
        int row = tbUsuario.getSelectedRow();
//        Id=(tbUsuario.getValueAt(row, 0).toString());
        txtUsuario.setText(tbUsuario.getValueAt(row, 5).toString());
        txtContraseña.setText(tbUsuario.getValueAt(row, 6).toString());
        String est = tbUsuario.getValueAt(row, 8).toString();
        signIn = false;
        animatorBody.start();
    }//GEN-LAST:event_tbUsuarioMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtUsuario.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void enableLogin(boolean action) {
        txtUsuario.setEditable(action);
        txtContraseña.setEditable(action);
        btnIngresar.setEnabled(action);
    }

    public void clearLogin() {
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtUsuario.setHelperText("");
        txtContraseña.setHelperText("");
    }

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    public static void main(String args[]) {
        //FlatDarkLaf.setup();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    void cargar(String valor) {
        String mostrar = "SELECT * FROM usuario WHERE CONCAT(Nombres, Apellidos, Dni,Usuario, Contraseña, TipoUsuario, Estado) LIKE '%" + valor + "%'";
        String[] titulos = {"ID", "Nombres", "Apellidos", "Dni", "Email", "Usuario", "Contraseña", "Tipo Usuario", "Estado"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("idUsuario");
                Registros[1] = rs.getString("Nombres");
                Registros[2] = rs.getString("Apellidos");
                Registros[3] = rs.getString("Dni");
                Registros[4] = rs.getString("Email");
                Registros[5] = rs.getString("Usuario");
                Registros[6] = rs.getString("Contraseña");
                Registros[7] = rs.getString("TipoUsuario");
                Registros[8] = rs.getString("Estado");
                model.addRow(Registros);
            }
            tbUsuario.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(frmClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    //-------------------------------------------------------------------------------------------------------------------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Background background1;
    private com.raven.swing.Button btnIngresar;
    private com.raven.component.Header header1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelTransparent panelBody;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTable tbUsuario;
    private com.raven.swing.PasswordField txtContraseña;
    public static com.raven.swing.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
