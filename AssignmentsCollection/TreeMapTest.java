import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapTest {
  public static void main(String[] args) {
	  Map<Integer,StudentMarks> tmap=new TreeMap<Integer,StudentMarks>();
	  tmap.put(20,new StudentMarks("Shweta",90));
	  tmap.put(30, new StudentMarks("Riya",80));
	  tmap.put(40, new StudentMarks("Aditi",85));
	  
	  tmap.remove(1);
	  tmap.replace(2,new StudentMarks("priya",80));
	  tmap.put(10,new StudentMarks("Swara",95));
	  System.out.println(tmap.values());
	  System.out.println(tmap.keySet());
	  
	  
	  TreeMap<Integer,StudentMarks> otmap=new TreeMap<Integer,StudentMarks>();
	  otmap.put(20,new StudentMarks("Swara",90));
	  otmap.put(30, new StudentMarks("Riya",80));
	  otmap.put(40, new StudentMarks("Aditi",85));
	  System.out.println(otmap.descendingMap());
	  
	 

	  
	  
	  //ordering the map
//	  NavigableMap<Integer,StudentMarks> treOrder=;
	  
	 
}
}


class StudentMarks{
	String name;
	int totalscore;
	public StudentMarks(String name, int totalscore) {
		super();
		this.name = name;
		this.totalscore = totalscore;
	}
	@Override
	public String toString() {
		return name+"'s score is "+totalscore+"/100"+"\n";
		
		
	}
	
}