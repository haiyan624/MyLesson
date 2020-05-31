package com.wq.design.strategy;

import java.util.Arrays;

public class StrategyTest {
    public static void main(String[] args) {
        Cat[] arr = {new Cat(1,1),new Cat(5,5),new Cat(3,3)};
        Sorter<Cat> sorter = new Sorter<Cat>();
        sorter.sort(arr,new CatWeightComparator());
        System.out.println(Arrays.toString(arr));
    }
}
