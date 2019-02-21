/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.modelo.DAO;

import com.turno.modelo.Entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Tuple;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
public interface IEmpleadoDAO {
    
    public void insertarEmpleado(Empleado empleado);
    public boolean actualizarEmpleado(Empleado empleado);
    public boolean eliminar(int id);
    public List<Empleado> getEmpleados();
    public Empleado getEmpleado(int id);
    public Empleado getEmpleadoCI(String ci);
    public List<Empleado> listarEmpleado();    
    public List<Tuple> listarEmpleadoTuple();    
    public List<Empleado> listarEmpleadoCQ ();
    public List<Tuple> listarEmpleadoCQNombre();
    public List<Tuple> listarEmpleadosCQMS();
    public List<Empleado> listarTypedQuery();
    public Empleado listarEmpleadosParametros(int id);
    public Empleado listarEmpleadosParametrosCT(int id);
    public List<Empleado> listarNombresColaboradores();
}

