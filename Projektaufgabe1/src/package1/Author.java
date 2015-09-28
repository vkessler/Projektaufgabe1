package package1;

import Prog1Tools.IOTools;


public class Author {
	
	/* implement nicht mehr veränderbar */ private String firstname, middlename, lastname;
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getMiddlename() {
		return middlename;
	}	
	
	public String getLastname() {
		return lastname;
	}
	
	Author(String firstname, String lastname) {
		this.firstname = firstname;
		middlename = null;
		this.lastname = lastname;
	}
	
	Author(String firstname, String middlename, String lastname){
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
	}

	public String toString() {
		String m = null;
		if (middlename != null) 
			m = middlename;
		else m = "";
		return firstname + m + lastname;
	}
	
	Author readAuthorDataFromConsole(){
		firstname = IOTools.readString();
		lastname = IOTools.readString();
		System.out.println("Hat der Autor einen Mittelnamen?");
		if (IOTools.readBoolean()) {
			middlename = IOTools.readString();
			return new Author(firstname, middlename, lastname);
		}	
		else return new Author(firstname, lastname); 
		
		
	}
	
}//end of Author
