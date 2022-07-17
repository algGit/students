package com.uniquex.students.usecase;

import com.uniquex.students.domain.entity.GradedStudent;
import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.sort.algorithms.Bubble;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentSorterTest {

    @Test
    public void sortStudentsByBubble_emptyStudentsList() {
        StudentSorter studentSorter = new StudentSorter();
        Bubble bubble = new Bubble();
        List<Student> students = new ArrayList<>(Collections.emptyList());
        List<Student> studentsResult = studentSorter.sortStudentsBy(bubble, students);
        assertSame(students, studentsResult);
    }

    @Test
    public void sortStudentsByBubble_shouldReturnInCorrectOrder() {
        StudentSorter studentSorter = new StudentSorter();
        Bubble bubble = new Bubble();
        Student student1 = new GradedStudent("Student1", 1.0);
        Student student2 = new GradedStudent("Student2", 2.0);
        Student student3 = new GradedStudent("Student3", 3.0);
        List<Student> students = List.of(student3,student2,student1);
        List<Student> studentsResult = studentSorter.sortStudentsBy(bubble, students);
        assertThat(studentsResult).isEqualTo(List.of(student1,student2,student3));
    }

}