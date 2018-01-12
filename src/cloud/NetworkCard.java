package Cloud;


import Cloud.Util.CloudUtil;
import Cloud.Exceptions.*;
import Cloud.VirtualDevice;

public class NetworkCard extends VirtualDevice{
	
	public final String macAddress;  
	public final String label_prefix = "Network Card ";
	private String network;                                         

	/*
	 * NetworkCard[1]
	 * Reemplazar concatenación de strings 
	 * usando "+" por StringBuilder en 
	 * Constructores 
	 */
	public NetworkCard(int unitNumber){
		
		super(unitNumber);
		Description description = new Description(this.label_prefix + unitNumber,"");
		this.setDescription(description);
		
		if(unitNumber<1){
			try {
				throw new CloudGenericException("Unit number debe ser mayor a 0");
			} catch (CloudGenericException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		this.macAddress = CloudUtil.getMACAddress();
	}
	
	NetworkCard(int unitNumber, int nulo){
		
		super(unitNumber);
		Description description = new Description(this.label_prefix + unitNumber,"");
		this.setDescription(description);
		
		if(unitNumber<1){
			try {
				throw new CloudGenericException("Unit number debe ser mayor a 0");
			} catch (CloudGenericException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.macAddress = CloudUtil.getMACAddress();
	}
	
   NetworkCard(int unitNumber, int nulo, String network ){
		
		super(unitNumber);
		Description description = new Description(this.label_prefix + nulo,"");
		this.setDescription(description);
		
		if(unitNumber<1){
			try {
				throw new CloudGenericException("Unit number debe ser mayor a 0");
			} catch (CloudGenericException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.network = network;
		this.macAddress = CloudUtil.getMACAddress();
	}
	
	/*
	 * NetworkCard[2]
	 * obrecargar el método java.lang.Object.toString() para
	 * mostrar la representación en String de NetworkCard
	 * como lo hacía CloudUtil.printNICInfo()
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		// Escribe tu código {
		sb.append("Etiqueta : ").append(this.getDescription().getLabel()).append("\n");
		sb.append("Unidad : ").append(this.getUnitNumber()).append("\n");
		sb.append("MAC : ").append(macAddress).append("\n");
		sb.append("Network : ").append(network).append("\n");
		sb.append("\n");
		// }
		return sb.toString();
	}
}
