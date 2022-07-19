package com.uniquex.students.usecase;

import com.uniquex.students.domain.entity.GradedStudent;
import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.sort.algorithms.Merge;
import com.uniquex.students.usecase.sort.algorithms.port.SortAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentSorterTest {

    @Test
    public void sortStudentsByBubble_emptyStudentsList() {
        StudentSorter studentSorter = new StudentSorter();
        List<Student> students = new ArrayList<>(Collections.emptyList());
        List<Student> studentsResult = studentSorter.sortStudentsBy("bubble", students);
        assertSame(students, studentsResult);
    }

    @Test
    public void sortStudentsByBubble_shouldReturnInCorrectOrder() {
        StudentSorter studentSorter = new StudentSorter();
        List<Student> students = getStudentsInReverseOrder();
        List<Student> studentsResult = studentSorter.sortStudentsBy("bubble", students);
        assertThat(studentsResult).isEqualTo(getStudentsInNaturalOrder());
    }

    @Test
    public void sortStudentsByHeap_shouldReturnInCorrectOrder() {
        StudentSorter studentSorter = new StudentSorter();
        List<Student> studentsResult = studentSorter.sortStudentsBy("heap", getStudentsInReverseOrder());
        assertThat(studentsResult).isEqualTo(getStudentsInNaturalOrder());
    }

    @Test
    public void sortStudentsByMerge_shouldReturnInCorrectOrder() {
        StudentSorter studentSorter = new StudentSorter();
        SortAlgorithm merge = new Merge();
        List<Student> studentsResult = studentSorter.sortStudentsBy("merge", getStudentsInReverseOrder());
        assertThat(studentsResult).isEqualTo(getStudentsInNaturalOrder());
    }

    private List<Student> getStudentsInReverseOrder() {
        Student student1 = new GradedStudent("Student1", 1.0);
        Student student2 = new GradedStudent("Student2", 2.0);
        Student student3 = new GradedStudent("Student3", 3.0);
        return List.of(student3, student2, student1);
    }

    private List<Student> getStudentsInNaturalOrder() {
        Student student1 = new GradedStudent("Student1", 1.0);
        Student student2 = new GradedStudent("Student2", 2.0);
        Student student3 = new GradedStudent("Student3", 3.0);
        return List.of(student1, student2, student3);
    }

}