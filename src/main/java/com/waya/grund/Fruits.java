package com.waya.grund;

import java.util.Arrays;

public class Fruits {

  public static void main(String[] args) {

    if (args.length != 0) {
      System.out.println("Calculating best options for buying fruits.");
      Double[] cherriesBasketPrices = parseArgumentToDoubleArray(args[0]);
      Double[] peachesBasketPrices = parseArgumentToDoubleArray(args[1]);
      int bestStandToBuyAt = calculateBestStandToBuyAt(cherriesBasketPrices, peachesBasketPrices);
      System.out.println("Best stand to buy at is stant no: " + (bestStandToBuyAt + 1));
    } else {
      System.out.println("You have not entered any fruit prices.");
    }
  }

  static int calculateBestStandToBuyAt(
      Double[] cherriesBasketPrices, Double[] peachesBasketPrices) {
    int bestOption = 0;
    double currentBestPrice = 0;
    double buyPrice = 0;
    for (int i = 0; i < cherriesBasketPrices.length; i++) {
      buyPrice = cherriesBasketPrices[i] + peachesBasketPrices[i];

      if (i == 0) {
        currentBestPrice = buyPrice;
        bestOption = i;
      }

      if (currentBestPrice > buyPrice) {
        currentBestPrice = buyPrice;
        bestOption = i;
      }
    }
    return bestOption;
  }

  private static Double[] parseArgumentToDoubleArray(String argument) {
    return Arrays.stream(argument.split(",")).map(Double::parseDouble).toArray(Double[]::new);
  }
}
