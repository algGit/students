package com.uniquex.students.usecase.port;

import com.uniquex.students.adapter.controller.StudentDAO;

import java.util.List;

public interface StudentAPI {

    List<StudentDAO> sortStudentByAlgorithm(String sortAlgorithmName, List<StudentDAO> students);
}
