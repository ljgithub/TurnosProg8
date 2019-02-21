package com.turno.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.turno.modelo.Entidades.Turno;

public interface ITurnoControlador  {

	public void insertarTurno(Turno Turno) throws Exception ;
    public boolean actualizarTurno(Turno Turno)throws Exception;
    public boolean eliminar(int id)throws Exception;
    public List<Tuple> listarTurno()throws Exception ;
    public List<Turno> getTurnos()throws Exception;
    public Turno getTurno(int id)throws Exception;
    public Turno getTurnoCI(String ci)throws Exception;
    public List<Tuple> listarTurnoTuple()throws Exception ;
    public List<Turno> listarTurnoCQ ()throws Exception ;
    public List<Tuple> listarTurnoCQNombre()throws Exception ;
    public List<Tuple> listarTurnosCQMS()throws Exception ;
    public List<Turno> listarTypedQuery()throws Exception ;
    public Turno listarTurnosParametros(int id)throws Exception ;
    public Turno listarTurnosParametrosCT(int id)throws Exception ;
}
