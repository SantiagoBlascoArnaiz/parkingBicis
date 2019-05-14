package practica1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CityBikeParkingPointTest {
	public static final double ERROR_ADMISIBLE = 0.000001;
	//cityBikeParkingPoint
	@Test(expected=IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testConstructorCoordenadasNull(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		
		coordenadas = null;
		assertNull(coordenadas);
		
		CityBikeParkingPoint punto = new CityBikeParkingPoint(12,coordenadas);
	 }
	
	@Test(expected=IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testConstructorAnclajesNegativos(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(-1,coordenadas);
	 }
	
	@Test
	public void testConstructorTodoCorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
	 }
	
	@Test
	public void testConstructorCoordenadasIgualesALasDeOtroParking(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto2);
	 }
	//numeroDeAnclajesOcupados
	@Test
	public void testContarAnclajesOcupadosEstandoTodosLibres(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		assertEquals(0,punto.numeroDeAnclajesOcupados(),ERROR_ADMISIBLE);
	}
	
	@Test
	public void testContarAnclajesOcupadosEstandoTodosOcupados(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		for (int i = 0; i < 6; i++) {
			punto.recibirBici(i);
		}
		assertEquals(6,punto.numeroDeAnclajesOcupados(),ERROR_ADMISIBLE);
	}
	
	@Test
	public void testContarAnclajesOcupadosEstandoAlgunosOcupados(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		for (int i = 0; i < 3; i++) {
			punto.recibirBici(i);
		}
		
		assertEquals(3,punto.numeroDeAnclajesOcupados(),ERROR_ADMISIBLE);
	}
	//anclajesDisponibles
	@Test
	public void testHayAnclajesDisponiblesEstandoTodosLibres(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
	
		assertTrue(punto.anclajesDisponibles());
	}
	
	@Test
	public void testHayAnclajesDisponiblesEstandoTodosOcupados(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		for (int i = 0; i < 6; i++) {
			punto.recibirBici(i);
		}
		assertFalse(punto.anclajesDisponibles());
	}
	
	@Test
	public void testHayAnclajesDisponiblesEstandoAlgunosOcupados(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		for (int i = 0; i < 3; i++) {
			punto.recibirBici(i);
		}
		assertTrue(punto.anclajesDisponibles());
	}
	//anclajesOcupados
	@Test
	public void testHayAnclajesOcupadosEstandoTodosLibres(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
	
		assertFalse(punto.anclajesOcupados());
	}
	
	@Test
	public void testHayAnclajesOcupadosEstandoTodosOcupados(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		for (int i = 0; i < 6; i++) {
			punto.recibirBici(i);
		}
		assertTrue(punto.anclajesOcupados());
	}
	
	@Test
	public void testHayAnclajesOcupadosEstandoAlgunosOcupados(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		for (int i = 0; i < 3; i++) {
			punto.recibirBici(i);
		}
		assertTrue(punto.anclajesOcupados());
	}
	//getCoordenadasParking
	@Test
	public void testGetterCoordenadasDelParking(){
		Coordenadas coordenadas = new Coordenadas(20,30);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		assertEquals(coordenadas,punto.getCoordeandasParking());
	}
	//getIdentificador
	@Test
	public void testGetterIdentificadorDelParking(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		String test = "2000.0N2000.0E";
		
		assertEquals(test,punto.getIdentificador());
	}
	//getTamañoParking
	@Test
	public void testGetterSizeParking(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		assertEquals(6, punto.getSizeParking(),ERROR_ADMISIBLE);
	}
	//estadoDelAnclaje
	@Test(expected=IllegalArgumentException.class)
	public void testEstadoDeUnAnclajeNegativo(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		punto.estadoDelAnclaje(-1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testEstadoDeUnAnclajeInexistente(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		punto.estadoDelAnclaje(7);
		
	}
	
	@Test 
	public void testEstadoDeUnAnclajeLibreExistente(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		assertFalse(punto.estadoDelAnclaje(0));
	}
	
	@Test 
	public void testEstadoDeUnAnclajeOcupadoExistente(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		punto.recibirBici(0);
		
		assertTrue(punto.estadoDelAnclaje(0));
	}
	//darBici
	@Test (expected=IllegalArgumentException.class)
	public void testDarUnaBiciDeUnAnclajeInexistente(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		punto.darBici(-8);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testDarUnaBiciDeUnAnclajeExistenteSinBici(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		punto.darBici(0);
		
	}
	
	@Test
	public void testDarUnaBiciDeUnAnclajeExistenteConBici(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		punto.recibirBici(0);
		
		punto.darBici(0);
		assertFalse(punto.estadoDelAnclaje(0));
	}
	//recibirBici
	@Test (expected=IllegalArgumentException.class)
	public void testRecibirUnaBiciEnUnAnclajeInexistente(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		punto.recibirBici(-8);
	}
	
	@Test 
	public void testRecibirUnaBiciEnUnAnclajeExistenteSinBici(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		punto.recibirBici(0);
		
		assertTrue(punto.estadoDelAnclaje(0));
	}
	
	@Test (expected=IllegalStateException.class)
	public void testRecibirUnaBiciEnUnAnclajeExistenteConBici(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		punto.recibirBici(0);
		
		punto.recibirBici(0);
	}
	//distanciaHastaElParking
	@Test(expected=IllegalArgumentException.class)
	public void testDistanciaDeUnParkingAOtroNull(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadasOtro = new Coordenadas(40,40);
		assertNotNull(coordenadasOtro);
		CityBikeParkingPoint puntoOtro = new CityBikeParkingPoint(6,coordenadasOtro);
		assertNotNull(puntoOtro);
		
		puntoOtro = null;
		assertNull(puntoOtro);
		
		punto.distanciaHastaElParking(puntoOtro);
	}
	
	@Test
	public void testDistanciaDeUnParkingAOtroLejano(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadasOtro = new Coordenadas(40,40);
		assertNotNull(coordenadasOtro);
		CityBikeParkingPoint puntoOtro = new CityBikeParkingPoint(6,coordenadasOtro);
		assertNotNull(puntoOtro);
		
		assertEquals(2927385.1926051,punto.distanciaHastaElParking(puntoOtro),ERROR_ADMISIBLE);
	}
	
	@Test
	public void testDistanciaDeUnParkingAOtroCercano(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadasOtro = new Coordenadas(20.0005,20.0005);
		assertNotNull(coordenadasOtro);
		CityBikeParkingPoint puntoOtro = new CityBikeParkingPoint(6,coordenadasOtro);
		assertNotNull(puntoOtro);
		
		assertEquals(76.2925931,punto.distanciaHastaElParking(puntoOtro),ERROR_ADMISIBLE);
	}
	
	@Test
	public void testDistanciaDeUnParkingASiMismo(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		assertEquals(0,punto.distanciaHastaElParking(punto),ERROR_ADMISIBLE);
	}
	//
	@Test (expected=IllegalArgumentException.class)
	public void testDistanciaDeUnParkingAUnPuntoNull(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadasOtro = new Coordenadas(40,40);
		assertNotNull(coordenadasOtro);
		
		coordenadasOtro = null;
		assertNull(coordenadasOtro);
		
		punto.distanciaHastaElParking(coordenadasOtro);
	}
	
	@Test
	public void testDistanciaDeUnParkingAUnPuntoLejano(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadasOtro = new Coordenadas(40,40);
		assertNotNull(coordenadasOtro);
		
		
		assertEquals(2927385.1926051,punto.distanciaHastaElParking(coordenadasOtro),ERROR_ADMISIBLE);
	}
	
	@Test
	public void testDistanciaDeUnParkingAUnPuntoCercano(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadasOtro = new Coordenadas(20.0005,20.0005);
		assertNotNull(coordenadasOtro);
		
		
		assertEquals(76.2925931,punto.distanciaHastaElParking(coordenadasOtro),ERROR_ADMISIBLE);
	}
	
	@Test
	public void testDistanciaDeUnParkingAUnPuntoIgualASusCoordenadas(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		assertEquals(0,punto.distanciaHastaElParking(coordenadas),ERROR_ADMISIBLE);
	}
}
