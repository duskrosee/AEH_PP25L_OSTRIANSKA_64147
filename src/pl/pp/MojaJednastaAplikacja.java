package pl.pp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MojaJednastaAplikacja {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new Student("67990", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new Student("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        // Найти студента с наивысшей средней оценкой
        Student topStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade))
                .orElse(null);

        if (topStudent != null) {
            System.out.println("Student z najwyższą średnią: " + topStudent);
        } else {
            System.out.println("Nie znaleziono studentów.");
        }

        // Отсортировать студентов по фамилии
        students.sort(Comparator.comparing(Student::getLastName));

        // Вывести всех студентов
        System.out.println("\nStudenci posortowani według nazwisk:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}



class Student {
    private String indexNumber;
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student(String indexNumber, String firstName, String lastName, List<Integer> grades) {
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (Integer grade : grades) {
            if (grade != null) {
                sum += grade;
                count++;
            }
        }
        return count == 0 ? 0.0 : sum / count;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + indexNumber + ") - Average: " + getAverageGrade();
    }
}