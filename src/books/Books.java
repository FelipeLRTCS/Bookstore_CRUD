package books;

import java.util.List;

public class Books{
	
	private int idBook;
	private String title;
	private String bookDescription;
	private double bookPrice;
	private int quantity;
	private Disponibility status;
	
	public Books(int idBook, String title, String bookDescription, double price, int quantity){
		this.idBook = idBook;
		this.title = title;
		this.bookDescription = bookDescription;
		this.bookPrice = price;
		this.quantity = quantity;
		this.bookStatus();
		
	}
	
	public Books() {
		
	}
	
	
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	
	public int getIdBook() {
		return this.idBook;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	
	public String getBookDescription() {
		return this.bookDescription;
	}
	
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public double getBookPrice() {
		return this.bookPrice;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void bookStatus() {
		if(this.quantity > 0) {
			status = Disponibility.in_stock;
		}
		else {
			status = Disponibility.out_of_stock;
		}
	}
	
	
	public Disponibility getBookStatus() {
		return this.status;
	}
	
	public String toString() {
		return getIdBook()
				+ "\t"
				+ getTitle()
				+  "\n"
				+ getBookDescription()
				+ "\nR$ "
				+ getBookPrice()
				+ "\t"
				+ getQuantity()
				+ "\t"
				+ getBookStatus();
	}
	
	public static boolean isRegistered(List <Books> list, int bookId) {
		Books bookIdOg = list.stream().filter(x -> x.getIdBook() == bookId).findFirst().orElse(null);
		if(bookIdOg == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
}