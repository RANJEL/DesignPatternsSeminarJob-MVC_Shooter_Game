package cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern;

public interface Originator {
    Memento createMemento();

    void setMemento(Memento memento);
}
