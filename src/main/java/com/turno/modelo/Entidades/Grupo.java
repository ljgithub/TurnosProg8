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
@Table (name ="grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name ="id_grupo")
    private int idGrupo;
    @Column(name ="descripGrupo")
    private String descripGrupo;
    
    
    @OneToMany (cascade = CascadeType.ALL, mappedBy="grupo")
    private List<TurnosVirtuales> turnosVirtuales = new ArrayList<>();

    public Grupo() {
    }



	public List<TurnosVirtuales> getTurnosVirtuales() {
		return turnosVirtuales;
	}



	public void setTurnosVirtuales(List<TurnosVirtuales> turnosVirtuales) {
		this.turnosVirtuales = turnosVirtuales;
	}



	public Grupo(int idGrupo, String descripGrupo) {
        this.idGrupo = idGrupo;
        this.descripGrupo = descripGrupo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getDescripGrupo() {
        return descripGrupo;
    }

    public void setDescripGrupo(String descripGrupo) {
        this.descripGrupo = descripGrupo;
    }

    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", descripGrupo=" + descripGrupo + '}';
    }
    
    
    
}
