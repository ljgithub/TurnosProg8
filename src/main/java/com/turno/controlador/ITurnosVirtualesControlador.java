package com.turno.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.turno.modelo.Entidades.TurnosVirtuales;

public interface ITurnosVirtualesControlador {
	public void insertarTurnosVirtuales(TurnosVirtuales TurnosVirtuales) throws Exception ;
    public boolean actualizarTurnosVirtuales(TurnosVirtuales TurnosVirtuales)throws Exception;
    public boolean eliminar(int id)throws Exception;
    public List<Tuple> listarTurnosVirtuales()throws Exception ;
    public List<TurnosVirtuales> getTurnosVirtualess()throws Exception;
    public TurnosVirtuales getTurnosVirtuales(int id)throws Exception;
    public TurnosVirtuales getTurnosVirtualesCI(String ci)throws Exception;
    public List<Tuple> listarTurnosVirtualesTuple()throws Exception ;
    public List<TurnosVirtuales> listarTurnosVirtualesCQ ()throws Exception ;
    public List<Tuple> listarTurnosVirtualesCQNombre()throws Exception ;
    public List<Tuple> listarTurnosVirtualessCQMS()throws Exception ;
    public List<TurnosVirtuales> listarTypedQuery()throws Exception ;
    public TurnosVirtuales listarTurnosVirtualessParametros(int id)throws Exception ;
    public TurnosVirtuales listarTurnosVirtualessParametrosCT(int id)throws Exception ;
}
