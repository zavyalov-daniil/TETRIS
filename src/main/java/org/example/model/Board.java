package org.example.model;

import org.example.Observable;
import org.example.Observer;
import org.example.view.BoardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class Board implements Observable {

    private final HashSet<int[]> elements = new HashSet<>();
    List<Observer> observers;

    public Board() {
        elements.add(new int[] { 0, 21 });
        elements.add(new int[] { 9, 21 });
        elements.add(new int[] { 8, 21 });
        elements.add(new int[] { 7, 21 });
        elements.add(new int[] { 6, 21 });
        elements.add(new int[] { 5, 21 });
        elements.add(new int[] { 4, 13 });
    }

    @Autowired
    @Lazy
    public void setBoard(BoardView boardView) {
        observers = new ArrayList<>();
        observers.add(boardView);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(elements);
        }
    }

    public void putElement(int[] coords) {
        elements.add(coords);
        notifyObservers();
    }

    public void deleteElement(int x, int y) {
        elements.removeIf(array -> array[0] == x && array[1] == y);
        notifyObservers();
    }

    public boolean containElement(int x, int y) {
        for (int[] element : elements) {
            if (element[0] == x && element[1] == y) {
                return true;
            }
        }
        return false;
    }

    //TODO: delete it
    public HashSet<int[]> getElements() {
        return elements;
    }
}
