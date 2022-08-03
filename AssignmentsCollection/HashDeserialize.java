import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;



public class HashDeserialize {
   public static void main(String[] args) {

		Book ba = null;
		System.out.println("Object is null...");
		
		try {
			FileInputStream fin  = new FileInputStream("D:\\\\\\\\work_dsi\\\\\\\\java_traianing\\\\\\\\prince.txt");
			System.out.println("File is ready..for reading.....");
			
			ObjectInputStream ois = new ObjectInputStream(fin);
			System.out.println("Object stream is ready...for reading object.");
			
			System.out.println("Trying to retrieve the object...");
			ba = (Book) ois.readObject();
			System.out.println("Object retrieved....");
			
			System.out.println("ba is : "+ba);
			
			ois.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
