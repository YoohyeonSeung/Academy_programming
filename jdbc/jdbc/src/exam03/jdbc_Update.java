package exam03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc_Update {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		Scanner input =  new Scanner(System.in);
		
		Connection con = null;
		PreparedStatement pstmt=null;
		//Statement stmt=null;
		String sql = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			//stmt = con.createStatement();
			
			System.out.println("회원 정보 수정");
			System.out.println("수정할 회원 번호를 입력 하세요:");
			String no = input.nextLine();		
			int changeNo = Integer.parseInt(no);
			System.out.println("수정할 이름을 입력 하세요:");
			String name = input.nextLine();			
			System.out.println("수정할 이메일을 입력 하세요:");
			String email = input.nextLine();			
			System.out.println("수정할 전화 번호를 입력 하세요:");
			String tel = input.nextLine();
			
			
			sql = "update customer set name=?, email=?, tel=? where no = ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, tel);
			pstmt.setInt(4, changeNo);
		
				
			
			int result = pstmt.executeUpdate();
			
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
				
				if(pstmt!=null) { pstmt.close();}
				
				if(con!=null) {	con.close();}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
