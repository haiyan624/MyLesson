package com.wq.design.strategy;

public class CatWeightComparator implements Comparator<Cat> {
    public int compare(Cat t1, Cat t2) {
        if(t1.weight>t2.weight){
            return 1;
        } else if(t1.weight<t2.weight){
            return -1;
        }
        return 0;
    }
}
