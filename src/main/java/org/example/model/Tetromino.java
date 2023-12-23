package org.example.model;

import org.example.Observable;
import org.example.Observer;

import java.util.ArrayList;
import java.util.List;

public class Tetromino implements Observable {
    private final TetrominoType type;
    private int[][] coordinates;
    List<Observer> observers;
    boolean isDropped;

    public Tetromino(TetrominoType type, int xOffset, int yOffset) {
        this.type = type;
        coordinates = type.getCoordinates();
        for (int element = 0; element < coordinates.length; element++) {
            coordinates[element][0] = coordinates[element][0] + xOffset;
            coordinates[element][1] = coordinates[element][1] + yOffset;
        }
        observers = new ArrayList<>();
        isDropped = false;
    }

    public Tetromino(TetrominoType type, int xOffset, int yOffset, Observer observer) {
        this.type = type;
        coordinates = type.getCoordinates();
        for (int element = 0; element < coordinates.length; element++) {
            coordinates[element][0] = coordinates[element][0] + xOffset;
            coordinates[element][1] = coordinates[element][1] + yOffset;
        }
        observers = new ArrayList<>();
        observers.add(observer);
        isDropped = false;
    }

    public Tetromino(TetrominoType type, int xOffset, int yOffset, List<Observer> observers) {
        this.type = type;
        coordinates = type.getCoordinates();
        for (int element = 0; element < coordinates.length; element++) {
            coordinates[element][0] = coordinates[element][0] + xOffset;
            coordinates[element][1] = coordinates[element][1] + yOffset;
        }
        this.observers = observers;
        isDropped = false;
    }

    public TetrominoType getType() {
        return type;
    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[][] coordinates) {
        this.coordinates = coordinates;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(coordinates);
        }
    }

    public boolean isDropped() {
        return isDropped;
    }

    public void setDropped(boolean dropped) {
        isDropped = dropped;
    }
}
