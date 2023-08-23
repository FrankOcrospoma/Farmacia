
package Vista;

//import Conexion.ConexionBD;


public class Principal {

    public static void main(String[] args) {

       
       
       //ConexionBD cn = new ConexionBD();
       //ConexionBD.conectar();
       
       
               java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splashscreen.SplashScreen(null, true).setVisible(true);
                  Login.main(args);
            }
        });
    }
    
}
