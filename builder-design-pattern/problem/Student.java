
import java.util.List;

public class Student {

    // Mandatory fields
    int rollNo;
    String name;
    int age;
    String branch;

    // optional fields
    String fathersName;
    String mothersName;
    List<String> subjects;
    String moblieNumber;
    String emailId;

    // mandatory
    public Student(int rollNo, String name, String branch, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.age = age;
    }

    // optional
    public Student(int rollNo, String name, String branch, int age, String fathersNmae) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.age = age;
        this.fathersName = fathersNmae;
    }

    // optional
    public Student(int rollNo, String name, String branch, int age, String fathersNmae, List<String> subjects ) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.age = age;
        this.fathersName = fathersNmae;
        this.subjects = subjects;
    }

    // optional
    public Student(int rollNo, String name, String branch, int age, String fathersNmae, String mothersName ) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.age = age;
        this.fathersName = fathersNmae;
        this.mothersName = mothersName;
    }

    // optional, but this will throw an error because it doesn't know the the parameters like mothersname and email id as differnt
    // public Student(int rollNo, String name, String branch, int age, String fathersNmae, String emailId ) {
    //     this.rollNo = rollNo;
    //     this.name = name;
    //     this.branch = branch;
    //     this.age = age;
    //     this.fathersName = fathersNmae;
    //     this.emailId = emailId;
    // }

    public void printDetails() {
        System.out.println("Students details: ");
        System.out.println(this + ":");
        System.err.println("rollNo: " + rollNo + ", " +
            "name: " + name + ", " +
            "branch: " + branch + ", " +
            "age: " + age + ", " +
            "Mothers Name: " + mothersName + ", " +
            "Fathers Name: " + fathersName + ", " +
            "Email: " + emailId +  ", " +
            "Mobile Number: " + moblieNumber
        );
    }

    public static void main(String[] args) {
        Student s = new Student(1, "Vikash", "CSE", 25);

        s.printDetails();
    }
}
