package package1;

import Prog1Tools.IOTools;


class Author {
	
	/*final ??? */ final private String firstname, middlename, lastname;
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getMiddlename() {
		return middlename;
	}	
	
	public String getLastname() {
		return lastname;
	}
	
//	{// INIT-Block für Konstruktoren		
//	this.firstname = firstname;
//	this.lastname = lastname;
//	}
	
	Author(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;		
		middlename = null;		
	}
	
	Author(String firstname, String middlename, String lastname){
		this.firstname = firstname;
		this.lastname = lastname;		
		this.middlename = middlename;		
	}

	public String toString() {
		String m = null;
		if (middlename != null) 
			m = middlename + " ";
		else m = "";
		return firstname + " " + m + lastname;
	}
	
	public static Author readAuthorDataFromConsole(){
		System.out.println("Bitte den Vornamen eingeben:");
		String first = IOTools.readString();
		System.out.println("Bitte den Nachnamen eingeben:");		
		String last = IOTools.readString();
		System.out.println("Hat der Autor einen Mittelnamen (\"true\" oder \"false\" eingeben) ?");
		if (IOTools.readBoolean()) {
			System.out.println("Bitte Mittelnamen eingeben:");
			String middle = IOTools.readString();
			return new Author(first, middle, last);
		}	
		else return new Author(first, last); 
		
		
	}
	
}//end of Author
