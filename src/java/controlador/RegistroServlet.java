/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Registro;
import modelo.AlmacenadoRegistro;

/**
 *
 * @author ivanb
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})  
public class RegistroServlet extends HttpServlet {  
    private final static Logger LOG = Logger.getLogger(RegistroServlet.class.getName());  

    @Override  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
        
        ArrayList<String> errores = new ArrayList<>();  
        String respuesta;  
        
        // Recibir parámetros  
        String idP = request.getParameter("id");  
        String nombre = request.getParameter("nombre");  
        String pesoP = request.getParameter("peso");  
        String prematuroP = request.getParameter("prematuro");  
        String sexoP = request.getParameter("sexo");  
        String centroP = request.getParameter("centro");  
        
        // Obtener la fecha y hora actual del sistema
        Date fechaNacimiento = new Date(); // Esto obtiene la fecha y hora actuales

        // Validar campos de entrada  
        validarEntradas(idP, nombre, pesoP, prematuroP, sexoP, centroP, errores);  
        
        // Si hay errores, se devolverá el formulario con mensajes  
        if (errores.isEmpty()) {  
            // Crear objeto de Registro y almacenar  
            Registro registro = crearRegistro(idP, nombre, pesoP, prematuroP, sexoP, centroP, fechaNacimiento);  
            HttpSession session = request.getSession();  
            AlmacenadoRegistro almacenadoReg = (AlmacenadoRegistro) session.getAttribute("registro");  
            if (almacenadoReg == null) {  
                almacenadoReg = new AlmacenadoRegistro();  
                session.setAttribute("registro", almacenadoReg);  
            }  
            almacenadoReg.agregarRegistro(registro);  
            respuesta = "Tu registro se ingresó exitosamente";  
            LOG.log(Level.INFO, "Proceso exitoso");  
        } else {  
            respuesta = "Tu registro no se ingresó debido a errores.";  
            LOG.log(Level.SEVERE, "Proceso NO exitoso");  
        }  

        // Despachar vista  
        request.setAttribute("respuesta", respuesta);  
        request.setAttribute("errores", errores);  
        request.setAttribute("id", idP);  
        request.setAttribute("nombre", nombre);  
        request.setAttribute("peso", pesoP);  
        request.setAttribute("prematuro", prematuroP);  
        request.setAttribute("sexo", sexoP);  
        request.setAttribute("centro", centroP);  
        request.setAttribute("fechaNacimiento", fechaNacimiento); // Enviar la fecha de nacimiento a la vista
        
        RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");  
        despachador.forward(request, response);  
    }  

    private void validarEntradas(String idP, String nombre, String pesoP,  
                                 String prematuroP, String sexoP, String centroP,  
                                 ArrayList<String> errores) {  
        // Validaciones  
        if (idP == null || idP.isEmpty()) {  
            errores.add("Ingrese id");  
        }  
        if (nombre == null || nombre.isEmpty()) {  
            errores.add("Ingrese nombre");  
        }  
        if (pesoP == null || pesoP.isEmpty()) {  
            errores.add("Ingrese peso en gramos");  
        }  
        if (prematuroP == null || prematuroP.isEmpty()) {  
            errores.add("Ingrese si es prematuro");  
        }  
        if (sexoP == null || sexoP.isEmpty()) {  
            errores.add("Ingrese sexo (M/F)");  
        } else if (!sexoP.equalsIgnoreCase("M") && !sexoP.equalsIgnoreCase("F")) {  
            errores.add("El sexo debe ser 'M' o 'F'");  
        }  
        if (centroP == null || centroP.isEmpty()) {  
            errores.add("Seleccione centro");  
        }  
        // Validaciones numéricas  
        validarNumero("id", idP, errores);  
        validarNumero("peso", pesoP, errores);  
        validarNumero("centro", centroP, errores);  
    }  

    private void validarNumero(String nombreCampo, String valor, ArrayList<String> errores) {  
        try {  
            int numero = Integer.parseInt(valor);  
            if (numero <= 0) {  
                errores.add("El " + nombreCampo + " debe ser mayor a 0");  
            }  
        } catch (NumberFormatException e) {  
            errores.add("El " + nombreCampo + " debe ser un número válido");  
        }  
    }  

    private Registro crearRegistro(String idP, String nombre, String pesoP, String prematuroP, String sexoP, String centroP, Date fechaNacimiento) {  
        int id = Integer.parseInt(idP);  
        int peso = Integer.parseInt(pesoP);  
        boolean prematuro = "true".equalsIgnoreCase(prematuroP);  
        char sexo = sexoP.toUpperCase().charAt(0);  
        int centro = Integer.parseInt(centroP);  
        return new Registro(id, nombre.toUpperCase(), peso, fechaNacimiento, prematuro, sexo, centro);  
    }  
}
