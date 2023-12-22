package org.example.model;

public enum TetrominoType {
    ZShape(new int[][] { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } }),
    SShape(new int[][] { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } }),
    LineShape(new int[][] { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } }),
    TShape(new int[][] { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } }),
    SquareShape(new int[][] { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } }),
    LShape(new int[][] { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } }),
    MirroredLShape(new int[][] { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } });

    private final int[][] coordinates;

    TetrominoType(int[][] coordinates) {
        this.coordinates = coordinates;
    }

    public int[][] getCoordinates() {
        int[][] result = new int[coordinates.length][coordinates[0].length];
        for (int i = 0; i < coordinates.length; i++) {
            result[i] = coordinates[i].clone();
        }
        return result;
    }
}
