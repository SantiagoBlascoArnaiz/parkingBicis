package practica1;

import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.asin;
import static java.lang.Math.sqrt;
import static java.lang.Math.min;
import static java.lang.Math.toRadians;
import static java.lang.Math.abs;
/**
 * Tipo de dato que representa las coordenadas en la superficie de la tierra,
 *  aporta funcionalidades como la distancia y la obtención de las distints componentes de las coordenadas.
 * @author PatAgua
 * @author SanBlas
 *
 */
public class Coordenadas {
	
	private int gradosLatitud;
	private int minutosLatitud;
	private double segundosLatitud;
	private char puntoCardinalLatitud;
	
	private int gradosLongitud;
	private int minutosLongitud;
	private double segundosLongitud;
	private char puntoCardinalLongitud;

	/**
	 * Crea unas coordenadas inicializadas con los valores GPS dados en GMS pasados como parámetros.
	 * @param gradosLatitud nuevo valor para los grados latitudinales, sólo admite números enteros no negativos menores o iguales que 90.
	 * @param minutosLatitud nuevo valor para los minutos latitudinales, sólo admite números enteros no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @param segundosLatitud nuevo valor para los segundos latitudinales, sólo admite números decimales no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @param cardinalLatitud acepta el carácter 'N' para el punto norte y 'S' para el punto sur.
	 * @param gradosLongitud nuevo valor para los grados longitudinales, sólo admite números enteros no negativos menores o iguales que 90.
	 * @param minutosLongitud nuevo valor para los minutos longitudinales, sólo admite números enteros no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @param segundosLongitud nuevo valor para los segundos longitudinales, sólo admite números decimales no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @param cardinalLongitud acepta el carácter 'E' para el puunto este y tanto 'W' como 'O' para el punto oeste.
	 */
	public Coordenadas(int gradosLatitud,int minutosLatitud, double segundosLatitud, char cardinalLatitud,int gradosLongitud,int minutosLongitud, double segundosLongitud, char cardinalLongitud){
		setGradosLatitud(gradosLatitud);
		setMinutosLatitud(minutosLatitud);
		setSegundosLatitud(segundosLatitud);
		setPuntoCardinalLatitud(cardinalLatitud);
		
		setGradosLongitud(gradosLongitud);
		setMinutosLongitud(minutosLongitud);
		setSegundosLongitud(segundosLongitud);
		setPuntoCardinalLongitud(cardinalLongitud);
	}
	/**
	 * Crea unas coordenadas inicializadas con los valores GD pasados como parámetros.
	 * @param latitudGD nuevo valor para la latitud en GD, puede tomar valores decimales tanto positivos como negativos cuyo valor absoluto es menor o igual que 90.
	 * @param longitudGD nuevo valor para la longitud en GD, puede tomar valores decimales tanto positivos como negativos cuyo valor absoluto es menor o igual que 180.
	 */
	public Coordenadas(double latitudGD,double longitudGD){
		setLatitudGD(latitudGD);
		setLongitudGD(longitudGD);
	}
	/**
	 * Consulta el valor de los grados de la parte latitudinal de las coordenadas.
	 * @return números enteros no negatvos.
	 */
	public int getGradosLatitud() {
		return gradosLatitud;
	}
	/**
	 * Consulta el valor de los minutos de la parte latitudinal de las coordenadas.
	 * @return números enteros no negatvos.
	 */
	public int getMinutosLatitud() {
		return minutosLatitud;
	}
	/**
	 * Consulta el valor de los segundos de la parte latitudinal de las coordenadas.
	 * @return números decimales no negatvos.
	 */
	public double getSegundosLatitud() {
		return segundosLatitud;
	}
	/**
	 * Consulta el punto cardinal de la parte latitudinal de las coordenadas.
	 * @return carácter 'N' o carácter 'S'.
	 */
	public char getPuntoCardinalLatitud() {
		return puntoCardinalLatitud;
	}
	/**
	 * Consulta el valor de los grados de la parte longitudinal de las coordenadas.
	 * @return números enteros no negativos.
	 */
	public int getGradosLongitud() {
		return gradosLongitud;
	}
	/**
	 * Consulta el valor de los minutos de la parte longitudinal de las coordenadas.
	 * @return números enteros no negatvos.
	 */
	public int getMinutosLongitud() {
		return minutosLongitud;
	}
	/**
	 * Consulta el valor de los segundos de la parte longitudinal de las coordenadas.
	 * @return números decimales no negatvos.
	 */
	public double getSegundosLongitud() {
		return segundosLongitud;
	}
	/**
	 * Consulta el punto cardinal de la parte longitudinal de las coordenadas.
	 * @return carácter 'N' o carácter 'S'.
	 */
	public char getPuntoCardinalLongitud() {
		return puntoCardinalLongitud;
	}
	/**
	 * Cambia el valor de los grados de la parte latitudinal de las coordenadas.
	 * @param gradosLatitud nuevo valor para los grados latitudinales. Sólo admite enteros no negativos menores o iguales que 90 (Sólo podrá valer 90 en el caso de que los grados y minutos sean 0).
	 * @throws IllegalArgumentException Los grados deben estar comprendidos entre 0 y 90.
	 */
	public void setGradosLatitud(int gradosLatitud) {
		if (gradosLatitud < 90 && gradosLatitud >= 0 || gradosLatitud == 90 && minutosLatitud == 0 && segundosLatitud == 0){
			this.gradosLatitud = gradosLatitud;
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto de los grados latitudinales.");
		}
	}
	/**
	 * Cambia el valor de los minutos de la parte latitudinal de las coordenadas.
	 * @param minutosLatitud nuevo valor para los minutos latitudinales. Sólo admite enteros no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @throws IllegalArgumentException Los minutos deben estar comprendidos entre 0 y 59 (Excepto si los grados valen 90 que deberan valer 0).
	 */
	public void setMinutosLatitud(int minutosLatitud) {
		if (minutosLatitud < 60 && minutosLatitud >= 0 && gradosLatitud < 90 && gradosLatitud >= 0 || minutosLatitud == 0 && segundosLatitud == 0 && gradosLatitud == 90){
			this.minutosLatitud = minutosLatitud;
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto de los minutos latitudinales.");
		}
	}
	/**
	 * Cambia el valor de los segundos de la parte latitudinal de las coordenadas.
	 * @param segundosLatitud nuevo valor para los segundos latitudinales. Sólo admite decimales no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @throws IllegalArgumentException Los segundos deben estar comprendidos entre 0 y 59 (Excepto si los grados valen 90 que deberan valer 0).
	 */
	public void setSegundosLatitud(double segundosLatitud) {
		if (segundosLatitud < 60 && segundosLatitud >= 0 && gradosLatitud < 90 && gradosLatitud >= 0 || segundosLatitud == 0 && minutosLatitud == 0 && gradosLatitud == 90){
			this.segundosLatitud = segundosLatitud;
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto de los segundos latitudinales.");
		}
	}
	/**
	 * Cambia el punto cardinal de la parte latitudinal de las coordenadas.
	 * @param puntoCardinalLatitud nuevo valor para el punto cardinal latitudinal. Sólo admite los carácteres 'N' y 'S'.
	 * @throws IllegalArgumentException El punto cardinal debe ser 'N' o 'S'.
	 */
	public void setPuntoCardinalLatitud(char puntoCardinalLatitud) {
		if(puntoCardinalLatitud == 'N' || puntoCardinalLatitud == 'S'){
			this.puntoCardinalLatitud = puntoCardinalLatitud;
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto del cardinal latitudinal.");
		}
		
	}
	/**
	 * Cambia el valor de los grados de la parte longitudinal de las coordenadas.
	 * @param gradosLongitud nuevo valor para los grados longitudinales. Sólo admite enteros no negativos menores o iguales que 180 (Sólo podrá valer 180 en el caso de que los grados y minutos sean 0.
	 * @throws IllegalArgumentException Los grados deben estar comprendidos entre 0 y 180.
	 */
	public void setGradosLongitud(int gradosLongitud) {
		if (gradosLongitud < 180 && gradosLongitud >= 0 || gradosLongitud == 180 && minutosLongitud == 0 && segundosLongitud == 0){
			this.gradosLongitud = gradosLongitud;
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto de los grados longitudinales.");
		}
	}
	/**
	 * Cambia el valor de los minutos de la parte longitudinal de las coordenadas.
	 * @param minutosLongitud nuevo valor para los minutos longitudinales. Sólo admite enteros no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @throws IllegalArgumentException Los minutos deben estar comprendidos entre 0 y 59 (Excepto si los grados valen 90 que deberan valer 0).
	 */
	public void setMinutosLongitud(int minutosLongitud) {
		if (minutosLongitud < 60 && minutosLongitud >= 0 && gradosLongitud < 180 && gradosLongitud >= 0 || minutosLongitud == 0 && segundosLongitud == 0 && gradosLongitud == 180){
			this.minutosLongitud = minutosLongitud;
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto de los minutos longitudinales.");
		}
	}
	/**
	 * Cambia el valor de los segundos de la parte longitudinal de las coordenadas.
	 * @param segundosLongitud nuevo valor para los segundos latitudinales. Sólo admite decimales no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @throws IllegalArgumentException Los segundos deben estar comprendidos entre 0 y 59 (Excepto si los grados valen 90 que deberan valer 0).
	 */
	public void setSegundosLongitud(double segundosLongitud) {
		if (segundosLongitud < 60 && segundosLongitud >= 0 && gradosLongitud < 180 && gradosLongitud >= 0 || segundosLongitud == 0 && minutosLongitud == 0 && gradosLongitud == 180){
			this.segundosLongitud = segundosLongitud;
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto de los segundos longitudinales.");
		}
	}
	/**
	 * Cambia el punto cardinal de la parte longitudinal de las coordenadas.
	 * @param puntoCardinalLongitud nuevo valor para el punto cardinal longitudinal. Sólo admite los carácteres 'E','O' y 'W'.
	 * @throws IllegalArgumentException El punto cardinal debe ser 'E', 'O' o 'W'.
	 */
	public void setPuntoCardinalLongitud(char puntoCardinalLongitud) {
		if (puntoCardinalLongitud == 'E' || puntoCardinalLongitud == 'O' || puntoCardinalLongitud == 'W'){
			this.puntoCardinalLongitud = puntoCardinalLongitud;
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto del cardinal longitudinal.");
		}
		
	}
	/**
	 * Consulta el valor de la latitud expresada en GD de las coordenadas.
	 * @return número decimal entre -90.0 y 90.0.
	 */
	public double getLatitudGD() {
		int signo = 1;
		
		if (getPuntoCardinalLatitud() == 'S') {
			signo = -1;
		}
		return signo*( getGradosLatitud() + ( getMinutosLatitud()/60.0 ) + ( getSegundosLatitud()/3600.0));
	}
	/**
	 * Consulta el valor de la longitud expresada en GD de las coordenadas.
	 * @return número decimal entre -180.0 y 180.0.
	 */
	public double getLongitudGD() {
		int signo = 1;
		
		if (getPuntoCardinalLongitud() == 'O' || getPuntoCardinalLongitud() == 'W') {
			signo = -1;
		}
		return signo*( getGradosLongitud() + ( getMinutosLongitud()/60.0 ) + ( getSegundosLongitud()/3600.0 ));
	
	}
	/**
	 * Cambia el valor de la latitud expresada en GD de las coordenadas.
	 * @param latitudGD nuevo valor para la latitud. Su valor absoluto debe ser menor o igual que 90.
	 * @throws IllegalArgumentException La latitud debe estar comprendida entre -90 y 90.
	 */
	public void setLatitudGD(double latitudGD) {
		if(abs(latitudGD) <= 90){
			char nuevoPuntoCardinalLatitud;
			if (latitudGD < 0) {
				nuevoPuntoCardinalLatitud = 'S';
				latitudGD = latitudGD * -1.0;
			}else{
				nuevoPuntoCardinalLatitud = 'N';
			}
			int nuevosGradosLatitud = (int)latitudGD;
			int nuevosMinutosLatitud = (int)((latitudGD - nuevosGradosLatitud) * 60);
			double nuevosSegundosLatitud = (((latitudGD - nuevosGradosLatitud) * 60.0) - (nuevosMinutosLatitud)) * 60.0;
			
			
			setGradosLatitud(nuevosGradosLatitud);
			setMinutosLatitud(nuevosMinutosLatitud);
			setSegundosLatitud(nuevosSegundosLatitud);
			setPuntoCardinalLatitud(nuevoPuntoCardinalLatitud);
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto de la latitud.");
		}
	}
	/**
	 * Cambia el valor de la longitud expresada en GD de las coordenadas.
	 * @param longitudGD nuevo valor para la longitud. Su valor absoluto debe ser menor o igual que 180.
	 * @throws IllegalArgumentException La longitud debe estar comrpendida entre -180 y 180.
	 */
	public void setLongitudGD(double longitudGD) {
		if (abs(longitudGD) <= 180){
			char nuevoPuntoCardinalLongitud;
			if (longitudGD < 0) {
				nuevoPuntoCardinalLongitud = 'O';
				longitudGD = longitudGD * -1.0;
			}else{
				nuevoPuntoCardinalLongitud = 'E';
			}
			int nuevosGradosLongitud = (int)longitudGD;
			int nuevosMinutosLongitud = (int)((longitudGD - nuevosGradosLongitud) * 60);
			double nuevosSegundosLongitud = (((longitudGD - nuevosGradosLongitud) * 60.0) - (nuevosMinutosLongitud)) * 60.0;
			
			
			setGradosLongitud(nuevosGradosLongitud);
			setMinutosLongitud(nuevosMinutosLongitud);
			setSegundosLongitud(nuevosSegundosLongitud);
			setPuntoCardinalLongitud(nuevoPuntoCardinalLongitud);
		}else{
			throw new IllegalArgumentException("Se ha introducido un valor incorrecto de la longitud.");
		}
	}
	/**
	 * Cambia el valor de las coordenadas expresadas en GD.
	 * @param latitudGD nuevo valor para la latitud. Su valor absoluto debe ser menor o igual que 90.
	 * @param longitudGD nuevo valor para la longitud. Su valor absoluto debe ser menor o igual que 180.
	 */
	public void setCoordenadasGD(double latitudGD,double longitudGD){
		setLatitudGD(latitudGD);
		setLongitudGD(longitudGD);
	}
	/**
	 * Cambia el valor de las coordenadas expresadas en GMS.
	 * @param gradosLatitud nuevo valor para los grados latitudinales, sólo admite números enteros no negativos menores o iguales que 90.
	 * @param minutosLatitud nuevo valor para los minutos latitudinales, sólo admite números enteros no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @param segundosLatitud nuevo valor para los segundos latitudinales, sólo admite números decimales no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @param cardinalLatitud acepta el carácter 'N' para el punto norte y 'S' para el punto sur.
	 * @param gradosLongitud nuevo valor para los grados longitudinales, sólo admite números enteros no negativos menores o iguales que 90.
	 * @param minutosLongitud nuevo valor para los minutos longitudinales, sólo admite números enteros no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @param segundosLongitud nuevo valor para los segundos longitudinales, sólo admite números decimales no negativos menores que 60 (Excepto si los grados valen 90, entonces debe valer 0).
	 * @param cardinalLongitud acepta el carácter 'E' para el punto este y tanto 'W' como 'O' para el punto oeste.
	 */
	public void setCoordenadasGMS(int gradosLatitud,int minutosLatitud, double segundosLatitud, char cardinalLatitud,int gradosLongitud,int minutosLongitud, double segundosLongitud, char cardinalLongitud) {
		setMinutosLatitud(minutosLatitud);
		setSegundosLatitud(segundosLatitud);
		setPuntoCardinalLatitud(cardinalLatitud);
		setGradosLatitud(gradosLatitud);
		
		setMinutosLongitud(minutosLongitud);
		setSegundosLongitud(segundosLongitud);
		setPuntoCardinalLongitud(cardinalLongitud);
		setGradosLongitud(gradosLongitud);
	}
	/**
	 * Obtiene una cadena con las coordenadas expresadas en GMS.
	 * @return cadena de carácteres que expresa las coordenadas en GMS.
	 */
	public String coordenadasGMSACadena() {
		return getGradosLatitud() + "º " + getMinutosLatitud() + "' " + getSegundosLatitud() + "\" " + getPuntoCardinalLatitud() + " " + getGradosLongitud() + "º " + getMinutosLongitud() + "' " + getSegundosLongitud() + "\" " + getPuntoCardinalLongitud();
	}
	/**
	 * Obtiene una cadena con las coordenadas expresadas en GD.
	 * @return cadena de carácteres que expresa las coordenadas en GD.
	 */
	public String coordenadasGDACadena() {
		
		return getLatitudGD() + ", " + getLongitudGD();
	}
	/**
	 * Consulta la distancia entre unas coordenadas y otras.
	 * @param otras coordenadas cuya distacia queremos conocer.
	 * @return número decimal que expresa la distancia entre los dos puntos de coordenadas.
	 */
	public double distancia(Coordenadas otras) {
		double dlon = toRadians(otras.getLongitudGD() - getLongitudGD());
		double dlat = toRadians(otras.getLatitudGD() - getLatitudGD());
		double a = pow(sin(dlat/2.0),2.0) + cos(toRadians(getLatitudGD())) * cos(toRadians(otras.getLatitudGD())) * pow(sin(dlon/2.0),2.0);
		double c = 2 * asin(min(1,sqrt(a)));
		
		return (double)round((6371000 * c) * 10000000d) / 10000000d;
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
		Coordenadas other = (Coordenadas) obj;
		if (gradosLatitud != other.gradosLatitud)
			return false;
		if (gradosLongitud != other.gradosLongitud)
			return false;
		if (minutosLatitud != other.minutosLatitud)
			return false;
		if (minutosLongitud != other.minutosLongitud)
			return false;
		if (puntoCardinalLatitud != other.puntoCardinalLatitud)
			return false;
		if (puntoCardinalLongitud != other.puntoCardinalLongitud)
			return false;
		if (abs(Double.doubleToLongBits(segundosLatitud) - Double.doubleToLongBits(other.segundosLatitud)) > 0.0001)
			return false;
		if (abs(Double.doubleToLongBits(segundosLongitud) - Double.doubleToLongBits(other.segundosLongitud)) > 0.0001)
			return false;
		return true;
	}
	
}
