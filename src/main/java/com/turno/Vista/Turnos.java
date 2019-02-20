/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.Vista;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import com.turno.controlador.IEmpleadoControlador;
import com.turno.controlador.IGrupoControlador;
import com.turno.controlador.ITurnoControlador;
import com.turno.controlador.ITurnosVirtualesControlador;
import com.turno.controladorImpl.EmpleadoControladorImpl;
import com.turno.controladorImpl.GrupoControladorImpl;
import com.turno.controladorImpl.TurnoControladorImpl;
import com.turno.controladorImpl.TurnosVirtualesControladorImpl;
import com.turno.helpers.Helpers;
import static com.turno.helpers.Helpers.diasPorMes;
import com.turno.modelo.DAO.ITurnoDAO;
import com.turno.modelo.Entidades.Empleado;
import com.turno.modelo.Entidades.Grupo;
import com.turno.modelo.Entidades.Turno;
import com.turno.modelo.Entidades.TurnosVirtuales;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
public class Turnos {

    public static void main(String[] args) {

        Helpers h = new Helpers();
        //h.crearColaboradores(5);
        //h.crearGrupos(5);
        
        h.crearHorarioMensualColaborador(1, 1, 1);
        h.crearHorarioMensualColaborador(2, 1, 1);
        h.crearHorarioMensualColaborador(3, 1, 1);
        h.crearHorarioMensualColaborador(4, 1, 1);
        h.crearHorarioMensualColaborador(5, 1, 1);
        
        h.crearHorarioMensualColaborador(6, 2, 1);
        h.crearHorarioMensualColaborador(7, 2, 1);
        h.crearHorarioMensualColaborador(8, 2, 1);
        h.crearHorarioMensualColaborador(9, 2, 1);
        h.crearHorarioMensualColaborador(10, 2, 1);
        
        h.crearHorarioMensualColaborador(11, 3, 1);
        h.crearHorarioMensualColaborador(12, 3, 1);
        h.crearHorarioMensualColaborador(13, 3, 1);
        h.crearHorarioMensualColaborador(14, 3, 1);
        h.crearHorarioMensualColaborador(15, 3, 1);
        
        h.crearHorarioMensualColaborador(16, 4, 1);
        h.crearHorarioMensualColaborador(17, 4, 1);
        h.crearHorarioMensualColaborador(18, 4, 1);
        h.crearHorarioMensualColaborador(19, 4, 1);
        h.crearHorarioMensualColaborador(20, 4, 1);       
        h.crearHorarioMensualColaborador(21, 4, 1);
        h.crearHorarioMensualColaborador(22, 4, 1);
        h.crearHorarioMensualColaborador(23, 4, 1);
        h.crearHorarioMensualColaborador(24, 4, 1);
        h.crearHorarioMensualColaborador(25, 4, 1);
        
         
        
        
        
        /***
         * TODO  
         * Autor:  Javier Morales
         * 
         * Para generar los horarios, se debe ingresar en el metodo crearHorarioMensualColaborador
         * 
         * 3 parametros de los cuales: 
         * 
         * El primero representa al id del empleado
         * El segundo representa al grupo al que se asigna al empleado
         * El tercer parametro tiene que ver con el mes que se va a generar el horario
         * 
         * 
         * 
         * Cada horario de cada colaborador esta adelantado con un turno por lo cual
         * por cada grupo se va a sumar un turno, lo cual en el reporte
         * No generara turnos repetidos para grupos distintos.
         */
        
        //h.crearHorarioMensualColaborador(2, 1, 2);

        // h.crearHorarioMensualColaborador(1, 1, 3);
     
        
    }
}
