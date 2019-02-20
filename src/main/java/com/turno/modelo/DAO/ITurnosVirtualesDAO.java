package com.turno.modelo.DAO;

import java.util.List;

import javax.persistence.Tuple;

import com.turno.modelo.Entidades.TurnosVirtuales;

public interface ITurnosVirtualesDAO {
	public void insertarTurnosVirtuales(TurnosVirtuales TurnosVirtuales);
    public boolean actualizarTurnosVirtuales(TurnosVirtuales TurnosVirtuales);
    public boolean eliminar(int id);
    public List<TurnosVirtuales> getTurnosVirtualess();
    public TurnosVirtuales getTurnosVirtuales(int id);
    public TurnosVirtuales getTurnosVirtualesCI(String ci);
    public List<TurnosVirtuales> listarTurnosVirtuales();    
    public List<Tuple> listarTurnosVirtualesTuple();    
    public List<TurnosVirtuales> listarTurnosVirtualesCQ ();
    public List<Tuple> listarTurnosVirtualesCQNombre();
    public List<Tuple> listarTurnosVirtualessCQMS();
    public List<TurnosVirtuales> listarTypedQuery();
    public TurnosVirtuales listarTurnosVirtualessParametros(int id);
    public TurnosVirtuales listarTurnosVirtualessParametrosCT(int id);
}
