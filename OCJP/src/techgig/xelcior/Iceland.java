package techgig.xelcior;

import java.util.ArrayList;
import java.util.List;

public class Iceland {
	String name;
	List<Iceland> connectedIceLand = new ArrayList<>();

	public Iceland(String name) {
		this.name = name;
	}

	public void addConnectedIceland(Iceland il){
		connectedIceLand.add(il);
	}
	
	public boolean canConnect(Iceland i){
		for(Iceland ci: connectedIceLand){
			if(i.name.equals(ci.name)){
				return true;
			}else{
				return ci.canConnect(i);
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public String toString() {
		return name;
	}

}
