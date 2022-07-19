package com.uniquex.students.usecase.port;

import com.uniquex.students.domain.entity.port.Student;

import java.util.List;

public interface StudentRepo<T> {

    List<T> getAllStudents();

    void saveAllStudents(List<T> students);
}
