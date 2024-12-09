/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package attendance.attendancefinal;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class StudentList {
    private ArrayList<Student> students;
    private int currentIndex;

    public StudentList() {
        this.students = new ArrayList<>();
        this.currentIndex = 0;
        loadStudentData(); 
    }

    public void loadStudentData() {
        students.add(new Student("21446844", "Ramie Theofil D. Pondar"));
        students.add(new Student("23794878", "Junex Baran"));
        students.add(new Student("21424343", "Adamusa Pingay"));
        students.add(new Student("23762529", "Aldrin Basalo"));
        students.add(new Student("23800634", "Warren Ygona"));
        students.add(new Student("23802747", "Kenneth Viovicente"));
        students.add(new Student("23798424", "Joshua Jamisola"));
        students.add(new Student("23799950", "Jude Eleazar Ebarita"));
        students.add(new Student("23456789", "Jewel Cedrick Gesim"));
        students.add(new Student("21412044", "Irish Claire Zabate"));
    }

    public Student getCurrentStudent() {
        if (currentIndex >= 0 && currentIndex < students.size()) {
            return students.get(currentIndex);
        }
        return null;
    }

    public void nextStudent() {
        if (currentIndex < students.size() - 1) {
            currentIndex++;
        }
    }

    public void previousStudent() {
        if (currentIndex > 0) {
            currentIndex--;
        }
    }

    public int getTotalStudents() {
        return students.size();
    }
    public ArrayList<Student> getStudents() {
    return students;
}
}
