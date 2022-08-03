import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectStudnent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Registering driver...");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver registered....");

			System.out.println("Trying to connect to the DB");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");

			System.out.println("Connected to the DB : " + conn);

			System.out.println("trying to make a statment");
			Statement statement = conn.createStatement();
			System.out.println("Statement created : " + statement);

			System.out.println("Trying to execute the statement....");
			Scanner sc = new Scanner(System.in);
			int rolln = sc.nextInt();

			ResultSet rs = statement.executeQuery("SELECT * FROM STUDENT\r\n" + "			WHERE ROLLNO=" + rolln);
			System.out.println("Statement executed, got the result....");

			if (rs.next()) {

				int studentRollNo = rs.getInt(1);
				String studentName = rs.getString(2);
				Date studentBirthDate = rs.getDate(3);
				int physicsMark = rs.getInt(4);
				int chemMarks = rs.getInt(5);
				int totalScore = rs.getInt(6);
				String gradeOfStudentMarks = rs.getString(7);

				System.out.println("Student roll no :" + studentRollNo);
				System.out.println("Student Name :" + studentName);
				System.out.println("Student Birth Date :" + studentBirthDate);
				System.out.println("Physics Marks :" + physicsMark);
				System.out.println("Chemistry Marks :" + chemMarks);
				System.out.println("Total Score :" + totalScore);
				System.out.println("Grade of studnet :" + gradeOfStudentMarks);
				System.out.println("------------------------");
			}

			else {
				StundentNotFoundException ex = new StundentNotFoundException("Stundent NOT found : ");
				throw ex;
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
