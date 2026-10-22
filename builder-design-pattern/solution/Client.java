public class Client {
    public static void main(String[] args) {
        System.out.println("============= Builder Design Pattern ============");
        
        StudentRegistrationDirector enggStudentDirector = new StudentRegistrationDirector(new EngineeringStudentBuilder());
        StudentRegistrationDirector mbaStudentDirector = new StudentRegistrationDirector(new MBAStudentBuilder());

        Student1 enggStudent = enggStudentDirector.createStudent();
        Student1 mbaStudent = mbaStudentDirector.createStudent();

        System.out.println("Engineering Student Details: " + enggStudent.toString());
        System.out.println("MBA Student Details: " + mbaStudent.toString());
    }
}
