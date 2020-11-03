package edu.westga.cs.schoolgrades.views;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class GuiWindowBuilderLayout extends JFrame {
	private JButton btnAddQuiz;
	private JButton btnAddHomework;
	private JButton btnAddExam;
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
	
	public GuiWindowBuilderLayout() {
		getContentPane().setLayout(null);
		
		btnAddExam = new JButton("Add Exam");
		this.btnAddExam.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddExam.setBounds(554, 46, 114, 30);
		getContentPane().add(btnAddExam);
		
		btnAddHomework = new JButton("Add Homework");
		this.btnAddHomework.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddHomework.setBounds(353, 46, 161, 30);
		getContentPane().add(btnAddHomework);
		
		btnAddQuiz = new JButton("Add Quiz");
		this.btnAddQuiz.setBackground(Color.WHITE);
		this.btnAddQuiz.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddQuiz.setBounds(189, 46, 114, 30);
		getContentPane().add(btnAddQuiz);
		
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
		
		this.tableQuiz = new JTable();
		this.tableQuiz.setBounds(299, 319, -109, -243);
		getContentPane().add(this.tableQuiz);
		
		this.tableHomework = new JTable();
		this.tableHomework.setBounds(513, 318, -149, -230);
		getContentPane().add(this.tableHomework);
		
		this.tableExam = new JTable();
		this.tableExam.setBounds(663, 319, -98, -231);
		getContentPane().add(this.tableExam);
		
		JSpinner spinnerQuizWeight = new JSpinner();
		spinnerQuizWeight.setBounds(189, 363, 114, 20);
		getContentPane().add(spinnerQuizWeight);
		
		JSpinner spinnerHomeworkWeight = new JSpinner();
		spinnerHomeworkWeight.setBounds(353, 363, 161, 20);
		getContentPane().add(spinnerHomeworkWeight);
		
		JSpinner spinnerExamWeight = new JSpinner();
		spinnerExamWeight.setBounds(554, 363, 114, 20);
		getContentPane().add(spinnerExamWeight);
		
		JLabel lblWeight = new JLabel("Weight (0.0 - 1.0)");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWeight.setBounds(36, 366, 114, 14);
		getContentPane().add(lblWeight);
		
		JLabel lblSubtotal = new JLabel("Subtotals");
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubtotal.setBounds(84, 400, 66, 14);
		getContentPane().add(lblSubtotal);
		
		JCheckBox chckbxDropLowestGrade = new JCheckBox("Drop Lowest Grade?");
		chckbxDropLowestGrade.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxDropLowestGrade.setBounds(353, 440, 161, 23);
		getContentPane().add(chckbxDropLowestGrade);
		
		JLabel lblFinalGrade = new JLabel("Final Grade");
		lblFinalGrade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFinalGrade.setBounds(554, 527, 114, 14);
		getContentPane().add(lblFinalGrade);
		
		this.textFieldQuizSubtotal = new JTextField();
		this.textFieldQuizSubtotal.setBounds(189, 398, 114, 20);
		getContentPane().add(this.textFieldQuizSubtotal);
		this.textFieldQuizSubtotal.setColumns(10);
		
		this.textFieldHomeworkSubtotal = new JTextField();
		this.textFieldHomeworkSubtotal.setBounds(353, 398, 161, 20);
		getContentPane().add(this.textFieldHomeworkSubtotal);
		this.textFieldHomeworkSubtotal.setColumns(10);
		
		this.textFieldExamSubtotal = new JTextField();
		this.textFieldExamSubtotal.setBounds(554, 398, 114, 20);
		getContentPane().add(this.textFieldExamSubtotal);
		this.textFieldExamSubtotal.setColumns(10);
		
		this.textFieldFinalGrade = new JTextField();
		this.textFieldFinalGrade.setBounds(554, 552, 106, 20);
		getContentPane().add(this.textFieldFinalGrade);
		this.textFieldFinalGrade.setColumns(10);
	}
}
