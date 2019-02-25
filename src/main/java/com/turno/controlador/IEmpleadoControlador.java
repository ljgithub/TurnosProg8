/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.controlador;

import com.turno.modelo.Entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Tuple;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
public interface IEmpleadoControlador {
    public void insertarEmpleado(Empleado empleado) throws Exception ;
    public boolean actualizarEmpleado(Empleado empleado)throws Exception;
    public boolean eliminar(Empleado empleado)throws Exception;
    public List<Empleado> listarEmpleado()throws Exception ;
    public List<Empleado> getEmpleados()throws Exception;
    public Empleado getEmpleado(int id)throws Exception;
    public Empleado getEmpleadoCI(String ci)throws Exception;
    public List<Tuple> listarEmpleadoTuple()throws Exception ;
    public List<Empleado> listarEmpleadoCQ ()throws Exception ;
    public List<Tuple> listarEmpleadoCQNombre()throws Exception ;
    public List<Tuple> listarEmpleadosCQMS()throws Exception ;
    public List<Empleado> listarTypedQuery()throws Exception ;
    public Empleado listarEmpleadosParametros(int id)throws Exception ;
    public Empleado listarEmpleadosParametrosCT(int id)throws Exception ;
    public List<Empleado> listarNombresColaboradores () throws Exception;
}
