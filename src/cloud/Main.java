package Cloud;


import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	// Método principal
	
	static ArrayList<String> errors = new ArrayList<>();
	
	public static void main(String[] args) {


			int[] memories = {0, 1024, 2048, 4096, 5000};
			int[] cpus = {2, 1, 0, 2, 1};
			int[] disks = {10, 0, 40, 10, 80};
			String[] os = {"Ubuntu", "CentOS", "Windows", "OSX", "Suse"};
			
			
			
	    for (int i=0; i<5; i++){
	    	createVM(memories[i],cpus[i],disks[i],i,os[i]);
	
	    }
	    
	    for(String error : errors){
	    	System.out.println(error);
	    }
	    
			
			
	}
	
	public static void createVM(int memory, int cpu, int diskCapacity, int suffix, String os){
		
		  VirtualMachine vm1;
		
			vm1 = new VirtualMachine(cpu, memory, "VirtualMachine_" + suffix, diskCapacity, os);
			
			NetworkCard nic1 = new NetworkCard(1000, 1, "128.100.100.100");
			NetworkCard nic2 = new NetworkCard(2000, 2, "128.100.100.100");
			HashMap<Integer, NetworkCard> nics = new HashMap<>();
			nics.put(1, nic1);
			nics.put(2, nic2);
			vm1.setNICs(nics);
			
			HardDiskDrive hdd1 = new HardDiskDrive(diskCapacity, 1, diskCapacity);
			HardDiskDrive hdd2 = new HardDiskDrive(diskCapacity, 2, diskCapacity);
			HashMap<Integer, HardDiskDrive> hdds = new HashMap<>();
			hdds.put(1, hdd1);
			hdds.put(2, hdd2);
			vm1.setHDDs(hdds);

			
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

			if(vm1.error != null){
				errors.add("vm" +  suffix + " "+ vm1.error);}
		
					
	}
	

}
