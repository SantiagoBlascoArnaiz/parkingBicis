package practica1;

import fabricante.externo.tarjetas.TarjetaMonedero;
import practica1.CityBikeParkingPoint;

public class Main {

	public static void main(String[] args) {
		
		TarjetaMonedero Santiago = new TarjetaMonedero("A156Bv09_1zXo894",25.0);
		
		CityBikeSystem Valladolid = new CityBikeSystem();
		
		Coordenadas uni = new Coordenadas(41.661701, -4.707817);
		CityBikeParkingPoint universidad = new CityBikeParkingPoint(12, uni);
		System.out.println("Identificador: " + universidad.getIdentificador());
		System.out.println("Universidad");
		System.out.println("Sus cordenadas decimales son :\n" + universidad.getCoordeandasParking().coordenadasGDACadena());
		System.out.println("Sus cordenadas GMS son :\n" + universidad.getCoordeandasParking().coordenadasGMSACadena());

		Coordenadas fili = new Coordenadas(41,38,41.6,'N',4,44,00.2,'W');
		CityBikeParkingPoint filipinos = new CityBikeParkingPoint(12,fili);
		System.out.println("\nIdentificador: " + filipinos.getIdentificador());
		System.out.println("Filipinos");
		System.out.println("Sus cordenadas decimales son :\n" + filipinos.getCoordeandasParking().coordenadasGDACadena());
		System.out.println("Sus cordenadas GMS son :\n" + filipinos.getCoordeandasParking().coordenadasGMSACadena());
		
		Coordenadas sangregorio = new Coordenadas(41.657852, -4.721827);
		CityBikeParkingPoint sanGregorio = new CityBikeParkingPoint(12,sangregorio);
		System.out.println("\nIdentificador: " + sanGregorio.getIdentificador());
		System.out.println("San Gregorio");
		System.out.println("Sus cordenadas decimales son :\n" + sanGregorio.getCoordeandasParking().coordenadasGDACadena());
		System.out.println("Sus cordenadas GMS son :\n" + sanGregorio.getCoordeandasParking().coordenadasGMSACadena());
		
		System.out.println("\nLa distancia entre universidad y filipinos es de " + universidad.distanciaHastaElParking(fili) + " metros.");
		System.out.println("La distancia entre filipinos y universidad es de " + filipinos.distanciaHastaElParking(uni) + " metros.");
		System.out.println("La distancia entre filipinos y sangregorio es de " + filipinos.distanciaHastaElParking(sangregorio) + " metros.");
		System.out.println("La distancia entre filipinos y filipinos es de " + filipinos.distanciaHastaElParking(filipinos) + " metros.");
		
		System.out.println("\nExisten " + Valladolid.getParkings().size() + " parkings.");
		Valladolid.addParking(universidad);
		Valladolid.addParking(filipinos);
		Valladolid.addParking(sanGregorio);
		System.out.println("Añadimos el parking universidad, filipinos y San Gregorio.");
		System.out.println("Existen " + Valladolid.getParkings().size() + " parkings.");
		
		System.out.print("\n" + universidad + "\n");
		
		System.out.print("\n Universidad: ");
		System.out.println( Valladolid.getParkings().get(0));
		System.out.print("\n Filipinos: ");
		System.out.println( Valladolid.getParkings().get(1));
		System.out.print("\n San Gregorio: ");
		System.out.println( Valladolid.getParkings().get(2));
		System.out.println("");
		
		System.out.println("Aparcamos una bici en el anclaje 0 de Filipinos.");
		Valladolid.getParkings().get(1).recibirBici(0);
		
		System.out.print("¿En el anclaje 0 de la parada de filipinos hay una bici aparcada? ");
		System.out.println( filipinos.estadoDelAnclaje(0));
		

		
		System.out.println("Intentamos coger la bici con saldo valido.");
		
		Valladolid.prestarBici(filipinos, 0, "6Z1y00Nm31aA-571", Santiago);
		System.out.print("¿En el anclaje 0 de la parada de filipinos hay una bici aparcada? ");
		System.out.println( filipinos.estadoDelAnclaje(0));
		System.out.println("");
		
		System.out.println(Valladolid.parkingsConBicisDisponibles());
		System.out.println(Valladolid.parkingsConAnclajesDisponibles());

		System.out.println("Parkings en el radio 0 centrado en universidad: " + Valladolid.parkingsEnElRadio(0,uni ));
		
		System.out.print("\n" + Valladolid.parkingsConAnclajesDisponibles() + "\n");

	}

}
