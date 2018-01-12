package Cloud;

import java.util.HashMap;
import Cloud.Interfaces.Powerable;


import Cloud.Util.CloudUtil;
import Cloud.Enums.PowerState;
import Cloud.Exceptions.CloudGenericException;

public class VirtualMachine implements Powerable {
	final String id;         // Identificador único
	private int cpuCount;            // Número de CPU
	private long memoryGB;           // Memoria en GB
	private String name;             // Nombre
	private String guestOS;          // Sistema Operativo
	private PowerState powerState = PowerState.POWERED_ON;
	
	
	HashMap<Integer, NetworkCard> nics = new HashMap<>();

	HashMap<Integer, HardDiskDrive> hdds = new HashMap<>();
	
	public String error;
	
	VirtualMachine(int cpuCount, long memoryGB, int disk, String guestOS){
		// Escribe tu código {
		try {
				if(cpuCount<=0){
			
							throw new CloudGenericException("Cpu count debe ser mayor a 0");
						}
				else{
					
					this.cpuCount = cpuCount;
					}
				} catch (CloudGenericException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		
		try{
		if(memoryGB<1){

			throw new CloudGenericException("MemoryGB debe ser mayor 1");
			}
		else{
			this.memoryGB = memoryGB;
				}
		}catch (CloudGenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		try{
			if(disk<1){

				throw new CloudGenericException("Disco debe ser mayor a 0");
				}
		
			}catch (CloudGenericException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		
		if(guestOS.length()>=5){
			this.guestOS = guestOS;
		}
		else{
			this.guestOS = guestOS;
			System.err.println("guestOS debe ser mayor a 5 caracteres");
		}
		
		
		this.id = CloudUtil.getUUID();
	}
	
	VirtualMachine(int cpuCount, long memoryGB, String name, int disk, String guestOS) {
		this.name = name;
		
		
		if(guestOS.length()<=5){

			System.err.println("Se recomienda nombres mayores a 5 caracteres");
			}
	
		
		
		try {
			if(cpuCount>0){
				this.cpuCount = cpuCount;
					}
			else{
				
				throw new CloudGenericException("Cpu debe ser mayor a 0");
				}
			} catch (CloudGenericException e) {
			// TODO Auto-generated catch block
				error =  e.toString();
	      }
	
	
		try{
			if(memoryGB<1){
				
				throw new CloudGenericException("Memoria debe ser múltiplo de 1024");
				}
			
				this.memoryGB = memoryGB;
	}catch (CloudGenericException e) {
		// TODO Auto-generated catch block
	
		error = e.toString();
		
	}
		try{
			if(memoryGB%1024 != 0){
				
				throw new CloudGenericException("Memoria debe ser mayor o igual a 1024");
				}
			
				this.memoryGB = memoryGB;
	}catch (CloudGenericException e) {
		// TODO Auto-generated catch block
	
		error =  e.toString();
		
	}
		
		try{
			if(disk<1){

				throw new CloudGenericException("Disco debe ser mayor a 0");
				}
		
			}catch (CloudGenericException e) {
				// TODO Auto-generated catch block
				error = e.toString();
			
			}
		
		this.guestOS = guestOS;
		
		
	
		// }
		this.id = CloudUtil.getUUID();
		
	}
	
	@Override
	public void powerOn() {
		
		this.powerState = PowerState.POWERED_ON;
		System.out.println("La VM se ha encendido");
		// }
		}
	
	public void powerOff() {
		
		this.powerState = PowerState.POWERED_OFF;
			
			System.out.println("La VM se ha apagado");
		// }
		}
	
	public void suspend() {
		this.powerState = PowerState.SUSPENDED;
		System.out.println("La vm se ha suspendido");
		
	}
	
	public PowerState getPowerState() {
		return powerState;
	}

	public void setPowerState(PowerState powerState) {
		this.powerState = powerState;
	}
	
	public int getCpuCount() {
		return this.cpuCount;
		}
	
	public void setCpuCount(int cpuCount){
		this.cpuCount = cpuCount;
	}
	
	public long getMemoryGB() {
		return this.memoryGB;
		}
	
	public void setMemoryGB(long memoryGB){
		this.memoryGB = memoryGB;
	}
	
	public String getName() {
		return this.name;
		}
	
	public void setName(String name) {
		this.name = name;
		}
	
	public String getGuestOS(){
		return this.guestOS;
	}
	
	public void setGuestOS(String guestOS){
		this.guestOS = guestOS;
	}
	
	public HashMap<Integer, NetworkCard> getNICs(){
		return this.nics;
	}
	
	public void setNICs(HashMap<Integer, NetworkCard> nics){
		
		this.nics = nics;
		
	}
	
	public HashMap<Integer, HardDiskDrive> getHDDs(){
		return this.hdds;
	}
	
	public void setHDDs(HashMap<Integer, HardDiskDrive> hdds){
		
		this.hdds = hdds;
		
	}
	
	public String getId(){
		return this.id;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		// Escribe tu código {
		sb.append("Nombre: ").append(this.name).append("\n");
		sb.append("CPU: ").append(this.cpuCount).append("\n");
		sb.append("Memoria : ").append(this.memoryGB).append("\n");
		sb.append("OS : ").append(this.guestOS).append("\n");
		sb.append("Estado : ");
		
		switch(this.powerState){
		
		case POWERED_ON:
			sb.append("encendida").append("\n");
			break;
			
		case POWERED_OFF:
			sb.append("apagada").append("\n");
			break;
			
		case SUSPENDED:
			sb.append("suspendida").append("\n");
			break;
		}
		sb.append("ID : ").append(this.id).append("\n");
		
		sb.append("NICs : ").append(this.nics.size()).append("\n");
		
		sb.append("HDDs : ").append(this.hdds.size()).append("\n");
		sb.append("\n");
		// }
		
		
		return sb.toString();
	}

	

	
}
