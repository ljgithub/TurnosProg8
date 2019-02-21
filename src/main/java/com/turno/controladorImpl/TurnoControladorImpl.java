package com.turno.controladorImpl;

import java.util.List;

import javax.persistence.Tuple;

import com.turno.controlador.ITurnoControlador;
import com.turno.modelo.DAO.ITurnoDAO;
import com.turno.modelo.DAOImpl.GrupoDAOImpl;
import com.turno.modelo.DAOImpl.TurnoDAOImpl;
import com.turno.modelo.Entidades.Grupo;
import com.turno.modelo.Entidades.Turno;

public class TurnoControladorImpl implements ITurnoControlador{


    public void insertarTurno(Turno Turno) throws Exception {
        try {
        ITurnoDAO sql = new TurnoDAOImpl(Turno.class);
        sql.insertarTurno(Turno);
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }

    
    public boolean actualizarTurno(Turno Turno) throws Exception {
        try {
            ITurnoDAO sql = new TurnoDAOImpl(Turno.class);
            sql.actualizarTurno(Turno);            
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
            return false;
        }
        return true;
    }

    
    public boolean eliminar(int id) throws Exception {
        try {
            ITurnoDAO sql = new TurnoDAOImpl(Turno.class);
            sql.eliminar(id);            
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
            return false;
        }
        return true;
    }

    
    public List<Turno> getTurnos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Turno getTurno(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Turno getTurnoCI(String ci) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Turno> listarTurnoCQ() {
        try {
            TurnoDAOImpl sql = new TurnoDAOImpl(Turno.class);
            return sql.listarTurnoCQ();
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    
    public List<Tuple> listarTurnoCQNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Tuple> listarTurnosCQMS() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Turno> listarTypedQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Turno listarTurnosParametros(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Turno listarTurnosParametrosCT(int id) {
        try {
            TurnoDAOImpl sql = new TurnoDAOImpl(Turno.class);
            return sql.listarTurnosParametros(id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public List<Tuple> listarTurnoTuple() throws Exception {
        try {
            TurnoDAOImpl sql = new TurnoDAOImpl(Turno.class);
            return sql.listarTurnoTuple();
        } catch (Exception e) {

            System.err.println("ERROR:" + e);
            return null;
        }
    }

    
    public List<Tuple> listarTurno() throws Exception {
    	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }


}
