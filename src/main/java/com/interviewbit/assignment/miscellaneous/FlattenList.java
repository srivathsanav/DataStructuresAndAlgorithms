package com.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by srivathsan on 02/03/17.
 */
public class FlattenList {
    public Vector list;
    public int value;

    public void flatten() {
       // return flatten(new Vector());
    }

    private void flatten(Vector res) {
        if (list == null) res.add(value);
        else {
          //  for (T v : list) flatten(v);
        }
    }
}