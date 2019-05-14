package practica1;

import fabricante.externo.tarjetas.TarjetaMonedero;
import practica1.CityBikeParkingPoint;

import java.util.ArrayList;
/**
 * Gestión y creación de un sistema de alquiler de bicis.
 * Permite la creación del sistema y su gestión, la adición y supresión de puntos de aparcamiento, el prestamo y recogida de bicis, el cambio del valor de la fianza, 
 * conocer información tal como los parkings con anclajes disponibles, bicis disponibles y que se encuentran en un area centrada en unas coordenadas.
 * @author PatAgua
 * @author SanBlas
 *
 */
public class CityBikeSystem {
	
	private ArrayList<CityBikeParkingPoint> listaParkings;
	private double fianza;
	/**
	 * Crea un nuevo sistema con una fianza inicial de 25 unidades monetarias.
	 */
	public CityBikeSystem() {
		listaParkings = new ArrayList<CityBikeParkingPoint>();
		fianza = 25.0;
	}
	/**
	 * Introduce en el sistema un parking.
	 * @param parking debe ser de tipo CityBikeParkingPoint y no puede haber dos con las mismas coordenadas exactas ni el mismo identificador.
	 * @throws IllegalArgumentException El objeto parking no puede ser nulo o vacío.
	 * @throws IllegalStateException No puede haber dos parkings en el sistema con las mismas coordenadas.
	 */
	public void addParking(CityBikeParkingPoint parking) {
		if (parking == null){
			throw new IllegalArgumentException("El objeto parking tiene valor null.");
		}else{
			if (parkingsEnElRadio(0,parking.getCoordeandasParking()).size() == 0){ //Si el radio es 0 comprueba si hay un parking en esas coordenadas,por tanto si lo hubiese querría decir que ya existe un parking con esas coordenadas en el sistema
				listaParkings.add(parking);
			}else{
				throw new IllegalStateException("Ya existe un parking en esas coordenadas exactas.");
			}
		}
	}
	/**
	 * Elimina del sistema un parking.
	 * @param parking debe ser de tipo CityBikeParkingPoint.
	 * @throws IllegalArgumentException El objeto parking no puede ser nulo o vacío.
	 * @throws IllegalStateException El parking debe estar en el sistema.
	 */
	public void eliminarParking (CityBikeParkingPoint parking) {
		if (parking == null){
			throw new IllegalArgumentException("El objeto parking tiene valor null.");
		}else{
			if (listaParkings.contains(parking) == true){
				listaParkings.remove(parking);
			}else{
				throw new IllegalStateException("Ese parking no está en el sistema.");
			}
		}
	}
	/**
	 * Consulta los parkings que existen dentro del sistema.
	 * @return un arraylist cuyos elementos serán referencias a objetos tipo CityBikeParkingPoint.
	 */
	public ArrayList<CityBikeParkingPoint> getParkings(){
		ArrayList<CityBikeParkingPoint> copiaListaParkings = new ArrayList<CityBikeParkingPoint>();
		for (int i = 0; i < listaParkings.size(); i++){
			CityBikeParkingPoint copia = listaParkings.get(i);
			copiaListaParkings.add(copia);
		}
		return copiaListaParkings;
	}
	/**
	 * Cambia el valor de la fianza por uno nuevo.
	 * @param nuevaFianza debe ser un número decimal estrictamente positivo.
	 * @throws IllegalArgumentException La fianza no puede ser nula ni negativa.
	 */
	public void cambiarFianza(double nuevaFianza){
		if (nuevaFianza > 0){
			fianza = nuevaFianza;
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor negativo o nulo para la fianza.");
		}
	}
	/**
	 * Consulta el valor de la fianza.
	 * @return un double estrictamente positivo.
	 */
	public double getFianza (){
		return fianza;
	}
	/**
	 * Consulta los parkings en los que hay sitio para aparcar una bici.
	 * @return un arraylist cuyos elementos serán objetos tipo CityBikeParkingPoint.
	 */
	public ArrayList<CityBikeParkingPoint> parkingsConAnclajesDisponibles(){
	    ArrayList<CityBikeParkingPoint> parkingsConAnclajesDisponibles = new ArrayList<CityBikeParkingPoint>();
	    for (int i = 0; i < listaParkings.size(); i++) {
	    	if (listaParkings.get(i).anclajesDisponibles() == true) {
	    		CityBikeParkingPoint copia = listaParkings.get(i);
	    		parkingsConAnclajesDisponibles.add(copia);
	    	}
	    }
	    return parkingsConAnclajesDisponibles;
	}
	/**
	 * Consulta los parkings en los que hay bicis disponibles.
	 * @return un arraylist cuyos elementos serán referencias a objetos tipo CityBikeParkingPoint.
	 */
	public ArrayList<CityBikeParkingPoint> parkingsConBicisDisponibles(){
	    ArrayList<CityBikeParkingPoint> parkingsConBicisDisponibles = new ArrayList<CityBikeParkingPoint>();
	    for (int i = 0; i < listaParkings.size(); i++) {
	    	if (listaParkings.get(i).anclajesOcupados() == true) {
	    		CityBikeParkingPoint copia = listaParkings.get(i);
	    		parkingsConBicisDisponibles.add(copia);
	    	}
	    }
	    return parkingsConBicisDisponibles;
	}
	/**
	 * Consulta los parkings que se encuentran en el area circular con un determinado radio y centrada en un punto de coordenadas.
	 * @param radio dado en metros. Debe ser mayor o igual que 0.
	 * @param coordenadas en las que se centra la búsqueda. Debe ser del tipo Coordenadas.
	 * @return un arraylist cuyos elementos serán objetos tipo CityBikeParkingPoint.
	 * @throws IllegalArgumentException El objeto coordenadas no puede ser nulo o vacío.
	 * @throws IllegalArgumentException El radio no puede ser negativo.
	 */
	public ArrayList<CityBikeParkingPoint> parkingsEnElRadio(double radio, Coordenadas coordenadas){
		if (coordenadas == null){
			throw new IllegalArgumentException("El objeto coordenadas tiene valor null.");
		}else{
			if (radio >= 0){
				ArrayList<CityBikeParkingPoint> parkingsEnElRadio = new ArrayList<CityBikeParkingPoint>();
			    for (int i = 0; i < listaParkings.size(); i++) {
			    	if (listaParkings.get(i).distanciaHastaElParking(coordenadas) <= radio) {
			    		CityBikeParkingPoint copia = listaParkings.get(i);
			    		parkingsEnElRadio.add(copia);
			    	}
			    }
			    return parkingsEnElRadio;
			}else{
				throw new IllegalArgumentException("Se ha introducido un valor negativo para el radio.");
			}
		}
	}
	/**
	 * Permite al sistema liberar una bici de su anclaje en un parking para prestarla a un usuario.
	 * @param parking donde se encuentra la bici que se presta.
	 * @param numeroDelAnclaje anclaje donde está aparcada la bici. El anclaje debe existir.
	 * @param credencial aportada por el código cliente por razones de seguridad para obtener el permiso necesario para descontar saldo.
	 * @param tarjeta del tipo TarjetaMonedero, debe contener un saldo igual o superior a la fianza.
	 * @throws IllegalArgumentException El objeto parking no puede ser nulo o vacío.
	 * @throws IllegalArgumentException El objeto tarjeta no puede ser nulo o vacío.
	 * @throws IllegalStateException Debe haber una bici en el anclaje.
	 * @throws IllegalArgumentException El anclaje debe existir.
	 */
	public void prestarBici(CityBikeParkingPoint parking, int numeroDelAnclaje, String credencial, TarjetaMonedero tarjeta){
		if (parking == null){
			throw new IllegalArgumentException("El objeto parking tiene valor null.");
		}else if (tarjeta == null){
			throw new IllegalArgumentException("El objeto tarjeta tiene valor null.");
		}else{
			if (numeroDelAnclaje >= 0 && numeroDelAnclaje < parking.getSizeParking()){
				if (parking.estadoDelAnclaje(numeroDelAnclaje) == true){
					tarjeta.descontarDelSaldo(credencial, fianza);
					parking.darBici(numeroDelAnclaje);
				}else{
					throw new IllegalStateException("No hay una bici en ese anclaje.");
				}
			}else{
				throw new IllegalArgumentException("Se ha introducido un anclaje inexistente.");
			}
		}
	}
	/**
	 * Permite al sistema colocar una bici en un anclaje de un parking para retirarle el préstamo de esta a un usuario.
	 * @param parking donde se desea devolver la bici prestada.
	 * @param numeroDelAnclaje anclaje donde se desea aparcar la bici. El anclaje debe existir.
	 * @param credencial aportada por el código cliente por razones de seguridad para obtener el permiso de recarga.
	 * @param tarjeta de tipo TarjetaMonedero.
	 * @throws IllegalArgumentException El objeto parking no puede ser nulo o vacío.
	 * @throws IllegalArgumentException El objeto tarjeta no puede ser nulo o vacío.
	 * @throws IllegalStateException No debe haber una bici en el anclaje.
	 * @throws IllegalArgumentException El anclaje debe existir.
	 */
	public void recuperarBici(CityBikeParkingPoint parking, int numeroDelAnclaje, String credencial, TarjetaMonedero tarjeta){
		if (parking == null){
			throw new IllegalArgumentException("El objeto parking tiene valor null.");
		}else if (tarjeta == null){
			throw new IllegalArgumentException("El objeto tarjeta tiene valor null.");
		}else{
			if (numeroDelAnclaje >= 0 && numeroDelAnclaje < parking.getSizeParking()){
				if (parking.estadoDelAnclaje(numeroDelAnclaje) == false){
					tarjeta.recargaSaldo(credencial, fianza);
					parking.recibirBici(numeroDelAnclaje);
				}else{
					throw new IllegalStateException("El anclaje ya está ocupado.");
				}
			}else{
				throw new IllegalArgumentException("Se ha introducido un anclaje inexistente.");
			}
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
		CityBikeSystem other = (CityBikeSystem) obj;
		if (Double.doubleToLongBits(fianza) != Double.doubleToLongBits(other.fianza))
			return false;
		if (listaParkings == null) {
			if (other.listaParkings != null)
				return false;
		} else if (!listaParkings.equals(other.listaParkings))
			return false;
		return true;
	}
	
}