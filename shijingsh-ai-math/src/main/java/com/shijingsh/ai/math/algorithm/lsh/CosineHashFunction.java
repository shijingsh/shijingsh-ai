package com.shijingsh.ai.math.algorithm.lsh;

import java.util.Random;

import com.shijingsh.ai.math.structure.DefaultScalar;
import com.shijingsh.ai.math.structure.MathScalar;
import com.shijingsh.ai.math.structure.vector.ArrayVector;
import com.shijingsh.ai.math.structure.vector.MathVector;
import com.shijingsh.ai.math.structure.vector.ArrayVector;
import com.shijingsh.ai.math.structure.vector.MathVector;

public class CosineHashFunction implements VectorHashFunction {

    final MathVector randomProjection;

    public CosineHashFunction(Random random, int dimensions) {
        randomProjection = new ArrayVector(dimensions, new float[dimensions]);
        for (int dimension = 0; dimension < dimensions; dimension++) {
            // mean 0
            // standard deviation 1.0
            float value = (float) random.nextGaussian();
            randomProjection.setValue(dimension, value);
        }
    }

    @Override
    public int hash(MathVector vector) {
        MathScalar scalar = DefaultScalar.getInstance();
        // calculate the dot product.
        float hash = scalar.dotProduct(vector, randomProjection).getValue();
        // returns a 'bit' encoded as an integer.
        // 1 when positive or zero, 0 otherwise.
        return hash > 0 ? 1 : 0;
    }
}
