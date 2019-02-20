/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.backingBeans;

import com.turno.controlador.ITurnoControlador;
import com.turno.controladorImpl.TurnoControladorImpl;
import com.turno.modelo.Entidades.Turno;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author electro
 */
@ManagedBean
@ViewScoped
public class TurnoView implements Serializable {

    private int idTurno;
    private String descripcion;    
    private Turno g;
    private ITurnoControlador ig;
    private List<Turno> listarTur;

    public TurnoView() {

    }

    @PostConstruct
    public void init() {
        try {
            System.out.println("Inicio");
            ig = new TurnoControladorImpl();
            listarTurnos();
        } catch (Exception ex) {
            Logger.getLogger(TurnoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarTurno() {
        try {
            System.out.println("Ya esta en el server");
            g = new Turno();
            g.setIdTurno(idTurno);
            g.setDescripTurno(descripcion);            
            ig.insertarTurno(g);
            listarTurnos();                     
        } catch (Exception ex) {
            Logger.getLogger(TurnoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turno> listarTurnos() throws Exception {
        listarTur = ig.getTurnos();
        return listarTur;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Turno getG() {
        return g;
    }

    public void setG(Turno g) {
        this.g = g;
    }

    public ITurnoControlador getIg() {
        return ig;
    }

    public void setIg(ITurnoControlador ig) {
        this.ig = ig;
    }

    public List<Turno> getListarTur() {
        return listarTur;
    }

    public void setListarTur(List<Turno> listarTur) {
        this.listarTur = listarTur;
    }

    

}
