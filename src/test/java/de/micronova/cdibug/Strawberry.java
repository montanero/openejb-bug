package de.micronova.cdibug;

import de.micronova.cdibug.annotations.FoodQualifier;
import de.micronova.cdibug.annotations.FoodType;
import de.micronova.cdibug.annotations.TasteQualifier;
import de.micronova.cdibug.annotations.TasteType;

@FoodQualifier(FoodType.FRUIT)
@TasteQualifier(TasteType.JUMMY)
public class Strawberry extends Food {

    public Strawberry() {
        super("Strawberry");
    }
}
