package practica1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class CityBikeSystemTest {
	public static final double ERROR_ADMISIBLE = 0.000001;
	//CityBikeSystem
	@Test
	public void testConstructorSistemaDeParkings(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
	 }
	//añadirParking
	@Test(expected=IllegalArgumentException.class)
	public void testAddUnparkingConParkingNull(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		punto = null;
		assertNull(punto);
		
		valladolid.addParking(punto);
	 }
	
	@Test(expected=IllegalStateException.class)
	public void testAddUnparkingConCoordenadasIgualesALasDeOtro(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadas2 = new Coordenadas(20,20);
		assertNotNull(coordenadas2);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(6,coordenadas2);
		assertNotNull(punto2);
		
		valladolid.addParking(punto);
		valladolid.addParking(punto2);
	 }
	
	@Test
	public void testAddUnparkingConCoordenadasDistintasALasDeOtro(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadas2 = new Coordenadas(40,40);
		assertNotNull(coordenadas2);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(6,coordenadas2);
		assertNotNull(punto2);
		
		valladolid.addParking(punto);
		valladolid.addParking(punto2);
		
		assertEquals(2,valladolid.getParkings().size(),ERROR_ADMISIBLE);
	 }
	
	@Test
	public void testAddUnparkingConCoordenadasMuyCercanasALasDeOtro(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadas2 = new Coordenadas(20.00005,20.00005);
		assertNotNull(coordenadas2);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(6,coordenadas2);
		assertNotNull(punto2);
		
		valladolid.addParking(punto);
		valladolid.addParking(punto2);
		
		assertEquals(2,valladolid.getParkings().size(),ERROR_ADMISIBLE);
	 }
	//eliminarParking
	@Test(expected=IllegalArgumentException.class)
	public void testEliminarUnparkingConParkingNull(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		punto = null;
		assertNull(punto);
		
		valladolid.eliminarParking(punto);
	 }
	
	@Test(expected=IllegalStateException.class)
	public void testEliminarUnParkingQueNoEstaEnElSistema(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadas2 = new Coordenadas(20,20);
		assertNotNull(coordenadas2);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(6,coordenadas2);
		assertNotNull(punto2);
		
		valladolid.eliminarParking(punto);
	 }
	
	@Test
	public void testEliminarParkingQueEstaEnElSistema(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		valladolid.eliminarParking(punto);
		
		ArrayList<CityBikeParkingPoint> listaTest = new ArrayList<CityBikeParkingPoint>();
		
		assertEquals(listaTest,valladolid.getParkings());
	 }
	//getParkings
	@Test
	public void testGetterListaDeParkings(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadas2 = new Coordenadas(40,40);
		assertNotNull(coordenadas2);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(6,coordenadas2);
		assertNotNull(punto2);
		
		valladolid.addParking(punto);
		valladolid.addParking(punto2);
		
		ArrayList<CityBikeParkingPoint> listaTest = new ArrayList<CityBikeParkingPoint>();
		listaTest.add(punto);
		listaTest.add(punto2);
		
		assertEquals(listaTest,valladolid.getParkings());
	 }
	//cambiarFianza
	@Test (expected=IllegalArgumentException.class)
	public void testDarValorNegativoALaFianza(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		
		valladolid.cambiarFianza(-1);
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testDarValorNuloALaFianza(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		
		valladolid.cambiarFianza(0);
	 }
	
	@Test 
	public void testDarValorValidoALaFianza(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		
		valladolid.cambiarFianza(53.5);
		
		assertEquals(53.5,valladolid.getFianza(),ERROR_ADMISIBLE);
	 }
	//getFianza
	@Test 
	public void testObtenerValorDeLaFianzaSinCambiar(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		
		assertEquals(25,valladolid.getFianza(),ERROR_ADMISIBLE);
	 }
	
	@Test 
	public void testObtenerValorDeLaFianzaCambiada(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		
		valladolid.cambiarFianza(53.5);
		
		assertEquals(53.5,valladolid.getFianza(),ERROR_ADMISIBLE);
	 }
	//parkingsConAnclajesDisponibles
	@Test 
	public void testObtenerListaConParkingsConAnclajesDisponiblesSiNoHay(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(1,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		valladolid.recuperarBici(punto, 0, "A156Bv09_1zXo894", santiago);
		
		ArrayList<CityBikeParkingPoint> listaTest = new ArrayList<CityBikeParkingPoint>();
		
		assertEquals(listaTest,valladolid.parkingsConAnclajesDisponibles());
	 }
	
	@Test 
	public void testObtenerListaConParkingsConAnclajesDisponiblesSiHay(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(1,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		
		ArrayList<CityBikeParkingPoint> listaTest = new ArrayList<CityBikeParkingPoint>();
		listaTest.add(punto);
		
		assertEquals(listaTest,valladolid.parkingsConAnclajesDisponibles());
	 }
	//parkingsConBicisDisponibles
	@Test 
	public void testObtenerListaConParkingsConBicisDisponiblesSiNoHay(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(1,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		
		ArrayList<CityBikeParkingPoint> listaTest = new ArrayList<CityBikeParkingPoint>();
		
		assertEquals(listaTest,valladolid.parkingsConBicisDisponibles());
	 }
	
	@Test 
	public void testObtenerListaConParkingsConBicisDisponiblesSiHay(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(1,coordenadas);
		assertNotNull(punto);
		
		valladolid.addParking(punto);
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		
		valladolid.recuperarBici(punto, 0, "A156Bv09_1zXo894", santiago);
		
		ArrayList<CityBikeParkingPoint> listaTest = new ArrayList<CityBikeParkingPoint>();
		listaTest.add(punto);
		
		assertEquals(listaTest,valladolid.parkingsConBicisDisponibles());
	 }
	//parkingsEnELRadio
	@Test(expected=IllegalArgumentException.class)
	public void testObtenerListaConParkingsEnUnRadioCentradoEnUnasCoordenadasConCoordenadasNull(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(1,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadas2 = new Coordenadas(40,40);
		assertNotNull(coordenadas2);
		
		coordenadas2 = null;
		assertNull(coordenadas2);
		
		valladolid.addParking(punto);
		
		valladolid.parkingsEnElRadio(10, coordenadas2);
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testObtenerListaConParkingsEnUnRadioNegativo(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(1,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadas2 = new Coordenadas(40,40);
		assertNotNull(coordenadas2);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(6,coordenadas2);
		assertNotNull(punto2);
		
		valladolid.addParking(punto);
		valladolid.addParking(punto2);
		
		valladolid.parkingsEnElRadio(-10, coordenadas);
	 }
	
	@Test 
	public void testObtenerListaConParkingsEnUnRadioPositivo(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(1,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadas2 = new Coordenadas(20.00005,20.00005);
		assertNotNull(coordenadas2);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(6,coordenadas2);
		assertNotNull(punto2);
		
		valladolid.addParking(punto);
		valladolid.addParking(punto2);
		
		ArrayList<CityBikeParkingPoint> listaTest = new ArrayList<CityBikeParkingPoint>();
		listaTest.add(punto);
		listaTest.add(punto2);
		
		assertEquals(listaTest,valladolid.parkingsEnElRadio(10, coordenadas));
	 }
	
	@Test 
	public void testObtenerListaConParkingsEnUnRadioIgualACero(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(1,coordenadas);
		assertNotNull(punto);
		
		Coordenadas coordenadas2 = new Coordenadas(40,40);
		assertNotNull(coordenadas2);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(6,coordenadas2);
		assertNotNull(punto2);
		
		valladolid.addParking(punto);
		valladolid.addParking(punto2);
		
		ArrayList<CityBikeParkingPoint> listaTest = new ArrayList<CityBikeParkingPoint>();
		listaTest.add(punto);
		
		assertEquals(listaTest,valladolid.parkingsEnElRadio(10, coordenadas));
	 }
	//prestarBici
	@Test (expected=IllegalArgumentException.class)
	public void testPrestarUnaBiciConParkingNull(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		punto.recibirBici(0);
		
		punto = null;
		assertNull(punto);
		
		valladolid.prestarBici(punto, 0, "6Z1y00Nm31aA-571", santiago);
	 }
	
	public void testPrestarUnaBiciConTarjetaNull(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		punto.recibirBici(0);
		
		punto = null;
		assertNull(punto);
		
		valladolid.prestarBici(punto, 0, "6Z1y00Nm31aA-571", santiago);
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testPrestarUnaBiciDeUnAnclajeNegativo(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		punto.recibirBici(0);
		
		valladolid.prestarBici(punto, -8, "6Z1y00Nm31aA-571", santiago);
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testPrestarUnaBiciDeUnAnclajeInexistente(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		punto.recibirBici(0);
		
		valladolid.prestarBici(punto, 8, "6Z1y00Nm31aA-571", santiago);
	 }
	
	@Test (expected=IllegalStateException.class)
	public void testPrestarUnaBiciDeUnAnclajeVacio(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		punto.recibirBici(0);
		
		valladolid.prestarBici(punto, 1, "6Z1y00Nm31aA-571", santiago);
	 }

	@Test
	public void testPrestarUnaBiciDeUnAnclajeOcupado(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		punto.recibirBici(0);
		
		valladolid.prestarBici(punto, 0, "6Z1y00Nm31aA-571", santiago);
		assertFalse(punto.estadoDelAnclaje(0));
	 }
	//recuperarBici
	@Test (expected=IllegalArgumentException.class)
	public void testRecuperarUnaBiciConParkingNull(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		punto = null;
		assertNull(punto);
		
		valladolid.recuperarBici(punto, 0, "A156Bv09_1zXo894", santiago);
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testRecuperarUnaBiciConTarjetaNull(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		santiago = null;
		assertNull(santiago);
		
		valladolid.recuperarBici(punto, 0, "A156Bv09_1zXo894", santiago);
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testRecuperarUnaBiciDeUnAnclajeInexistente(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		valladolid.recuperarBici(punto, 8, "A156Bv09_1zXo894", santiago);
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testRecuperarUnaBiciDeUnAnclajeNegativo(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		valladolid.recuperarBici(punto, -8, "A156Bv09_1zXo894", santiago);
	 }
	
	@Test (expected=IllegalStateException.class)
	public void testRecuperarUnaBiciDeUnAnclajeOcupado(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		punto.recibirBici(0);
		
		valladolid.recuperarBici(punto, 0, "A156Bv09_1zXo894", santiago);
	 }
	
	@Test
	public void testRecuperarUnaBiciDeUnAnclajeVacio(){
		CityBikeSystem valladolid = new CityBikeSystem();
		assertNotNull(valladolid);
		
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		CityBikeParkingPoint punto = new CityBikeParkingPoint(6,coordenadas);
		assertNotNull(punto);
		
		TarjetaMonedero santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		assertNotNull(santiago);
		
		valladolid.recuperarBici(punto, 0, "A156Bv09_1zXo894", santiago);
		
		assertTrue(punto.estadoDelAnclaje(0));
	 }
}
