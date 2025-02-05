class Course {
    String name;
    Professor professor;
    List<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    void enrollStudent(Student student) {
        students.add(student);
    }

    void displayDetails() {
        System.out.println("Course: " + name);
        System.out.println("Professor: " + (professor != null ? professor.name : "Not Assigned"));
        System.out.println("Enrolled Students: " + (students.isEmpty() ? "None" : ""));
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}
class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }
}
class Professor {
    String name;
    Professor(String name) {
        this.name = name;
    }

    void assignToCourse(Course course) {
        course.assignProfessor(this);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int studentCount = sc.nextInt();
        sc.nextLine();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter student name: ");
            students.add(new Student(sc.nextLine()));
        }

        System.out.print("Enter number of professors: ");
        int professorCount = sc.nextInt();
        sc.nextLine();
        List<Professor> professors = new ArrayList<>();
        for (int i = 0; i < professorCount; i++) {
            System.out.print("Enter professor name: ");
            professors.add(new Professor(sc.nextLine()));
        }

        System.out.print("Enter number of courses: ");
        int courseCount = sc.nextInt();
        sc.nextLine();
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter course name: ");
            courses.add(new Course(sc.nextLine()));
        }

        for (Student student : students) {
            System.out.print("Enter course name for " + student.name + " to enroll: ");
            String courseName = sc.nextLine();
            for (Course course : courses) {
                if (course.name.equalsIgnoreCase(courseName)) {
                    student.enrollCourse(course);
                }
            }
        }

        for (Professor professor : professors) {
            System.out.print("Enter course name for " + professor.name + " to teach: ");
            String courseName = sc.nextLine();
            for (Course course : courses) {
                if (course.name.equalsIgnoreCase(courseName)) {
                    professor.assignToCourse(course);
                }
            }
        }

        for (Course course : courses) {
            course.displayDetails();
        }
    }
}






5
