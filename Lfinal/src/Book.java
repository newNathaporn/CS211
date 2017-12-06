
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

public class Book {
	JFileChooser choos;
	
	public Book() {
		Pattern p =  Pattern.compile("([a-zA-Z_0-9 ]+)\\.[a-z]{3}");
		
		choos = new JFileChooser();
		choos.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = choos.showOpenDialog(null);
		if(option == JFileChooser.APPROVE_OPTION){
			File f = choos.getSelectedFile();
			
			
			HashSet<String> sevenFile = new HashSet<String>();   
			HashSet<String> threeFile = new HashSet<String>();
			
			readFileName(f, threeFile);
			
			try(FileReader fR = new FileReader(new File("bookList.txt"));
					BufferedReader bR = new BufferedReader(fR);){
				String str = bR.readLine();
			while (str != null) {
					sevenFile.add(str);
					str = bR.readLine();
			}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			//sevenFile.removeAll(threeFile); //อันที่ไม่มี 
			sevenFile.retainAll(threeFile);//อันที่มี อินเตอร์เซค
			
			for (String string : sevenFile) {
				System.out.println(string);
			}
			System.out.println("---------------");
			/* (String string : threeFile) {
				System.out.println(string);
			}*/
			
			
			
		}
		
	}
	
	public void readFileName(File file,HashSet<String> set) {
		Pattern p =  Pattern.compile("([a-zA-Z_0-9 ]+)\\.[a-z]{3}");
	
			File[] s = file.listFiles();
			for (File f : s) {
				if(f.isDirectory() ){
					readFileName(f, set);
				}
				Matcher mat = p.matcher(f.getName());
				if(mat.matches()){
					set.add(mat.group(1));
				}		
			}
			
			
		
	}
	
	public static void main(String[] args) {
		Book b = new Book();
		HashSet<BookName> book = new HashSet<BookName>();
		book.add(new BookName("Harry Potter"));
		book.add(new BookName("Harry Potter"));
		for (BookName bookName : book) {
			System.out.println(bookName.getName());
		}
		
	}

}
