import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.*;
public class BookListGUIGenre {
	
	public BookListGUIGenre(){
	}
	
	
	
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		        BookDatabaseGUI b = new BookDatabaseGUI(1200,900);
		      }
		    });
		  }
}
