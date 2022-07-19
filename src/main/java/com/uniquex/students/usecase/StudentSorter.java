package com.uniquex.students.usecase;

import com.uniquex.students.domain.entity.port.Student;
import com.uniquex.students.usecase.sort.algorithms.AlgorithmsContainer;
import com.uniquex.students.usecase.sort.algorithms.port.SortAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class StudentSorter {
    private final Logger logger = LoggerFactory.getLogger(StudentSorter.class);

    public List<Student> sortStudentsBy(String sortAlgorithmName, List<Student> students) {
        SortAlgorithm sortAlgorithm = AlgorithmsContainer
                .valueOf(sortAlgorithmName.toUpperCase(Locale.ROOT)).getSortAlgorithm();
        long start = System.nanoTime();
        List<Student> sort = sortAlgorithm.sort(students);
        logger.info(sortAlgorithm.getClass().getSimpleName() + " Sorted in: " +
                (System.nanoTime() - start) + " nano");
        return sort;
    }
}
