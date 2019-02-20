package com.turno.modelo.Entidades;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table (name = "turnos_virtuales")
public class TurnosVirtuales {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name ="id_turno_virtual")
	private long idTurnoVirtual;
	@Temporal(TemporalType.DATE)
	@Column(name ="fecha_virtual")
	private Date fechaVirtual;
	
	
	@ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name ="id_empleado")
	private Empleado empleado;

	@ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name ="id_grupo")
	private Grupo grupo;
	
	@ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name ="id_turno")
	private Turno turno;

	public TurnosVirtuales() {

	}

	public TurnosVirtuales(long idTurnoVirtual, Date fechaVirtual, Empleado empleado, Grupo grupo, Turno turno) {
		super();
		this.idTurnoVirtual = idTurnoVirtual;
		this.fechaVirtual = fechaVirtual;
		this.empleado = empleado;
		this.grupo = grupo;
		this.turno = turno;
	}

	public long getIdTurnoVirtual() {
		return idTurnoVirtual;
	}

	public void setIdTurnoVirtual(long idTurnoVirtual) {
		this.idTurnoVirtual = idTurnoVirtual;
	}

	public Date getFechaVirtual() {
		return fechaVirtual;
	}

	public void setFechaVirtual(Date fechaVirtual) {
		this.fechaVirtual = fechaVirtual;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "TurnosVirtuales [idTurnoVirtual=" + idTurnoVirtual + ", fechaVirtual=" + fechaVirtual + ", empleado="
				+ empleado + ", grupo=" + grupo + ", turno=" + turno + "]";
	}
	
	
	
	
	
}
