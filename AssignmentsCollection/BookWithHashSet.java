import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

public class BookWithHashSet {
	
	public static void main(String[] args) {
		
		
		Book book1 = new Book("Shweta Konde","123","90.8",300,200);
		Book book2 = new Book("Vishwas Patil","128","90.0",900,800);
		
		HashSet<Book> bookShop = new HashSet<Book>();
		bookShop.add(book1);
		bookShop.add(book2);

		for (Book book : bookShop) {
			System.out.println("The Book : "+book);
		}
		
	}
}


class Book implements Serializable{
	 String bookAuthor;
	 String bookNumber;
	 String bookEdition;
	 int noOfPages;
	 int price;
	public Book(String bookAuthor, String bookNumber, String bookEdition, int noOfPages, int price) {
		super();
		this.bookAuthor = bookAuthor;
		this.bookNumber = bookNumber;
		this.bookEdition = bookEdition;
		this.noOfPages = noOfPages;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookAuthor=" + bookAuthor + ", bookNumber=" + bookNumber + ", bookEdition=" + bookEdition
				+ ", noOfPages=" + noOfPages + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookAuthor, bookEdition, bookNumber, noOfPages, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookAuthor, other.bookAuthor) && Objects.equals(bookEdition, other.bookEdition)
				&& Objects.equals(bookNumber, other.bookNumber) && noOfPages == other.noOfPages && price == other.price;
	}
	 
}
