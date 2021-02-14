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
public class Usuario {
    private String nombreU;
    private String apellido1U;
    private String apellido2U;
    private int nifU;
    private String passU;
    private ArrayList<Libro> librosReserva;
    private static Scanner lectorUsuario = new Scanner(System.in);

    public Usuario() {
        this.librosReserva = new ArrayList();
    }

    public Usuario(String nombreU, String apellido1U, String apellido2U, int nifU, String passU) {
        this.setNombreU(nombreU);
        this.setApellido1U(apellido1U);
        this.setApellido2U(apellido2U);
        this.setNifU(nifU);
        this.setPassU(passU);
        this.librosReserva = new ArrayList();
    }

    public Usuario(Usuario uCopia) {
        this.setNombreU(uCopia.getNombreU());
        this.setApellido1U(uCopia.getApellido1U());
        this.setApellido2U(uCopia.getApellido2U());
        this.setNifU(uCopia.getNifU());
        this.setPassU(uCopia.getPassU());
        this.setLibrosReserva(uCopia.getLibrosReserva());
    }
    
    public String getNombreU() {
        return nombreU;
    }

    public String getApellido1U() {
        return apellido1U;
    }

    public String getApellido2U() {
        return apellido2U;
    }

    public int getNifU() {
        return nifU;
    }

    public String getPassU() {
        return passU;
    }

    public ArrayList<Libro> getLibrosReserva() {
        return librosReserva;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public void setApellido1U(String apellido1U) {
        this.apellido1U = apellido1U;
    }

    public void setApellido2U(String apellido2U) {
        this.apellido2U = apellido2U;
    }

    public void setNifU(int nifU) {
        this.nifU = nifU;
    }

    public void setPassU(String passU) {
        while (passU.length() < 8) {
            System.out.println("La contraseña debe tener por lo menos 8 caracteres:");
            passU = lectorUsuario.nextLine();
        }
        this.passU = passU;
    }

    public void setLibrosReserva(ArrayList<Libro> librosReserva) {
        if (librosReserva.size() >= 5) {
            System.out.println("Un usuario no puede reservar más de 5 libros a la vez");
        } else {
            this.librosReserva = librosReserva;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreU=" + nombreU + ", apellido1U=" + apellido1U + ", apellido2U=" + apellido2U + ", nifU=" + nifU + ", passU=" + passU + ", librosReserva=" + librosReserva + '}';
    }
    
    public static void anadirUsuario(ArrayList<Usuario> lista) {
        Usuario usuario = new Usuario();
        System.out.print("\nNombre: ");
        usuario.setNombreU(lectorUsuario.nextLine());
        System.out.print("\nPrimer Apellido: ");
        usuario.setApellido1U(lectorUsuario.nextLine());
        System.out.print("\nSegundo Apellido: ");
        usuario.setApellido2U(lectorUsuario.nextLine());
        System.out.print("\nNIF: ");
        usuario.setNifU(lectorUsuario.nextInt());
        lectorUsuario.nextLine();
        System.out.print("\nContraseña: ");
        usuario.setPassU(lectorUsuario.nextLine());
        lista.add(usuario);
    }
    
    public static int buscarUsuario(ArrayList<Usuario> lista) {
        System.out.println("Indica el NIF: ");
        int nif = lectorUsuario.nextInt();
        for (int i=0; i<lista.size(); i++) {
            if (lista.get(i).getNifU()== nif) {
                return i;
            }
        }
        return -1;
    }
    
    public void mostrarReservaLibros() {
        for (int i=0; i<getLibrosReserva().size(); i++) {
            System.out.println(getLibrosReserva().get(i));
        }
    }
}