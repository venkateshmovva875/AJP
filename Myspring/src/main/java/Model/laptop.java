package Model;

import org.springframework.stereotype.Component;

@Component("lap1")
public class laptop {
private int lid;
private String lnameString;
private String techString;
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
@Override
public String toString() {
	return "laptop [lid=" + lid + ", lnameString=" + lnameString + ", techString=" + techString + "]";
}
public String getTechString() {
	return techString;
}
public void setTechString(String techString) {
	this.techString = techString;
}
public laptop(int lid, String anameString, String techString) {
	super();
	this.lid = lid;
	this.lnameString = anameString;
	this.techString = techString;
}
public String getLnameString() {
	return lnameString;
}
public void setLnameString(String lnameString) {
	this.lnameString = lnameString;
}
public void compile()
{
	System.out.println("compiling");
}

}
