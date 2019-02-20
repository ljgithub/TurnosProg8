package com.turno.modelo.DAOImpl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.turno.modelo.DAO.IGrupoDAO;
import com.turno.modelo.Entidades.Empleado;
import com.turno.modelo.Entidades.Grupo;

public class GrupoDAOImpl extends GenericDAO<Grupo> implements IGrupoDAO {

    public GrupoDAOImpl() {

    }

    public GrupoDAOImpl(Class<Grupo> entiClass) {
        super(entiClass);
    }

    public void insertarGrupo(Grupo Grupo) {
        this.beginTransaction();
        this.create(Grupo);
        this.commit();
        this.closeTransaction();
    }

    public boolean actualizarGrupo(Grupo Grupo) {
        try {
            this.beginTransaction();
            this.update(Grupo);
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

    public List<Grupo> getGrupos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Grupo getGrupo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Grupo getGrupoCI(String ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Grupo> listarGrupo() {
        this.beginTransaction();
        List<Grupo> lista = this.findAll();
        this.closeTransaction();
        return lista;
    }

    public List<Grupo> listarGrupoCQ() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Grupo> cq = cb.createQuery(Grupo.class);
        Root<Grupo> Grupo = cq.from(Grupo.class);
        cq.select(Grupo);
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Tuple> listarGrupoCQNombre() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> c = cb.createTupleQuery();
        Root<Grupo> emp = c.from(Grupo.class);
        c.select(cb.tuple(emp.get("id_grupo"), emp.get("descripgrupo")));
        return entityManager.createQuery(c).getResultList();
    }

    public List<Tuple> listarGruposCQMS() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> c = cb.createTupleQuery();
        Root<Grupo> emp = c.from(Grupo.class);
        c.multiselect(cb.tuple(emp.get("id_grupo"), emp.get("descripgrupo")));
        return entityManager.createQuery(c).getResultList();
    }

    public List<Grupo> listarTypedQuery() {
        TypedQuery<Grupo> q2
                = entityManager.createQuery("Select c from grupo c", Grupo.class);
        return q2.getResultList();
    }

    public Grupo listarGruposParametros(int id) {
        try {
            TypedQuery<Grupo> query = entityManager.createQuery(
                    "Select g from Grupo g where g.idGrupo = :id", Grupo.class);
            return (Grupo) query.setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Grupo listarGruposParametrosCT(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Grupo> c = cb.createQuery(Grupo.class);
        Root<Grupo> emp = c.from(Grupo.class);
        c.select(emp);
        c.where(cb.equal(emp.get("id_grupo"), id));
        return entityManager.createQuery(c).getSingleResult();
    }

    public List<Tuple> listarGrupoTuple() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<Empleado> cliente = cq.from(Empleado.class);
        cq.select(cb.tuple(cliente.get("id_grupo"), cliente.get("descripgrupo")));
        return this.entityManager.createQuery(cq).getResultList();
    }

}
