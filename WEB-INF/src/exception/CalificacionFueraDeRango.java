package exception;

@SuppressWarnings("serial")
public class CalificacionFueraDeRango extends Exception{
	
	public  CalificacionFueraDeRango()  { super(); }
		 
		
		public CalificacionFueraDeRango(String message) {
			super(message);
		}

}
