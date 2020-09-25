package com.waya;

import static org.assertj.core.api.Assertions.assertThat;

import com.waya.util.TravelPathCreator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FruitCalculatorTest {

  @Test
  void travelPathWithCheapestAsFirst() {
    List<FruitType> fruitTypes = new ArrayList<>();
    Collections.addAll(fruitTypes, FruitType.CHERRY, FruitType.PEACH);
    TravelPath travelPath = TravelPathCreator.withCheapestFirst();
    FruitStand fruitStand = FruitBasketCalculator.calculateCheapestStand(travelPath);
    assertThat(getPriceForFruits(fruitStand, fruitTypes))
        .isEqualTo(getPriceForFruits(travelPath.getFruitStands().get(0), fruitTypes));
  }

  @Test
  void travelPathWithCheapestInTheMiddle() {
    List<FruitType> fruitTypes = new ArrayList<>();
    Collections.addAll(fruitTypes, FruitType.CHERRY, FruitType.PEACH);
    TravelPath travelPath = TravelPathCreator.withCheapestInTheMiddle();
    FruitStand fruitStand = FruitBasketCalculator.calculateCheapestStand(travelPath);
    assertThat(getPriceForFruits(fruitStand, fruitTypes))
        .isEqualTo(getPriceForFruits(travelPath.getFruitStands().get(4), fruitTypes));
  }

  @Test
  void travelPathWithCheapesAsLast() {
    List<FruitType> fruitTypes = new ArrayList<>();
    Collections.addAll(fruitTypes, FruitType.CHERRY, FruitType.PEACH);
    TravelPath travelPath = TravelPathCreator.withCheapestLast();
    FruitStand fruitStand = FruitBasketCalculator.calculateCheapestStand(travelPath);
    assertThat(getPriceForFruits(fruitStand, fruitTypes))
        .isEqualTo(getPriceForFruits(travelPath.getFruitStands().get(9), fruitTypes));
  }

  @Test
  void travelPathWithOnlyOneStand() {
    List<FruitType> fruitTypes = new ArrayList<>();
    Collections.addAll(fruitTypes, FruitType.CHERRY, FruitType.PEACH);
    TravelPath travelPath = TravelPathCreator.withOnlyOne();
    FruitStand fruitStand = FruitBasketCalculator.calculateCheapestStand(travelPath);
    assertThat(getPriceForFruits(fruitStand, fruitTypes))
        .isEqualTo(getPriceForFruits(travelPath.getFruitStands().get(0), fruitTypes));
  }

  private double getPriceForFruits(FruitStand fruitStand, List<FruitType> fruitTypes) {
    double price = 0.0;
    for (FruitType fruitType : fruitTypes) {
      price += fruitStand.getFruitBaskets().get(fruitType).getPrice();
    }
    return price;
  }
}
