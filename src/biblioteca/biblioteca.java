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
    private static Scanner lectorBiblioteca = new Scanner(System.in);

    public biblioteca() {
    }

    public biblioteca(String bNombre) {
        this.setbNombre(bNombre);
        this.listaLibros = new ArrayList();
        this.listaPersonas = new ArrayList();
    }

    public biblioteca(biblioteca bCopia) {
        this.setbNombre(bCopia.getbNombre());
        this.setListaLibros(bCopia.getListaLibros());
        this.setListaPersonas(bCopia.getListaPersonas());
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

    public void setbNombre(String bNombre) {
        this.bNombre = bNombre;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
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
    
    public void mostrarPersonas() {
        for (int i=0; i<this.getListaPersonas().size(); i++) {
            System.out.println(this.getListaPersonas().get(i));
        }
    }
    
    public void mostrarBibliotecario() {
        for (int i=0; i<this.getListaPersonas().size(); i++) {
            if (this.getListaPersonas().get(i) instanceof Bibliotecario) {
                System.out.println((Bibliotecario)this.getListaPersonas().get(i));
            }
        }
    }
    
    public void mostrarUsuarios() {
        for (int i=0; i<this.getListaPersonas().size(); i++) {
            if (this.getListaPersonas().get(i) instanceof Usuario) {
                System.out.println((Usuario)this.getListaPersonas().get(i));
            }
        }
    }
}
