import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStudent {
	public static void main(String[] args) {
		try {
			// 1.Connect driver
			System.out.println("Registering driver...");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver registered....");

			// 2.Connect DB
			System.out.println("Trying to connect to the DB");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected to the DB : " + conn);

			// 3.Take a id which need to modify
			System.out.println("Trying to execute the statement....");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a id of studnent");
			int rollno = sc.nextInt();

			// 4.check whether the id is present that we want to delete
			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery("select * from student where rollno=" + rollno);
			System.out.println("Statement executed, got the result....");

			if (rs1.next()) {

				// 5.right a query
				PreparedStatement statement = conn.prepareStatement("delete from student  where rollno=?");

				// 6.pass the values
				statement.setInt(1, rollno);

				// 7.executeUpdate
				int i = statement.executeUpdate();
				System.out.println("deleted record" + i);

				// 8.close connection
				statement.close();
				conn.close();
			}

			else {
				StundentNotFoundException ex = new StundentNotFoundException("Studnet NOT found : ");
				throw ex;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}