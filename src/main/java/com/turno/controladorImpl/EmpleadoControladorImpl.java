/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.controladorImpl;

import com.turno.controlador.IEmpleadoControlador;
import com.turno.modelo.DAO.IEmpleadoDAO;
import com.turno.modelo.DAOImpl.EmpleadoDAOImpl;
import com.turno.modelo.Entidades.Empleado;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Tuple;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
public class EmpleadoControladorImpl implements IEmpleadoControlador {

    public void insertarEmpleado(Empleado empleado) throws Exception {
        try {
            IEmpleadoDAO sql = new EmpleadoDAOImpl(Empleado.class);
            sql.insertarEmpleado(empleado);
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }

    public boolean actualizarEmpleado(Empleado empleado) throws Exception {
        try {
            IEmpleadoDAO sql = new EmpleadoDAOImpl(Empleado.class);
            sql.actualizarEmpleado(empleado);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean eliminar(Empleado empleado) throws Exception {
        try {
            IEmpleadoDAO sql = new EmpleadoDAOImpl(Empleado.class);
            sql.eliminar(empleado);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public Empleado listarEmpleadosParametros(int id) {
        try {
            IEmpleadoDAO sql = new EmpleadoDAOImpl(Empleado.class);
            return sql.listarEmpleadosParametros(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Empleado> getEmpleados() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    public Empleado getEmpleado(int id) throws Exception {
        try {
            IEmpleadoDAO sql = new EmpleadoDAOImpl(Empleado.class);
            return sql.getEmpleado(id);

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }

    public Empleado getEmpleadoCI(String ci) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    public List<Empleado> listarEmpleadoCQ() {
        try {
            EmpleadoDAOImpl sql = new EmpleadoDAOImpl(Empleado.class);
            return sql.listarEmpleadoCQ();
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    public List<Tuple> listarEmpleadoCQNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    public List<Tuple> listarEmpleadosCQMS() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    public List<Empleado> listarTypedQuery() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }
    
    public Empleado listarEmpleadosParametrosCT(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    public List<Tuple> listarEmpleadoTuple() throws Exception {
        try {
            EmpleadoDAOImpl sql = new EmpleadoDAOImpl(Empleado.class);
            return sql.listarEmpleadoTuple();
        } catch (Exception e) {

            System.err.println("ERROR:" + e);
            return null;
        }
    }

    public List<Empleado> listarEmpleado() throws Exception {
       try {
            EmpleadoDAOImpl sql = new EmpleadoDAOImpl(Empleado.class);
            return sql.listarEmpleado();
        } catch (Exception e) {

            System.err.println("ERROR:" + e);
            return null;
        }
        // Tools | Templates.
    }

   
    public List<Empleado> listarNombresColaboradores() {
        try {
            IEmpleadoDAO eci = new EmpleadoDAOImpl();
            return eci.listarNombresColaboradores();
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

}
