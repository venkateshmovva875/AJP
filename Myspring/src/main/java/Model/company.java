package Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class company {
	private int id;
	private String nameString;
	@Autowired
	@Qualifier("lap1")
	private laptop laptop;
   public company() {
		super();
		System.out.println("object created");
	}
@Override
public String toString() {
	return "company [id=" + id + ", nameString=" + nameString + "]";
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNameString() {
	return nameString;
}
public void setNameString(String nameString) {
	this.nameString = nameString;
}
public company(int id, String nameString) {
	super();
	this.id = id;
	this.nameString = nameString;
}
public void show()
{
	System.out.println("inshow");
	laptop.compile();
}

   
}
