package fecha;
/**
 * Clase que contiene informacion de la fecha (dia, mes, anyo)
 * @author pcarbonero
 */
public class Fecha {
	/**
	 * variable para los dias
	 */
	private int d; 
	/**
	 * variable para los meses
	 */
	private int m; 
	/**
	 * variable para los anyos
	 */
	private int a; 

	/**
	 * Constructor sin paraemtros de la clase
	 */
	public Fecha() {

	}

	/**
	 * Constructor con parametros de la clase
	 * @param dia 
	 * @param mes
	 * @param anio
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Funcion que comprueba si la fecha introducida es correcta
	 * @return devuelve true o false dependiendo de si la fecha es corecta o no
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Funcion que comprueba si el anyo es bisiesto
	 * @return devuelve true o false dependiendo de si es o no bisiesto
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Funcion que hace que avancen los dias
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Funcion que dconvierte la fecha a una cadena
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
