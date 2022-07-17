package com.uniquex.students.usecase.sort.algorithms;

import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.sort.algorithms.port.SortAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Heap implements SortAlgorithm {
    @Override
    public List<Student> sort(List<Student> students) {
        if (students == null || students.size() < 2) return students;
        List<Student> copyOfStudents = new ArrayList<>(students);

        int n = copyOfStudents.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(copyOfStudents, n, i);
        }

        for (int i=n-1; i>=0; i--) {
            Student temp = copyOfStudents.get(0);
            copyOfStudents.set(0,copyOfStudents.get(i));
            copyOfStudents.set(i,temp);
            heapify(copyOfStudents, i, 0);
        }
        return copyOfStudents;
    }

    void heapify(List<Student>students, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && students.get(l).getGrade() > students.get(largest).getGrade()) largest = l;

        if (r < n && students.get(r).getGrade() > students.get(largest).getGrade()) largest = r;

        if (largest != i) {
            Student swap = students.get(i);
            students.set(i,students.get(largest));
            students.set(largest,swap);
            heapify(students, n, largest);
        }
    }
}
