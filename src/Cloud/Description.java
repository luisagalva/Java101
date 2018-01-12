package Cloud;

public class Description {
	
	private String label;
	private String summary;
	
	
	public Description(String label, String summary){
		this.label = label;
		this.summary = summary;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
