package Cloud;

import java.util.HashMap;

public class Main {
	// Método principal
	public static void main(String[] args) {

			// 1. Crear objeto vm1 basado en VirtualMachine
			// Escribe tu código {
		
			VirtualMachine vm1 = new VirtualMachine(1, 1024, "VM1", "Ubuntu");

			// }
			NetworkCard nic1 = new NetworkCard("122.22.22.22", 1);
			NetworkCard nic2 = new NetworkCard("133.33.33.33", 2, 1000);

			// 2. Crear un HashMap<Integer, NetworkCard> para agregar los 
			//    objetos nic1 y nic2 creados previamente
			// Escribe tu código {
			
			HashMap<Integer, NetworkCard> nics = new HashMap<Integer, NetworkCard>();
			nics.put(nic1.unitNumber, nic1);
			nics.put(nic2.unitNumber, nic1);
			// }
			
			HardDiskDrive hdd1 = new HardDiskDrive(100, 1);
			HardDiskDrive hdd2 = new HardDiskDrive(120, 2);
			
			// 3. Crear un HashMap<Integer, HardDiskDrive> para agregar los 
			//    objetos hdd1 y hdd1 creados previamente
			// Escribe tu código {
			HashMap<Integer, HardDiskDrive> hdds = new HashMap<Integer, HardDiskDrive>();   
			hdds.put(hdd1.unitNumber, hdd1);
			hdds.put(hdd2.unitNumber, hdd1);
			// }		
			
			// 4. Asignar nics y hdds a VirtualMachine.nics y
			// VirtualMachine.hdds respectivamente
			// Escribe tu código {
			vm1.addNICs(nics);
			vm1.addHDDs(hdds);
			// }

			// 5. Imprimiendo variables de VM1
			System.out.println("Resumen: ");
			System.out.println(vm1.toString());

			// 6. Imprimiendo variables de VM1.nics
			System.out.println("Detallado NICs: ");
			System.out.println(nic1.toString());
			System.out.println(nic2.toString());
			// Escribe tu código {

			// }
			
			// 7. Imprimiendo variables de VM1.hdds
			System.out.println("Detallado HDDs: ");
			System.out.println(hdd1.toString());
			System.out.println(hdd2.toString());
			// Escribe tu código {

			// }
	}
	

}
