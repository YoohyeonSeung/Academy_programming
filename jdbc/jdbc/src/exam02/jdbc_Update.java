package exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc_Update {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		Scanner input =  new Scanner(System.in);
		
		Connection con = null;
		Statement stmt=null;
		String sql = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			stmt = con.createStatement();
			
			System.out.println("회원 정보 수정");
			System.out.println("수정할 회원 번호를 입력 하세요:");
			String no = input.nextLine();		
			System.out.println("수정할 이름을 입력 하세요:");
			String name = input.nextLine();			
			System.out.println("수정할 이메일을 입력 하세요:");
			String email = input.nextLine();			
			System.out.println("수정할 전화 번호를 입력 하세요:");
			String tel = input.nextLine();
			
			
			sql = "update customer set name=' "+name+" ',email=' "+email+" ',tel=' "+tel+" ' where no = "+no;
			//작은따움표는 sql명령문에서 문자열은 작은 따움표로 해주기 때문에 꼭 넣어줘야 한다. 
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("데이터 수정 성공");
			}
			else {
				System.out.println("데이터 수정 실패");
			}			
			//System.out.println("데이터 베이스 연결 성공");
		} catch (Exception e) {
			//System.out.println("데이터 베이스 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				
				if(stmt!=null) { stmt.close();}
				
				if(con!=null) {	con.close();}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
