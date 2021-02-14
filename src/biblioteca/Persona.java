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
public class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int nif;
    private String pass;
    private static Scanner lectorPersona = new Scanner(System.in);
    
    public Persona() {
    }

    public Persona(String nombre, String apellido1, String apellido2, int nif, String pass) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNif(nif);
        this.setPass(pass);
    }

    public Persona(Persona pCopia) {
        this.setNombre(pCopia.getNombre());
        this.setApellido1(pCopia.getApellido1());
        this.setApellido2(pCopia.getApellido2());
        this.setPass(pCopia.getPass());
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

    public int getNif() {
        return nif;
    }

    public String getPass() {
        return pass;
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

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setPass(String pass) {
        while (pass.length() < 8) {
            System.out.println("La contraseña debe tener por lo menos 8 caracteres:");
            pass = lectorPersona.nextLine();
            lectorPersona.nextLine();
        }
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nif=" + nif + ", pass=" + pass + '}';
    }
    
    public static void anadirPersona(ArrayList<Persona> lista) {
        Persona persona = new Persona();
        System.out.print("\nNombre: ");
        persona.setNombre(lectorPersona.nextLine());
        System.out.print("\nPrimer Apellido: ");
        persona.setApellido1(lectorPersona.nextLine());
        System.out.print("\nSegundo Apellido: ");
        persona.setApellido2(lectorPersona.nextLine());
        System.out.print("\nNIF: ");
        persona.setNif(lectorPersona.nextInt());
        lectorPersona.nextLine();
        System.out.print("\nContraseña: ");
        persona.setPass(lectorPersona.nextLine());
        lista.add(persona);
    }
    
    public static void eliminarPersona(ArrayList<Persona> lista) {
        System.out.print("Introduce el NIF de la persona a eliminar: ");
        int nif = lectorPersona.nextInt();
        boolean seguir = true;
        for (int i=0; i<lista.size() && seguir; i++) {
            if (lista.get(i).getNif() == nif) {
                seguir = false;
                lista.remove(i);
                System.out.println("Se ha eliminado el elemento");
            }
        }
        if (seguir) {
            System.out.println("El elemento no existe en la lista");
        }
    }
    
}
