package Cloud;
import Cloud.Exceptions.*;

public class HardDiskDrive {
	String id;						// Identificador único
	long capacityGB;				// Capacidad en GB
	int unitNumber;                 // Número de unidad
	String label;	                // Etiqueta
	
	/* 
	 * HardDiskDrive[1]
	 * Crear constructor y validar lo siguiente:
	 * - capacityGB debe ser mayor a 0 y múltiplo de 40
	 * HardDiskDrive[2]
	 * Reemplazar concatenación de strings 
	 * usando "+" por StringBuilder en Constructores 
	 */
	public HardDiskDrive(long capacityGB, int unitNumber){
		this.unitNumber = unitNumber;	
		// Escribe tu código {
		StringBuilder sb = new StringBuilder().append("Hard Disk ").append(unitNumber);
		this.label = sb.toString();
		
			if(unitNumber>=0 || unitNumber%40!=0){
			
			System.err.println("Unit Number debe ser mayor a 0 y multiplo de 40");
		}
			try {
			if(capacityGB<1){
				
					throw new CloudGenericException("CapacityGB debe ser mayor a 1GB");
				} 
			}catch (CloudGenericException e) {
				// TODO Auto-generated catch block
				System.out.println("Error: "+e.toString());
			}
		this.capacityGB = capacityGB;
		// }
	}
	
	/*
	 * HardDiskDrive[3]
	 * Sobrecargar el método 
	 * java.lang.Object.toString() para mostrar la 
	 * representación en String de HardDiskDrive
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		// Escribe tu código {
		sb.append("Etiqueta : ").append(label).append("\n");
		sb.append("Unidad : ").append(unitNumber).append("\n");
		sb.append("Capacidad : ").append(capacityGB).append("GB\n");
		sb.append("\n");
		// }
		return sb.toString();
	}
}
