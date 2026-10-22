public class StudentRegistrationDirector {
    StudentBuilder studentBuilder;

    public StudentRegistrationDirector(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student1 createStudent() {
        if(studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudent();
        } else if(studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }

        return null;
    }

    public Student1 createEngineeringStudent() {
        return studentBuilder.setRollNo(1)
                .setAge(25)
                .setDept("CSE")
                .setEmailId("Vikash@example.com")
                .setFathersName("Vijay Prasad")
                .setMothersName("Manju Devi")
                .setName("Vikash Kumar")
                .setSubjects()
                .build();
    }

    public Student1 createMBAStudent() {
        return studentBuilder.setRollNo(2)
                .setAge(24)
                .setDept("MBA")
                .setEmailId("Swarnadeep@example.com")
                .setFathersName("Vikash Kumar")
                .setMothersName("null")
                .setName("Swarnadeep Sahani")
                .setSubjects()
                .build();
    }
}
