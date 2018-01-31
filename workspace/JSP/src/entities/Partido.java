package entities;
import java.sql.Date;

import entities.Equipo;

public class Partido {
	private int id;
	private Equipo equipoVisitante;
	private Equipo equipoLocal;
	private Date fechaInicio;
	private String resultado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}
