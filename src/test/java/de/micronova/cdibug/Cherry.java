package de.micronova.cdibug;

import de.micronova.cdibug.annotations.FoodQualifier;
import de.micronova.cdibug.annotations.FoodType;
import de.micronova.cdibug.annotations.TasteQualifier;
import de.micronova.cdibug.annotations.TasteType;

@FoodQualifier(FoodType.FRUIT)
@TasteQualifier(TasteType.DISGUSTING)
public class Cherry extends Food {

    public Cherry() {
        super("Cherry");
    }
}
