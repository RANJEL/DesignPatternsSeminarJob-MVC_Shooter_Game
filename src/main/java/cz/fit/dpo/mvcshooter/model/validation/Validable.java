package cz.fit.dpo.mvcshooter.model.validation;

public interface Validable {
    boolean isInvalid();

    void invalidate();
}
