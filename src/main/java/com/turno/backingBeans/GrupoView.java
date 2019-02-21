/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.backingBeans;

import com.turno.controlador.IGrupoControlador;
import com.turno.controladorImpl.GrupoControladorImpl;
import com.turno.modelo.Entidades.Grupo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Doc1
 */
@ManagedBean
@ViewScoped
public class GrupoView {

    /**
     * Creates a new instance of GrupoView
     */
    
    private int idGrupo;
    private String descripGrupo;
    private Grupo grupo;
    private IGrupoControlador ig;
    private List<Grupo> listGrup;

    
    public GrupoView() {
        
    }
    
    @PostConstruct
    public void init() {
        try {
            ig = new GrupoControladorImpl();
                listarGrupos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertarGrupo() throws Exception {
        grupo = new Grupo();
        grupo.setIdGrupo(idGrupo);
        grupo.setDescripGrupo(descripGrupo);
        ig.insertarGrupo(grupo);
        
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage("Successful",  "Dato Guardado: " + grupo.getDescripGrupo()) );
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
        
        listarGrupos();
    }

    public List<Grupo> listarGrupos() {
        try {
            listGrup = ig.listarGrupo();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listGrup;
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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public IGrupoControlador getIg() {
        return ig;
    }

    public void setIg(IGrupoControlador ig) {
        this.ig = ig;
    }

    public List<Grupo> getListGrup() {
        return listGrup;
    }

    public void setListGrup(List<Grupo> listGrup) {
        this.listGrup = listGrup;
    }

}
