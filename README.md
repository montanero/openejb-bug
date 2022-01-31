# Code to reproduce possible Bug in OWB/Tomee
within an openejb server (version 8.0.9) I have Managed Beans annotated with two qualifiers each. Examples from my test project:

    @FoodQualifier(FoodType.FRUIT)
    @TasteQualifier(TasteType.JUMMY)
    public class Strawberry extends Food {
    ...

I got an injected Instance object, on which I want to select beans in a two-step process:

    @Inject @Any private Instance<Food> allTypesOfFood;
    ...
    Instance<Food> vegetables = allTypesOfFood.select(new LiteralFoodType(FoodType.VEGETABLE));
    Instance<Food> jummyVegetables = vegetables.select(new LiteralTasteType(TasteType.JUMMY));


The second call to "select" seems to completely ignore the fact it is meant to be working on a restricted set, it yields all JUMMY foots, not just the vegetables.


## To reproduce using tomee:
    mvn clean install

## To reproduce using owb:
    mvn clean install -P owb

## To run tests using weld
(errors will not happen)

    mvn clean install -P weld



