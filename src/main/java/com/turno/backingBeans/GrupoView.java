/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.backingBeans;

import com.turno.controlador.IGrupoControlador;
import com.turno.controladorImpl.GrupoControladorImpl;
import com.turno.modelo.Entidades.Grupo;
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
public class GrupoView implements Serializable {

    private int idGrupo;
    private String descripcion;    
    private Grupo g;
    private IGrupoControlador ig;
    private List<Grupo> listarGru;

    public GrupoView() {

    }

    @PostConstruct
    public void init() {
        try {
            System.out.println("Inicio");
            ig = new GrupoControladorImpl();
            listarGrupos();
        } catch (Exception ex) {
            Logger.getLogger(GrupoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarGrupo() {
        try {
            System.out.println("Ya esta en el server");
            g = new Grupo();
            g.setIdGrupo(idGrupo);
            g.setDescripGrupo(descripcion);            
            ig.insertarGrupo(g);
            listarGrupos();                     
        } catch (Exception ex) {
            Logger.getLogger(GrupoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Grupo> listarGrupos() throws Exception {
        listarGru = ig.getGrupos();
        return listarGru;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Grupo getG() {
        return g;
    }

    public void setG(Grupo g) {
        this.g = g;
    }

    public IGrupoControlador getIg() {
        return ig;
    }

    public void setIg(IGrupoControlador ig) {
        this.ig = ig;
    }

    public List<Grupo> getListarGru() {
        return listarGru;
    }

    public void setListarGru(List<Grupo> listarGru) {
        this.listarGru = listarGru;
    }

    

}
