package com.waya;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FruitStand {
  private final Map<FruitType, FruitBasket> fruitBaskets;
}
