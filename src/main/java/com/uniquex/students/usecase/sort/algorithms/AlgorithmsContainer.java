package com.uniquex.students.usecase.sort.algorithms;

import com.uniquex.students.usecase.sort.algorithms.port.SortAlgorithm;

public enum AlgorithmsContainer {
    BUBBLE(new Bubble()), HEAP(new Heap()), MERGE(new Merge());

    private final SortAlgorithm sortAlgorithm;

    AlgorithmsContainer(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public SortAlgorithm getSortAlgorithm() {
        return this.sortAlgorithm;
    }

}
