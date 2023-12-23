package org.example;

import java.util.HashSet;

public interface Observer {
    void update(int[][] coordinates);
    void update(HashSet<int[]> elements);
}
