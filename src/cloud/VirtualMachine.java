package cloud;

import java.util.HashMap;
import java.lang.*;

import cloud.util.CloudUtil;

public class VirtualMachine {
	final String id;         // Identificador único
	int cpuCount;            // Número de CPU
	long memoryGB;           // Memoria en GB
	boolean powerStatus;     // Estado
	String name;             // Nombre
	String guestOS;          // Sistema Operativo
	
	/* 
	 * VirtualMachine[1]:
	 * Variable nics de ser un arreglo de
	 * tipo NetworkCard a un HashMap de tipo 
	 * HashMap<Integer, NetworkCard> 
	 */
	HashMap<Integer, NetworkCard> nics = new HashMap<Integer, NetworkCard>();  // Tarjetas de Red Virtuales
	/*
	 * VirtualMachine[10]
	 * Agregar variable hdds de tipo 
	 * HashMap<Integer, HardDiskDrive>
	 */
	HashMap<Integer, HardDiskDrive> hdds = new HashMap<Integer, HardDiskDrive>();            // Discos duros virtuales

	/*
	 * VirtualMachine[6]
	 * Constructor debe validar lo siguiente:
	 * - cpuCount(int) mayor a 0
	 * - memoryGB(long) mayor o igual a 1024 y/o múltiplo de 1024
	 * - name(String) mayor a 5 caracteres
	 * - guestOS(String) mayor a 5 caracteres
	 */
	VirtualMachine(int cpuCount, long memoryGB, String guestOS){
		// Escribe tu código {
		if(cpuCount<=0){
			this.cpuCount = 1;
			System.err.println("Cpu count debe ser mayor a 0");
		}
		else{
			
			this.cpuCount = cpuCount;
		}
		
		if(memoryGB>=1024 && memoryGB%1024 == 0){
			this.memoryGB = memoryGB;}
		else{
			
			this.memoryGB = 1024;
			System.err.println("MemoryGB debe ser mayor a 1024 o un múltiplo de 1024");	}
		
		if(guestOS.length()>=5){
			this.guestOS = guestOS;
		}
		else{
			this.guestOS = guestOS;
			System.err.println("guestOS debe ser mayor a 5 caracteres");
		}
		
		// }
		this.id = CloudUtil.getUUID();
	}
	
	VirtualMachine(int cpuCount, long memoryGB, String name, String guestOS){
		// Escribe tu código {
		if(cpuCount<=0){
			this.cpuCount = 1;
			System.err.println("Cpu count debe ser mayor a 0");
		}
		else{
			this.cpuCount = cpuCount;
		}
		
		if(memoryGB>=1024 && memoryGB%1024 == 0){
			this.memoryGB = memoryGB;}
		else{
			
			this.memoryGB = 1024;
			System.err.println("MemoryGB debe ser mayor a 1024 o un múltiplo de 1024");	}
		
		if(guestOS.length()>=5){
			this.guestOS = guestOS;
		}
		else{
			this.guestOS = guestOS;
			System.err.println("guestOS debe ser mayor a 5 caracteres");
		}
		if(name.length()>=5){
			this.name = name;
		}
		else{
			this.name = name;
			System.err.println("Nombre debe ser mayor a 5 caracteres");
		}
		// }
		this.id = CloudUtil.getUUID();
	}
	
	String getID(){
		return this.id;
	}
	/*
	 * VirtualMachine[9]
	 * Crear método isPoweredOn regresando 
	 * un Boolean si la VM está prendida.
	 */
	boolean isPoweredOn() {
		/* Validar si la VM está prendida */
		// Escribe tu código {
		if(this.powerStatus){return true;}
		else{return false;}
		// }
		}
	/*
	 * VirtualMachine[8]
	 * Crear método isPoweredOff regresando 
	 * un Boolean si la VM está apagada.
	 */
	boolean isPoweredOff(){
		// Escribe tu código {
		if(!this.powerStatus){return true;}
		else{return false;}

		// }
	}
	
	int numberOfCPUs() {
		/* Obtener el número de CPUs de la VM */
		return this.cpuCount;
		}
	/* 
	 * VirtualMachine[4]
	 * Complementar Método powerOn: validar si la
	 *  VM está prendida e imprimir mensaje 
	 * informando que el estado es prendido.
	 */
	void powerOn() {
		/* Encender la VM */
		// Escribe tu código {
		if (!this.powerStatus){
		this.powerStatus = true;

		}
		System.out.println("La VM se ha encendido");
		// }
		}
	
	/* 
	 * VirtualMachine[5]
	 * Método powerOff: validar si la VM está prendida 
	 * e imprimir mensaje informando que el estado es apagado.
	 */
	void powerOff() {
		// Escribe tu código {
		if (this.powerStatus){
			this.powerStatus = false;

			}
			System.out.println("La VM se ha apagado");
		// }
		}
	
	void setName(String name) {
		/* Asignar nombre a la VM */
		this.name = name;
		}
	/* 
	 * VirtualMachine[2]
	 * Complementar Método addNIC(NetworkCard nic). 
	 * el id debe ser el valor de unitNumber
	 */
	void addNIC(NetworkCard nic) {
		/* Agregar NIC a la VM */
		// Escribe tu código {
		nics.put(nic.unitNumber,nic);
		// }
		}
	
	/* 
	 * VirtualMachine [3]
	 * Complementar Método addNICs 
	 * (HashMap<Integer, NetworkCard> nics)
	 */
	void addNICs(HashMap<Integer, NetworkCard> nics){
		/* Inicializar nics con un arrayList*/
		// Escribe tu código {
		this.nics = nics;
		// }
	}
	
	/*
	 * VirtualMachine 11
	 * Crear Métodos addHDD(HardDiskDrive hdd) y 
	 * addHDDs(HashMap<Integer, HardDiskDrive>) 
	 */
	void addHDD(HardDiskDrive hdd){
		/* Agregar HDD a la VM */
		// Escribe tu código {
		this.hdds.put(hdd.unitNumber, hdd);
		// }	
	}
	
	void addHDDs(HashMap<Integer, HardDiskDrive> hdds){
		/* Agregar HDDs a la VM */
		// Escribe tu código {
		this.hdds = hdds;
		// }	
	}
	/*
	 * VirtualMachine[7]
	 * Sobrecargar el método java.lang.Object.toString() para mostrar
	 *  la representación en String de VirtualMachine 
	 *  como lo hacía CloudUtil.printVMInfo() incluyendo:
	 *  - Los objetos NICs
	 *  - Los objetos HDDs
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		// Escribe tu código {
		sb.append("Nombre: ").append(this.name).append("\n");
		sb.append("CPU: ").append(this.cpuCount).append("\n");
		sb.append("Memoria : ").append(this.memoryGB).append("\n");
		sb.append("OS : ").append(this.guestOS).append("\n");
		sb.append("Estado : ");
		
		if(this.powerStatus){sb.append("Encendido").append("\n");}
		else{sb.append("Apagado").append("n");}
		
		sb.append("ID : ").append(this.id).append("\n");
		
		sb.append("NICs : ").append(this.nics.size()).append("\n");
		
		sb.append("HDDs : ").append(this.hdds.size()).append("\n");
		sb.append("\n");
		// }
		
		
		return sb.toString();
	}
}
