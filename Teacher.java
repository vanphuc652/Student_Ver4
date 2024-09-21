package Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Teacher extends Person {
    private String department;
    private String teachingSubject;

    public Teacher(String id, String fullName, Date dateOfBirth, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void addPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        setId(sc.nextLine());
        System.out.print("Enter Name: ");
        setFullName(sc.nextLine());
        System.out.print("Enter Department: ");
        setDepartment(sc.nextLine());
        System.out.print("Enter Teaching Subject: ");
        setTeachingSubject(sc.nextLine());
        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        setDateOfBirth(parseDate(sc.nextLine()));
    }

    @Override
    public void updatePerson(String id) {
        if (getId().equals(id)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Update Name: ");
            setFullName(sc.nextLine());
            System.out.print("Update Department: ");
            setDepartment(sc.nextLine());
            System.out.print("Update Teaching Subject: ");
            setTeachingSubject(sc.nextLine());
            System.out.print("Update Date of Birth (dd/MM/yyyy): ");
            setDateOfBirth(parseDate(sc.nextLine()));
            System.out.println("Teacher updated successfully.");
        } else {
            System.out.println("Teacher ID not found.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher Information:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Teaching Subject: " + getTeachingSubject());
        System.out.println("Date of Birth: " + getDateOfBirth());
    }

    private Date parseDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return null;
        }
    }
}