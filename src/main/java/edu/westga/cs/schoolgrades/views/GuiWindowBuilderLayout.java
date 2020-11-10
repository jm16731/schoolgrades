package edu.westga.cs.schoolgrades.views;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class GuiWindowBuilderLayout extends JFrame {
	protected JButton btnAddHomework;
	protected JButton btnAddExam;
	protected JLabel lblQuizzes;
	protected JLabel lblHomework;
	protected JLabel lblExams;
	protected JTable tableQuiz;
	protected JTable tableHomework;
	protected JTable tableExam;
	protected JTextField textFieldQuizSubtotal;
	protected JTextField textFieldHomeworkSubtotal;
	protected JTextField textFieldExamSubtotal;
	protected JTextField textFieldFinalGrade;
	protected JSpinner spinnerQuizWeight;
	protected JSpinner spinnerHomeworkWeight;
	protected JSpinner spinnerExamWeight;
	protected JLabel lblWeight;
	protected JLabel lblSubtotal;
	protected JLabel lblFinalGrade;
	protected JCheckBox chckbxDropLowestHomeworkGrade;
	protected JButton btnAddQuiz;
	protected JScrollPane scrollPaneQuiz;
	protected JScrollPane scrollPaneHomework;
	protected JScrollPane scrollPaneExam;
	
	public GuiWindowBuilderLayout() {
		setPreferredSize(new Dimension(730, 680));
		setSize(new Dimension(730, 680));
		getContentPane().setLayout(null);
		
		btnAddExam = new JButton("Add Exam");
		this.btnAddExam.setToolTipText("Add a student's exam grade");
		this.btnAddExam.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddExam.setBounds(554, 46, 114, 30);
		getContentPane().add(btnAddExam);
		
		btnAddHomework = new JButton("Add Homework");
		this.btnAddHomework.setToolTipText("Add a student's homework grade");
		this.btnAddHomework.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddHomework.setBounds(353, 46, 161, 30);
		getContentPane().add(btnAddHomework);
		
		this.lblQuizzes = new JLabel("Quizzes");
		this.lblQuizzes.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.lblQuizzes.setBounds(189, 21, 48, 14);
		getContentPane().add(this.lblQuizzes);
		
		this.lblHomework = new JLabel("Homework");
		this.lblHomework.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.lblHomework.setBounds(353, 21, 66, 14);
		getContentPane().add(this.lblHomework);
		
		this.lblExams = new JLabel("Exams");
		this.lblExams.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.lblExams.setBounds(554, 21, 48, 14);
		getContentPane().add(this.lblExams);
		
		scrollPaneQuiz = new JScrollPane();
		scrollPaneQuiz.setBounds(203, 87, 100, 243);
		getContentPane().add(scrollPaneQuiz);
		
		this.tableQuiz = new JTable();
		scrollPaneQuiz.setViewportView(this.tableQuiz);
		this.tableQuiz.setToolTipText("Table of all student's quizzes");
		
		scrollPaneHomework = new JScrollPane();
		scrollPaneHomework.setBounds(363, 87, 149, 230);
		getContentPane().add(scrollPaneHomework);
		
		this.tableHomework = new JTable();
		scrollPaneHomework.setViewportView(this.tableHomework);
		this.tableHomework.setToolTipText("Table of all of student's homework");
		
		scrollPaneExam = new JScrollPane();
		scrollPaneExam.setBounds(564, 87, 98, 231);
		getContentPane().add(scrollPaneExam);
		
		this.tableExam = new JTable();
		scrollPaneExam.setViewportView(this.tableExam);
		this.tableExam.setToolTipText("Table of all of student's exams");
		
		spinnerQuizWeight = new JSpinner();
		this.spinnerQuizWeight.setToolTipText("Change how much quizzes are weighed for the final grade");
		spinnerQuizWeight.setBounds(189, 363, 114, 20);
		getContentPane().add(spinnerQuizWeight);
		
		spinnerHomeworkWeight = new JSpinner();
		this.spinnerHomeworkWeight.setToolTipText("Change how much homework is weighed for the final grade");
		spinnerHomeworkWeight.setBounds(353, 363, 161, 20);
		getContentPane().add(spinnerHomeworkWeight);
		
		spinnerExamWeight = new JSpinner();
		this.spinnerExamWeight.setToolTipText("Change how much exams are weighed for the final grade");
		spinnerExamWeight.setBounds(554, 363, 114, 20);
		getContentPane().add(spinnerExamWeight);
		
		lblWeight = new JLabel("Weight (0.0 - 1.0)");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWeight.setBounds(36, 366, 114, 14);
		getContentPane().add(lblWeight);
		
		lblSubtotal = new JLabel("Subtotals");
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubtotal.setBounds(84, 400, 66, 14);
		getContentPane().add(lblSubtotal);
		
		chckbxDropLowestHomeworkGrade = new JCheckBox("Drop Lowest Homework?");
		this.chckbxDropLowestHomeworkGrade.setToolTipText("Should you drop the lowest homework grade?");
		chckbxDropLowestHomeworkGrade.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxDropLowestHomeworkGrade.setBounds(353, 440, 179, 23);
		getContentPane().add(chckbxDropLowestHomeworkGrade);
		
		lblFinalGrade = new JLabel("Final Grade");
		lblFinalGrade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFinalGrade.setBounds(554, 527, 114, 14);
		getContentPane().add(lblFinalGrade);
		
		this.textFieldQuizSubtotal = new JTextField();
		this.textFieldQuizSubtotal.setToolTipText("The quiz grade subtotal");
		this.textFieldQuizSubtotal.setBounds(189, 398, 114, 20);
		getContentPane().add(this.textFieldQuizSubtotal);
		this.textFieldQuizSubtotal.setColumns(10);
		
		this.textFieldHomeworkSubtotal = new JTextField();
		this.textFieldHomeworkSubtotal.setToolTipText("The homework grade subtotal");
		this.textFieldHomeworkSubtotal.setBounds(353, 398, 161, 20);
		getContentPane().add(this.textFieldHomeworkSubtotal);
		this.textFieldHomeworkSubtotal.setColumns(10);
		
		this.textFieldExamSubtotal = new JTextField();
		this.textFieldExamSubtotal.setToolTipText("The exam grade subtotal");
		this.textFieldExamSubtotal.setBounds(554, 398, 114, 20);
		getContentPane().add(this.textFieldExamSubtotal);
		this.textFieldExamSubtotal.setColumns(10);
		
		this.textFieldFinalGrade = new JTextField();
		this.textFieldFinalGrade.setToolTipText("The final grade");
		this.textFieldFinalGrade.setBounds(554, 552, 106, 20);
		getContentPane().add(this.textFieldFinalGrade);
		this.textFieldFinalGrade.setColumns(10);
		
		btnAddQuiz = new JButton("Add Quiz");
		this.btnAddQuiz.setToolTipText("Add a student's quiz grade");
		btnAddQuiz.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddQuiz.setBounds(189, 46, 114, 30);
		getContentPane().add(btnAddQuiz);
	}
}
