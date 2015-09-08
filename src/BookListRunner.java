import java.io.FileNotFoundException;


public class BookListRunner{
	public static void main(String args[]){
		
		BookDatabase list = new BookDatabase();
		list.addBook(new Book("Bob", "The Art Of Bob", "Action").setRL(2.0));
		list.addBook(new Book("NotBob", "The Art Of Bob", "Action").setRL(9.0));
		list.addBook(new Book("IMBOB", "The Art Of Bob", "Action").setRL(6.8));
		list.addBook(new Book("Bob", "A POTATO Of Bob", "Action").setRL(6.8));
		list.addBook(new Book("Alec", "Foo", "CS"));
		list.addBook(new Book("Alec", "Fooey", "CS"));

		list.addBook(new Book("Alec", "Faonlkasjngweagnaw[o", "Action"));
		list.addBook(new Book("Alec", "Potato", "Action"));

		//list.addBook("Alec", "NotFoo", "CS");
		//list.addBook("Alec", "Fooey", "Action");

		//list.addBook("Alec", "sjadhgowaejnbgoweang", "CS");

		

		
		System.out.println(list.bookList());
		System.out.println(list.bookListConstrainedTitle("The"));
		
		list.save("Trial.txt");
		BookDatabase list2 = new BookDatabase();
		list2.load("Trial.txt");
		System.out.println(list.getAuthorBooksTitles("Alec", list.bookList()));

		
	}
	
	
	
	
	
}
