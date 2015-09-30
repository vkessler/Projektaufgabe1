/**
 * 
 */
package library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BookCatalog {

	private Book[] books = new Book[0];
	
	public void registerNewBooks(Book... b) {
		Book[] newBookArray = new Book[books.length + b.length];
		for (int i = 0; i < books.length; i++) {
			newBookArray[i] = books[i];
		}
		for (int i = books.length; i < newBookArray.length; i++) {
			newBookArray[i] = b[i];
		}
		books = newBookArray;
		System.out.println("Es wurden " + b.length + " Bücher hinzugefügt.");
	}
	
	public Book getBookByID(int ID) {
		for (Book b : books) {
			if ( b.objectID() == ID )
			return b;
		}
		return null;
	}

	/**
	 * searches the books and returns only the ones with the respective status
	 * 
	 * @param status
	 * @return
	 */
	public Book[] getBooksByStatus(int status) {
		ArrayList<Book> res = new ArrayList<Book>();
		for (Book b : books)
			if (b.getStatus() == status)
				res.add(b);
		return res.toArray(new Book[res.size()]);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Book Catalog:");
		for (int i = 0; i < books.length; i++)
			sb.append("\n\t" + books[i]);
		return sb.toString();
	}

	/**
	 * loads an initial data set from the file inputdata.csv
	 * 
	 * * @return a Book [], will never be null but may have length 0
	 */
	public static Book[] preloadInitialDataSet() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("inputdata.csv"));
			ArrayList<Book> b = new ArrayList<Book>();
			String line;
			while ((line = br.readLine()) != null) {
				String[] splits = line.split(";");
				if (splits.length == 3) {
					b.add(new Book(splits[0], new Author(
							splits[1].split("\\s")[0],
							splits[1].split("\\s")[1]), Integer
							.parseInt(splits[2])));
				} else if (splits.length == 4) {
					b.add(new Book(splits[0], new Author(
							splits[1].split("\\s")[0],
							splits[1].split("\\s")[1]), Integer
							.parseInt(splits[2]), splits[3]));
				} else {
					System.out.println("Could not process line:" + line);
				}
			}
			for (Book book : b) {
				double random = Math.random();
				if (random > 0.5 && random < 0.75)
					book.setStatus(Book.RESERVED);
				else if (random >= 0.75)
					book.setStatus(book.CHECKED_OUT);
			}
			return b.toArray(new Book[b.size()]);

		} catch (Exception e) {
			System.out
					.println("There was an error while trying to load the initial data set:");
			e.printStackTrace();
			return new Book[0];
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}

	

}
