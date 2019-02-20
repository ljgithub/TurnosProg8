package com.turno.controladorImpl;

import java.util.List;

import javax.persistence.Tuple;

import com.turno.controlador.IGrupoControlador;
import com.turno.modelo.DAO.IGrupoDAO;
import com.turno.modelo.DAOImpl.EmpleadoDAOImpl;
import com.turno.modelo.DAOImpl.GrupoDAOImpl;
import com.turno.modelo.Entidades.Empleado;
import com.turno.modelo.Entidades.Grupo;

public class GrupoControladorImpl implements IGrupoControlador {

    public void insertarGrupo(Grupo Grupo) throws Exception {
        try {
            IGrupoDAO sql = new GrupoDAOImpl(Grupo.class);
            sql.insertarGrupo(Grupo);
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }

    public boolean actualizarGrupo(Grupo Grupo) throws Exception {
        try {
            IGrupoDAO sql = new GrupoDAOImpl(Grupo.class);
            sql.actualizarGrupo(Grupo);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean eliminar(int id) throws Exception {
        try {
            IGrupoDAO sql = new GrupoDAOImpl(Grupo.class);
            sql.eliminar(id);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
        return true;
    }

    public List<Grupo> getGrupos() throws Exception {
        try {
            IGrupoDAO sql = new GrupoDAOImpl(Grupo.class);
            return sql.listarGrupo();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return null;
        }        
    }

    public Grupo getGrupo(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Grupo getGrupoCI(String ci) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Grupo> listarGrupoCQ() {
        try {
            GrupoDAOImpl sql = new GrupoDAOImpl(Grupo.class);
            return sql.listarGrupoCQ();
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    public List<Tuple> listarGrupoCQNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Tuple> listarGruposCQMS() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Grupo> listarTypedQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Grupo listarGruposParametros(int id) {
        try {
            GrupoDAOImpl sql = new GrupoDAOImpl(Grupo.class);
            return sql.listarGruposParametros(id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Grupo listarGruposParametrosCT(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Tuple> listarGrupoTuple() throws Exception {
        try {
            GrupoDAOImpl sql = new GrupoDAOImpl(Grupo.class);
            return sql.listarGrupoTuple();
        } catch (Exception e) {

            System.err.println("ERROR:" + e);
            return null;
        }
    }

    public List<Tuple> listarGrupo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
}
