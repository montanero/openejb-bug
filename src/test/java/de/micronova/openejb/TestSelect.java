package de.micronova.openejb;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import de.micronova.openejb.annotations.FoodQualifier;
import de.micronova.openejb.annotations.FoodType;
import de.micronova.openejb.annotations.LiteralFoodType;
import de.micronova.openejb.annotations.LiteralTasteType;
import de.micronova.openejb.annotations.TasteQualifier;
import de.micronova.openejb.annotations.TasteType;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class TestSelect {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FoodQualifier.class.getPackage())
                .addPackage(TestSelect.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    @Any
    private Instance<Food> allTypesOfFood;

    @Test
    public void findYummyFruit ()
    {
        Instance<Food> fruits = allTypesOfFood.select(new LiteralFoodType(FoodType.FRUIT));
        Instance<Food> jummyFruits = fruits.select(new LiteralTasteType(TasteType.JUMMY));
        Optional<Food> someJummyFruit = jummyFruits.stream().findAny();
        Assert.assertTrue(someJummyFruit.isPresent());
    }

    @Test
    public void thereIsNoJummyVegetable ()
    {
        Instance<Food> vegetables = allTypesOfFood.select(new LiteralFoodType(FoodType.VEGETABLE));
        Assert.assertTrue(vegetables.isUnsatisfied());
        Instance<Food> jummyVegetables = vegetables.select(new TasteQualifier.Literal(TasteType.JUMMY));
        Optional<Food> someJummyVegetable = jummyVegetables.stream().findAny();
        Assert.assertFalse(someJummyVegetable.isPresent());

    }
}
