/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Casa
 */
public class Registro implements Serializable {
    private int id;
    private String nombre;
    private int peso;
    private Date fechaNacimiento; // Fecha del sistema
    private boolean prematuro;
    private char sexo;
    private int centro;
    private static final long serialVersionUID = 1L;

    // Constructor vacío
    public Registro() {
    }

    // Constructor con todos los parámetros, incluyendo fecha de nacimiento
    public Registro(int id, String nombre, int peso, Date fechaNacimiento, boolean prematuro, char sexo, int centro) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.prematuro = prematuro;
        this.sexo = sexo;
        this.centro = centro;
    }

    // Constructor que no incluye fecha de nacimiento (por compatibilidad con otras versiones)
    public Registro(int id, String nombre, int peso, boolean prematuro, char sexo, int centro) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.prematuro = prematuro;
        this.sexo = sexo;
        this.centro = centro;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isPrematuro() {
        return prematuro;
    }

    public void setPrematuro(boolean prematuro) {
        this.prematuro = prematuro;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getCentro() {
        return centro;
    }

    public void setCentro(int centro) {
        this.centro = centro;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", fechaNacimiento=" + fechaNacimiento + // Incluimos fecha de nacimiento en el toString
                ", prematuro=" + prematuro +
                ", sexo=" + sexo +
                ", centro=" + centro +
                '}';
    }
}
