package com.shijingsh.ai.math.algorithm.lsh;

import java.util.Random;

import com.shijingsh.ai.math.structure.vector.MathVector;
import com.shijingsh.ai.math.structure.vector.VectorScalar;
import com.shijingsh.ai.math.structure.vector.MathVector;
import com.shijingsh.ai.math.structure.vector.VectorScalar;

public class MinHashFunction implements VectorHashFunction {

    private int a;

    private int b;

    public MinHashFunction(Random dimension) {
        // a and b should be randomly generated in [1,PRIME-1]
        this.a = dimension.nextInt(Integer.MAX_VALUE - 1) + 1;
        this.b = dimension.nextInt(Integer.MAX_VALUE - 1) + 1;
    }

    public int hash(MathVector vector) {
        int hash = Integer.MAX_VALUE;
        for (VectorScalar scalar : vector) {
            if (scalar.getValue() > 0F) {
                hash = Math.min((a * scalar.getIndex() + b) % Integer.MAX_VALUE, hash);
            }
        }
        return hash;
    }

}
