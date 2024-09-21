package Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Processer {
    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person by ID");
            System.out.println("4. Delete person by ID");
            System.out.println("5. Find person by ID");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find teachers by department");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    personList.addStudent();
                    break;
                case 2:
                    personList.addTeacher();
                    break;
                case 3:
                    System.out.print("Enter person ID to update: ");
                    personList.updatePerson(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter person ID to delete: ");
                    personList.deletePersonById(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter person ID to find: ");
                    Person person = personList.findPersonById(sc.nextLine());
                    if (person != null) {
                        person.displayInfo();
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 6:
                    personList.displayEveryone();
                    break;
                case 7:
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter department name: ");
                    ArrayList<Teacher> teachers = personList.findTeachersByDepartment(sc.nextLine());
                    if (teachers.isEmpty()) {
                        System.out.println("No teachers found in this department.");
                    } else {
                        for (Teacher teacher : teachers) {
                            teacher.displayInfo();
                            System.out.println();
                        }
                    }
                    break;
                case 9:
                    System.out.println("End of the program!!!");
                    break;
                default:
                    System.out.println("Please choose again!!!");
            }
        } while (choice != 9);
    }
}