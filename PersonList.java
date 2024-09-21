package Student;

import java.util.ArrayList;
import java.util.Date;

public class PersonList {
    private ArrayList<Person> personList;

    public PersonList() {
        this.personList = new ArrayList<>();
    }

    public void addStudent() {
        Student student = new Student("", "", new Date(), 0, "");
        student.addPerson(); 
        personList.add(student);
        System.out.println("Student added successfully.");
    }

    public void addTeacher() {
        Teacher teacher = new Teacher("", "", new Date(), "", "");
        teacher.addPerson(); 
        personList.add(teacher);
        System.out.println("Teacher added successfully.");
    }

    public void updatePerson(String id) {
        Person person = findPersonById(id);
        if (person != null) {
            person.updatePerson(id); 
            System.out.println("Person not found.");
        }
    }

    public void deletePersonById(String id) {
        boolean removed = personList.removeIf(person -> person.getId().equals(id));
        if (removed) {
            System.out.println("Person with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    public Person findPersonById(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null; 
    }

    public void displayEveryone() {
        if (personList.isEmpty()) {
            System.out.println("No persons to display.");
            return;
        }
        for (Person person : personList) {
            person.displayInfo();
            System.out.println();
        }
    }

    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                if (topStudent == null || ((Student) person).getGpa() > topStudent.getGpa()) {
                    topStudent = (Student) person;
                }
            }
        }
        return topStudent;
    }

    public ArrayList<Teacher> findTeachersByDepartment(String department) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equalsIgnoreCase(department)) {
                    teachers.add(teacher);
                }
            }
        }
        return teachers;
    }
}