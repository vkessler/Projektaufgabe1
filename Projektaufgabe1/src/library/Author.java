package library;


import Prog1Tools.IOTools;


class Author {
	
	final private String firstname, middlename, lastname;
	
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
		String first = IOTools.readString("Bitte den Vornamen eingeben:");
		String last = IOTools.readString("Bitte den Nachnamen eingeben:");
		if (IOTools.readBoolean("Hat der Autor einen Mittelnamen (\"true\" oder \"false\" eingeben) ?")) {
			String middle = IOTools.readString("Bitte Mittelnamen eingeben:");
			return new Author(first, middle, last);
		}	
		else return new Author(first, last); 
		
		
	}
	
}//end of Author
