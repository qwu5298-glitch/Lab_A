package tw.brad.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.brad.apis.Student;

public class Brad48 {
	public static void main(String[] args) {
		Student s1 = new Student("Brad", 70, 40, 32);
		s1.getBike().upSpeed().upSpeed().upSpeed().upSpeed();
		System.out.printf("%s : %d : %f : %s\n", s1.getName(), s1.score(), s1.avg(), s1.getBike());
		
		Student s2 = new Student("Tony", 98, 90, 86);
		System.out.printf("%s : %d : %f\n", s2.getName(), s2.score(), s2.avg());
		
		try(FileOutputStream fout = new FileOutputStream("dir1/brad.score");
				ObjectOutputStream oout = new ObjectOutputStream(fout)){
			oout.writeObject(s1);
			oout.writeObject(s2);
			oout.flush();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}