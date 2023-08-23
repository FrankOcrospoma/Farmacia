package Vista;

public class Principal {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new splashscreen.SplashScreen(null, true).setVisible(true);
                Login.main(args);
            }
        });
    }

}
