import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
public class BookListGUI{
	private JFrame frame;
	private BookList library;
	
	
	public BookListGUI(int width, int height){
		library = new BookList();
		library.load("Trial.txt");
		frame = new JFrame("Book Catalogue");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setResizable(false);
		
		//MenuBar setup
		JMenuBar bar = new JMenuBar();
		JMenu loadBar = new JMenu("Load");
		JMenu saveBar = new JMenu("Save");
		JMenuItem loadFrom  = new JMenuItem("Load...");
		JMenuItem reload  = new JMenuItem("Reload");
		JMenuItem save  = new JMenuItem("Save");
		JMenuItem saveAs = new JMenuItem("Save As...");
		
		loadBar.add(loadFrom);
		loadBar.add(reload);
		saveBar.add(save);
		saveBar.add(saveAs);
		bar.add(loadBar);
		bar.add(saveBar);
		frame.setJMenuBar(bar);
		//MenuBar Listeners
		
		
		//the boxes
		Box bigBox = Box.createHorizontalBox();
		Box leftVBox = Box.createVerticalBox();
		Box rightVBox = Box.createVerticalBox();
		
		
		
		//left Box
		JLabel leftVBoxLabel = new JLabel("Related Books");
		JTextArea leftVBoxTextArea = new JTextArea("Scrolling Title and Authors\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		leftVBoxTextArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(leftVBoxTextArea,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		leftVBoxTextArea.setPreferredSize(new Dimension(width/2, height-50));
		leftVBoxTextArea.setSize(new Dimension(width/2, height-50));
		leftVBoxTextArea.setMaximumSize(new Dimension(width/2, height-50));
		leftVBoxTextArea.setMinimumSize(new Dimension(width/2, height-50));
		 
		leftVBox.add(leftVBoxLabel);
		leftVBox.add(Box.createVerticalStrut(10));
		leftVBox.add(scroll);
		
		
		
		//right box
		Box searchBox = Box.createVerticalBox();
		Box displayBox = Box.createVerticalBox();
		JTextArea bookInfo = new JTextArea("Book Info will go here");
		bookInfo.setEditable(false);
		displayBox.add(bookInfo);
		
		Box authorSearch = Box.createHorizontalBox();
		Box titleSearch = Box.createHorizontalBox();
		Box genreSearch = Box.createHorizontalBox();
		Box readingLevelSearch = Box.createHorizontalBox();	
		authorSearch.setPreferredSize(new Dimension(200,25));
		authorSearch.setSize(new Dimension(200,25));
		authorSearch.setMaximumSize(new Dimension(200,25));
		authorSearch.setMinimumSize(new Dimension(200,25));	
		titleSearch.setPreferredSize(new Dimension(200,25));
		titleSearch.setSize(new Dimension(200,25));
		titleSearch.setMaximumSize(new Dimension(200,25));
		titleSearch.setMinimumSize(new Dimension(200,25));
		genreSearch.setPreferredSize(new Dimension(200,25));
		genreSearch.setSize(new Dimension(200,25));
		genreSearch.setMaximumSize(new Dimension(200,25));
		genreSearch.setMinimumSize(new Dimension(200,25));
		readingLevelSearch.setPreferredSize(new Dimension(200,25));
		readingLevelSearch.setSize(new Dimension(200,25));
		readingLevelSearch.setMaximumSize(new Dimension(200,25));
		readingLevelSearch.setMinimumSize(new Dimension(200,25));

		JTextField authorSearchBar = new JTextField();
		JTextField titleSearchBar = new JTextField();
		JTextField genreSearchBar = new JTextField();
		JTextField readingLevelSearchBar = new JTextField();
		
		JLabel authorLabel = new JLabel("\tAuthor:\t");
		JLabel titleLabel = new JLabel("\tTitle:\t");
		JLabel genreLabel = new JLabel("\tGenre:\t");
		JLabel readingLevelLabel = new JLabel("\tReading Level:\t");

		JButton searchButton = new JButton("Search");
		
		
		authorSearch.add(authorLabel);
		authorSearch.add(Box.createHorizontalStrut(46));
		authorSearch.add(authorSearchBar);
		
		titleSearch.add(titleLabel);
		titleSearch.add(Box.createHorizontalStrut(60));
		titleSearch.add(titleSearchBar);
		
		genreSearch.add(genreLabel);
		genreSearch.add(Box.createHorizontalStrut(50));
		genreSearch.add(genreSearchBar);
		
		readingLevelSearch.add(readingLevelLabel);
		readingLevelSearch.add(Box.createHorizontalStrut(5));
		readingLevelSearch.add(readingLevelSearchBar);
		
		searchBox.add(authorSearch);
		searchBox.add(Box.createVerticalStrut(10));
		searchBox.add(titleSearch);
		searchBox.add(Box.createVerticalStrut(10));
		searchBox.add(genreSearch);
		searchBox.add(Box.createVerticalStrut(10));
		searchBox.add(readingLevelSearch);
		searchBox.add(Box.createVerticalStrut(10));
		searchBox.add(Box.createHorizontalBox().add(searchButton));
		

		
		rightVBox.add(searchBox);
		rightVBox.add(displayBox);
		bigBox.add(rightVBox);
		bigBox.add(Box.createHorizontalStrut(10));
		bigBox.add(leftVBox);
		frame.add(bigBox);
		
		
		//Listeners
		authorSearchBar.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					 	searchButton.doClick();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				 searchButton.doClick();
								
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}});

		titleSearchBar.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
				 	searchButton.doClick();
				}	
			}

			public void keyReleased(KeyEvent arg0) {
				searchButton.doClick();				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}});
		

		genreSearchBar.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
				 	searchButton.doClick();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				searchButton.doClick();
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}});


		readingLevelSearchBar.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
				 	searchButton.doClick();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				searchButton.doClick();
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}});


		
		searchButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				leftVBoxTextArea.setText("");

				String authorSearch = authorSearchBar.getText();
				String titleSearch = titleSearchBar.getText();
				String generSearch = genreSearchBar.getText();
				double readingLevel = -1;
				try{
				readingLevel = Double.parseDouble(readingLevelSearchBar.getText());
				}
				catch(NumberFormatException arg0){}
				//java.util.List<Book> slectedBooks = library.bookList();
				//slectedBooks.sort(null);
				//TreeSet<Book> shownBooks = new TreeSet<Book>();
				/*for(Book book : slectedBooks){
				}	
					if(authorSearch.equals(book.getAuthor()))
						shownBooks.add(book);
					if(titleSearch.equals(book.getTitle()))
						shownBooks.add(book);
					if(generSearch.equals(book.getGenre()) )
						shownBooks.add(book);
					if(readingLevel == book.getReadingLevel())
						shownBooks.add(book);
				}*/
				String s = "";
				for(Book b : library.bookListSearchedFor(authorSearch, titleSearch, generSearch, readingLevel)){
					if(!b.getRead())
						s +=  "  \"" + b.getTitle() + "\" \t Author:  " + b.getAuthor() + "\n";
				}
				leftVBoxTextArea.setText(s);
				}});
		
		frame.getContentPane().setBackground(new Color(200,250,200));
			
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	
	public static void main(String args[]){

		SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		        BookListGUI b = new BookListGUI(1100,900);
		      }
		    });
		  }
//
	}
