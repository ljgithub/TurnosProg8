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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    private List<EmpleadoView> listaEmV;

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

    public void actualizar(RowEditEvent event) {
        try {
            Empleado e = (Empleado) event.getObject();
            e.setNombres(nombres);
            e.setTelefono(telefono);
            ie.actualizarEmpleado(e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
        } catch (Exception e) {
            System.out.println("Error : " + e.getStackTrace().toString());
        }

    }

    public String eliminar(Empleado em) {
        try {
            ie.eliminar(em);
            listarEmpleados();  
            return "Eliminado";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("No se pudo eliminar causa: " + e.getMessage()));
            return "Fallido";
        }

    }

    public void cancelar(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Opción Cancelada"));
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

}
