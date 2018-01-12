package cloud.util;

import java.util.Random;
import java.util.UUID;

import cloud.NetworkCard;
import cloud.VirtualMachine;

public class CloudUtil {
    static int macElements = 6;

    public static String getUUID(){
		return UUID.randomUUID().toString();
	}

	public static String getMACAddress(){
		/* Método para generar MAC addresses
		 * aleatorias con fines educativos
		 * Basado en método por Phate en 
		 * Stack Overflow
		 * */
	    Random random = new Random();
	    byte[] macAddress = new byte[macElements];

	    // Generar bytes aleatorios
	    random.nextBytes(macAddress);
	    
	    // Crear un StringBuilder de 18 elementos
	    // 64-D9-2C-A1-BD-B5
	    StringBuilder mac = new StringBuilder(18);

	    // Generar MAC Address basado en la generación
	    // aleatoria
    	int i = 0;
	    for(byte b : macAddress){
	    	mac.append(String.format("%02x%s", b, (mac.length() >= 0 && i < macElements -1 ? ":" : "")));
	    	i++;
	    }

	    // Regresar la dirección MAC en mayúsculas
	    return mac.toString().toUpperCase();
	}
	public static void printNICInfo(NetworkCard nic){
		// Escribe tu código {
			System.out.println("Network Card");
			System.out.println("macAddress= " + nic.macAddress);
			System.out.println("label = " + nic.label);
			System.out.println("speedMb = " + nic.speedMb);
			System.out.println("network = " + nic.macAddress);
			System.out.println("");
			
		// }
	}
	
	public static void printVMInfo(VirtualMachine vm){
		// Escribe tu código {
		System.out.println("Virtual Machine");
		System.out.println("id = " + vm.id);
		System.out.println("name = " + vm.name);
		System.out.println("guestOs = " + vm.guestOS);
		System.out.println("cpuCount = " + vm.cpuCount);
		System.out.println("memoryGB = "+ vm.memoryGB);
		System.out.println("nics = "+ vm.nics);
		System.out.println("");
			// }
	}
}
