package Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void addPerson() {
        addStudent();
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        setId(id);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        setFullName(name);
        System.out.print("Enter Major: ");
        String major = sc.nextLine();
        setMajor(major);
        System.out.print("Enter GPA: ");
        float gpa = Float.parseFloat(sc.nextLine());
        setGpa(gpa);
        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        String dobString = sc.nextLine();
        setDateOfBirth(parseDate(dobString));
    }

    @Override
    public void updatePerson(String id) {
        updateStudent();
    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Update Name: ");
        setFullName(sc.nextLine());
        System.out.print("Update Major: ");
        setMajor(sc.nextLine());
        System.out.print("Update GPA: ");
        setGpa(Float.parseFloat(sc.nextLine()));
        System.out.print("Update Date of Birth (dd/MM/yyyy): ");
        setDateOfBirth(parseDate(sc.nextLine()));
        System.out.println("Student updated successfully.");
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Student Information:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("GPA: " + getGpa());
        System.out.println("Major: " + getMajor());
        System.out.println("Date of Birth: " + sdf.format(getDateOfBirth()));
    }

    private Date parseDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(dateString);
        } catch (Exception e) {
            System.out.println("Wrong format. Using current date.");
            return new Date();
        }
    }
}