/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.modelo.Entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
@Entity
@Table (name = "turno")
public class Turno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name ="id_turno")
    private int idTurno;
    @Column(name ="descripTurno")
    private String descripTurno;


    @OneToMany (cascade = CascadeType.ALL, mappedBy="turno")
    private List<TurnosVirtuales> turnosVirtuales = new ArrayList<>();
    
    public Turno() {
    }
    
    

    public List<TurnosVirtuales> getTurnosVirtuales() {
		return turnosVirtuales;
	}



	public void setTurnosVirtuales(List<TurnosVirtuales> turnosVirtuales) {
		this.turnosVirtuales = turnosVirtuales;
	}



	public Turno(int idTurno, String descripTurno) {
        this.idTurno = idTurno;
        this.descripTurno = descripTurno;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getDescripTurno() {
        return descripTurno;
    }

    public void setDescripTurno(String descripTurno) {
        this.descripTurno = descripTurno;
    }

    @Override
    public String toString() {
        return "Turno{" + "idTurno=" + idTurno + ", descripTurno=" + descripTurno + '}';
    }
            
}
