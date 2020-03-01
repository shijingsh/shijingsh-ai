package com.shijingsh.core.common.hash;

import java.util.Random;

public interface HashFamily<T extends HashFunction> {

    T getHashFunction(Random random);

}
