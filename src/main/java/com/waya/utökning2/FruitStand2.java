package com.waya.utökning2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStand2 {

  private static final int SCALE = 2;
  private final int order;
  private final Map<FruitType2, FruitBox2> fruitBoxes;
  private final Double bestPriceComboWithPears;

  public FruitStand2(int order, Double cherriesPrice, Double peachesPrice, Double pearsPrice) {
    this.order = order;
    this.fruitBoxes = new HashMap<>();
    this.fruitBoxes.put(
        FruitType2.CHERRIES, new FruitBox2(cherriesPrice, FruitType2.CHERRIES, false));
    this.fruitBoxes.put(FruitType2.PEACHES, new FruitBox2(peachesPrice, FruitType2.PEACHES, false));
    this.fruitBoxes.put(FruitType2.PEARS, new FruitBox2(pearsPrice, FruitType2.PEARS, false));
    this.bestPriceComboWithPears = calculateBestPriceComboWithPearsAndSetBoughtFruit();
  }

  private Double calculateBestPriceComboWithPearsAndSetBoughtFruit() {
    double cherriesCombo =
        fruitBoxes.get(FruitType2.CHERRIES).getPrice()
            + fruitBoxes.get(FruitType2.PEARS).getPrice();
    double peachesCombo =
        fruitBoxes.get(FruitType2.PEACHES).getPrice() + fruitBoxes.get(FruitType2.PEARS).getPrice();
    setBoughtFruit(cherriesCombo, peachesCombo);
    return Math.min(cherriesCombo, peachesCombo);
  }

  private void setBoughtFruit(double cherriesCombo, double peachesCombo) {
    if (cherriesCombo > peachesCombo) {
      fruitBoxes.get(FruitType2.CHERRIES).setBought(true);
    } else {
      fruitBoxes.get(FruitType2.PEACHES).setBought(true);
    }
    fruitBoxes.get(FruitType2.PEARS).setBought(true);
  }

  public int getOrder() {
    return this.order;
  }

  public Double getBestPriceComboWithPears() {
    return this.bestPriceComboWithPears;
  }

  public List<FruitType2> getBoughtFruitBoxTypes() {
    List<FruitType2> fruitType2s = new ArrayList<>();
    for (Map.Entry<FruitType2, FruitBox2> entry : fruitBoxes.entrySet()) {
      if (entry.getValue().isBought()) {
        fruitType2s.add(entry.getValue().getFruitType2());
      }
    }
    return fruitType2s;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;

    if (!(obj instanceof FruitStand2)) return false;

    FruitStand2 other = (FruitStand2) obj;

    BigDecimal thisComboPrice =
        BigDecimal.valueOf(this.getBestPriceComboWithPears()).setScale(SCALE, RoundingMode.HALF_UP);
    BigDecimal otherComboPrice =
        BigDecimal.valueOf(other.getBestPriceComboWithPears())
            .setScale(SCALE, RoundingMode.HALF_UP);

    return thisComboPrice.compareTo(otherComboPrice) == 0;
  }
}
