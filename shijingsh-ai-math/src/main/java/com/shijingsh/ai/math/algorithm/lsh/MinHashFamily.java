package com.shijingsh.ai.math.algorithm.lsh;

import java.util.Random;

import com.shijingsh.ai.math.algorithm.correlation.similarity.JaccardIndexSimilarity;
import com.shijingsh.ai.math.structure.vector.MathVector;
import com.shijingsh.ai.math.algorithm.correlation.similarity.JaccardIndexSimilarity;
import com.shijingsh.ai.math.structure.vector.MathVector;

public class MinHashFamily implements LshHashFamily {

    private static final JaccardIndexSimilarity similarity = new JaccardIndexSimilarity();

    public MinHashFamily() {
    }

    @Override
    public VectorHashFunction getHashFunction(Random random) {
        return new MinHashFunction(random);
    }

    @Override
    public float getCoefficient(MathVector leftVector, MathVector rightVector) {
        return 1F - similarity.getCoefficient(leftVector, rightVector);
    }
}
