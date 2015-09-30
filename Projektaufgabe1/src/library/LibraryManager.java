/**
 * 
 */
package library;

import Prog1Tools.IOTools;

 
public class LibraryManager {

	public static final int LIST = 0;
	public static final int LIST_BY_STATUS = 1;
	public static final int RESERVATION = 2;
	public static final int CHECK_OUT = 3;
	public static final int RETURN = 4;
	public static final int ADD = 5;
	public static final int EXIT = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BookCatalog catalog = new BookCatalog();
		catalog.registerNewBooks(BookCatalog.preloadInitialDataSet());
		System.out.println("Welcome to the library manager!");
		boolean running = true;
		while (running) {
			System.out.println("Please, enter one of the following commands:"
					+ "\n0 to list all books"
					+ "\n1 to list books filtered by status"
					+ "\n2 to make a reservation" + "\n3 to check out a book"
					+ "\n4 to return a book" + "\n5 to add a new book"
					+ "\n6 to exit.");
			int command = IOTools.readInt();
			switch (command) {
			case LIST:
				System.out.println(catalog);
				break;
			case LIST_BY_STATUS:

				Book[] queryResult = catalog
						.getBooksByStatus(IOTools
								.readInt("Please, enter the status code (0=AVAILABLE,1=RESERVED,2=CHECKED OUT:"));
				if (queryResult.length == 0)
					System.out.println("No books found for this status");
				else {
					StringBuffer sb = new StringBuffer("Search results:");
					for (Book b : queryResult)
						sb.append("\n\t" + b);
					System.out.println(sb.toString());
				}
				break;
			case RESERVATION:
				int id = IOTools.readInt("Please, enter book id:");
				Book b = catalog.getBookByID(id);
				if (b == null) {
					System.out.println("Error: Unknown book ID!");
					break;
				}
				b.setStatus(Book.RESERVED);
				System.out
						.println("The following reservation has been accepted:\n"
								+ b);
				break;
			case CHECK_OUT:
				id = IOTools.readInt("Please, enter book id:");
				b = catalog.getBookByID(id);
				if (b == null) {
					System.out.println("Error: Unknown book ID!");
					break;
				}
				if (b.getStatus() == Book.RESERVED)
					b.setStatus(Book.CHECKED_OUT);
				else if (b.getStatus() == Book.AVAILABLE) {
					System.out.println("You need to reserve this book first.");
					break;
				} else {
					System.out
							.println("This book has already been checked out.");
					break;
				}
				System.out.println("You have checked out the following book:\n"
						+ b);
				break;

			case RETURN:
				id = IOTools.readInt("Please, enter book id:");
				b = catalog.getBookByID(id);
				if (b == null) {
					System.out.println("Error: Unknown book ID!");
					break;
				}
				if (b.getStatus() == Book.CHECKED_OUT) {
					b.setStatus(Book.AVAILABLE);
					System.out
							.println("The following book has been returned:\n"
									+ b);
				} else
					System.out
							.println("You can only return checked-out books.");
				break;

			case ADD:
				b = Book.readBookDataFromConsole();
				catalog.registerNewBooks(b);
				System.out
						.println("The following book has been added to the catalog:\n"
								+ b);
				break;

			case EXIT:
				running = false;
				break;

			default:
				System.out.println("Unknown command: " + command);
				break;
			}
		}
		System.out.println("Byebye!");

	}
}
