package com.uniquex.students.usecase;

import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.sort.algorithms.port.SortAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class StudentSorter {

    public List<Student> sortStudentsBy(SortAlgorithm sortAlgorithm, List<Student> students) {
        return sortAlgorithm.sort(students);
    }
}
