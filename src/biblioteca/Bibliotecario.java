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
public class Bibliotecario extends Persona {
    private String puesto;
    private int nif;
    private String pass;
    private static Scanner lectorBibliotecario = new Scanner(System.in);

    public Bibliotecario() {
    }

    public Bibliotecario(String puesto, int nif, String pass, String nombre, 
            String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.setPuesto(puesto);
        this.setNif(nif);
        this.setPass(pass);
    }
    
    //CONSTRUCTOR COPIA
    public Bibliotecario(Bibliotecario bCopia) {
        super(bCopia.getNombre(), bCopia.getApellido1(), bCopia.getApellido2(), bCopia.getEdad());
        this.setPuesto(bCopia.getPuesto());
        this.setNif(bCopia.getNif());
        this.setPass(bCopia.getPass());
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "puesto=" + puesto + ", nif=" + nif + ", pass=" + pass + '}';
    }
    
    @Override
    public void solicitarDatosPersona() {
        super.solicitarDatosPersona();
        System.out.print("\nIntroducir puesto: ");
        this.setPuesto(lectorBibliotecario.nextLine());
        System.out.print("\nIntroduce NIF: ");
        this.setNif(lectorBibliotecario.nextInt());
        lectorBibliotecario.nextLine();
        System.out.print("\nIntroduce contraseña: ");
        this.setPass(lectorBibliotecario.nextLine());
    }
    
    public static int devolverPosBibliotecario(ArrayList<Persona> lista) {
        System.out.println("Introduce NIF: ");
        int bibNif = lectorBibliotecario.nextInt();
        for (int i=0; i<lista.size(); i++) {
            if (lista.get(i) instanceof Bibliotecario) {
                if (((Bibliotecario)lista.get(i)).getNif() == bibNif) {
                    return i;
                }
            }
        }
        System.out.println("No existe bibliotecario con NIF "+bibNif);
        return -1;   
    }
    
    public static int confirmarContrasenaBibliotecario(ArrayList<Persona> lista) {
        System.out.println("\nInicio de sesión");
        int posBib = devolverPosBibliotecario(lista);
        if (posBib != -1) {
            System.out.println("\nIntroduce contraseña: ");
            lectorBibliotecario.nextLine();
            String pass = lectorBibliotecario.nextLine();
            if (((Bibliotecario)lista.get(posBib)).getPass().equals(pass)) {
                System.out.println("Sesión iniciada como "+((Bibliotecario)lista.get(posBib)).getNombre());
                return posBib;
            } else {
                System.out.println("Constraseña incorrecta");
                return -1;
            }
        }
        return -1;
    }
       
    public static void reservarLibro(ArrayList<Libro> listaLibro, ArrayList<Persona> listaPersona) {
        int posUsuario = Usuario.confirmarContrasenaUsuario(listaPersona);
        if (posUsuario != -1) {
            Usuario usuario = ((Usuario) listaPersona.get(posUsuario));
            if (usuario.getListaReserva().size() < 5) {
                int posLibro = Libro.buscarLibro(listaLibro);
                if (posLibro != -1) {
                    if (listaLibro.get(posLibro).getnCopiasDisp() > 0) {
                        listaLibro.get(posLibro).setnCopiasDisp(listaLibro.get(posLibro).getnCopiasDisp()-1);
                        Reserva reserva = new Reserva(listaLibro.get(posLibro));
                        usuario.getListaReserva().add(reserva);
                        System.out.println("Reserva realizada");
                    } else {
                        System.out.println("No existen copias disponibles del libro");
                    }
                }
            } else {
                System.out.println("No se pueden reservar mas de 5 libros a la vez");
            }
        }     
    }
    
    public static void devolverLibro(ArrayList<Libro> listaLibro, ArrayList<Persona> listaPersona) {
        int posUsuario = Usuario.confirmarContrasenaUsuario(listaPersona);
        if (posUsuario != -1) {
            Usuario usuario = ((Usuario) listaPersona.get(posUsuario));
            if (usuario.getListaReserva().size() > 0) {
                System.out.print("Introduce ISBN del libro a devolver: ");
                int isbn = lectorBibliotecario.nextInt();
                int i=0;
                boolean encontrado = false;
                while (!encontrado && i<((Usuario) listaPersona.get(posUsuario)).getListaReserva().size()) {
                    if (usuario.getListaReserva().get(i).getLibro().getIsbn() == isbn) {
                        usuario.getListaReserva().remove(i);
                        Libro libro = listaLibro.get(Libro.buscarLibro(listaLibro, isbn));
                        libro.setnCopiasDisp(libro.getnCopiasDisp()+1);
                        System.out.println("Se ha devuelto el libro");
                        encontrado = true;
                    }              
                    i++;
                }
            } else {
                System.out.println("No hay libros reservados para devolver");
            }
        }
    }
    
    @Override
    public void cambiarContrasena() {
        boolean iguales = false;
        while (!iguales) { 
            System.out.print("Introduce nueva constraseña: ");
            String contrasena = lectorBibliotecario.nextLine();
            System.out.print("Vuelve a introducir nueva contraseña: ");
            String contrasenaC = lectorBibliotecario.nextLine();
            if (contrasena.equals(contrasenaC)) {
                iguales = true;
            } else {
                System.out.println("Las contraseñas no coinciden. Vuelve a intentar");
            }
        }
        System.out.println("Nueva contraseña establecida");
        this.setPass(lectorBibliotecario.nextLine());
    }
    
}
