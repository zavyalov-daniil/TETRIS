package org.example;

public interface Observable {
    void registerObserver(Observer o);
    void notifyObservers();
}
