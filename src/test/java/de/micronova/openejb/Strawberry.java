package de.micronova.openejb;

import de.micronova.openejb.annotations.FoodQualifier;
import de.micronova.openejb.annotations.FoodType;
import de.micronova.openejb.annotations.TasteQualifier;
import de.micronova.openejb.annotations.TasteType;

@FoodQualifier(FoodType.FRUIT)
@TasteQualifier(TasteType.JUMMY)
public class Strawberry extends Food {

    public Strawberry() {
        super("Strawberry");
    }
}
