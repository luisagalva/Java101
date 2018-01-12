package cloud;

import cloud.util.CloudUtil;

public class Main {
	// Método principal
	
	
	public static void main(String[] args) {
		if (args.length > 1){
			// 1. Creando objeto vm1 basado en VirtualMachine
			// Escribe tu código {
			String name = args[0];
			String guestOS = args[1];
			long memoryGB = Long.parseLong(args[2]);
			int cpuCount = Integer.parseInt(args[3]);
			
			VirtualMachine vm1 = new VirtualMachine(cpuCount, memoryGB, name, guestOS);
			
			// }
			
			NetworkCard nic1 = new NetworkCard(args[0], 1);
			NetworkCard nic2 = new NetworkCard(args[1], 2, 1000);

			// 2. Asignando nic1 y nic2 a VirtualMachine.nics
			// Escribe tu código {
				vm1.addNICs(nic1,nic2);
			// }

			// 3. Imprimiendo variables de VM1
			// Escribe tu código {
			CloudUtil.printVMInfo(vm1);
			CloudUtil.printNICInfo(nic1);
			CloudUtil.printNICInfo(nic2);
			// }
		} else {
			System.out.println("Al menos un argumento es necesario.");
			System.out.println("java -jar Cloud.jar \"name\" \"guestOs\" \"memoryGB\" \"cpuCount\"");
		}
	}
	

}
