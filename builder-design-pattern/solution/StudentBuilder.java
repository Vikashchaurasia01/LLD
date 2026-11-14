import java.util.List;

public abstract class StudentBuilder {
    int age;
    String name;
    String dept;
    int rollNo;

    String fathersName;
    String mothersName;
    String mobileNumber;
    String emailId;
    List<String> subjects;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setDept(String dept) {
        this.dept = dept;
        return this;
    }

    public StudentBuilder setRollNo(int rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public StudentBuilder setFathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public StudentBuilder setMothersName(String mothersName) {
        this.mothersName = mothersName;
        return this;
    }

    public StudentBuilder setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    abstract public StudentBuilder setSubjects();

    public Student1 build() {
        return new Student1(this);
    }
}
