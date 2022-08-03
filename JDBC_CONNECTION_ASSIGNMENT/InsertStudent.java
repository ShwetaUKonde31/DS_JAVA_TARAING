import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStudent {

	public static void main(String[] args) {

		try {
			System.out.println("Registering driver...");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver registered....");

			// 1.connect the db
			System.out.println("Trying to connect to the DB");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");

			// 2.make prepared statement to insert the record
			System.out.println("trying to make a statment");
			PreparedStatement statement = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
			System.out.println("Statement created : " + statement);

			System.out.println("Trying to execute the statement....");
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter a id of student");
			int studentId = sc.nextInt();

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM student where rollno=" + studentId);
			if (rs.next()) {
				StudentAlreadyExistsException ex = new StudentAlreadyExistsException("Student already exists");
				throw ex;

			}

			System.out.println("----------Insert the student record------------------");
			System.out.println("Enter a name of student");
			String stdName = sc.next();
			
			System.out.println("Enter a birthdate of student");
			Date studBirthDate = Date.valueOf(sc.next());
			
			System.out.println("Enter a physic score of student :");
			int physics = sc.nextInt();
			
			System.out.println("Enter a chem score of student :");
			int chemistry = sc.nextInt();
			
			System.out.println("Enter a math score of student :");
			int maths = sc.nextInt();

			int totalScore = physics + chemistry + maths;

			String grade = "";
			if (totalScore > 250)
				grade = "A+";
			else if (totalScore > 225)
				grade = "A";
			else if (totalScore > 210)
				grade = "B+";
			else if (totalScore > 180)
				grade = "B";

			System.out.println("----------Stundent record is get added------------------");

			statement.setInt(1, studentId);// 1 specifies the first parameter in the query
			statement.setString(2, stdName);
			statement.setDate(3, studBirthDate);
			statement.setInt(4, physics);
			statement.setInt(5, chemistry);
			statement.setInt(6, maths);
			statement.setInt(7, totalScore);
			statement.setString(8, grade);

			int i = statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}