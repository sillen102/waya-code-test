package com.waya;

public class FruitBasketCalculator {

  public static FruitStand calculateCheapestStand(TravelPath travelPath) {
    FruitStand chepestFruitStand = null;
    for (FruitStand fruitStand : travelPath.getFruitStands()) {
      if (chepestFruitStand == null) {
        chepestFruitStand = fruitStand;
      }

      if (chepestFruitStand.getFruitBaskets().get(FruitType.CHERRY).getPrice()
              + chepestFruitStand.getFruitBaskets().get(FruitType.PEACH).getPrice()
          > fruitStand.getFruitBaskets().get(FruitType.CHERRY).getPrice()
              + fruitStand.getFruitBaskets().get(FruitType.PEACH).getPrice()) {
        chepestFruitStand = fruitStand;
      }
    }
    return chepestFruitStand;
  }
}
