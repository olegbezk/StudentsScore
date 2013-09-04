package scan.scores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentScores {

	int id;
	int score;

	public static void main(String args[]) {

		try {
			Scanner in = new Scanner(System.in);
			ArrayList<StudentScores> students = new ArrayList<StudentScores>();

			int c = 0;
			while (c < 10) {
				String s = in.nextLine();
				StringTokenizer stk = new StringTokenizer(s, "-");

				StudentScores stdsc = new StudentScores();

				stdsc.id = Integer.parseInt(stk.nextToken());
				stdsc.score = Integer.parseInt(stk.nextToken());

				if (c > 1) {
					StudentScores stDupl = findStudentById(stdsc.id, students);

					if (stDupl != null) {
						if (stdsc.score > stDupl.score) {
							students.add(stdsc);
							students.remove(stDupl);
						}
					} else {
						students.add(stdsc);
					}
				} else
					students.add(stdsc);
				c++;
			}
			Collections.sort(students, new Comparator<StudentScores>() {
				public int compare(StudentScores o1, StudentScores o2) {
					return o2.score - o1.score;
				}
			});

			System.out.println();

			for (StudentScores stt : students) {
				System.out.println(stt.id + "-" + stt.score);
			}
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	static StudentScores findStudentById(int id, ArrayList<StudentScores> list) {
		for (StudentScores s : list) {
			if (s.id == id)
				return s;
		}
		return null;
	}
}
