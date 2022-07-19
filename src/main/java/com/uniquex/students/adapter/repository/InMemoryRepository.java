package com.uniquex.students.adapter.repository;

import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.port.StudentRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryRepository implements StudentRepo<Student> {

    private List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public void saveAllStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
