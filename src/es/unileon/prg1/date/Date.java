package es.unileon.prg1.date;
/*
*
*	Calse que respersenta una fecha y sus metodos.
*
*
*	@author Guzman Salas Florez
*	@version 1.0
*
*/
public class Date {
	/**
	*	int que representa el dia.
	**/
	
	private int day;
	
	/**
	*	int que representa el mes.
	**/
	
	private int month;
	
	/**
	*	int que representa el año.
	**/
	
	private int year;
	
	/**
	*	Constructor de la clase
	**/
	
	public Date(){

		this.day = 6;
		this.month = 1;
		this.year = 2021;
	}
	
	/**
	*	Constructor de la clase que comprueba si los valores de la fecha son validos antes de asignarlos.
	**/
	
	public Date(int day, int month, int year) throws DateException{
		if (year >= 0) {
			this.year = year;
		}else {
			throw new DateException("Año "+ year +" no valido");
		}
		if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido");
		} else {
			this.month = month;
		}
		if (correctDayForMonth(day,month) == false) {
			throw new DateException("Dia " + day + " no valido");
		}else {
			this.day = day;
			this.month = month;
			this.year = year;
	}	
	}
	
	/**
	 * Metodo auxiliar para comprovar que la fecha,concretamente el dia es posible.
	 * 
	 */
	
	 private boolean correctDayForMonth(int day,int month){
		boolean diaposible=true;

			switch (month) {
				case 1://next				
				case 3://next 
				case 5://next
				case 7://next
				case 8://next
				case 10://next
				case 12:
					if (day<1 || day>31) {
						diaposible=false;
					}
					break;
				case 2: 
					if (day<1 || day>28) {
						diaposible=false;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (day<1 || day>30) {
						diaposible=false;
					}
					break;
		}
		return diaposible ;
	}
	
	public Date(Date another){
		this.day = another.getDay();
		this.month = another.getMonth();
		this.year = another.getYear();
	}
	
	/**
	*	Set del dia.
	*
	**/
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	/**
	*	Set del mes.
	*
	**/
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	/**
	*	Set del anyo.
	*
	**/
	
	public void setYear (int year) {
		this.year = year;
	}
	
	/**
	*	Set del dia.
	*
	**/
	
	private int getDaysOfMonth(int month) {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	
	/**
	*
	*	Metodo que devuleve el dia siguiente al date.
	**/
	
	public Date tomorrow(){
		Date tomorrow = null;
		int dia1, mes1, year1;
				
		dia1 = this.day;
		mes1 = this.month;
		year1 = this.year;
		
		dia1++;
		if ( dia1 > this.getDaysOfMonth(month) ) {
			dia1 = 1;
			mes1++;
			if ( mes1 > 12 ) {
				mes1 = 1;
				year1++;
			}	
		}
		
		try{
			tomorrow = new Date(dia1, mes1, year1);
		} catch (DateException e){
			System.err.println(e.getMessage());
		}

		return tomorrow;
	}
	
	/**
	*
	*	Metodo que comprueba si dos fechas tienen el mismo dia.
	**/
	
	public boolean isSameDay(Date other){
		if ( this.day == other.getDay() )
			return true;
		else
			return false;
	}
	
	/**
	*
	*	Metodo que comprueba si dos fechas tienen el mismo mes.
	**/
	
	public boolean isSameMonth(Date other){
		if ( this.month == other.getMonth() ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	*
	*	Metodo que comprueba si dos fechas tienen el mismo año.
	**/
	
	public boolean isSameYear(Date other){
		return this.year == other.getYear();
	}
	
	/**
	*	Metodo que comprueba si dos fechas son iguales.
	**/
	
	public boolean isSame (Date other){
		return this.isSameDay(other) && this.isSameMonth(other) && this.isSameYear(other);
	}
	
	/**
	*
	*	Metodo que devuelve el mes de forma de String.
	**/
	
	private boolean isDayRight(int day){
		return ( ( day > 0 ) && (day <= this.getDaysOfMonth(this.month) ) );
	}
	
	/**
	*	Metodo que devuelve el mes de forma de String.
	**/
	
	public String getMonthName(){
		String nameM = null;
		switch (this.month){
		case 1:
			nameM = "Enero";
			break;
		case 2:
			nameM = "Febrero";
			break;
		case 3:
			nameM = "Marzo";
			break;
		case 4:
			nameM = "Abril";
			break;
		case 5:
			nameM = "Mayo";
			break;
		case 6:
			nameM = "Junio";
			break;
		case 7:
			nameM = "Julio";
			break;
		case 8:
			nameM = "Agosto";
			break;
		case 9:
			nameM = "Septiembre";
			break;
		case 10:
			nameM = "Octubre";
			break;
		case 11:
			nameM = "Noviembre";
			break;
		case 12:
			nameM = "Diciembre";
			break;
		}
		return nameM;
	}
	
	public int getDaysOfMonth(){
		return this.getDaysOfMonth(this.month);
	}
	
	/**
	*
	*	Metodo que devuelve la estacion  ala que pertenece la fecha en forma de String.
	**/
	
	public String getSeason(){
		String estacion = null;
		switch (this.month){
		case 1: 
		case 2: 
		case 3: 
			estacion = "Invierno";
			break;
		case 4: 
		case 5: 
		case 6:
			estacion = "Primavera";
			break;
		case 7: 
		case 8: 
		case 9:
			estacion = "Verano";
			break;
		case 10:
		case 11: 
		case 12:
			estacion = "Otonyo";
			break;
		}
		return estacion;
	}
	
	/**
	*
	*	Metodo que devuelve los meses que quedan para fin de año.
	**/
	
	public String getMonthsLeft(){

		StringBuilder salida = new StringBuilder();
		int i = this.month;
		if (this.month == 12) {
			salida.append("Quedan 0 mese para acabar el año ");
		}

		for (int j = this.month+1 ; j <= 12 ; j++) {
			this.month+=1;
			 salida.append(getMonthName());
			 salida.append(" ");
			 
		}
		this.month= i;
		return salida.toString();
	}
	
	/**
	*
	*	Metodo que devuelve la fecha en forma "escrita"
	**/
	
	public String stringVersionDate(){

		return this.day + " de " + this.getMonthName() + " de " + this.year;

	}
	
	/**
	*
	*	Metodo que devuelve una cadena de caracteres con los dias que faltan para final de mes.
	**/ 
	
	public String getDaysLeftOfMonth(){
		Date aux = tomorrow();
		StringBuffer daysLeft = new StringBuffer();
		
		try{
			for (int i = aux.getDay(); isDayRight(i); i++) {
				aux.setDay(i);
				daysLeft.append(aux.toString() + " ");
			}
		} catch (DateException e){
			System.err.println(e.getMessage());
		}
		return daysLeft.toString();
	}
	
	/**
	*
	*	Metodo que devuelve una cadena de caracteres con los  meses que tienen los mismo dias quel de la fecha.
	**/ 
	
	public String getMonthsSameDays(){
		Date aux = new Date(this);
		StringBuffer months = new StringBuffer();

		try{
			for ( int i = 1; i <= 12; i++) {
				aux.setMonth(i);
				if ( aux.getDaysOfMonth() == this.getDaysOfMonth() ) {
					months.append(aux.getMonthName() + " ");
				}
			}
		} catch (DateException e){
			System.err.println(e.getMessage());
		}
		return months.toString();
	}
	
	/**
	*
	*	Metodo que devuelve los dias que han pasado desde que comenzo el año.
	**/ 
	
	public int daysPast(){
		int pasados;
		pasados = 0;
		try{
			Date aux = new Date(1,1,this.year);
		
			for ( int i = 1; i < this.month; i++ ) {
				pasados += aux.getDaysOfMonth();
				aux.setMonth(i + 1);
			}
		} catch (DateException e){
			System.err.println(e.getMessage());
		}
		return pasados + this.day - 1;
	}
	
	/**
	*
	*	Metodo que devuelve el  numero de intentos que se necesitarian para tener la misma fecha de forma aleatoria.
	**/
	
	public int numRandomTriesEqualDate(){
		int intentos; 
		int diarandom; 
		int mesrandom; 
		int yearrandom;
        intentos = 0;
        
        try{
        	do{
				mesrandom = (int) (Math.random()*12) + 1;
				diarandom = (int) (Math.random()*this.getDaysOfMonth(mesrandom) ) + 1;
				yearrandom = this.year;
        		intentos++;
        	} while ( !this.isSame(new Date(diarandom ,mesrandom,yearrandom) ) );
		} catch (DateException e){
			System.out.println(e.getMessage());
		}

        return intentos;
	}
	/**
	*
	*	Metodo que devuelve el nombre del dia.
	**/
	private String nameOfDay(int day) {
		String nameday;
		switch (day) {
		case 1: 
			nameday = "Lunes";
			break;
		case 2: 
			nameday = "Martes";
			break;
		case 3: 
			nameday = "Miercoles";
			break;
		case 4: 
			nameday = "Jueves";
			break;
		case 5: 
			nameday = "Viernes";
			break;
		case 6: 
			nameday = "Sabado";
			break;
		case 7: 
			nameday = "Domingo";
			break;
		default:
			nameday = "Valor incorrecto";
		}
		return nameday;
	}
	
	/**
	*
	*	Metodo que devuelve que dia de la seman era el uno de enero del año de la fecha.
	**/
	
	public String dayFirstofYear(int diaunoenero){
		int diauno;
		
		diauno = ( daysPast() % 7 + diaunoenero ) % 7;
		
		return nameOfDay(diauno);
	}
}