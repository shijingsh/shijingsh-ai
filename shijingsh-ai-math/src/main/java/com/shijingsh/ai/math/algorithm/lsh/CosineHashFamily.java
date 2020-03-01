package com.shijingsh.ai.math.algorithm.lsh;

import java.util.Random;

import com.shijingsh.ai.math.algorithm.correlation.similarity.CosineSimilarity;
import com.shijingsh.ai.math.structure.vector.MathVector;
import com.shijingsh.ai.math.algorithm.correlation.similarity.CosineSimilarity;
import com.shijingsh.ai.math.structure.vector.MathVector;

public class CosineHashFamily implements LshHashFamily {

    private static final CosineSimilarity similarity = new CosineSimilarity();

    private final int dimensions;

    public CosineHashFamily(int dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public VectorHashFunction getHashFunction(Random random) {
        return new CosineHashFunction(random, dimensions);
    }

    @Override
    public float getCoefficient(MathVector leftVector, MathVector rightVector) {
        return 1F - similarity.getCoefficient(leftVector, rightVector);
    }
}
