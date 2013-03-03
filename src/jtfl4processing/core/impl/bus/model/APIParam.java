package jtfl4processing.core.impl.bus.model;

public class APIParam implements Comparable<APIParam>{

	private String key;
	private String value;
	private int index;
	
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getIndex() {
		return index;
	}

	@Override
	public int compareTo(APIParam p) {
		return this.index - p.getIndex();
	}
	public APIParam(String key, int index){
		this.key = key;
		this.index = index;
	}
}
