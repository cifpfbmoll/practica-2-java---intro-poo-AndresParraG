/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Andrew
 */
public class Reserva {
    private Libro libro;
    private LocalDate data;
    private LocalTime hora;

    public Reserva() {
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public Reserva(Libro libro) {
        this.setLibro(libro);
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
    }
    
    public Reserva(Reserva rCopia) {
        this.setLibro(rCopia.getLibro());
        this.setData(rCopia.getData());
        this.setHora(rCopia.getHora());
    }
    
    public Libro getLibro() {
        return libro;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
}
