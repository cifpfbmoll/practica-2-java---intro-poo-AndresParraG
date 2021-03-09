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
public class Usuario extends Persona {
    //private String nombreU;
    //private String apellido1U;
    //private String apellido2U;
    //private int nifU;
    //private String passU;
    //private ArrayList<Libro> librosReserva;
    private int telef;
    private String direcc;
    private int post;
    private String correoE;
    private ArrayList<Reserva> listaReserva;
    private static Scanner lectorUsuario = new Scanner(System.in);

    public Usuario() {
    }
    
    public Usuario(int telef, String direcc, int post, String correoE, 
             String nombre, String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.setTelef(telef);
        this.setDirecc(direcc);
        this.setPost(post);
        this.setCorreoE(correoE);
        this.listaReserva = new ArrayList();
    }
    
    //HACER CONSTRUCTOR COPIA
    public Usuario(Usuario uCopia) {
        super(uCopia.getNombre(), uCopia.getApellido1(), uCopia.getApellido2(), uCopia.getEdad());
        this.setTelef(uCopia.getTelef());
        this.setDirecc(uCopia.getDirecc());
        this.setPost(uCopia.getPost());
        this.setCorreoE(uCopia.getCorreoE());
        this.listaReserva = new ArrayList();
        this.setListaReserva(uCopia.getListaReserva());
    }

    public void setTelef(int telef) {
        this.telef = telef;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public void setListaReserva(ArrayList<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }
    
    public int getTelef() {
        return telef;
    }

    public String getDirecc() {
        return direcc;
    }

    public int getPost() {
        return post;
    }

    public String getCorreoE() {
        return correoE;
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Usuario{" + "telef=" + telef + ", direcc=" + direcc + ", post=" + post + ", correoE=" + correoE + ", listaReserva=" + listaReserva + '}';
    }
    
    @Override
    public void solicitarDatosPersona() {
        super.solicitarDatosPersona();
        System.out.print("\nIntroduce telefono: ");
        this.setTelef(lectorUsuario.nextInt());
        lectorUsuario.nextLine();
        System.out.print("\nIntroduce direccion: ");
        this.setDirecc(lectorUsuario.nextLine());
        System.out.print("\nIntroduce direccion postal: ");
        this.setPost(lectorUsuario.nextInt());
        lectorUsuario.nextLine();
        System.out.print("\nIntroduce correo electronico: ");
        this.setCorreoE(lectorUsuario.nextLine());
    }
    
    public static int devolverPosUsuario(ArrayList<Persona> lista) {
        System.out.println("Introduce NIF: ");
        String correo = lectorUsuario.nextLine();
        for (int i=0; i<lista.size(); i++) {
            if (lista.get(i) instanceof Usuario) {
                if (((Usuario)lista.get(i)).getCorreoE() == correo) {
                    return i;
                }
            }
        }
        System.out.println("No existe usuario con correo "+correo);
        return -1;   
    }
    
    public static int confirmarContrasenaUsuario(ArrayList<Persona> lista) {
        System.out.println("\nIdentificación de usuario");
        int posUs = devolverPosUsuario(lista);
        System.out.println("\nIntroduce numero de telefono: ");
        int telef = lectorUsuario.nextInt();
        if (((Usuario)lista.get(posUs)).getTelef() == telef) {
            return posUs;
        } else {
            System.out.println("Numero usuario incorrecto");
            return -1;
        }
    }
    
    @Override
    public void cambiarContrasena() {
        System.out.println("Cambiar: ");
        System.out.println("1.- Correo"+"\n2.- Telefono");
        int ent = lectorUsuario.nextInt();
        boolean iguales = false;
        switch(ent) {
            case 1:
                String correo = "";
                String correoC = "";
                while (!iguales) { 
                    System.out.print("Introduce nuevo correo electronico: ");
                    correo = lectorUsuario.nextLine();
                    System.out.print("Vuelve a introducir nuevo correo electronico: ");
                    correoC = lectorUsuario.nextLine();
                    if (correo.equals(correoC)) {
                        iguales = true;
                    } else {
                        System.out.println("Los correos no coinciden. Vuelve a intentar");
                    }
                }
                this.setCorreoE(correo);
                System.out.println("Nuevo correo establecido");  
                break;

            case 2:
                int telef = 0;
                int telefC = 0;
                while (!iguales) { 
                    System.out.print("Introduce nuevo telefono: ");
                    telef = lectorUsuario.nextInt();
                    System.out.print("Vuelve a introducir nuevo correo electronico: ");
                    telefC = lectorUsuario.nextInt();
                    if (telef == telefC) {
                        iguales = true;
                    } else {
                        System.out.println("Los telefonos no coinciden. Vuelve a intentar");
                    }
                }
                this.setTelef(telef);
                break;
        }
    }
}