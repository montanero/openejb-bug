package de.micronova.openejb.annotations;

import javax.enterprise.util.AnnotationLiteral;

public final class LiteralFoodType extends AnnotationLiteral<FoodQualifier> implements FoodQualifier {
    private static final long serialVersionUID = 1L;

    private final FoodType food;

    public LiteralFoodType(FoodType food) {
        this.food = food;
    }

    @Override
    public FoodType value() {
        return food;
    }
}

