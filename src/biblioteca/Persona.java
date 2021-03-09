/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andrew
 */
public abstract class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    //private int nif;
    //private String pass;
    private static Scanner lectorPersona = new Scanner(System.in);
   
    public Persona() {
    }

    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setEdad(edad);
    }
    
    public Persona(Persona pCopia) {
        this.setNombre(pCopia.getNombre());
        this.setApellido1(pCopia.getApellido1());
        this.setApellido2(pCopia.getApellido2());
        this.setEdad(pCopia.getEdad());
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEdad(int edad) {
        while (edad < 0) {
            System.out.print("Edad no valida: ");
            edad = lectorPersona.nextInt();
        }
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getEdad() {
        return edad;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }
    
    
    public void solicitarDatosPersona() {
        System.out.print("\nIntroduce nombre: ");
        this.setNombre(lectorPersona.nextLine());
        System.out.print("\nIntroduce primer apellido: ");
        this.setApellido1(lectorPersona.nextLine());
        System.out.print("\nIntroduce segundo apellido: ");
        this.setApellido2(lectorPersona.nextLine());
        System.out.print("\nIntroduce edad: ");
        this.setEdad(lectorPersona.nextInt());
        lectorPersona.nextLine();
    }
    
    public abstract void cambiarContrasena();
    
}
