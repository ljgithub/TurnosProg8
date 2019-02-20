package com.turno.controladorImpl;

import java.util.List;

import javax.persistence.Tuple;

import com.turno.controlador.ITurnosVirtualesControlador;
import com.turno.modelo.DAO.ITurnosVirtualesDAO;
import com.turno.modelo.DAOImpl.TurnosVirtualesDAOImpl;
import com.turno.modelo.Entidades.TurnosVirtuales;

public class TurnosVirtualesControladorImpl implements ITurnosVirtualesControlador {


    public void insertarTurnosVirtuales(TurnosVirtuales TurnosVirtuales) throws Exception {
        try {
        ITurnosVirtualesDAO sql = new TurnosVirtualesDAOImpl(TurnosVirtuales.class);
        sql.insertarTurnosVirtuales(TurnosVirtuales);
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }

    
    public boolean actualizarTurnosVirtuales(TurnosVirtuales TurnosVirtuales) throws Exception {
        try {
            ITurnosVirtualesDAO sql = new TurnosVirtualesDAOImpl(TurnosVirtuales.class);
            sql.actualizarTurnosVirtuales(TurnosVirtuales);            
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
            return false;
        }
        return true;
    }

    
    public boolean eliminar(int id) throws Exception {
        try {
            ITurnosVirtualesDAO sql = new TurnosVirtualesDAOImpl(TurnosVirtuales.class);
            sql.eliminar(id);            
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
            return false;
        }
        return true;
    }

    
    public List<TurnosVirtuales> getTurnosVirtualess() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public TurnosVirtuales getTurnosVirtuales(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public TurnosVirtuales getTurnosVirtualesCI(String ci) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<TurnosVirtuales> listarTurnosVirtualesCQ() {
        try {
            TurnosVirtualesDAOImpl sql = new TurnosVirtualesDAOImpl(TurnosVirtuales.class);
            return sql.listarTurnosVirtualesCQ();
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    
    public List<Tuple> listarTurnosVirtualesCQNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Tuple> listarTurnosVirtualessCQMS() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<TurnosVirtuales> listarTypedQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public TurnosVirtuales listarTurnosVirtualessParametros(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public TurnosVirtuales listarTurnosVirtualessParametrosCT(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Tuple> listarTurnosVirtualesTuple() throws Exception {
        try {
            TurnosVirtualesDAOImpl sql = new TurnosVirtualesDAOImpl(TurnosVirtuales.class);
            return sql.listarTurnosVirtualesTuple();
        } catch (Exception e) {

            System.err.println("ERROR:" + e);
            return null;
        }
    }

    
    public List<Tuple> listarTurnosVirtuales() throws Exception {
    	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
}
