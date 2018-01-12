package cloud;

import cloud.util.CloudUtil;

public class NetworkCard {
	public static final int MAX_SPEED_MB = 100;            
	public final String macAddress;            
	public final int unitNumber;  
	public final String label;
	public int speedMb = MAX_SPEED_MB;
	public String network;                                         

	NetworkCard(int unitNumber){
		this.unitNumber = unitNumber;
		this.label = "Network Card " + unitNumber;
		this.macAddress = CloudUtil.getMACAddress();
	}
	
	NetworkCard(String network, int unitNumber){
		this.network = network;
		this.unitNumber = unitNumber;
		this.label = "Network Card " + unitNumber;
		this.macAddress = CloudUtil.getMACAddress();
	}
	NetworkCard(String network, int unitNumber, int speedMb){
		this.network = network;
		this.unitNumber = unitNumber;
		this.speedMb = speedMb;
		this.label = "Network Card " + unitNumber;
		this.macAddress = CloudUtil.getMACAddress();
	}
}
