package com.waya.utökning2;

import java.util.Arrays;
import java.util.Iterator;

public class Fruits2 {

  public static void main(String[] args) {

    if (args.length != 0) {
      System.out.println("Calculating best options for buying fruits.");
      Double[] cherriesBasketPrices = parseArgumentToDoubleArray(args[0]);
      Double[] peachesBasketPrices = parseArgumentToDoubleArray(args[1]);
      Double[] pearsBasketPrices = parseArgumentToDoubleArray(args[2]);
      FruitStand2 bestStandToBuyAt =
          calculateBestStandToBuyAt(cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices);

      System.out.println("Best stand to buy at is stant no: " + (bestStandToBuyAt.getOrder() + 1));
      System.out.println(
          "The price at the stand is: " + bestStandToBuyAt.getBestPriceComboWithPears());
      System.out.println("Fruit bought: " + getBoughtFruitTypes(bestStandToBuyAt));
    } else {
      System.out.println("You have not entered any fruit prices.");
    }
  }

  static FruitStand2 calculateBestStandToBuyAt(
      Double[] cherriesBasketPrices, Double[] peachesBasketPrices, Double[] pearsBasketPrices) {
    FruitStand2 currentBestStand = new FruitStand2(0, 0.0, 0.0, 0.0);
    for (int i = 0; i < cherriesBasketPrices.length; i++) {
      FruitStand2 stand =
          new FruitStand2(i, cherriesBasketPrices[i], peachesBasketPrices[i], pearsBasketPrices[i]);

      if (i == 0) {
        currentBestStand = stand;
      }

      if (currentBestStand
              .getBestPriceComboWithPears()
              .compareTo(stand.getBestPriceComboWithPears())
          > 0) {
        currentBestStand = stand;
      }
    }
    return currentBestStand;
  }

  private static Double[] parseArgumentToDoubleArray(String argument) {
    return Arrays.stream(argument.split(",")).map(Double::parseDouble).toArray(Double[]::new);
  }

  private static String getBoughtFruitTypes(FruitStand2 fruitStand2) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<FruitType2> iterator = fruitStand2.getBoughtFruitBoxTypes().iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next().toString().toLowerCase());
      if (iterator.hasNext()) stringBuilder.append(" and ");
    }
    return stringBuilder.toString();
  }
}
