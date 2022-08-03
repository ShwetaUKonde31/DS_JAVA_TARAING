import java.util.ArrayList;
import java.util.Scanner;

public class Department {

	private int depId;
	private String depName;
	private String depLocation;
	private int depNumberOfEmployee;

	public int getDepId() {
		return depId;
	}

	public String getDepName() {
		return depName;
	}

	public String getDepLocation() {
		return depLocation;
	}

	public int getDepNumberOfEmployee() {
		return depNumberOfEmployee;
	}

//	@Override
//	public String toString() {
//		return "Department [depId=" + depId + ", depName=" + depName + ", depLocation=" + depLocation
//				+ ", depNumberOfEmployee=" + depNumberOfEmployee + "]";
//	}
	
	public void printstudentData() {
		 System.out.println("Name of department: "+depName);
		 System.out.println("Department location : "+depLocation);
		 System.out.println("No. of employess in department : "+depNumberOfEmployee);
		 
	}
	
	

	public Department(int depId, String depName, String depLocation, int depNumberOfEmployee) {

		this.depId = depId;
		this.depName = depName;
		this.depLocation = depLocation;
		this.depNumberOfEmployee = depNumberOfEmployee;
	}

	public static void main(String[] args) {
		String ans;
		
		String ch = "y";
		ArrayList<Department> dept=new ArrayList<Department>();
		do {
		
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Do you want to create department...?");
			ans = sc.next();

			switch (ans.toLowerCase()) {
			case "y":
				
				System.out.println("Enter a id of a department:");
                 int departMentId =sc.nextInt();
				
				
				System.out.println("Enter a name of a deparment");
				String departmentName=sc.next();
				
				
				
				System.out.println("Enter a location of department");
				String departmemtLocation=sc.next();
				
	            System.out.println("Enter a number of employess in a department:");
				int numberOfEmpoyeeInDep=sc.nextInt();
			
				Department d=new Department(departMentId,departmentName,departmemtLocation,numberOfEmpoyeeInDep);
				
				dept.add(d);
			
				
				break;
			case "n":
				  System.out.println("*****Departmemt Records*****");
				 for (Department org : dept)
	               {
					 org.printstudentData();
	               }
				ch = "n";
				break;

			default:
				System.out.println("Do you want to continoue..?");
				break;
			}
		} while (ch == "y");

	}
}
