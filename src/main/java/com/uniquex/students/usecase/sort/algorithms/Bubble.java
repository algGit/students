package com.uniquex.students.usecase.sort.algorithms;

import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.sort.algorithms.port.SortAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Bubble implements SortAlgorithm {
    @Override
    public List<Student> sort(List<Student> students) {
        if (students == null || students.size() < 2) return students;
        List<Student> copyOfStudents = new ArrayList<>(students);
        Student temp;
        for (int i = 0; i < copyOfStudents.size(); i++) {
            for (int j = 0; j < copyOfStudents.size() - j; j++) {
                if (copyOfStudents.get(j).compareTo(copyOfStudents.get(j + 1)) > 0) {
                    temp = copyOfStudents.get(j);
                    copyOfStudents.set(j, copyOfStudents.get(j + 1));
                    copyOfStudents.set(j + 1, temp);
                }
            }
        }
        return copyOfStudents;
    }
}
