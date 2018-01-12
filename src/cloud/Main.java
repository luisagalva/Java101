package Cloud;

import java.io.IOException;

public class Main {
	// Método principal
	public static void main(String[] args) {


	    int[] memories = {0, 1024, 2048, 4096,0};
	    int[] cpus = {2, 1, 0, 2,0};
	    int[] disks = {10, 0, 40, 10,0};
	    String[] os = {"Ubuntu", "CentOS", "Windows", "OSX",""};

	    for (int i=0; i<=4; i++){
	    	CreateVM(memories[i],cpus[i],disks[i],i,os[i]);
	    }
			
			
	}
	
	public static void CreateVM(int memory, int cpu, int diskCapacity, int suffix, String os){
		
		VirtualMachine vm1;
		
			vm1 = new VirtualMachine(cpu, memory, "VirtualMachine_" + suffix, os);
			NetworkCard nic1 = new NetworkCard("122.22.22.22", 1);
			vm1.addNIC(nic1);
			HardDiskDrive hdd1 = new HardDiskDrive(diskCapacity, 1);
			vm1.addHDD(hdd1);
			// 5. Imprimiendo variables de VM1
			System.out.println("Resumen: ");
			System.out.println(vm1.toString());

			// 6. Imprimiendo variables de VM1.nics
			System.out.println("Detallado NICs: ");
			System.out.println(nic1.toString());
			// Escribe tu código {

			// }
			
			// 7. Imprimiendo variables de VM1.hdds
			System.out.println("Detallado HDDs: ");
			System.out.println(hdd1.toString());

	
		
					
	}
	

}
