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
public class main {
    private static Scanner ent = new Scanner(System.in);
    private static int in;
    private static boolean seguir = true;
    private static biblioteca bib = new biblioteca("Biblioteca B.Moll");
    private static Libro libro;
    private static Bibliotecario bibliotecario;
    private static Usuario usuario;
    
    public static void main(String[] args) {
        libro = new Libro(1234, "El Libro", "Librero", "Libreria", 15, 5);
        bibliotecario = new Bibliotecario("ADMIN", 1234, "ADMIN", "ADMIN", "ADMIN", "ADMIN", 99);
        usuario = new Usuario(666999666, "DIRECCION", 07000, "CORREO", "NOMBRE", "APELLIDO1", "APELLIDO2", 21);
        bib.getListaLibros().add(libro);
        bib.getListaPersonas().add(bibliotecario);
        bib.getListaPersonas().add(usuario);
        while (seguir) {
            System.out.println("1.- Opciones Libros");
            System.out.println("2.- Opciones Bibliotecario");
            System.out.println("3.- Opciones Biblioteca");
            System.out.println("0.- Salir");
            in = ent.nextInt();
            switch (in) {
                case 1:
                    opcionesLibro();
                    break;
                case 2:
                    opcionesBibliotecario();
                    break;
                case 3:
                    opcionesBiblioteca();
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
    
    public static void opcionesBibliotecario() {
        ArrayList<Persona> listaPersonas = bib.getListaPersonas();
        ArrayList<Libro> listaLibro = bib.getListaLibros();
        int posBib = bibliotecario.confirmarContrasenaBibliotecario(bib.getListaPersonas());
        
        if (posBib != -1) {
            while (seguir) {
                Bibliotecario sesionBibliotecario = (Bibliotecario) listaPersonas.get(posBib);
                System.out.println("1.- Añadir Bibliotecario");
                System.out.println("2.- Añadir Usuario");
                System.out.println("3.- Reservar Libro");
                System.out.println("4.- Devolver Libro");
                System.out.println("5-. Añadir Copia Libro");
                System.out.println("6.- Cambiar contraseña bibliotecario");
                System.out.println("7.- Cambiar contraseña usuario");
                System.out.println("0.- Volver");
                in = ent.nextInt();
                switch (in) {
                    case 1:
                        Bibliotecario nuevoBibliotecario = new Bibliotecario();
                        nuevoBibliotecario.solicitarDatosPersona();
                        listaPersonas.add(nuevoBibliotecario);
                        break;
                    case 2:
                        Usuario nuevoUsuario = new Usuario();
                        nuevoUsuario.solicitarDatosPersona();
                        listaPersonas.add(nuevoUsuario);
                        break;
                    case 3:
                        Bibliotecario.reservarLibro(listaLibro, listaPersonas);
                        break;
                    case 4:
                        Bibliotecario.devolverLibro(listaLibro, listaPersonas);
                        break;
                    case 5:
                        //AÑADIR COPIA LIBRO
                        break;
                    case 6:
                        sesionBibliotecario.cambiarContrasena();
                        break;
                    case 7:
                        Usuario usuario = (Usuario)listaPersonas.get(Usuario.devolverPosUsuario(listaPersonas));
                        usuario.cambiarContrasena();
                    case 0:
                        seguir = false;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }
            seguir = true;
        }
    }
    
    public static void opcionesBiblioteca() {
        while (seguir) {
            System.out.println("1.- Mostrar Libros");
            System.out.println("2.- Mostrar Personas");
            System.out.println("3.- Mostrar Bibliotecarios");
            System.out.println("4.- Mostrar Usuarios");
            System.out.println("0.- Volver");
            in = ent.nextInt();
            switch (in) {
                case 1:
                    bib.mostrarLibros();
                    break;
                case 2:
                    bib.mostrarPersonas();
                    break;
                case 3:
                    bib.mostrarBibliotecario();
                    break;
                case 4:
                    bib.mostrarUsuarios();
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
    
}
