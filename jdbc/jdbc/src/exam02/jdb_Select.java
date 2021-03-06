package exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdb_Select {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		String sql=null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Connection con = null;
		int no=0;
		String name=null, email=null, tel=null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			stmt = con.createStatement();
			
			sql = "select * from customer";
			
			rs = stmt.executeQuery(sql);   //반환형이 ResultSet이므로 위에 먼저 변수 선언해줘야함.
			//select는 반환값이 있기 때문에 query이고 이게 아닌 입력, 업데이트, 삭제 기능은 출력이 없기때문에 executeUpdate를 이용한다.
			
			System.out.println("번호 \t 이름\t \t \t 이메일  \t\t 전화번호");
			System.out.println("--------------------------------------------------------------");
			
			while(rs.next()) {
				no = rs.getInt("no");
				name = rs.getString("name");
				email = rs.getString("email");
				tel = rs.getString("tel");
			
			
				System.out.printf("%d \t %s \t %s \t %s \n", no, name, email, tel);
			}
			
			
			//System.out.println("데이터 베이스 연결 성공");
					
			
		} catch (Exception e) {
			//System.out.println("데이터 베이스 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				if(con!=null) {	con.close();}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
