package exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc_Insert {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		Connection con = null;
		Statement stmt = null;
		
		Scanner input =  new Scanner(System.in);
		String no=null, name=null, email=null, tel=null;
		String sql=null;
				
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pw);
			stmt = con.createStatement();
			 
			//System.out.println("연결 성공");
			
			System.out.println("테이블에 입력할 값 입력 받기");
			System.out.print("번호 입력 : ");
			no = input.nextLine();
			System.out.print("이름 입력 : ");
			name = input.nextLine();
			System.out.print("이메일 입력 : ");
			email = input.nextLine();
			System.out.print("전화번호 입력 : ");
			tel = input.nextLine();
			
			sql = "insert into customer values("+no+",' "+ name+" ',' "+ email+" ',' " +tel+" ')";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("데이터 저장 성공");
			}
			else {
				System.out.println("데이터 저장 실패");
			}
			
			
			
			
		} catch (Exception e) {
			//System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) { stmt.close();}
				if(con!=null) { con.close();  }
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
