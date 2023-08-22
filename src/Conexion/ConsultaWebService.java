/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Alertas.AlertaError;
import java.io.IOException;
import javax.swing.JTextField;
import okhttp3.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author jc_26
 */
public class ConsultaWebService {
    //Declara el tipo de medio de solicitud HTTP, Formato:JSON, codificacion: UTF8

    MediaType mediaType = MediaType.get("application/json; charset=utf-8");
    //////////////////////////////////////////////////////////////////
    OkHttpClient client = new OkHttpClient();

    public String consultarReniecDni(
            String nrodni,
            JTextField txtNombreCliente,
            JTextField txtNombres,
            JTextField txtApellidoPat,
            JTextField txtApellidoMat,
            JTextField txtfechaNac,
            JTextField txtSexo) throws Exception {
        //Dato para determinar si la consulta fue exitosa
        String valor = "";

        try {
            //Se declara la respuesta y se ejecuta el metodo post con parametro de entrada la API de consulta + el nDni
            String response = post("https://apiperu.dev/api/dni/" + nrodni);
            ///
            if (response == null) {
                valor = "NO";
            } else {
                //Se declara un metodo JSONParser para deserializar los datos obtenido en la consulta
                JSONParser parser = new JSONParser();

                Object obj = parser.parse(response);
                try {
                    //Se intenta convertir el objeto analizado en un JSONObject y se extrae el objeto "data" de ese JSON
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONObject data = (JSONObject) jsonObject.get("data");
                    //
                    //Se hace una busqueda del nombre completo en la data extraida
                    String nombre_completo = (String) data.get("nombre_completo");
                    String nombres = (String) data.get("nombres");
                    String ape_pat = (String) data.get("apellido_paterno");
                    String ape_mat = (String) data.get("apellido_materno");
                    String ubig_sunat = (String) data.get("ubigeo_sunat");
                    String fechaNac = (String) data.get("fecha_nacimiento");
                    String sexo = (String) data.get("sexo");
                    txtNombreCliente.setText(nombre_completo.replace(",", ""));
                    txtNombres.setText(nombres);
                    txtApellidoPat.setText(ape_pat);
                    txtApellidoMat.setText(ape_mat);
                    txtfechaNac.setText(fechaNac);
                    txtSexo.setText(sexo);
                    //Operación de consulta Exitosa
                    valor = "SI";

                } catch (Exception e) {
                    //Operación de consulta Fallida
                    valor = "NO";
                }
            }
        } catch (Exception e) {
            valor = "NO";
        }

        return valor;
    }

    public String consultarSunatruc(String nroruc, JTextField txtNombreR, JTextField txtdireccion) throws Exception {
        String valor = "";
        try {
            String response = post("https://apiperu.dev/api/ruc/" + nroruc);

            if (response == null) {
                valor = "NO";
            } else {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(response);
                try {
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONObject data = (JSONObject) jsonObject.get("data");

                    String estado = (String) data.get("estado");
                    String condicion = (String) data.get("condicion");

                    if (estado.equalsIgnoreCase("ACTIVO")) {
                        if (condicion.equalsIgnoreCase("HABIDO")) {

                            String nombre_o_razon_social = (String) data.get("nombre_o_razon_social");
                            String direccion_completa = (String) data.get("direccion_completa");
                            txtNombreR.setText(nombre_o_razon_social);
                            txtdireccion.setText(direccion_completa);
                            valor = "SI";

                        } else {
                            valor = "NO";
                            AlertaError alert = new AlertaError("Mensaje", "El RUC consultado se encuentra como NO HABIDO");
                            alert.setVisible(true);
                        }
                    } else {
                        valor = "NO";
                        AlertaError alert = new AlertaError("Mensaje", "El RUC consultado se encuentra INACTIVO");
                        alert.setVisible(true);
                    }

                } catch (Exception e) {
                    valor = "NO";
                }
            }
        } catch (Exception e) {
            valor = "NO";
        }

        return valor;

    }

    String post(String url) throws IOException {
        //Se crea un objeto Request.Builder para construir la solicitud HTTP POST.
        Request request = new Request.Builder()
                .url(url)//URL de la API 
                .addHeader("Authorization", "Bearer bde393ec7a70c1e67f8711c7455ddf2f2ebf74df030d2fa543ba69d25300041e")//Token de autenticacion
                .build();//Se contruye el objeto de la solicitud

        // envía la solicitud al servidor y devuelve una instancia de la clase Response, que contiene la respuesta del servidor.
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
            //Extrae el cuerpo de la respuesta y lo convierte en un dato String
        }
    }
}
