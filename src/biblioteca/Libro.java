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
public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int nCopias;
    private int nCopiasDisp;
    private static int contadorLibros;
    private static Scanner lectorLibro = new Scanner(System.in);

    public Libro() {
        contadorLibros++;
    }

    public Libro(int isbn, String titulo, String autor, String editorial, int nCopias, int nCopiasDisp) {
        contadorLibros++;
        this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setnCopias(nCopias);
        this.setnCopiasDisp(nCopiasDisp);
    }
    
    public Libro(Libro lCopia) {
        contadorLibros++;
        this.setIsbn(lCopia.getIsbn());
        this.setTitulo(lCopia.getTitulo());
        this.setAutor(lCopia.getAutor());
        this.setEditorial(lCopia.getEditorial());
        this.setnCopias(lCopia.getnCopias());
        this.setnCopiasDisp(lCopia.getnCopiasDisp());
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getnCopias() {
        return nCopias;
    }

    public int getnCopiasDisp() {
        return nCopiasDisp;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setnCopias(int nCopias) {
        while (nCopias < 1) {
            System.out.println("El número de copias inicial no puede ser menor que 1");
            nCopias = lectorLibro.nextInt();
        }
        this.nCopias = nCopias;
    }

    public void setnCopiasDisp(int nCopiasDisp) {
        while ((nCopiasDisp > nCopias) || (nCopias < 0)) {
            System.out.println("El número de copais disponible no puede ser menor que 0 o mayor que el número de copias");
            nCopias = lectorLibro.nextInt();
        }
        this.nCopiasDisp = nCopiasDisp;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", nCopias=" + nCopias + ", nCopiasDisp=" + nCopiasDisp + '}';
    }
    
    public static void anadirLibro(ArrayList<Libro> lista) {
        Libro libro = new Libro();
        System.out.print("\nISBN: ");
        libro.setIsbn(lectorLibro.nextInt());
        lectorLibro.nextLine();
        System.out.print("\nTitulo: ");
        libro.setTitulo(lectorLibro.nextLine());
        System.out.print("\nAutor: ");
        libro.setAutor(lectorLibro.nextLine());
        System.out.print("\nEditorial: ");
        libro.setEditorial(lectorLibro.nextLine());
        System.out.print("\nNumero de copias: ");
        libro.setnCopias(lectorLibro.nextInt());
        System.out.print("\nNumero de copias disponible: ");
        libro.setnCopiasDisp(lectorLibro.nextInt());
        lista.add(libro);
    }
    
    public static void eliminarLibro(ArrayList<Libro> lista) {
        boolean seguir = true;
        System.out.print("Indica el ISBN: ");
        int isbn = lectorLibro.nextInt();
        for(int i=0; i<lista.size() && seguir; i++) {
            if (lista.get(i).getIsbn() == isbn) {
                seguir = false;
                if (lista.get(i).getnCopiasDisp() == lista.get(i).getnCopias()) {
                    System.out.println("El libro "+lista.get(i).getTitulo()+" ha sido eliminado");
                    lista.remove(i);
                    contadorLibros--;
                } else {
                    System.out.println("El libro tiene copias reservadas. Imposible eliminar");
                }
            }
        }
        if (seguir) {
            System.out.println("El libro con ISBN "+isbn+" no existe");
        }
    }
    
    public static int buscarLibro(ArrayList<Libro> lista) {
        System.out.println("Indica el ISBN: ");
        int isbn = lectorLibro.nextInt();
        for (int i=0; i<lista.size(); i++) {
            if (lista.get(i).getIsbn() == isbn) {
                System.out.println("El libro con ISBN "+isbn+" se encuentra en la posicion "+i);
                return i;
            }
        }
        System.out.println("El libro con ISBN "+isbn+" no existe");
        return -1;
    }
    
    public static int buscarLibro(ArrayList<Libro> lista, int isbn) {
        for (int i=0; i<lista.size(); i++) {
            if (lista.get(i).getIsbn() == isbn) {
                return i;
            }
        }
        System.out.println("El libro con ISBN "+isbn+" no existe");
        return -1;
    }
    
    public static void buscarLibroTitulo(ArrayList<Libro> lista) {
        boolean encontrado = false;
        System.out.print("Indica el titulo del libro: ");
        String titulo = lectorLibro.nextLine();
        lectorLibro.nextLine();
        for (int i=0; i<lista.size(); i++) {
            if (lista.get(i).getTitulo().contains(titulo)) {
                System.out.println(lista.get(i));
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se ha encontrado ningún libro con el título "+titulo);
        }
    }
    
    public static boolean comprobarDisponible(ArrayList<Libro> lista, int posLibro) {
        if (lista.get(posLibro).getnCopiasDisp() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
