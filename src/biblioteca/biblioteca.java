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
public class biblioteca {
    private String bNombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Usuario> listaUsuarios;
    private static Scanner lectorBiblioteca = new Scanner(System.in);

    public biblioteca() {
    }

    public biblioteca(String bNombre) {
        this.setbNombre(bNombre);
        listaLibros = new ArrayList();
        listaPersonas = new ArrayList();
        listaUsuarios = new ArrayList();
    }

    public biblioteca(biblioteca bCopia) {
        this.setbNombre(bCopia.getbNombre());
        this.setListaLibros(bCopia.getListaLibros());
        this.setListaPersonas(bCopia.getListaPersonas());
        this.setListaUsuarios(bCopia.getListaUsuarios());
    }
    
    public String getbNombre() {
        return bNombre;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setbNombre(String bNombre) {
        this.bNombre = bNombre;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    @Override
    public String toString() {
        return "biblioteca{" + "bNombre=" + bNombre + ", listaLibros=" + listaLibros + ", listaPersonas=" + listaPersonas + '}';
    }
    
    public void mostrarLibros() {
        for (int i=0; i<listaLibros.size(); i++) {
            System.out.println(listaLibros.get(i));
        }
    }
    
    public static void mostrarPersonas(biblioteca bib) {
        for (int i=0; i<bib.getListaPersonas().size(); i++) {
            System.out.println(bib.getListaPersonas().get(i));
        }
    }
    
    public static void mostrarUsuarios(biblioteca bib) {
        for (int i=0; i<bib.getListaUsuarios().size(); i++) {
            System.out.println(bib.getListaUsuarios().get(i));
        }
    }
    
    public static void reservarLibro(biblioteca bib) {
        int usuario = Usuario.buscarUsuario(bib.getListaUsuarios());
        if (usuario != -1) {
            if (bib.getListaUsuarios().get(usuario).getLibrosReserva().size() < 5) {
                int libro = Libro.buscarLibro(bib.getListaLibros());
                if (Libro.comprobarDisponible(bib.getListaLibros(), libro)) {
                    bib.getListaLibros().get(libro).setnCopiasDisp(bib.getListaLibros().get(libro).getnCopiasDisp()-1);
                    bib.getListaUsuarios().get(usuario).getLibrosReserva().add(bib.getListaLibros().get(libro));
                    System.out.println("Se ha reservado el libro");
                } else {
                    System.out.println("El libro no tiene copias disponibles para reservar");
                }
            } else {
                System.out.println("No se pueden tener más de 5 libros reservados al mismo tiempo");
            }
        } else {
            System.out.println("El usuario no existe");
        }
    }
    
    public static void devolverLibro(biblioteca bib) {
        int usuario = Usuario.buscarUsuario(bib.getListaUsuarios());
        if (usuario != -1) {
            int libroDevuelto = Libro.buscarLibro(bib.getListaUsuarios().get(usuario).getLibrosReserva());
            int libro = Libro.buscarLibro(bib.getListaLibros(), bib.getListaUsuarios().get(usuario).getLibrosReserva().get(libroDevuelto).getIsbn());
            bib.getListaLibros().get(libro).setnCopiasDisp(bib.getListaLibros().get(libro).getnCopiasDisp()+1);
            bib.getListaUsuarios().get(usuario).getLibrosReserva().remove(libroDevuelto);
            System.out.println("El libro se ha devuelto");
        } else {
            System.out.println("El usuario no existe");
        }
    }
    
    public void mostrarReservas() {
        int usuario = Usuario.buscarUsuario(getListaUsuarios());
        getListaUsuarios().get(usuario).mostrarReservaLibros();
    }
}
