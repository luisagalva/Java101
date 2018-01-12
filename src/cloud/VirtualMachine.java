package cloud;

import cloud.util.CloudUtil;

public class VirtualMachine {
	public final static String id = CloudUtil.getUUID();  // Identificador único
	public int cpuCount;            // Número de CPU
	public long memoryGB;           // Memoria en GB
	public boolean powerStatus;     // Estado
	public String name;             // Nombre
	public String guestOS;          // Sistema Operativo
	public NetworkCard[] nics;      // Tarjetas de Red Virtuales
	
	VirtualMachine(int cpuCount, long memoryGB, String name, String guestOS){
		// Escribe tu código {
		this.cpuCount = cpuCount;
		this.memoryGB = memoryGB;
		this.name = name;
		this.guestOS = guestOS;
		
		// }
	}
	
	String getID(){
		return this.id;
	}
	
	boolean isPoweredOn() {
		/* Validar si la VM está prendida */
		return (this.powerStatus ? true : false);
		}
	
	int numberOfCPUs() {
		/* Obtener el número de CPUs de la VM */
		return this.cpuCount;
		}
	
	void powerOn() {
		/* Encender la VM */
		this.powerStatus = true;
		}
	
	void powerOff() {
		/* Apagar la VM */
		this.powerStatus = false;
		}
	
	void setName(String name) {
		/* Asignar nombre a la VM */
		this.name = name;
		}
	
	void addNICs(NetworkCard ... nics) {
		/* Asignar NICs a la VM */
		this.nics = nics;
		}
}
