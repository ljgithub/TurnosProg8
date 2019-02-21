/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.modelo.DAO;

import com.turno.modelo.Entidades.Turno;
import java.util.List;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
public interface ITurnoDAO {
    
     public void insertarTurno(Turno turno);

    public boolean actualizarTurno(Turno turno);

    public boolean eliminar(int id);

    public List<Turno> getTurnos();

    public Turno getTurno(int id);

    public Turno getTurnoCI(String ci);
    
    public List<Turno> listarTurno();
}
