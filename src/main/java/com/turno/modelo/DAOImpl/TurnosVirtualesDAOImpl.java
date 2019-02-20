package com.turno.modelo.DAOImpl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.turno.modelo.DAO.ITurnosVirtualesDAO;
import com.turno.modelo.Entidades.Empleado;
import com.turno.modelo.Entidades.TurnosVirtuales;

public class TurnosVirtualesDAOImpl extends GenericDAO<TurnosVirtuales> implements ITurnosVirtualesDAO {

    public TurnosVirtualesDAOImpl() {

    }

    public TurnosVirtualesDAOImpl(Class<TurnosVirtuales> entiClass) {
        super(entiClass);
    }

    public void insertarTurnosVirtuales(TurnosVirtuales TurnosVirtuales) {
        this.beginTransaction();
        this.create(TurnosVirtuales);
        this.commit();
        this.closeTransaction();
    }

    public boolean actualizarTurnosVirtuales(TurnosVirtuales TurnosVirtuales) {
        try {
            this.beginTransaction();
            this.update(TurnosVirtuales);
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

    public List<TurnosVirtuales> getTurnosVirtualess() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TurnosVirtuales getTurnosVirtuales(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TurnosVirtuales getTurnosVirtualesCI(String ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<TurnosVirtuales> listarTurnosVirtuales() {
        this.beginTransaction();
        List<TurnosVirtuales> lista = this.findAll();
        this.closeTransaction();
        return lista;
    }

    public List<TurnosVirtuales> listarTurnosVirtualesCQ() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<TurnosVirtuales> cq = cb.createQuery(TurnosVirtuales.class);
        Root<TurnosVirtuales> TurnosVirtuales = cq.from(TurnosVirtuales.class);
        cq.select(TurnosVirtuales);
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Tuple> listarTurnosVirtualesCQNombre() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> c = cb.createTupleQuery();
        Root<TurnosVirtuales> emp = c.from(TurnosVirtuales.class);
        c.select(cb.tuple(emp.get("id_turno_virtual"), emp.get("fecha_virtual")));
        return entityManager.createQuery(c).getResultList();
    }

    public List<Tuple> listarTurnosVirtualessCQMS() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> c = cb.createTupleQuery();
        Root<TurnosVirtuales> emp = c.from(TurnosVirtuales.class);
        c.multiselect(cb.tuple(emp.get("id_turno_virtual"), emp.get("fecha_virtual")));
        return entityManager.createQuery(c).getResultList();
    }

    public List<TurnosVirtuales> listarTypedQuery() {
        TypedQuery<TurnosVirtuales> q2
                = entityManager.createQuery("Select c from turnos_virtuales c", TurnosVirtuales.class);
        return q2.getResultList();
    }

    public TurnosVirtuales listarTurnosVirtualessParametros(int id) {
        try {
            TypedQuery<TurnosVirtuales> query = entityManager.createQuery(
                    "Select tv from TurnosVirtuales tv where tv.idTurnoVirtual :id", TurnosVirtuales.class);
            return (TurnosVirtuales) query.setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public TurnosVirtuales listarTurnosVirtualessParametrosCT(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TurnosVirtuales> c = cb.createQuery(TurnosVirtuales.class);
        Root<TurnosVirtuales> emp = c.from(TurnosVirtuales.class);
        c.select(emp);
        c.where(cb.equal(emp.get("id_turno_virtual"), id));
        return entityManager.createQuery(c).getSingleResult();
    }

    public List<Tuple> listarTurnosVirtualesTuple() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<Empleado> cliente = cq.from(Empleado.class);
        cq.select(cb.tuple(cliente.get("id_turno_virtual"), cliente.get("fecha_virtual")));
        return this.entityManager.createQuery(cq).getResultList();
    }

}
