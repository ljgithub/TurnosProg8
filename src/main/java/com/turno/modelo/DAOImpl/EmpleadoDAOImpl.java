/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.modelo.DAOImpl;

import com.turno.modelo.DAO.IEmpleadoDAO;
import com.turno.modelo.Entidades.Empleado;
import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
public class EmpleadoDAOImpl extends GenericDAO<Empleado> implements IEmpleadoDAO{

    ResultSet resultado = null;
    Statement sentencia = null;
    
    public EmpleadoDAOImpl(){
        
    }
    
    public EmpleadoDAOImpl(Class<Empleado> entiClass){
        super(entiClass);
    }
    
    
    public void insertarEmpleado(Empleado empleado) {
        this.beginTransaction();
        this.create(empleado);
        this.commit();
        this.closeTransaction();
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        try {
            this.beginTransaction();
            this.update(empleado);
            this.commit();
            this.closeTransaction();
            return true;
        } catch (Exception e) {
            System.out.println("Error:" + e.getStackTrace());
            return false;                 
        }
    }

    
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Empleado> getEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Empleado getEmpleado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Empleado getEmpleadoCI(String ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Empleado> listarEmpleado() {
        this.beginTransaction();
        List<Empleado> lista= this.findAll();
        this.closeTransaction();
        return lista;
    }
    
    public List<Empleado> listarEmpleadoCQ (){
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Empleado> cq = cb.createQuery(Empleado.class);
        Root<Empleado> empleado = cq.from(Empleado.class);
        cq.select(empleado);
        return entityManager.createQuery(cq).getResultList();        
    }
    
    public List<Tuple> listarEmpleadoCQNombre(){
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> c = cb.createTupleQuery();
        Root<Empleado> emp = c.from(Empleado.class);
        c.select(cb.tuple(emp.get("id"), emp.get("nombre")));
        return entityManager.createQuery(c).getResultList();
    }
    
    public List<Tuple> listarEmpleadosCQMS(){
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> c = cb.createTupleQuery();
        Root<Empleado> emp = c.from(Empleado.class);
        c.multiselect(cb.tuple(emp.get("id"), emp.get("nombre")));
        return entityManager.createQuery(c).getResultList();
    }
    
    public List<Empleado> listarTypedQuery(){
        TypedQuery<Empleado> q2 = 
                entityManager.createQuery("Select c from empleado c", Empleado.class );
        return q2.getResultList();
    }
    
    public Empleado listarEmpleadosParametros(int id){
        try {
            TypedQuery<Empleado> query = entityManager.createQuery(
        "Select e from Empleado e where e.idEmple = :id", Empleado.class);
     
            return (Empleado)query.setParameter("id", id).getSingleResult();
        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public Empleado listarEmpleadosParametrosCT(int id){
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<Empleado> c = cb.createQuery(Empleado.class);
        Root<Empleado> emp = c.from(Empleado.class);
        c.select(emp);
        c.where(cb.equal(emp.get("id"),id));
        return entityManager.createQuery(c).getSingleResult();
    }

    public List<Tuple> listarEmpleadoTuple() {
        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<Empleado> cliente= cq.from(Empleado.class);          
        cq.select(cb.tuple(cliente.get("id_emple"), cliente.get("nombres")));
        return this.entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Empleado> listarNombresColaboradores() {
        ArrayList<Empleado> lista_nombre_colaborador = new ArrayList<Empleado>();
        TypedQuery<Empleado> query = entityManager.createQuery(
        "Select e.nombres from Empleado e ", Empleado.class);
        this.beginTransaction();
        return query.getResultList();
    }
    
    
}
