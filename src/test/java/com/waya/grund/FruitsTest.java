package com.waya.grund;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FruitsTest {

  @Test
  void bestIsFirst() {
    Double[] cherriesBasketPrices = {1.34, 3.23, 1.22, 5.34, 2.67};
    Double[] peachesBasketPrices = {1.56, 7.33, 12.45, 6.54, 12.55};
    assertThat(Fruits.calculateBestStandToBuyAt(cherriesBasketPrices, peachesBasketPrices))
        .isEqualTo(0);
  }

  @Test
  void bestInTheMiddle() {
    Double[] cherriesBasketPrices = {1.34, 3.23, 1.22, 5.34, 2.67};
    Double[] peachesBasketPrices = {13.56, 7.33, 1.45, 6.54, 12.55};
    assertThat(Fruits.calculateBestStandToBuyAt(cherriesBasketPrices, peachesBasketPrices))
        .isEqualTo(2);
  }

  @Test
  void bestIsLast() {
    Double[] cherriesBasketPrices = {1.34, 3.23, 1.22, 5.34, 2.67};
    Double[] peachesBasketPrices = {12.56, 7.33, 12.45, 6.54, 2.55};
    assertThat(Fruits.calculateBestStandToBuyAt(cherriesBasketPrices, peachesBasketPrices))
        .isEqualTo(4);
  }

  @Test
  void onlyOneStandAvailable() {
    Double[] cherriesBasketPrices = {1.34};
    Double[] peachesBasketPrices = {12.56};
    assertThat(Fruits.calculateBestStandToBuyAt(cherriesBasketPrices, peachesBasketPrices))
        .isEqualTo(0);
  }
}
