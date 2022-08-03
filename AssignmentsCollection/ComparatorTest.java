import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {
  public static void main(String[] args) {
	    ArrayList<StudentRank> ar = new ArrayList<StudentRank>();
	    ar.add(new StudentRank("Shweta",90));
	    ar.add(new StudentRank("Priya",80));
	    
	  // Sorting student entries by name
        Collections.sort(ar, new SortByStudentMarks());
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
 
	     
}
}

class StudentRank{
	 String name;
	 int number;
	public StudentRank(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	@Override
	public String toString() {
		return "StudentRank [name=" + name + ", number=" + number + "]";
	}
	
	 
}


class SortByStudentMarks implements Comparator<StudentRank>{

	@Override
	public int compare(StudentRank o1, StudentRank o2) {
		// TODO Auto-generated method stub
		
		return o2.number -o1.number;
	}
	 
}