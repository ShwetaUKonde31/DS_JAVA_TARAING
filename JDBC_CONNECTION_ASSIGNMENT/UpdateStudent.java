import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudent {

	public static void main(String[] args) {
		try {
			System.out.println("Registering driver...");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver registered....");

			System.out.println("Trying to connect to the DB");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");

			System.out.println("Connected to the DB : " + conn);

			System.out.println("trying to make a statment");
			PreparedStatement statement = conn
					.prepareStatement("UPDATE student set name=? ,birthdate=? where rollno=?");
			System.out.println("Statement created : " + statement);

			System.out.println("Trying to execute the statement....");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a id of student to change the name and birthdate");
			int rollno = sc.nextInt();

			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery("select * from student where rollno=" + rollno);
			System.out.println("Statement executed, got the result....");

			if (rs1.next()) {
				System.out.println("---CURRENT STUDNET DETAILS ----");
				int strollno = rs1.getInt(1);
				String stName = rs1.getString(2);
				Date stbirthdate = rs1.getDate(3);

				System.out.println("Student NO   : " + strollno);
				System.out.println("Studnet NAME : " + stName);
				System.out.println("Student bdate  : " + stbirthdate);
				System.out.println("------------------------");
			}

			else {
				StundentNotFoundException ex = new StundentNotFoundException("Student NOT found : ");
				throw ex;
			}

			System.out.println("Enter a name of student");
			String studentNa = sc.next();

			System.out.println("Enter a birth date of student");
			Date studBirthDate = Date.valueOf(sc.next());

			statement.setInt(3, rollno);// 1 specifies the first parameter in the query
			statement.setString(1, studentNa);
			statement.setDate(2, studBirthDate);

			int i = statement.executeUpdate();
			System.out.println("The updated records at index " + i);

			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
