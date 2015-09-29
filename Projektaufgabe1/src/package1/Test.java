package package1;

public class Test {

	public static void main(String[] args) {
		
//		Author a1 = Author.readAuthorDataFromConsole();
//		System.out.println(a1);
//		a1 = Author.readAuthorDataFromConsole();
//		System.out.println(a1);
		
		Author a2 = new Author("Robert", "Anton", "Wilson");
		Book b1 = new Book("Das Auge in der Pyramide", a2, 1, "Illuminatus!");
		
		System.out.println(b1.objectID(a2));
		
		System.out.println(b1);
		

	}

}
