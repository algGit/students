package com.uniquex.students.domain.entity.port;

public interface Student extends Comparable<Student>{

    Double getGrade();
    String getName();
}
