/*
 *It is that time of year again. The Intro to Computer Science 101 class has ended at Greendale community college 
 *and the professor has to submit the final grades. The school requires grades to be submitted with a letter grade *. In addition
 *the grades should be submitted from the "best" student first. The individual scores should be be listed from "worse" to "best".
 *Input: You will be given class roster in the form of: (first name) , (last name) (score 1) (score 2) (score 3) (score 4) (score 5)
 *Data Crunch: Each student has 5 scores from 1 to 100. So a total of 500 points for the class. Based on this you must determine
 * what grade they get on a percentile 1-100.
 * The letter Grades are assigned based on the following

    90-100 A
    80-89 B
    70-79 C
    60-69 D
    59 and below F
 * Those scoring in the top 3 percent of the rank get a "+" added. Those scoring in the lower 3 percent of the rank get a "-". 
 * However there is no "+" for an A and there are no "+" or "-" for an F grade.
 * student scoring 82% would be a B-
 * student scoring 79% would be a C+
 * Note: Final Grades are rounded to the nearest whole number. So 89.5 is 90 and 89.4 is 89.
 * Output: The output should be ranked from the "best" student who had the best grade to the "worse" student who had the lowest grade.
 *  The 5 scores should also be arranged from the "lowest" to "highest".
 *  The output should take on this form:
 *  (Last Name) (First Name) (Final percentage) (Final Grade) : (Scores 1-5 from low to high)

 * Example:

Valerie Vetter 79   81  78  83  80
Richie  Rich    88  90  87  91  86

 * Would output as:

Rich    Richie  (88%) (B+): 86 87 88 90 91
Valerie Vetter (80%) (B-): 78 79 80 81 83 
 
 * 
 * 
Jennifer   Adams   100 70  85  86  79
Bubba  Bob  50  55  60  53  30
Matt   Brown   72  82  92  88  79
Ned    Bundy   73  75  80  79  88
Alfred    Butler  80  90  70  100 60
Sarah  Cortez  90  72  61  70  80
William    Fence   88  86  83  70  79
Casper     Ghost   80  85  87  89  90
Opie   Griffith    90  90  90  90  90
Tony   Hawk    60  60  60  72  72
Kirstin    Hill    100 90  92  94  95
Hodor  Hodor   40  50  53  62  33
Clark  Kent    89  90  88  92  91
Tyrion     Lannister   93  97  100 91  95
Ken    Larson  70  80  85  73  79
Stannis    Mannis  60  70  75  77  78
Bob    Martinez    79  88  92  82  72
Jean   Picard  90  89  95  70  65
Harry  Potter  73  75  77  69  73
Jaina  Proudmoore  90  92  100 95  94
Richie     Rich    88  90  87  91  86
John   Smith   90  80  70  60  50
Jon    Snow    70  70  70  70  72
Arya   Stark   91  92  90  93  90
Edwin Clef    40  50  55  57  33
Valerie    Vetter  79  81  78  83  80
Katelyn    Weekes  90  95  92  93  97
Wil   Wheaton  70  80  75  71  77
Steve  Wozniak 88  89  87  86  85
Derek  Zoolander   80  81  85  88  90
 */

package dailyprogrammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FinalGrades167 {
	
	private ArrayList<Student> students = new ArrayList<Student>();

	public FinalGrades167() {
	}

	protected void init(){
		read();
		calculate();
		print();
	}
	
	protected void print() {
		for (Student student : students) {
			System.out.print(student.getFirstName() 	+ " " + student.getSecondName() + "  (" + student.getFinalgrade()+"%) ("+student.getLetterGrade()+") "); 
				int[] score = student.getScores();
				for (int i : score) System.out.print(" "+i);
				System.out.println("");
		}
	
	}

	protected void calculate() {
		SortStudents st = new SortStudents();
		Collections.sort(this.students,st );
		
		ArrayList<Integer> stdgradecount =  new ArrayList<Integer>();
		for (String lgrade: new String[] {"A","B", "C","D"}){
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getLetterGrade().equals(lgrade)) stdgradecount.add(i);
			}
			if (stdgradecount.size() <= 1) continue;
			int graderank = (int) Math.floor(stdgradecount.size() * 0.03f);
			if (graderank == 0) graderank = 1;
			for (int c =0 ; c < graderank; c++){
				int priradenie =stdgradecount.get(c);
				int priradenie2 =stdgradecount.get(stdgradecount.size()-c-1);
				if (!lgrade.equals("A"))
					students.get(priradenie).setLetterGrade(lgrade+"+");
			    students.get(priradenie2).setLetterGrade(lgrade+"-");	
			}
			stdgradecount.clear();
		}
	}

	protected void read() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()){
			String[] nexline = scan.nextLine().split("\\s+");
			if (nexline.length != 7) break;
			
			nexline[0].replace(",", "");
			int[] scores = {Integer.valueOf(nexline[2]),Integer.valueOf(nexline[3]),Integer.valueOf(nexline[4]),Integer.valueOf(nexline[5]),Integer.valueOf(nexline[6])};
			students.add( new Student(nexline[0], nexline[1], scores));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FinalGrades167().init();
	}

}

class SortStudents implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		return  o2.getFinalgrade() - o1.getFinalgrade();
	}
}


class Student {
	private String firstName;
	private String secondName;
	private String letterGrade;
	private int finalgrade;
	private int[] scores = new int[4];

	public Student(String firstName, String secondName, int[] scores) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		
		this.setScores(scores);
		finalgrade = 0;
		for (int i : scores) finalgrade += i;
		finalgrade = finalgrade / 5;
		Arrays.sort(this.scores);
		
		nastavletterGrade();
		
	}
	
	private void nastavletterGrade(){
		letterGrade ="A";
		if (this.finalgrade < 90) letterGrade = "B";
		if (this.finalgrade < 80) letterGrade = "C";
		if (this.finalgrade < 70) letterGrade = "D";
		if (this.finalgrade < 60) letterGrade = "F";
	}


	public int getFinalgrade() {
		return finalgrade;
	}


	public void setFinalgrade(int finalgrade) {
		this.finalgrade = finalgrade;
	}


	public String getLetterGrade() {
		return letterGrade;
	}


	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSecondName() {
		return secondName;
	}


	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public int[] getScores() {
		return scores;
	}


	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
}