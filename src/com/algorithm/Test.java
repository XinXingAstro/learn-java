package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Test {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(2, .75F, true);
        map.put(1,1);
        map.put(2,2);
    }
}
