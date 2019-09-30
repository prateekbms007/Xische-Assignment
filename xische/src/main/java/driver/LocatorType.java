package driver;

public enum LocatorType {
	
	ID("id"),
	CLASSNAME("className"),
	XPATH("xpath");
	
	private String type;
	
	LocatorType(String type){
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
