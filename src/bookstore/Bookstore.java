package bookstore;

import books.Books;

import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Bookstore{
	
	//TODO in remove cases set something to be an alternative to null parameters;
	//TODO Update enum method to keep up with the update of stock
	//TODO make connection to a database(Postgres);
	
	
	static List <Books> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<>();
		while(true) {
		
		Menu.menu();
		int bookId;
		System.out.println("Enter the operation wanted: ");
		int op = sc.nextInt();
		switch(op) {
			case 1:
				do {
				System.out.println("Enter book ID: ");
					bookId = sc.nextInt();
					}
					while(Books.isRegistered(list, bookId) == true);
				
				System.out.println("Enter book's name: ");
					String bookName = sc.nextLine();
					sc.nextLine();
					
					
				System.out.println("Enter book's description: ");
					String bookDescription = sc.nextLine();
					sc.nextLine();
				
					
				System.out.println("Enter book's price: ");
					double bookPrice = sc.nextDouble();
				
				System.out.println("Enter book quantity in stock: ");
					int quantityinStock = sc.nextInt();
				
					
				list.add(new Books(bookId, bookName, bookDescription, bookPrice, quantityinStock));
				
				System.out.print("Press any key to continue...");
				System.in.read();
				
				continue;
				
			case 2:
				System.out.println("Enter with which book you want to view the info: ");
				int intendedBook = sc.nextInt();
				Books bk = list.stream().filter(x -> x.getIdBook() == intendedBook).findFirst().orElse(null);
				System.out.println("Book info: "+ bk.toString());
				
				System.in.read();
				
				continue;
			
				
			case 3:
				for(Books register: list) {
					System.out.println(register.toString());
					System.out.println();
				}
				
				System.in.read();
				
				continue;
				
				
			case 4:
				System.out.println("Enter with which book you want to view the info: ");
				intendedBook = sc.nextInt();
				bk = list.stream().filter(x -> x.getIdBook() == intendedBook).findFirst().orElse(null);
				
				System.out.println("Book info now: "+ bk.toString());
				
				
				System.out.println("Enter which information you want to change: ");
				System.out.println("Enter 1 to edit the title, "
						+ "2 to edit the description, "
						+ "3 to edit the price, "
						+ "4 to edit the quantity, "
						+ "5 to edit all info");
				int editOneInfo = sc.nextInt();
				
				
				switch(editOneInfo) {
				case 1:
					System.out.println("enter the new title: ");
					String newTitle = sc.nextLine();
					sc.next();
					bk.setTitle(newTitle);
					System.out.println("Updated info");
					bk.toString();
					continue;
					
				case 2:
					System.out.println("enter the new description: ");
					String newDescription = sc.nextLine();
					sc.next();
					bk.setBookDescription(newDescription);
					System.out.println("Updated info");
					bk.toString();
					continue;
					
				case 3:
					System.out.println("enter the new price: ");
					double newPrice = sc.nextDouble();
					bk.setBookPrice(newPrice);
					System.out.println("Updated info");
					bk.toString();
					continue;
					
				case 4:
					System.out.println("enter the new Quantity: ");
					int newQuantity = sc.nextInt();
					bk.setQuantity(newQuantity);
					System.out.println("Updated info");
					bk.toString();
					continue;
					
				case 5: 
					System.out.println("Enter book's name: ");
						newTitle = sc.nextLine();
						sc.next();
						bk.setTitle(newTitle);
					
					System.out.println("Enter book's description: ");
						newDescription = sc.nextLine();
						sc.next();
						bk.setBookDescription(newDescription);
					
					System.out.println("Enter book's price: ");
						newPrice = sc.nextDouble();
						bk.setBookPrice(newPrice);
					
					System.out.println("Enter book quantity in stock: ");
						newQuantity = sc.nextInt();
						bk.setQuantity(newQuantity);
					System.out.println("updated data: "+ bk.toString());
					System.in.read();
					continue;
				}

	
			
			case 5:
				System.out.println("Enter the book ID you want to remove: ");
				int removedBook = sc.nextInt();
				bk = list.stream().filter(x -> x.getIdBook() == removedBook).findFirst().orElse(null);
				if(bk == null) {
					System.out.println("This ID does not exist\n"
							+ "Press any key to continue...");
					System.in.read();
					continue;
				}
				list.remove(list.indexOf(bk));
				continue;
				
			case 6:
				break;
		}
		break;
		}
		
		sc.close();
		
	}
}