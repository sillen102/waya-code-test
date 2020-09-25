package com.waya.utökning1;

import java.util.Arrays;

public class Fruits1 {

  public static void main(String[] args) {

    if (args.length != 0) {
      System.out.println("Calculating best options for buying fruits.");
      Double[] cherriesBasketPrices = parseArgumentToDoubleArray(args[0]);
      Double[] peachesBasketPrices = parseArgumentToDoubleArray(args[1]);
      Double[] pearsBasketPrices = parseArgumentToDoubleArray(args[2]);
      FruitStand1 bestStandToBuyAt =
          calculateBestStandToBuyAt(cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices);

      System.out.println("Best stand to buy at is stant no: " + (bestStandToBuyAt.getOrder() + 1));
      System.out.println(
          "The price at the stand is: " + bestStandToBuyAt.getBestPriceComboWithPears());
    } else {
      System.out.println("You have not entered any fruit prices.");
    }
  }

  static FruitStand1 calculateBestStandToBuyAt(
      Double[] cherriesBasketPrices, Double[] peachesBasketPrices, Double[] pearsBasketPrices) {
    FruitStand1 currentBestStand = new FruitStand1(0, 0.0, 0.0, 0.0);
    for (int i = 0; i < cherriesBasketPrices.length; i++) {
      FruitStand1 stand =
          new FruitStand1(i, cherriesBasketPrices[i], peachesBasketPrices[i], pearsBasketPrices[i]);

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
}
