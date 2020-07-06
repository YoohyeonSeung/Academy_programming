package CalenderHW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

class SwingCalendar extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Calendar calendar;

	private JLabel lbTitle, lbYear, lbMonth;
	private JTextField tfYear, tfMonth;
	private JButton btnInput;
	private JTextPane txtpnOutDate;

	private JPanel panelTitle, panelSelect;

	private int nYear, nMonth;
	private String stYear, stMonth;

	public SwingCalendar() {
		calendar = Calendar.getInstance();
		showCalendarFrame();
	}

	public void showCalendarFrame() {
		lbTitle = new JLabel("달력 프로그램", SwingConstants.CENTER);

		tfYear = new JTextField(5);
		lbYear = new JLabel("년 ");
		tfMonth = new JTextField(3);
		lbMonth = new JLabel("월 ");
		btnInput = new JButton("입력");

		// 년,월,입력버튼 콤포넌트 담을 패널 생성
		panelSelect = new JPanel();
		panelSelect.add(tfYear);
		panelSelect.add(lbYear);
		panelSelect.add(tfMonth);
		panelSelect.add(lbMonth);
		panelSelect.add(btnInput);

		// 패널로 구성하는 이유: lbTitle을 panelContent 영역 위에 정렬(출력) 시키기 위해...
		panelTitle = new JPanel(new GridLayout(2, 1));
		panelTitle.add(lbTitle);
		panelTitle.add(panelSelect);

		// 날짜 출력 영역
		txtpnOutDate = new JTextPane();
		txtpnOutDate.setEditable(false);
		txtpnOutDate.setFont(new Font("font", Font.BOLD, 16));
		txtpnOutDate.setForeground(Color.blue);

		Container ct = getContentPane();
		ct.add(panelTitle, "North");
		ct.add(txtpnOutDate, "Center");

		btnInput.addActionListener(this);

		setSize(600, 280);
		setLocation(300, 300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj == btnInput) {
			stYear = tfYear.getText();
			stMonth = tfMonth.getText();

			try {
				nYear = Integer.parseInt(stYear);
				nMonth = Integer.parseInt(stMonth);

				if (stYear.length() != 4 || (stMonth.length() != 2 && stMonth.length() != 1)) {
					txtpnOutDate.setText("년도(4자리) 혹은 월(1~2자리) 입력이 잘못되었습니다.");
					return;
				} else if ((nMonth <= 0) || (12 < nMonth)) {
					txtpnOutDate.setText("월 입력이 잘못되었습니다.");
					return;
				} else {
					showCalendar();
				}
			} catch (NumberFormatException ne) {
				txtpnOutDate.setText("입력된 년도와 월이 숫자형태가 아닙니다.");
				return;
			}
		}
	}

	public void showCalendar() {
		StringBuffer displayDate = new StringBuffer();
		int day = 1; // 달력 시작 일자

		displayDate.append("\t일\t월\t화\t수\t목\t금\t토\n");

		// Calendar에 년,월,일 셋팅
		calendar.set(nYear, nMonth - 1, 1);

		int startDay = calendar.get(Calendar.DAY_OF_WEEK); // 월 시작 요일
		int lastDay = calendar.getActualMaximum(Calendar.DATE); // 월 마지막 날짜

		for (int i = 1; i < startDay; i++) {
			displayDate.append("\t ");
		}

		for (int i = startDay; day <= lastDay; i++) {
			if (day < 10) {
				displayDate.append("\t  ");
			} else {
				displayDate.append("\t");
			}

			displayDate.append(day);
			txtpnOutDate.setText(displayDate.toString());

			if (i % 7 == 0) {
				displayDate.append("\n");
			}

			day++;
		}
	}
}

public class SwingCalendarMain {
	/*
	 * 문제) swing을 이용하여 년월을 입력받아 달력을 출력하는 프로그램을 작성하세요.
	 */

	public static void main(String[] args) {
		new SwingCalendar();
	}

}