package com.waya.utökning1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FruitStand1 {

  private static final int SCALE = 2;
  private final int order;
  private final Double cherriesPrice;
  private final Double peachesPrice;
  private final Double pearsPrice;
  private final Double bestPriceComboWithPears;

  public FruitStand1(int order, Double cherriesPrice, Double peachesPrice, Double pearsPrice) {
    this.order = order;
    this.cherriesPrice = cherriesPrice;
    this.peachesPrice = peachesPrice;
    this.pearsPrice = pearsPrice;
    this.bestPriceComboWithPears = calculateBestPriceComboWithPears();
  }

  private Double calculateBestPriceComboWithPears() {
    double cherriesCombo = cherriesPrice + pearsPrice;
    double peachesCombo = peachesPrice + pearsPrice;
    return Math.min(cherriesCombo, peachesCombo);
  }

  public int getOrder() {
    return this.order;
  }

  public Double getBestPriceComboWithPears() {
    return this.bestPriceComboWithPears;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;

    if (!(obj instanceof FruitStand1)) return false;

    FruitStand1 other = (FruitStand1) obj;

    BigDecimal thisComboPrice =
        BigDecimal.valueOf(this.getBestPriceComboWithPears()).setScale(SCALE, RoundingMode.HALF_UP);
    BigDecimal otherComboPrice =
        BigDecimal.valueOf(other.getBestPriceComboWithPears())
            .setScale(SCALE, RoundingMode.HALF_UP);

    return thisComboPrice.compareTo(otherComboPrice) == 0;
  }
}
