package com.uniquex.students.usecase;

import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.sort.algorithms.port.SortAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentSorter {
    private final Logger logger = LoggerFactory.getLogger(StudentSorter.class);

    public List<Student> sortStudentsBy(SortAlgorithm sortAlgorithm, List<Student> students) {
        long start = System.nanoTime();
        List<Student> sort = sortAlgorithm.sort(students);
        logger.info(sortAlgorithm.getClass().getSimpleName() + " Sorted in: " +
                (System.nanoTime() - start) + " nano");
        return sort;
    }
}
