package logic;

import data.DataJugador;
import entities.Jugador;
import utils.ApplicationException;

public class ControladorABMCJugador {
	private Jugador jug;
	private DataJugador dataJug;
	
	public ControladorABMCJugador(){
		dataJug = new DataJugador();
	}
	
	public void agregarJugador(Jugador j) throws ApplicationException{
		
		if(!dataJug.coincideNombre(j)) {
			dataJug.add(j);
		} else
		{
			throw new ApplicationException("Ya existe un jugador con ese nombre");
		}
	}
	
}
