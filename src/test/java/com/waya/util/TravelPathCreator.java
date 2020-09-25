package com.waya.util;

import com.waya.FruitBasket;
import com.waya.FruitStand;
import com.waya.FruitType;
import com.waya.TravelPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPathCreator {

  public static TravelPath withCheapestFirst() {
    List<FruitStand> fruitStands = new ArrayList<>();
    fruitStands.add(createCheapestStand());
    fruitStands.addAll(createSomeNonCheapStands(9));
    return new TravelPath(fruitStands);
  }

  public static TravelPath withCheapestInTheMiddle() {
    List<FruitStand> fruitStands = new ArrayList<>(createSomeNonCheapStands(4));
    fruitStands.add(createCheapestStand());
    fruitStands.addAll(createSomeNonCheapStands(5));
    return new TravelPath(fruitStands);
  }

  public static TravelPath withCheapestLast() {
    List<FruitStand> fruitStands = new ArrayList<>(createSomeNonCheapStands(9));
    fruitStands.add(createCheapestStand());
    return new TravelPath(fruitStands);
  }

  public static TravelPath withOnlyOne() {
    List<FruitStand> fruitStands = new ArrayList<>();
    fruitStands.add(createCheapestStand());
    return new TravelPath(fruitStands);
  }

  private static FruitStand createCheapestStand() {
    Map<FruitType, FruitBasket> fruitBaskets = new HashMap<>();
    fruitBaskets.put(FruitType.CHERRY, new FruitBasket(1.00));
    fruitBaskets.put(FruitType.PEACH, new FruitBasket(1.00));
    return new FruitStand(fruitBaskets);
  }

  private static List<FruitStand> createSomeNonCheapStands(int noOfStands) {
    List<FruitStand> fruitStands = new ArrayList<>();
    for (int i = 0; i < noOfStands; i++) {
      Map<FruitType, FruitBasket> fruitBaskets = new HashMap<>();
      fruitBaskets.put(FruitType.CHERRY, new FruitBasket(2.00));
      fruitBaskets.put(FruitType.PEACH, new FruitBasket(2.00));
      fruitStands.add(new FruitStand(fruitBaskets));
    }
    return fruitStands;
  }
}
