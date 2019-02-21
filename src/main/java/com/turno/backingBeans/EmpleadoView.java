/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.backingBeans;

import com.turno.controlador.IEmpleadoControlador;
import com.turno.controladorImpl.EmpleadoControladorImpl;
import com.turno.modelo.Entidades.Empleado;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author electro
 */
@ManagedBean
@ViewScoped
public class EmpleadoView implements Serializable {

    private int idEmple;
    private String nombres;
    private String telefono;
    private Empleado em;
    private IEmpleadoControlador ie;
    private List<Empleado> listarEmp;

    public EmpleadoView() {

    }

    @PostConstruct
    public void init() {
        try {
            System.out.println("Inicio");
            ie = new EmpleadoControladorImpl();
            listarEmpleados();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     

    public void insertarEmpleado() {
        try {
            System.out.println("Ya esta en el server");
            em = new Empleado();
            em.setIdEmple(idEmple);
            em.setNombres(nombres);
            em.setTelefono(telefono);
            ie.insertarEmpleado(em);
            listarEmpleados();                     
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> listarEmpleados() throws Exception {
        listarEmp = ie.listarEmpleado();
        return listarEmp;
    }

    public int getIdEmple() {
        return idEmple;
    }

    public void setIdEmple(int idEmple) {
        this.idEmple = idEmple;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empleado getEm() {
        return em;
    }

    public void setEm(Empleado em) {
        this.em = em;
    }

    public IEmpleadoControlador getIe() {
        return ie;
    }

    public void setIe(IEmpleadoControlador ie) {
        this.ie = ie;
    }

    public List<Empleado> getListarEmp() {
        return listarEmp;
    }

    public void setListarEmp(List<Empleado> listarEmp) {
        this.listarEmp = listarEmp;
    }

    /* public void editarCelda(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }*/
    
}
