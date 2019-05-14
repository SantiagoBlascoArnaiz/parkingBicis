package practica1;

import java.util.ArrayList;

import practica1.Coordenadas;
/**
 * Gestión y creación de un parking de bicis.
 * Permite la creación y gestión de un parking de bicis, conocer si hay anclajes disponibles, anclajes ocupados, el número de anclajes ocupados y el estado de un anclaje en concreto, 
 * obtener el identificador de un parking, saber las coordenadas en las que está ubicado un parking y la distancia de otro punto u otro parking a estas.
 * @author PatAgua
 * @author SanBlas
 *
 */
public class CityBikeParkingPoint {

	private ArrayList<Boolean> anclajes;
	
	private Coordenadas coordenadas;
	private String identificador;
	
	private int sizeParking;
	/**
	 * Crea un nuevo parking con un identificador único en las coordenadas indicadas, y con el número de anclajes solicitado, todos ellos vacíos.
	 * @param numeroAnclajes debe ser un entero positivo.
	 * @param coordenadas en las que se situará el parking. Deben ser del tipo Coordenadas.
	 * @throws IllegalArgumentException El objeto coordenadas no puede ser nulo o vacío.
	 * @throws IllegalArgumentException Los anclajes deben ser positivos.
	 */
	public CityBikeParkingPoint(int numeroAnclajes, Coordenadas coordenadas) {
		if (coordenadas == null){
			throw new IllegalArgumentException("El objeto coordenadas tiene valor null.");
		}else{
			if (numeroAnclajes > 0){
				sizeParking = numeroAnclajes;
				
				this.coordenadas = new Coordenadas(coordenadas.getGradosLatitud(), coordenadas.getMinutosLatitud(), coordenadas.getSegundosLatitud(), coordenadas.getPuntoCardinalLatitud(), coordenadas.getGradosLongitud(), coordenadas.getMinutosLongitud(), coordenadas.getSegundosLongitud(), coordenadas.getPuntoCardinalLongitud());
				
				anclajes = new ArrayList<Boolean>();
				
				identificador = "" + coordenadas.getGradosLatitud() + coordenadas.getMinutosLatitud() + coordenadas.getSegundosLatitud() + coordenadas.getPuntoCardinalLatitud() + coordenadas.getGradosLongitud() + coordenadas.getMinutosLongitud() + coordenadas.getSegundosLongitud() + coordenadas.getPuntoCardinalLongitud();
				
				for (int i = 0; i < sizeParking; i++) {
							
							anclajes.add(false);
				}
			}else{
			throw new IllegalArgumentException("Los anclajes deben ser positivos.");
			}
		}
	}
	/**
	 * Calcula el número de anclajes ocupados que hay en el parking.
	 * @return únicamente números enteros mayores o iguales que 0.
	 */
	public int numeroDeAnclajesOcupados (){
		int anclajesOcupados = 0;
		for (int i = 0; i < anclajes.size(); i++) {
			if (anclajes.get(i) == true) {
				anclajesOcupados++;
			}
		}
		return anclajesOcupados;
	}
	/**
	 * Informa sobre si hay anclajes disponibles.
	 * @return devuelve true en caso de que así sea, false sino.
	 */
	public Boolean anclajesDisponibles () {
		if (anclajes.contains(false)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Informa sobre si hay bicis disponibles.
	 * @return devuelve true en caso de que así sea, false sino.
	 */
	public Boolean anclajesOcupados () {
		if (anclajes.contains(true)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Consulta las coordenadas en las que está ubicado el parking.
	 * @return coordendas del parking del tipo Coordenadas.
	 */
	public Coordenadas getCoordeandasParking () {
		Coordenadas copia = coordenadas;
		return copia;
	}
	/**
	 * Consulta el identificador de un parking, será único en el sistema.
	 * @return string formado por la concatenación de sus coordenadas GPS dadas en GMS.
	 */
	public String getIdentificador () {
		return identificador;
	}
	/**
	 * Consulta el tamaño del parking.
	 * @return Número entero mayor o igual que 1.
	 */
	public int getSizeParking () {
		return sizeParking;
	}
	/**
	 * Consulta si un anclaje en concreto está ocupado o libre.
	 * @param numeroDelAnclaje anclaje del que se desea saber el estado, debe existir.
	 * @return estado del anclaje de tipo boolean (true si está ocupado, false si está libre).
	 * @throws IllegalArgumentException El número del anclaje debe existir.
	 */
	public Boolean estadoDelAnclaje (int numeroDelAnclaje) {
		if (numeroDelAnclaje >= 0 && numeroDelAnclaje < sizeParking){
			return anclajes.get(numeroDelAnclaje);
		}else{
			throw new IllegalArgumentException("El número de anclaje debe estar comprendido entre 0 y " + (sizeParking-1) + ".");
		}
	}
	/**
	 * Cambia el estado de un anclaje de true a false si este se encontraba en true.
	 * @param numeroDelAnclaje anclaje que se desea cambiar de estado.
	 * @throws IllegalStateException Debe haber una bici en el anclaje.
	 * @throws IllegalArgumentException El número del anclaje debe existir.
	 */
	public void darBici ( int numeroDelAnclaje){
		if (numeroDelAnclaje >= 0 && numeroDelAnclaje < sizeParking){
			if (estadoDelAnclaje(numeroDelAnclaje) == true){
				anclajes.set(numeroDelAnclaje, false);
			}else{
				throw new IllegalStateException("No hay una bici en ese anclaje.");
			}
		}else{
			throw new IllegalArgumentException("El número de anclaje debe estar comprendido entre 0 y " + (sizeParking-1) + ".");
		}
	}
	/**
	 * Cambia el estado de un anclaje de false a true si este se encontraba en false.
	 * @param numeroDelAnclaje anclaje que se desea cambiar de estado.
	 * @throws IllegalStateException El anclaje debe estar vacío.
	 * @throws IllegalArgumentException El número del anclaje debe existir.
	 */
	public void recibirBici ( int numeroDelAnclaje){
		if (numeroDelAnclaje >= 0 && numeroDelAnclaje < sizeParking){
			if (estadoDelAnclaje(numeroDelAnclaje) == false){
				anclajes.set(numeroDelAnclaje, true);
			}else{
				throw new IllegalStateException("El anclaje ya está ocupado.");
			}
		}else{
			throw new IllegalArgumentException("El número de anclaje debe estar comprendido entre 0 y " + (sizeParking-1) + ".");
		}
	}
	/**
	 * Obtiene la distancia desde un parking a otro.
	 * @param otroParking parking del cual se desea saber la distancia a la que se encuentra. Del tipo CityBikeParkingPoint.
	 * @return número decimal mayor o igual que 0.
	 * @throws IllegalArgumentException El objeto parking no puede ser nulo o vacío.
	 */
	public double distanciaHastaElParking (CityBikeParkingPoint otroParking) {
		if (otroParking == null){
			throw new IllegalArgumentException("El objeto parking tiene valor null.");
		}else{
		return coordenadas.distancia(otroParking.getCoordeandasParking());
		}
	}
	/**
	 * Obtiene la distancia desde un parking a un punto de coordenadas.
	 * @param coordenadas de las cual se desea saber la distancia a la que se encuentran. Del tipo Coordenadas.
	 * @return número decimal mayor o igual que 0.
	 * @throws IllegalArgumentException El objeto coordenadas no puede ser nulo o vacío.
	 */
	public double distanciaHastaElParking (Coordenadas coordenadas) {
		if (coordenadas == null){
			throw new IllegalArgumentException("El objeto coordenadas tiene valor null.");
		}else{
		return this.coordenadas.distancia(coordenadas);
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityBikeParkingPoint other = (CityBikeParkingPoint) obj;
		if (anclajes == null) {
			if (other.anclajes != null)
				return false;
		} else if (!anclajes.equals(other.anclajes))
			return false;
		if (coordenadas == null) {
			if (other.coordenadas != null)
				return false;
		} else if (!coordenadas.equals(other.coordenadas))
			return false;
		if (sizeParking != other.sizeParking)
			return false;
		return true;
	}
	
}
