package com.turno.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.turno.modelo.Entidades.Grupo;

public interface IGrupoControlador {
    public void insertarGrupo(Grupo Grupo) throws Exception ;
    public boolean actualizarGrupo(Grupo Grupo)throws Exception;
    public boolean eliminar(int id)throws Exception;
    public List<Grupo> listarGrupo()throws Exception ;
    public List<Grupo> getGrupos()throws Exception;
    public Grupo getGrupo(int id)throws Exception;
    public Grupo getGrupoCI(String ci)throws Exception;
    public List<Tuple> listarGrupoTuple()throws Exception ;
    public List<Grupo> listarGrupoCQ ()throws Exception ;
    public List<Tuple> listarGrupoCQNombre()throws Exception ;
    public List<Tuple> listarGruposCQMS()throws Exception ;
    public List<Grupo> listarTypedQuery()throws Exception ;
    public Grupo listarGruposParametros(int id)throws Exception ;
    public Grupo listarGruposParametrosCT(int id)throws Exception ;
}
