package exam03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc_Delete {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		Scanner input = new Scanner(System.in);
		
		
		Connection con = null;
		String sql=null;
		PreparedStatement pstmt = null;
		//Statement stmt=null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			//stmt=con.createStatement();
			
			System.out.println("****** 회원 삭제 기능 ******");
			System.out.println("삭제할 회원 번호 입력 : ");
			String no = input.nextLine();//일관성을 위해서 nextint를 하지 않음
			int chNo = Integer.parseInt(no);
			
			sql="delete from customer where no=?";
					
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, chNo);
			
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("회원 삭제 성공");
			}
			else {
				System.out.println("회원 삭제 실패");
			}
			
			//System.out.println("데이터 베이스 연결 성공");
			
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패");
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
