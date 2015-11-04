
public class Book implements Comparable<Object>{
	private String myAuthor;
	private String myTitle;
	private String myGenre;
//	private boolean inSeries;
	private String mySeries;
	private int mySeriesNumber;
	private String myLocation;
	private double myReadingLevel;
	private int AR;
	private int IL;
	//private double RL;
	private int copyright;
	private boolean read;
	
	//Constructor with all parameters
	public Book(String author, String title, String genre, String series, int seriesNumber, String location, double readingLevel, int AR, int IL, int copyright, boolean read){
		myAuthor = author;
		myTitle = title;
		myGenre = genre;
		
		mySeries = series;
		mySeriesNumber = seriesNumber;
		
		myLocation = location;
		
		myReadingLevel = readingLevel;
		this.AR = AR;
		this.IL = IL;
		this.copyright = copyright;
	//	this.RL = RL;
		this.read = read;
	}
	
	//constructor for non series books
	public Book(String author, String title, String genre, String location, double readingLevel, int AR, int IL, int copyright, boolean read){
		myAuthor = author;
		myTitle = title;
		myGenre = genre;
		
		mySeries = null;
		mySeriesNumber = 0;
		
		myLocation = location;
		
		myReadingLevel = readingLevel;
		this.AR = AR;
		this.IL = IL;
		this.copyright = copyright;
		//this.RL = RL;
		this.read = read;
	}
	
	//Constructor for no location books
	public Book(String author, String title, String genre, String series, int seriesNumber, double readingLevel, int AR, int IL, int copyright){
		myAuthor = author;
		myTitle = title;
		myGenre = genre;
		
		mySeries = series;
		mySeriesNumber = seriesNumber;
		
		myLocation = null;
		
		myReadingLevel = readingLevel;
		this.AR = AR;
		this.IL = IL;
		this.copyright = copyright;
		read = false;
	}
	
	//Constructor for no AR Books
	public Book(String author, String title, String genre, String series, int seriesNumber, String location, double readingLevel, int IL, int copyright){
		myAuthor = author;
		myTitle = title;
		myGenre = genre;
		
		mySeries = series;
		mySeriesNumber = seriesNumber;
		
		myLocation = location;
		
		myReadingLevel = readingLevel;
		this.AR = 0;
		this.IL = IL;
		this.copyright = copyright;
		read = false;
	}

	//Basic Constructor
	public Book(String author, String title, String genre){
		myAuthor = author;
		myTitle = title;
		myGenre = genre;
		
		mySeries = null;
		mySeriesNumber = 0;
		read = false;
		myLocation = null;
		
		myReadingLevel = 0;
		this.AR = 0;
		this.IL = 0;
		this.copyright = 0;
	}

	//Basic with series
	public Book(String author, String title, String genre, String series, int seriesNumber){
		myAuthor = author;
		myTitle = title;
		myGenre = genre;
		read = false;
		mySeries = series;
		mySeriesNumber = seriesNumber;
		
		myLocation = null;
		
		myReadingLevel = 0;
		this.AR = 0;
		this.IL = 0;
		this.copyright = 0;
	}

	//getters
	public String getAuthor(){
		return myAuthor.replace("\t", "").replace( " ", "");
	}
	public String getTitle(){
		return myTitle;
	}
	public String getGenre(){
		return myGenre;
	}
	public String getSeries(){
		return mySeries;
	}
	public boolean inSeries(){
		if(mySeries.equals(""))
			return false;
		return true;
	}
	public int getSeriesNumber(){
		return mySeriesNumber;
	}
	public String getLoc(){
		return myLocation;
	}
	public int getAR(){
		return AR;
	}
	public int getIL(){
		return IL;  	
	}
	public int getCopyright(){
		return copyright;
	}
	public double getReadingLevel(){
		return myReadingLevel;
	}
	public boolean getRead(){
		return read;
	}
	//mutators
	public void setLoc(String newLocation){
		myLocation = newLocation; 
	}
	public void setAR(int newAR){
		AR = newAR;
	}
	public void setIL(int newIL){
		IL = newIL;
	}
	public void changeRead(){
		read = !read;
	}
	
	public Book setRL(double RL){
		myReadingLevel = RL;
		return this;
	}

	public int compareTo(Object book) {
		if(this.getTitle().equals(((Book) book).getTitle()) && this.getAuthor().equals(((Book)book).getAuthor()))
			return 0;
		if(this.getAuthor().equals(((Book)book).getAuthor()))
			return this.getTitle().compareTo(((Book)book).getTitle());
		else
			return this.getAuthor().compareTo(((Book)book).getAuthor());

	}
	
	public String toString(){
		return getAuthor() +":"+ getTitle();
	}
	









}
