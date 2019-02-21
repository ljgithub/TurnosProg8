/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.helpers;

import com.turno.controlador.IEmpleadoControlador;
import com.turno.controlador.IGrupoControlador;
import com.turno.controlador.ITurnoControlador;
import com.turno.controlador.ITurnosVirtualesControlador;
import com.turno.controladorImpl.EmpleadoControladorImpl;
import com.turno.controladorImpl.GrupoControladorImpl;
import com.turno.controladorImpl.TurnoControladorImpl;
import com.turno.controladorImpl.TurnosVirtualesControladorImpl;
import com.turno.modelo.Entidades.Empleado;
import com.turno.modelo.Entidades.Grupo;
import com.turno.modelo.Entidades.Turno;
import com.turno.modelo.Entidades.TurnosVirtuales;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
public class Helpers {

    public static int diasPorMes(int mes, int anio) {
        int numDias;
        Calendar fecha = Calendar.getInstance();
        fecha.set(anio, mes, 0);
        numDias = fecha.getActualMaximum(Calendar.DAY_OF_MONTH);
        return numDias;
    }

    public static void crearColaboradores(int numColaboradores) {
        Empleado em = new Empleado();
        try {
            for (int i = 1; i <= numColaboradores; i++) {
                em.setIdEmple(i);
                em.setNombres("Colaborador" + i);
                em.setTelefono(String.valueOf(new Random(i).nextInt(i + 2220)));
                IEmpleadoControlador iem = new EmpleadoControladorImpl();
                iem.insertarEmpleado(em);
            }
        } catch (Exception e) {
            System.out.println("El empleado no puede ser ingresado, revise la causa interna del error para         mas información\n"
                    + e.getStackTrace());
        }
    }

    public static void crearGrupos(int numGrupos) {
        Grupo gr = new Grupo();
        try {
            for (int i = 1; i <= numGrupos; i++) {
                gr.setIdGrupo(i);
                gr.setDescripGrupo("Grupo" + i);
                IGrupoControlador igc = new GrupoControladorImpl();
                igc.insertarGrupo(gr);
            }
        } catch (Exception e) {
            System.out.println("El empleado no puede ser ingresado, revise la causa interna del error para         mas información\n"
                    + e.getStackTrace());
        }
    }

    public static boolean crearHorarioMensualColaborador(int id_colaborador, int id_grupo, int mes) {
        try {
            int anio ;
            int numeroDias;
            mes = mes-1;
            GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
            Date fecha = new Date();          
            anio = cal.get(Calendar.YEAR);
            cal.set(anio, mes, 1);
            mes = mes+1;
            numeroDias = diasPorMes(mes, anio);
            Turno t = new Turno();
            TurnosVirtuales tv = new TurnosVirtuales();
            Empleado em = new Empleado();
            Grupo g = new Grupo();

            IEmpleadoControlador iemc = new EmpleadoControladorImpl();
            em = iemc.listarEmpleadosParametros(id_colaborador);

            IGrupoControlador igc = new GrupoControladorImpl();
            g = igc.listarGruposParametros(id_grupo);

            ITurnoControlador itc = new TurnoControladorImpl();
            int j = id_grupo;
            switch (j) {
                case 1:
                    j = 1;
                    break;
                case 2:
                    j = 2;
                    break;
                case 3:
                    j = 3;
                    break;
                case 4:
                    j = 4;
                    break;
                case 5:
                    j = 4;
                    break;
            }
            
            for (int i = 1; i <= numeroDias; i++) {
                //tv.setIdTurnoVirtual(i);
                tv.setFechaVirtual(cal.getTime());
                tv.setEmpleado(em);
                tv.setGrupo(g);

                if (j >= 5) {
                    if ((j % 5) == 0) {
                        j = 1;
                    }
                }
                t = itc.listarTurnosParametrosCT(j);
                j++;
                tv.setTurno(t);
                ITurnosVirtualesControlador itvc = new TurnosVirtualesControladorImpl();
                itvc.actualizarTurnosVirtuales(tv);
                cal.add((GregorianCalendar.DAY_OF_MONTH), 1);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
