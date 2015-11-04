import java.io.*;
import java.util.*;
public class BookDatabase {
	
	
	/*IMPORTANT*********
	 * add combining methods for lists
	 * ie a parameter that searches the argument for
	 * the matching list of Books
	*/
	
	
	
	private ArrayList<Book> myBooks;
	
	public BookDatabase(){
		myBooks = new ArrayList<Book>();
	}
	public boolean addBook(Book book){
		return myBooks.add(book);
	}
	
	public boolean addBook(String author, String title, String genre, String series, int seriesNumber, String location, double readingLevel, int AR, int IL, int copyright, boolean read){
		return myBooks.add(new Book( author, title, genre,  series, seriesNumber, location, readingLevel, AR, IL, copyright, read));
	}
	
	public boolean addBook(String author, String title, String genre, String location, double readingLevel, int AR, int IL, int copyright, boolean read){
		return myBooks.add(new Book( author, title, genre, location, readingLevel, AR, IL, copyright, read));
	}
	
	public boolean addBook(String author, String title, String genre, String series, int seriesNumber, double readingLevel, int AR, int IL, int copyright){
		return myBooks.add(new Book( author, title, genre,  series, seriesNumber, readingLevel, AR, IL, copyright));
	}
	
	public boolean addBook(String author, String title, String genre, String series, int seriesNumber, String location, double readingLevel, int IL, int copyright){
		return myBooks.add(new Book( author, title, genre,  series, seriesNumber, location, readingLevel, IL, copyright));
	}
	
	public boolean addBook(String author, String title, String genre){
		return myBooks.add(new Book( author, title, genre));
	}
	public boolean addBook(String author, String title, String genre, String series, int seriesNumber){
		return myBooks.add(new Book( author, title, genre,  series, seriesNumber));
	}
	
	public List<String> bookListTitles(){
		List<String> books = new ArrayList<String>(myBooks.size());
		for(Book book : myBooks){
			books.add(book.getTitle());
		}
		return books;
	}
	
	public List<Book> bookList(){
		List<Book> books = new ArrayList<Book>(myBooks.size());
		for(Book book : myBooks){
			books.add(book);
		}
		return books;
	}
	
	public List<String> bookListConstrainedTitle(String titleStartsWith){ 
		List<String> books = this.bookListTitles();
		List<String> newBooks = new ArrayList<String>();
		for(String book : books){
			if(book.toUpperCase().startsWith(titleStartsWith.toUpperCase())){
				newBooks.add(book);
			}
		}
		return newBooks;
	}
	
	//finds books with the parameters, unless they are null. then it includes all of them
	public List<Book> bookListSearchedFor(String author, String title, String genre, double RL){
		List<Book> books = new LinkedList<Book>();
		List<Book> books2 = new LinkedList<Book>();

		//books.addAll(this.getAuthorBooks(author, books));
		//books.addAll(this.getTitleBooks(title, books));
		//books.addAll(this.getGenreBooks(genre, books));
		this.getReadingLevelBooks(RL, this.getGenreBooks(genre, this.getTitleBooks(title, this.getAuthorBooks(author, books))));
		for(Book b : books){
			boolean authorBool = ((b.getAuthor().equals(author)	||		author.equals("")));
			boolean titleBool = ((b.getTitle().equals(title)		||		title.equals("")));
			boolean genreBool =((b.getGenre().equals(genre)		||		genre.equals("")));
			boolean rlBool = ((b.getReadingLevel() == RL)		||		RL == 0.0);
			if(authorBool && titleBool && genreBool && true)	
				books2.add(b);
			
		}
		return books2;
	}
	public List<Book> getSeries(String series){
		List<Book> books = new LinkedList<Book>();
		for(Book b : myBooks){
			if(b.getSeries().equals(series)){
				books.add(b);
			}
		}
		return books;
	}
	
	public List<String> getSeriesTitles(String series){
		List<String> books = new LinkedList<String>();
		for(Book b : myBooks){
			if(b.getSeries().equals(series)){
				books.add(b.getTitle());
			}
		}
		return books;
	}
	
	public Book getBook(String title, String author){
		for(Book b : myBooks)
			if(b.getTitle().equals(title) && b.getAuthor().equals(author))
				return b;
		return null;
	}
	
	public List<Book> getAuthorBooks(String author, List<Book> books){
		//books = new LinkedList<Book>();
		for(Book b : myBooks){
			if(!books.contains(b) &&  b.getAuthor().equals(author)){
				books.add(b);
			}
		}
		return books;
	}
	
	public List<Book> getTitleBooks(String title, List<Book> books){
		//books = new LinkedList<Book>();
		for(Book b : myBooks){
			if(b.getTitle().equals(title) && !books.contains(b)){
				books.add(b);
			}
		}
		return books;
	}
	
	
	public List<Book> getGenreBooks(String genre, List<Book> books){
		//books = new LinkedList<Book>();
		for(Book b : myBooks){
			if(b.getGenre().equals(genre) && !books.contains(b)){
				books.add(b);
			}
		}
		return books;
	}
	
	public List<Book> getReadingLevelBooks(double RL, List<Book> books){
		//books = new LinkedList<Book>();
		for(Book b : myBooks){
			if(b.getReadingLevel() == RL && !books.contains(b)){
				books.add(b);
			}
		}
		return books;
	}
	
	
	
	public List<String> getAuthorBooksTitles(String author , List<Book> myList){
		List<String> books = new LinkedList<String>();
		for(Book b : myList){
			if(b.getAuthor().equals(author)){
				books.add(b.getTitle());
			}
		}
		return books;
	} 
	
	public boolean removeBook(String title, String author){
		for(Book b : myBooks)
			if(b.getTitle().equals(title) && b.getAuthor().equals(author))
				return myBooks.remove(b);
		return false;
	}
	
	
	public String load(String filename){
		int numLoaded = 0;

		try{
			//int numLoaded = 0;
			File file = new File(filename);
			Scanner scan  = new Scanner(file);
			String delim = ":;-\t";
			String debug = "";

			while(scan.hasNextLine()){
				String lineString = scan.nextLine();
				String[] line = lineString.split(delim);
				myBooks.add(new Book(line[0],
						workWithNullString(line[1]), 
						workWithNullString(line[2]), 
						workWithNullString(line[3]),
						workWithNull(line[4]), 
						workWithNullString(line[5]), 
						workWithNullDouble(line[6]),
						workWithNull(line[7]), 
						workWithNull(line[4]), 
						workWithNull(line[4]), 
						false)); //BAD CODE DONT LOOK
				
				numLoaded++;
				debug += line[0].replace("\t", "").replace(" ", "") + ";";
			}
			scan.close();
			return numLoaded + " Titles: "+ myBooks.toString();
		}
		catch(FileNotFoundException e){return null;}
		catch(ArrayIndexOutOfBoundsException e){return Integer.toString((int) numLoaded);}

	}
	
	public void save(String filename){
		try{
			PrintWriter writer = new PrintWriter(filename);
			for(Book book : myBooks){
				String author = book.getAuthor();
				String title = book.getTitle();
				String genre = book.getGenre();
				String series = book.getSeries();
				int seriesNumber = book.getSeriesNumber();
				String location = book.getLoc();
				double readingLevel = book.getReadingLevel();
				int AR = book.getAR();
				int IL = book.getIL();
				int copyright = book.getCopyright();
				boolean bool = book.getRead();
				String delim = ":;-\t";
				String line = author + delim + title + delim + genre + delim + series + delim +
										Integer.toString(seriesNumber) + delim + location + delim + 
										Double.toString(readingLevel) + delim + Integer.toString(AR) + 
										delim + Integer.toString(IL) + delim + Integer.toString(copyright) + delim + Boolean.toString(bool);
				writer.println(line);
			}
			writer.close();
		}
		catch(FileNotFoundException e){}
	}	
		
	private int workWithNull(String in){
		if(in.equals("\t") || in.equals(" \t")){
			return 0;
		}
		else return Integer.parseInt(in.replace("\t", ""));
	}
	private double workWithNullDouble(String in){
		
		try{
		if(in.equals("\t") || in.equals(" \t") || in.equals("n/a")){
			return 0.0;
		}
		else return Double.parseDouble(in.replace("\t", ""));
		}
		catch(NumberFormatException e) {return 0; }
	}
	private String workWithNullString(String in){
		if(in.equals("\t") || in.equals(" \t")){
			return "";
		}
		else return (in.replace("\t", ""));
	}
	/*Collections.sort(this.bookList(), new Comparator<Book>() {
        @Override
        public int compare(final Book object1, final Book Book) {
            return object1.getName().compareTo(object2.getName());
        }

		@Override
		public int compare(Book arg0, Book arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
       } );
  */
	
}
