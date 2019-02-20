/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.modelo.Entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */

@Entity
@Table(name = "empleado")
public class Empleado {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emple")
    private int idEmple;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "telefono")
    private String telefono;
 
    
    @OneToMany (cascade = CascadeType.ALL, mappedBy="empleado")
    private List<TurnosVirtuales> turnosVirtuales = new ArrayList<>();
    
    public Empleado() {
    }

    
    
    public List<TurnosVirtuales> getTurnosVirtuales() {
		return turnosVirtuales;
	}



	public void setTurnosVirtuales(List<TurnosVirtuales> turnosVirtuales) {
		this.turnosVirtuales = turnosVirtuales;
	}

	public Empleado(int idEmple, String nombres, String telefono) {
        this.idEmple = idEmple;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public int getIdEmple() {
        return idEmple;
    }

    public void setIdEmple(int idEmple) {
        int oldIdEmple = this.idEmple;
        this.idEmple = idEmple;
        changeSupport.firePropertyChange("idEmple", oldIdEmple, idEmple);
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        String oldNombres = this.nombres;
        this.nombres = nombres;
        changeSupport.firePropertyChange("nombres", oldNombres, nombres);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmple=" + idEmple + ", nombres=" + nombres + ", telefono=" + telefono + '}';
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
               
}
