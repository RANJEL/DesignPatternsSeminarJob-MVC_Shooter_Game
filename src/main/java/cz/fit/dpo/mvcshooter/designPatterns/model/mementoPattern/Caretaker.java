package cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern;

import java.util.Stack;

/***
 * Singleton class responsible for the memento safekeeping
 */
public class Caretaker {
    private static volatile Caretaker itsInstance = null;
    private final Stack<Memento> mementoStack;

    private Caretaker() {
        mementoStack = new Stack<>();
    }

    public static Caretaker instance() {
        synchronized (Caretaker.class) {
            if (itsInstance == null) {
                itsInstance = new Caretaker();
            }
        }
        return itsInstance;
    }

    public void addMemento(Memento memento) {
        mementoStack.push(memento);
    }

    public Memento popLastMemento() {
        return mementoStack.pop();
    }
}
