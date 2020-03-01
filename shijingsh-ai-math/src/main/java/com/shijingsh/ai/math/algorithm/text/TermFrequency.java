package com.shijingsh.ai.math.algorithm.text;

import it.unimi.dsi.fastutil.ints.IntSet;

/**
 * Term Frequency
 *
 * @author Birdy
 *
 */
public interface TermFrequency {

    IntSet getKeys();

    float getValue(int key);

}
