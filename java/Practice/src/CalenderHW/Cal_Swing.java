package CalenderHW;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class Cal_main extends JFrame implements ActionListener{

   private JTextField jtf_month;
   private JTextField jtf_year;
   
   private JTextArea jta;
   
   
   Cal_main(){
      JPanel jp1 = new JPanel();
      JPanel jp2 = new JPanel();
      JPanel jp3 = new JPanel();
      jp1.setLayout(new FlowLayout());  //title
      jp2.setLayout(new FlowLayout());  //Area to obtain information
      jp3.setLayout(new FlowLayout());  //TextArea
      
      
      
      JLabel jl_title = new JLabel("달력 프로그램"); 
         
      jtf_year = new JTextField(5);  //년도 입력
      JLabel jl_Year = new JLabel("년"); 
      jtf_month= new JTextField(3);      // 월 입력
      JLabel jl_month = new JLabel("월");       
      JButton PrintCal = new JButton("입력");
            
      jta = new JTextArea(15, 55);       //달력이 출력될 Area
   
      
      Container container = getContentPane();
      container.setLayout(new BorderLayout());
         
      
      jp1.add(jl_title);
      
         
      jp2.add(jtf_year);
      jp2.add(jl_Year);
      jp2.add(jtf_month);
      jp2.add(jl_month);   
      jp2.add(PrintCal);
      jp2.add(jp1);
      
      
      jp3.add(jta);
      
      container.add(jp1, BorderLayout.NORTH);
      container.add(jp2, BorderLayout.CENTER);
      container.add(jp3, BorderLayout.SOUTH);
   
      
      PrintCal.addActionListener(this);
      
      
      setTitle("달력 프로그램");
      setSize(600,400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
                  
   }
   //달력 출력 메소드
    @Override
   public void actionPerformed(ActionEvent e) {
    	
    		int Year = Integer.parseInt(jtf_year.getText());
    		int Month = Integer.parseInt(jtf_month.getText());
    		
    		
    		
    		if(Year<=1500) {
    			jta.append("너무 과거 시점입니다.\n 적당히 2200년 이전의 년도를 입력해주세요.\n");
    		}else if(Year>=2200) {
    			jta.append("너무 미래 시점입니다.\n 적당히 2200년 이전의 년도를 입력해주세요.\n");
    		}else if(Month>12) {
    			jta.append("월은 1월부터 12월까지입니다.\n 1이상 12이하의 값을 입력해주세요 \n");
    		}else {
    			jta.setText(""); //입력시마다 자료지움
    			Calendar today = Calendar.getInstance();
    			today.set(Year, Month-1,1);
    			
    			//입력받은 날의 마지막날짜 출력
    			int EndDayOfMonth = today.getActualMaximum(Calendar.DAY_OF_MONTH);
    			jta.append("\n     ");
    			jta.append("         일             월             화             수             목             금             토  \n");
    			int i=today.get(Calendar.DAY_OF_WEEK)-1; //첫째주 빈공간
    			
    			//첫째주 빈공간 출력
    			for(int j=0;j<i;j++) {
    				jta.append("                   "); 
    			}
    			int cnt=1;
    			
    			//첫재주 출력
    			for(int j=1;j<=7-i;j++) {
    				jta.append("       "+Integer.toString(j)+"        ");
    				cnt++;
    				if(j==7-i) jta.append("\n       ");
    			}
    			
    			
    			//나머지 주 출력
    			for(int k=cnt; k<=EndDayOfMonth;k++) {
    				if(k%7==(7-i)) {
    					jta.append("      	 "+Integer.toString(k)+"        ");
    					jta.append("\n          ");
    				}
    				
    				else if(k<10) {
    					jta.append("        "+Integer.toString(k)+"       ");
    				}
    				else {
    					jta.append("      "+Integer.toString(k)+"      ");
    				}				
    			}
    		}
    
   }
   
}


public class Cal_Swing {
   public static void main(String[] args) {
      new Cal_main();
   }
}