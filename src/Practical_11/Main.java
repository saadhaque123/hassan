package Practical_11;

import java.util.Arrays;

/**
 * This class contains the main method which runs the program.
 * It creates an instance of StudentSupportOffice and calls its run method.
 */
public class Main {
    public static void main(String[] args) {
        StudentSupportOffice office = new StudentSupportOffice();
        office.run();
    }
}

/**
 * This class represents a student and implements the comparable interface
 * to allow students to be ordered by their id.
 */
class Student implements Comparable<Student> {
    private String id;

    /**
     * Constructor for Student
     * @param id the student's id
     */
    public Student(String id) {
        this.id = id;
    }

    /**
     * Getter method for student's id
     * @return id of the student
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for student's id
     * @param id the student's id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method is used to compare two students based on their id.
     * @param other student to be compared
     * @return an int based on the comparison of the two students ids
     */
    @Override
    public int compareTo(Student other) {
        return this.id.compareTo(other.getId());
    }

    /**
     * This method creates a human-friendly string representation of the class
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        return "Student " + id;
    }
}

/**
 * This class represents a module, it contains an array of students and keeps track of the current size of the class.
 * It also provides method to enroll and unenroll students to the module.
 */
class Module {
    private String id;
    private Student[] classList;
    private int size;

    /**
     * Constructor for Module
     * @param id the module's id
     */
    public Module(String id) {
        this.id = id;
        this.classList = new Student[5];
        this.size = 0;
    }

    /**
     * Getter method for the module's id
     * @return id of the module
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for the module's id
     * @param id the module's id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for the classlist array of the module
     * @return classList array of the module
     */
    public Student[] getClassList() {
        return classList;
    }

    /**
     * Getter method for the current size of the classList array
     * @return current size of the classList array
     */
    public int getSize() {
        return size;
    }

/**
 * This method is used to enroll a student in the module.
 * It maintains the classList in ascending order based on student
 /**
 * This method is used to enroll a student in the module.
 * It maintains the classList in ascending order based on student id.
 * @param student student to be enrolled
 * @return true if student is successfully enrolled, false if classList is full
 */
public boolean enroll(Student student) {
    if (size == classList.length) {
        return false;
    }

    int index = 0;
    while (index < size && classList[index].compareTo(student) < 0) {
        index++;
    }

    for (int i = size; i > index; i--) {
        classList[i] = classList[i - 1];
    }

    classList[index] = student;
    size++;
    return true;
}

    /**
     * This method is used to unenroll a student from the module.
     * It maintains the classList in sequence after unenrolling a student.
     * @param student student to be unenrolled
     * @return true if student is successfully unenrolled, false if student is not found in the classList
     */
    public boolean unenroll(Student student) {
        int index = 0;
        while (index < size && !classList[index].equals(student)) {
            index++;
        }

        if (index == size) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            classList[i] = classList[i + 1];
        }

        classList[size - 1] = null;
        size--;
        return true;
    }

    /**
     * This method creates a human-friendly string representation of the class
     * It ignore empty elements within the class list
     * @return a string representation of the module
     */
    @Override
    public String toString() {
        return "Module " + id + ": " + Arrays.toString(Arrays.stream(classList).filter(s -> s != null).toArray());
    }
}
class StudentSupportOffice {
    private Module cis2206; // instance of the CIS2206 module
    private Module cis2360; // instance of the CIS2360 module
    private Module cis2205; // instance of the CIS2205 module
    private Student u0000001; // instance of the student with id U0000001
    private Student u0000002; // instance of the student with id U0000002
    private Student u0000003; // instance of the student with id U0000003
    private Student u0000004; // instance of the student with id U0000004
    private Student u0000005; // instance of the student with id U0000005

    /**
     * Constructor for StudentSupportOffice
     * It creates instances of the modules and students that are used in the program.
     */
    public StudentSupportOffice() {
        cis2206 = new Module("CIS2206");
        cis2360 = new Module("CIS2360");
        cis2205 = new Module("CIS2205");
        u0000001 = new Student("U0000001");
        u0000002 = new Student("U0000002");
        u0000003 = new Student("U0000003");
        u0000004 = new Student("U0000004");
        u0000005 = new Student("U0000005");
    }

    /**
     * This method is used to run the program.
     * It enrolls the students to the modules and unenrolls them according to the requirements.
     * It also prints the initial and final enrollments of the students to the modules.
     */
    public void run() {
        // Enroll students to modules
        cis2206.enroll(u0000001);
        cis2206.enroll(u0000005);
        cis2360.enroll(u0000001);
        cis2360.enroll(u0000003);
        cis2360.enroll(u0000004);
        cis2205.enroll(u0000002);
        cis2205.enroll(u0000004);
        cis2205.enroll(u0000005);

        System.out.println("Initial enrollment:");
        System.out.println(cis2206);
        System.out.println(cis2360);
        System.out.println(cis2205);

        // Change module enrollment
        cis2206.unenroll(u0000005);
        cis2206.enroll(u0000003);
        cis2206.enroll(u0000004);
        cis2360.enroll(u0000002);
        cis2360.enroll(u0000005);
        cis2205.unenroll(u0000002);
        cis2205.unenroll(u0000005);
        cis2205.enroll(u0000001);
        cis2205.enroll(u0000003);
        cis2205.enroll(u0000004);

        System.out.println("\nChanged enrollment:");
        System.out.println(cis2206);
        System.out.println(cis2360);
        System.out.println(cis2205);
    }
}
