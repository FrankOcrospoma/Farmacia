package Vista;

import java.sql.Connection;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public final class JRReporte {

    public void abrirReporte(String ruta_archivo, Connection con) {
        String dir = ruta_archivo;
        try {
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, null, con);
            JasperViewer.viewReport(mostrarReporte,false);
            
        } catch (Exception jRException) {
            System.err.println(jRException.getMessage());
            JOptionPane.showMessageDialog(null, "Error al intentar abrir el reporte");
        }
    }

    public void abrirReporte(String ruta_archivo, Connection con, Map parametros) {
        String dir = ruta_archivo;
        
        try {
            JasperReport informe = JasperCompileManager.compileReport(dir);
            JasperPrint print = JasperFillManager.fillReport(informe, parametros, con);
            //JasperViewer.MAXIMIZED_BOTH;
            JasperViewer.viewReport(print, false);
            
        } catch (Exception jRException) {
            System.err.println(jRException.getMessage());
            JOptionPane.showMessageDialog(null, jRException.getMessage());
        }
    }
    
    
    
//    public void abrirReporte(String ruta_archivo, Connection con, Map parametros) {
//    String dir = ruta_archivo;
//
//    try {
//        JasperReport informe = JasperCompileManager.compileReport(dir);
//        JasperPrint print = JasperFillManager.fillReport(informe, parametros, con);
//        
//        // Crear el visor de JasperReports y configurar el tamaño del informe para ajustar al visor
//        JasperViewer viewer = new JasperViewer(print, false);
//        viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar el visor
//        
//        viewer.setVisible(true);
//    } catch (Exception jRException) {
//        System.err.println(jRException.getMessage());
//        JOptionPane.showMessageDialog(null, jRException.getMessage());
//    }
//}

}
