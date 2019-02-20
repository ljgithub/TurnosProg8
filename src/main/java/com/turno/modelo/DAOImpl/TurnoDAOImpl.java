package com.turno.modelo.DAOImpl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.turno.modelo.DAO.ITurnoDAO;
import com.turno.modelo.Entidades.Empleado;
import com.turno.modelo.Entidades.Turno;

public class TurnoDAOImpl extends GenericDAO<Turno> implements ITurnoDAO {

    public TurnoDAOImpl() {

    }

    public TurnoDAOImpl(Class<Turno> entiClass) {
        super(entiClass);
    }

    public void insertarTurno(Turno Turno) {
        this.beginTransaction();
        this.create(Turno);
        this.commit();
        this.closeTransaction();
    }

    public boolean actualizarTurno(Turno Turno) {
        try {
            this.beginTransaction();
            this.update(Turno);
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

    public List<Turno> getTurnos() {
         this.beginTransaction();
        List<Turno> lista = this.findAll();
        this.closeTransaction();
        return lista;
    }

    public Turno getTurno(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Turno getTurnoCI(String ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Turno> listarTurno() {
        this.beginTransaction();
        List<Turno> lista = this.findAll();
        this.closeTransaction();
        return lista;
    }

    public List<Turno> listarTurnoCQ() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Turno> cq = cb.createQuery(Turno.class);
        Root<Turno> Turno = cq.from(Turno.class);
        cq.select(Turno);
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Tuple> listarTurnoCQNombre() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> c = cb.createTupleQuery();
        Root<Turno> emp = c.from(Turno.class);
        c.select(cb.tuple(emp.get("id_turno"), emp.get("descripturno")));
        return entityManager.createQuery(c).getResultList();
    }

    public List<Tuple> listarTurnosCQMS() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> c = cb.createTupleQuery();
        Root<Turno> emp = c.from(Turno.class);
        c.multiselect(cb.tuple(emp.get("id_turno"), emp.get("descripturno")));
        return entityManager.createQuery(c).getResultList();
    }

    public List<Turno> listarTypedQuery() {
        TypedQuery<Turno> q2
                = entityManager.createQuery("Select c from turno c", Turno.class);
        return q2.getResultList();
    }

    public Turno listarTurnosParametros(int id) {
        try {
            TypedQuery<Turno> query = entityManager.createQuery(
                    "Select t from Turno t where t.idTurno = :id", Turno.class);
            return (Turno) query.setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Turno listarTurnosParametrosCT(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Turno> c = cb.createQuery(Turno.class);
        Root<Turno> emp = c.from(Turno.class);
        c.select(emp);
        c.where(cb.equal(emp.get("id_turno"), id));
        return entityManager.createQuery(c).getSingleResult();
    }

    public List<Tuple> listarTurnoTuple() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<Empleado> cliente = cq.from(Empleado.class);
        cq.select(cb.tuple(cliente.get("id_turno"), cliente.get("descripturno")));
        return this.entityManager.createQuery(cq).getResultList();
    }

}
