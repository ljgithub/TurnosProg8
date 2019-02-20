/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.modelo.DAO;

import com.turno.modelo.Entidades.Grupo;
import java.util.List;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
public interface IGrupoDAO {
    public void insertarGrupo(Grupo grupo);

    public boolean actualizarGrupo(Grupo grupo);

    public boolean eliminar(int id);

    public List<Grupo> getGrupos();

    public Grupo getGrupo(int id);

    public Grupo getGrupoCI(String ci);
    
    public List<Grupo> listarGrupo();
    
    
}
