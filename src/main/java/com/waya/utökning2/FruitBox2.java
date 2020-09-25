package com.waya.utökning2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FruitBox2 {
  private final double price;
  private final FruitType2 fruitType2;
  private boolean bought;
}
