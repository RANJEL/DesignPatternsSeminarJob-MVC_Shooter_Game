package cz.fit.dpo.mvcshooter.designPatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
    List<Observer> itsObservers = new ArrayList<>();

    default void registerObserver(Observer observer) {
        if (observer != null) {
            itsObservers.add(observer);
        }
    }

    default void unregisterObserver(Observer observer) {
        if (observer != null) {
            int observerIndex = itsObservers.indexOf(observer);
            if (observerIndex != -1) {
                itsObservers.remove(observerIndex);
            }
        }
    }

    default void notifyObservers() {
        for (Observer observer :
                itsObservers) {
            observer.update(this);
        }
    }
}
