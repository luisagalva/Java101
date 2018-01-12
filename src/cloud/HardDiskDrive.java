package Cloud;

public class HardDiskDrive extends VirtualDevice {
	
	
	private double capacityGB;				// Capacidad en GB
	public final String label_prefix = "Hard Disk Drive";	                // Etiqueta
	
	
	
public HardDiskDrive( int unitNumber){
		
		super(unitNumber);
		
		StringBuilder sb = new StringBuilder().append(this.label_prefix).append(unitNumber);
		Description description = new Description(sb.toString(),"");
		this.setDescription(description);
		}
	
	public HardDiskDrive( int unitNumber, int nulo){
		
		super(unitNumber);
		
		StringBuilder sb = new StringBuilder().append(this.label_prefix).append(unitNumber);
		Description description = new Description(sb.toString(),"");
		this.setDescription(description);
		}

	
	public HardDiskDrive(double capacityGB, int unitNumber, int nulo){
		
		super(unitNumber);
		
		// Escribe tu código {
		StringBuilder sb = new StringBuilder().append(this.label_prefix).append(unitNumber);
		Description description = new Description(sb.toString(),"");
		this.setDescription(description);
		

		
			if(capacityGB<0 || capacityGB%40!=0){
				
				System.err.println("Disco debe ser mayor a 0 y múltiplo de 40");
			}
			
		this.capacityGB = capacityGB;
		// }
	}
	
	public void setCapacityGB(double capacityGB){
		this.capacityGB = capacityGB;
	}
	
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		// Escribe tu código {
		sb.append("Etiqueta : ").append(this.getDescription().getLabel()).append("\n");
		sb.append("Unidad : ").append(this.getUnitNumber()).append("\n");
		sb.append("Capacidad : ").append(capacityGB).append("GB\n");
		sb.append("\n");
		// }
		return sb.toString();
	}
}
