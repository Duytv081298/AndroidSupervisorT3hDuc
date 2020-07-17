package com.t3h.duoihinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tes {
    Tes() {
        List<String> t = new ArrayList<>();
        Collections.sort(t, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.sort(t, (o1, o2) -> {
            return o1.compareTo(o2);
        });
    }
}
