
package Vista;

import Conexion.ConexionBD;


public class Principal {

    public static void main(String[] args) {
       frmLogin.main(args);
                try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
//       ConexionBD cn = new ConexionBD();
//       ConexionBD.conectar();
    }
    
}
