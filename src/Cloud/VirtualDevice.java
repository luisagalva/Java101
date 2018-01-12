package Cloud;

import Cloud.Description;

public class VirtualDevice {
	
	private int key;
	private int unitNumber;
	private Description description;

		public VirtualDevice(int unitNumber){
			this.unitNumber = unitNumber;
		}
		
		public int getKey(){
			return this.key;
		}

		public int getUnitNumber() {
			return unitNumber;
		}

		public void setUnitNumber(int unitNumber) {
			this.unitNumber = unitNumber;
		}
		
		public Description getDescription(){
			return this.description;
		}

		public void setDescription(Description description) {
			this.description = description;
		}
		
}
