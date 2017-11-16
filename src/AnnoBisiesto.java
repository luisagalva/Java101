/*
 * Compilación: java AnnoBisiesto.class
 * Ejecución: javac AnnoBisiesto 2015
 *
 * Imprime:
 * - Si el año de entrada es bisiesto = true o false
 *
 */
public class AnnoBisiesto{


	public static void main(String[] args){
		int anio = Integer.parseInt(args[0]);
		// Escribe tu código {

		// }
		System.out.println(esBisiesto(anio));
	}

	public static boolean esBisiesto (int anio)
	{
		if(anio%4 == 0){
			if(anio%100==0 && anio!=400)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else{
		return false;
	}

	}

}

