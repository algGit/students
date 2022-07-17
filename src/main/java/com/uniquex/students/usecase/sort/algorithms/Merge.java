package com.uniquex.students.usecase.sort.algorithms;

import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.sort.algorithms.port.SortAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Merge implements SortAlgorithm {

    @Override
    public List<Student> sort(List<Student> students) {
        List<Student> copyOfStudents = new ArrayList<>(students);
        sort(copyOfStudents, 0, students.size() - 1);
        return copyOfStudents;
    }

    private void sort(List<Student> students, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(students, l, m);
            sort(students, m + 1, r);
            merge(students, l, m, r);
        }
    }

    private void merge(List<Student> students, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Student left[] = new Student[n1];
        Student right[] = new Student[n2];

        for (int i = 0; i < n1; ++i)
            left[i] = students.get(l + i);
        for (int j = 0; j < n2; ++j)
            right[j] = students.get(m + 1 + j);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i].getGrade() <= right[j].getGrade()) {
                students.set(k,left[i]);
                i++;
            } else {
                students.set(k,right[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            students.set(k, left[i]);
            i++;
            k++;
        }

        while (j < n2) {
            students.set(k,right[j]);
            j++;
            k++;
        }
    }
}
