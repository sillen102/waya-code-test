package com.waya.utökning2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Fruits2Test {

  @Test
  void bestIsFirst() {
    Double[] cherriesBasketPrices = {1.14, 3.23, 1.22, 5.34, 2.67};
    Double[] peachesBasketPrices = {1.16, 7.33, 12.45, 6.54, 12.55};
    Double[] pearsBasketPrices = {1.12, 4.56, 3.67, 23.45, 3.89};

    List<FruitStand2> stands =
        createStands(cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices);

    assertThat(
            Fruits2.calculateBestStandToBuyAt(
                cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices))
        .isEqualTo(stands.get(0));
  }

  @Test
  void bestInTheMiddle() {
    Double[] cherriesBasketPrices = {1.34, 3.23, 1.22, 5.34, 2.67};
    Double[] peachesBasketPrices = {13.56, 7.33, 1.45, 6.54, 12.55};
    Double[] pearsBasketPrices = {11.12, 4.56, 1.67, 23.45, 3.89};

    List<FruitStand2> stands =
        createStands(cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices);

    assertThat(
            Fruits2.calculateBestStandToBuyAt(
                cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices))
        .isEqualTo(stands.get(2));
  }

  @Test
  void bestIsLast() {
    Double[] cherriesBasketPrices = {1.34, 3.23, 11.22, 5.34, 2.67};
    Double[] peachesBasketPrices = {12.56, 7.33, 12.45, 6.54, 2.55};
    Double[] pearsBasketPrices = {13.12, 14.56, 3.67, 23.45, 3.19};

    List<FruitStand2> stands =
        createStands(cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices);

    assertThat(
            Fruits2.calculateBestStandToBuyAt(
                cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices))
        .isEqualTo(stands.get(4));
  }

  @Test
  void onlyOneStandAvailable() {
    Double[] cherriesBasketPrices = {1.34};
    Double[] peachesBasketPrices = {12.56};
    Double[] pearsBasketPrices = {1.12};

    List<FruitStand2> stands =
        createStands(cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices);

    assertThat(
            Fruits2.calculateBestStandToBuyAt(
                cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices))
        .isEqualTo(stands.get(0));
  }

  @Test
  void pearsWithCherriesIsBest() {
    Double[] cherriesBasketPrices = {1.34, 3.23, 1.44, 5.34, 2.67};
    Double[] peachesBasketPrices = {13.56, 7.33, 1.45, 6.54, 12.55};
    Double[] pearsBasketPrices = {11.12, 4.56, 1.67, 23.45, 3.89};

    List<FruitStand2> stands =
        createStands(cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices);

    assertThat(
            Fruits2.calculateBestStandToBuyAt(
                cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices))
        .isEqualTo(stands.get(2));
  }

  @Test
  void pearsWithPeachesIsBest() {
    Double[] cherriesBasketPrices = {1.34, 3.23, 1.46, 5.34, 2.67};
    Double[] peachesBasketPrices = {13.56, 7.33, 1.45, 6.54, 12.55};
    Double[] pearsBasketPrices = {11.12, 4.56, 1.67, 23.45, 3.89};

    List<FruitStand2> stands =
        createStands(cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices);

    assertThat(
            Fruits2.calculateBestStandToBuyAt(
                cherriesBasketPrices, peachesBasketPrices, pearsBasketPrices))
        .isEqualTo(stands.get(2));
  }

  private List<FruitStand2> createStands(
      Double[] cherriesBasketPrices, Double[] peachesBasketPrices, Double[] pearsBasketPrices) {
    List<FruitStand2> stands = new ArrayList<>();
    for (int i = 0; i < cherriesBasketPrices.length; i++) {
      stands.add(
          new FruitStand2(
              i, cherriesBasketPrices[i], peachesBasketPrices[i], pearsBasketPrices[i]));
    }
    return stands;
  }
}
