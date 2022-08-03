import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public class HashSerialize  {
     public static void main(String[] args) {
    		Book book1 = new Book("Shweta Konde","123","90.8",300,200);
    		Book book2 = new Book("Vishwas Patil","128","90.0",900,800);
    		
    		HashSet<Book> bookShop = new HashSet<Book>();
    		bookShop.add(book1);
    		bookShop.add(book2);

    		
    		
    		
    		try {
				FileOutputStream fout  = new FileOutputStream("D:\\\\\\\\work_dsi\\\\\\\\java_traianing\\\\\\\\prince.txt");
				System.out.println("File is ready...");
				
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				System.out.println("Object stream is ready....");
				
				System.out.println("Trying to store the object...");
				oos.writeObject(bookShop);
				System.out.println("Object stored....");
				
				oos.close();
				fout.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
