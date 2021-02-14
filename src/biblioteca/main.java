/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Scanner;

/**
 *
 * @author Andrew
 */
public class main {
    private static Scanner ent = new Scanner(System.in);
    private static int in;
    private static boolean seguir = true;
    private static biblioteca bib = new biblioteca("Biblioteca B.Moll");
    private static Libro libro;
    private static Persona persona;
    private static Usuario usuario;
    
    public static void opcionesLibro() {
        while (seguir) {
            System.out.println("1.- Añadir Libro");
            System.out.println("2.- Eliminar Libro");
            System.out.println("3.- Buscar libro por ISBN");
            System.out.println("4.- Buscar libro por titulo");
            System.out.println("0.- Volver");
            in = ent.nextInt();
            switch (in) {
                case 1:
                    Libro.anadirLibro(bib.getListaLibros());
                    break;
                case 2:
                    Libro.eliminarLibro(bib.getListaLibros());
                    break;
                case 3:
                    Libro.buscarLibro(bib.getListaLibros());
                    break;
                case 4:
                    Libro.buscarLibroTitulo(bib.getListaLibros());
                    break;
                case 0:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        seguir = true;
    }
    
    public static void opcionesPersona() {
        while (seguir) {
            System.out.println("1.- Añadir Persona");
            System.out.println("2.- Eliminar Persona");
            System.out.println("0.- Volver");
            in = ent.nextInt();
            switch (in) {
                case 1:
                    Persona.anadirPersona(bib.getListaPersonas());
                    break;
                case 2:
                    Persona.eliminarPersona(bib.getListaPersonas());
                    break;
                case 0:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        seguir = true;
    }
    
    public static void opcionesBiblioteca() {
        while (seguir) {
            System.out.println("1.- Mostrar Libros");
            System.out.println("2.- Mostrar Personas");
            System.out.println("3.- Mostrar Usuarios");
            System.out.println("0.- Volver");
            in = ent.nextInt();
            switch (in) {
                case 1:
                    bib.mostrarLibros();
                    break;
                case 2:
                    biblioteca.mostrarPersonas(bib);
                    break;
                case 3:
                    biblioteca.mostrarUsuarios(bib);
                    break;
                case 0:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        seguir = true;
    }
    
    public static void opcionesUsuario() {
        while (seguir) {
            System.out.println("1.- Añadir Usuario");
            System.out.println("2.- Reservar Libro");
            System.out.println("3.- Devolver Libro");
            System.out.println("4.- Mostrar Reservas");
            System.out.println("0.- Volver");
            in = ent.nextInt();
            switch (in) {
                case 1:
                    Usuario.anadirUsuario(bib.getListaUsuarios());
                    break;
                case 2:
                    biblioteca.reservarLibro(bib);
                    break;
                case 3:
                    biblioteca.devolverLibro(bib);
                    break;
                case 4:
                    bib.mostrarReservas();
                    break;
                case 0:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        seguir = true;
    }
    
    public static void main(String[] args) {
        libro = new Libro(1234, "El Libro", "Librero", "Libreria", 15, 5);
        persona = new Persona("Persona", "De", "Incognito", 1234, "contraseña000");
        usuario = new Usuario("Usuario", "De", "Incognito", 1234, "contraseña111");
        bib.getListaLibros().add(libro);
        bib.getListaPersonas().add(persona);
        bib.getListaUsuarios().add(usuario);
        while (seguir) {
            System.out.println("1.- Opciones Libros");
            System.out.println("2.- Opciones Persona");
            System.out.println("3.- Opciones Biblioteca");
            System.out.println("4.- Opciones Usuario");
            System.out.println("0.- Salir");
            in = ent.nextInt();
            switch (in) {
                case 1:
                    opcionesLibro();
                    break;
                case 2:
                    opcionesPersona();
                    break;
                case 3:
                    opcionesBiblioteca();
                    break;
                case 4:
                    opcionesUsuario();
                    break;
                case 0:
                    seguir = false;
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción no válida");
                      
            }
        }
    }
}
