
import java.util.List;

public class Student1 {
    int age;
    String name;
    String dept;
    int rollNo;

    String fathersName;
    String mothersName;
    String mobileNumber;
    String emailId;
    List<String> subjects;

    public Student1(StudentBuilder builder) {
        this.name = builder.name;
        this.emailId = builder.emailId;
        this.age = builder.age;
        this.dept = builder.dept;
        this.rollNo = builder.rollNo;
        this.mothersName = builder.mothersName;
        this.fathersName = builder.fathersName;
        this.mobileNumber = builder.mobileNumber;
        this.subjects = builder.subjects;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo +
                ", Mobile Number: " + mobileNumber +
                ", Email Id: " + emailId +
                ", age: " + age +
                ", dept: " + dept +
                ", Mothers Name: " + mothersName +
                ", Fathers Name: " + fathersName +
                ", Roll Number: " + rollNo +
                ", Subjects: " + subjects.get(0) + ", " + subjects.get(1) + ", " + subjects.get(2);
    }
}
