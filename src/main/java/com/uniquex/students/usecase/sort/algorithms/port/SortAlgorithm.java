package com.uniquex.students.usecase.sort.algorithms.port;

import com.uniquex.students.domain.entity.port.Student;

import java.util.List;

public interface SortAlgorithm {

    List<Student> sort(List<Student> students);
}
