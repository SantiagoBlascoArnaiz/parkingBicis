package practica1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordenadasTest {
	public static final double ERROR_ADMISIBLE = 0.000001;
	//Coordenadas
	@Test(expected=IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testConstructorNoValido(){
		Coordenadas coordenadas = new Coordenadas(-20,60,120,'Y',-0,200,-3,'O');
	 }
	
	@Test
	public void testConstructorCorrecto(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		
		assertEquals(20,coordenadas.getGradosLatitud());
		assertEquals(20,coordenadas.getMinutosLatitud());
		assertEquals(20,coordenadas.getSegundosLatitud(),ERROR_ADMISIBLE);
		assertEquals('N',coordenadas.getPuntoCardinalLatitud());
		
		assertEquals(20,coordenadas.getGradosLongitud());
		assertEquals(20,coordenadas.getMinutosLongitud());
		assertEquals(20,coordenadas.getSegundosLongitud(),ERROR_ADMISIBLE);
		assertEquals('O',coordenadas.getPuntoCardinalLongitud());
		
		assertNotNull(coordenadas);
	 }
	//Coordenadas
	@Test(expected=IllegalArgumentException.class)
	@SuppressWarnings("unused")
	public void testConstructorGDInvalido(){
		Coordenadas coordenadas = new Coordenadas(100,-400);
	 }
	
	@Test
	public void testConstructorGDCorrecto(){
		Coordenadas coordenadas = new Coordenadas(-20,20);
		
		assertEquals(-20,coordenadas.getLatitudGD(),ERROR_ADMISIBLE);
		assertEquals(20,coordenadas.getLongitudGD(),ERROR_ADMISIBLE);
		assertNotNull(coordenadas);
	 }
	
	//getGradosLatitud
	@Test
	public void testGetterGradosLatitud(){
		Coordenadas coordenadas = new Coordenadas(10,20,30,'N',40,50,55,'O');
		assertEquals(10,coordenadas.getGradosLatitud(),ERROR_ADMISIBLE);
	 }
	//getMinutosLatitud
	@Test
	public void testGetterMinutosLatitud(){
		Coordenadas coordenadas = new Coordenadas(10,20,30,'N',40,50,55,'O');
		assertEquals(20,coordenadas.getMinutosLatitud(),ERROR_ADMISIBLE);
	 }
	//getSegundosLatitud
	@Test
	public void testGetterSegundosLatitud(){
		Coordenadas coordenadas = new Coordenadas(10,20,30,'N',40,50,55,'O');
		assertEquals(30,coordenadas.getSegundosLatitud(),ERROR_ADMISIBLE);
	 }
	//getPuntoCardinalLatitud
	@Test
	public void testGetterPuntoCardinalLatitud(){
		Coordenadas coordenadas = new Coordenadas(10,20,30,'N',40,50,55,'O');
		assertEquals('N',coordenadas.getPuntoCardinalLatitud());
	 }
	//getGradosLongitud
	@Test
	public void testGetterGradosLongitud(){
		Coordenadas coordenadas = new Coordenadas(10,20,30,'N',40,50,55,'O');
		assertEquals(40,coordenadas.getGradosLongitud(),ERROR_ADMISIBLE);
	 }
	//getMinutosLongitud
	@Test
	public void testGetterMinutosLongitud(){
		Coordenadas coordenadas = new Coordenadas(10,20,30,'N',40,50,55,'O');
		assertEquals(50,coordenadas.getMinutosLongitud(),ERROR_ADMISIBLE);
	 }
	//getSegundosLongitud
	@Test
	public void testGetterSegundosLongitud(){
		Coordenadas coordenadas = new Coordenadas(10,20,30,'N',40,50,55,'O');
		assertEquals(55,coordenadas.getSegundosLongitud(),ERROR_ADMISIBLE);
	 }
	//getPuntoCardinalLongitud
	@Test
	public void testGetterPuntoCardinalLongitud(){
		Coordenadas coordenadas = new Coordenadas(10,20,30,'N',40,50,55,'O');
		assertEquals('O',coordenadas.getPuntoCardinalLongitud());
	 }
	//setGradosLatitud
	@Test(expected=IllegalArgumentException.class)
	public void testSetterGradosLatitudinalesNegativos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setGradosLatitud(-10);
		
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetterGradosLatitudinalesSuperandoElLimite(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setGradosLatitud(90);
	 }
	
	@Test
	public void testSetterGradosLatitudinalesCorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setGradosLatitud(10);
		
		assertEquals(10,coordenadas.getGradosLatitud(),ERROR_ADMISIBLE);
	 }
	//setMinutosLatitud
	@Test(expected=IllegalArgumentException.class)
	public void testSetterMinutosLatitudinalesNegativos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setMinutosLatitud(-10);
		
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetterMinutosLatitudinalesSuperandoElLimite(){
		Coordenadas coordenadas = new Coordenadas(90,0,0,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setMinutosLatitud(20);
	 }

	@Test
	public void testSetterMinutosLatitudinalesCorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setMinutosLatitud(10);
		
		assertEquals(10,coordenadas.getMinutosLatitud(),ERROR_ADMISIBLE);
	 }
	//setSegundosLatitud
	@Test(expected=IllegalArgumentException.class)
	public void testSetterSegundosLatitudinalesNegativos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setSegundosLatitud(-10);
		
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetterSegundosLatitudinalesSuperandoElLimite(){
		Coordenadas coordenadas = new Coordenadas(90,0,0,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setSegundosLatitud(20);
	 }

	@Test
	public void testSetterSegundosLatitudinalesCorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setSegundosLatitud(10);
		
		assertEquals(10,coordenadas.getSegundosLatitud(),ERROR_ADMISIBLE);
	 }
	//setPuntoCardinalLatitud
	@Test (expected=IllegalArgumentException.class)
	public void testSetterPuntoCardinalLatitudinalInorrecto(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setPuntoCardinalLatitud('T');
	 }
	
	@Test
	public void testSetterPuntoCardinalLatitudinalN(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'S',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setPuntoCardinalLatitud('N');
		
		assertEquals('N',coordenadas.getPuntoCardinalLatitud());
	 }
	
	@Test
	public void testSetterPuntoCardinalLatitudinalS(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setPuntoCardinalLatitud('S');
		
		assertEquals('S',coordenadas.getPuntoCardinalLatitud());
	 }
	//setGradosLongitud
	@Test(expected=IllegalArgumentException.class)
	public void testSetterGradosLongitudinalesNegativos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setGradosLongitud(-10);
		
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetterGradosLongitudinalesSuperandoElLimite(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setGradosLongitud(1800);
	 }
	
	@Test
	public void testSetterGradosLongitudinalesCorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setGradosLongitud(10);
		
		assertEquals(10,coordenadas.getGradosLongitud(),ERROR_ADMISIBLE);
	 }
	//setMinutosLongitud
	@Test(expected=IllegalArgumentException.class)
	public void testSetterMinutosLongitudinalesNegativos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setMinutosLongitud(-10);
		
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetterMinutosLongitudinalesSuperandoElLimite(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',90,0,0,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setMinutosLongitud(180);
	 }

	@Test
	public void testSetterMinutosLongitudinalesCorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setMinutosLongitud(10);
		
		assertEquals(10,coordenadas.getMinutosLongitud(),ERROR_ADMISIBLE);
	 }
	//setSegundosLongitud
	@Test(expected=IllegalArgumentException.class)
	public void testSetterSegundosLongitudinalesNegativos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setSegundosLongitud(-10);
		
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetterSegundosLongitudinalesSuperandoElLimite(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',90,0,0,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setSegundosLongitud(180);
	 }

	@Test
	public void testSetterSegundosLongitudinalesCorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setSegundosLongitud(10);
		
		assertEquals(10,coordenadas.getSegundosLongitud(),ERROR_ADMISIBLE);
	 }
	//setPuntoCardinalLongitud
	@Test (expected=IllegalArgumentException.class)
	public void testSetterPuntoCardinalLongitudinalInorrecto(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setPuntoCardinalLongitud('T');
	 }
	
	@Test
	public void testSetterPuntoCardinalLongitudinalE(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setPuntoCardinalLongitud('E');
		
		assertEquals('E',coordenadas.getPuntoCardinalLongitud());
	 }
	
	@Test
	public void testSetterPuntoCardinalLongitudinalO(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'E');
		assertNotNull(coordenadas);
		
		coordenadas.setPuntoCardinalLongitud('O');
		
		assertEquals('O',coordenadas.getPuntoCardinalLongitud());
	 }
	
	@Test
	public void testSetterPuntoCardinalLongitudinalW(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setPuntoCardinalLongitud('W');
		
		assertEquals('W',coordenadas.getPuntoCardinalLongitud());
	 }
	//getLatitudGD
	@Test
	public void testGetterLatitudGD(){
		Coordenadas coordenadas = new Coordenadas(20,0);
		assertNotNull(coordenadas);
		
		assertEquals(20,coordenadas.getLatitudGD(),ERROR_ADMISIBLE);
	 }
	//getLongitudGD
	@Test
	public void testGetterLongitudGD(){
		Coordenadas coordenadas = new Coordenadas(0,20);
		assertNotNull(coordenadas);
		
		assertEquals(20,coordenadas.getLongitudGD(),ERROR_ADMISIBLE);
	 }
	//setLatitudGD
	@Test (expected=IllegalArgumentException.class)
	public void testSetterLatitudGDValorIncorrectoSuperior(){
		Coordenadas coordenadas = new Coordenadas(20,0);
		assertNotNull(coordenadas);
		
		coordenadas.setLatitudGD(100);
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetterLatitudGDValorIncorrectoInferior(){
		Coordenadas coordenadas = new Coordenadas(20,0);
		assertNotNull(coordenadas);
		
		coordenadas.setLatitudGD(-100);
	 }
	
	@Test 
	public void testSetterLatitudGDValorCorrecto(){
		Coordenadas coordenadas = new Coordenadas(20,0);
		assertNotNull(coordenadas);
		
		coordenadas.setLatitudGD(40);
		
		assertEquals(40,coordenadas.getLatitudGD(),ERROR_ADMISIBLE);
	 }
	//setLongitudGD
	@Test (expected=IllegalArgumentException.class)
	public void testSetterLongitudGDValorIncorrectoSuperior(){
		Coordenadas coordenadas = new Coordenadas(20,0);
		assertNotNull(coordenadas);
		
		coordenadas.setLongitudGD(181);
	 }
	
	@Test (expected=IllegalArgumentException.class)
	public void testSetterLongitudGDValorIncorrectoInferior(){
		Coordenadas coordenadas = new Coordenadas(20,0);
		assertNotNull(coordenadas);
		
		coordenadas.setLongitudGD(-190);
	 }
	
	@Test 
	public void testSetterLongitudGDValorCorrecto(){
		Coordenadas coordenadas = new Coordenadas(20,0);
		assertNotNull(coordenadas);
		
		coordenadas.setLongitudGD(40);
		
		assertEquals(40,coordenadas.getLongitudGD(),ERROR_ADMISIBLE);
	 }
	//setCoordenadasGD
	@Test (expected=IllegalArgumentException.class)
	public void testSetterCoordenadasGDValoresIncorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,0);
		assertNotNull(coordenadas);
		
		coordenadas.setLatitudGD(400);
		coordenadas.setLongitudGD(400);
		
		assertEquals(40,coordenadas.getLatitudGD(),ERROR_ADMISIBLE);
	 }
	
	@Test 
	public void testSetterCoordenadasGDCorrecto(){
		Coordenadas coordenadas = new Coordenadas(20,0);
		assertNotNull(coordenadas);
		
		coordenadas.setLatitudGD(50);
		coordenadas.setLongitudGD(40);
		
		assertEquals(50,coordenadas.getLatitudGD(),ERROR_ADMISIBLE);
		assertEquals(40,coordenadas.getLongitudGD(),ERROR_ADMISIBLE);
		
		assertNotNull(coordenadas);
	 }
	//setCoordenadasGMS
	@Test (expected=IllegalArgumentException.class)
	public void testSetterGradosLatitudIncorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setCoordenadasGMS(200,60,-20,'n',91,-2,200,'U');
	 }
	
	@Test 
	public void testSetterGradosLatitudCorrectos(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		coordenadas.setCoordenadasGMS(30,30,30,'S',30,30,30,'W');
		
		assertEquals(30,coordenadas.getGradosLatitud());
		assertEquals(30,coordenadas.getMinutosLatitud());
		assertEquals(30,coordenadas.getSegundosLatitud(),ERROR_ADMISIBLE);
		assertEquals('S',coordenadas.getPuntoCardinalLatitud());
		
		assertEquals(30,coordenadas.getGradosLongitud());
		assertEquals(30,coordenadas.getMinutosLongitud());
		assertEquals(30,coordenadas.getSegundosLongitud(),ERROR_ADMISIBLE);
		assertEquals('W',coordenadas.getPuntoCardinalLongitud());
		
		assertNotNull(coordenadas);
	 }
	//coordenadasGMSACadena
	@Test
	public void testCoordenadasGMSACadena(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		String string = "20º 20' 20.0\" N 20º 20' 20.0\" O";
		assertEquals(string,coordenadas.coordenadasGMSACadena());
	 }
	//coordenadasGDACadena
	@Test
	public void testCoordenadasGDACadena(){
		Coordenadas coordenadas = new Coordenadas(20,20);
		assertNotNull(coordenadas);
		
		String string = "20.0, 20.0";
		assertEquals(string,coordenadas.coordenadasGDACadena());
	 }
	//distancia
	@Test
	public void testDistanciaASiMismo(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		Coordenadas coordenadas2 = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas2);
		
		assertEquals(0,coordenadas.distancia(coordenadas2),ERROR_ADMISIBLE);
	 }
	
	@Test
	public void testDistanciaAOtro(){
		Coordenadas coordenadas = new Coordenadas(20,20,20,'N',20,20,20,'O');
		assertNotNull(coordenadas);
		
		Coordenadas coordenadas2 = new Coordenadas(20,20,21,'N',20,20,21,'O');
		assertNotNull(coordenadas2);
		
		assertEquals(42.3416767,coordenadas.distancia(coordenadas2),ERROR_ADMISIBLE);
	 }
}
