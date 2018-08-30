package cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern;

public interface Visitable {
    void acceptVisitor(Visitor visitor);
}
