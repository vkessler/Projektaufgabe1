package package1;

import Prog1Tools.IOTools;

class Book {
	
	//Book b1 = new Book();
	final String title;
	final Author author;
	final String series;
	final int edition;
	
	public enum Verfuegbarkeit {
		AVAILABLE(0),
		RESERVED(1),
		CHECKED_OUT(2);
		
		private int status = 0;
		
		Verfuegbarkeit(int status) {
			this.status = status;
		}
	}
	
	Book(String title, Author author, int edition, String series) {
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.series = series;
	}
	
	Book(String title, Author author, int edition) {
		this.title = title;
		this.author = author;
		this.edition = edition;
		series = null;
	}
	
	Book(String title, Author author) {
		this.title = title;
		this.author = author;
		edition = 1;
		series = null;
	}
	
	Book(String title, Author author, String series) {
		this.title = title;
		this.author = author;
		this.series = series;
		edition = 1;
	}
	
	public static int strToInt( String str ){
	    int i = 0;
	    int num = 0;
	    boolean isNeg = false;

	    //Check for negative sign; if it's there, set the isNeg flag
	    if (str.charAt(0) == '-') {
	        isNeg = true;
	        i = 1;
	    }

	    //Process each character of the string;
	    while( i < str.length()) {
	        num *= 10;
	        num += str.charAt(i++) - '0'; //Minus the ASCII code of '0' to get the value of the charAt(i++).
	    }

	    if (isNeg)
	        num = -num;
	    return num;
	}
	
	public int objectID(Author author) {
		int t = strToInt(title);
		int l = strToInt(author.getLastname());
		int f = strToInt(author.getFirstname());
		int s = strToInt(series);
		return l + f + t + s;
		//return y;
	}
	
	public static Book readBookDataFromConsole() {
		Author a = Author.readAuthorDataFromConsole();
		System.out.println("Bitte den Buchtitel eingeben:");
		String t = IOTools.readString();
		System.out.println("Bitte die Editionsnummer eingeben:");		
		int e = IOTools.readInt();	
		System.out.println("Ist das Buch Teil einer Serie (\"true\" oder \"false\" eingeben) ?");
		if (IOTools.readBoolean()) {
			System.out.println("Bitte Serienname eingeben:");
			String s = IOTools.readString();
			return new Book(t, a, e, s);
		}	
		else return new Book(t, a, e); 		
	}

	public String toString() {
		String t = title;
		Integer ed = new Integer(edition);
		String e = ed.toString();
		String se = null;
		if (series != null) 
			se = series;
		else se = "";
		return "Buchtitel: " + t + "\n" + 
				"Autor: " + author.toString() + "\n" +
				"Edition: " + e + "\n" +
				"Serie: " + se + "\n" +
				"Objekt-ID: " + objectID(author);
	}

}
