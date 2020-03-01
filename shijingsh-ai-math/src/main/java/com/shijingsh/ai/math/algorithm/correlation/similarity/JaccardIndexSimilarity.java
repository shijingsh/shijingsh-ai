package com.shijingsh.ai.math.algorithm.correlation.similarity;

import java.util.List;

import com.shijingsh.ai.math.algorithm.correlation.AbstractCorrelation;
import com.shijingsh.ai.math.algorithm.correlation.MathDistance;
import com.shijingsh.ai.math.algorithm.correlation.MathSimilarity;
import com.shijingsh.ai.math.structure.vector.MathVector;
import com.shijingsh.core.utility.Float2FloatKeyValue;
import com.shijingsh.ai.math.algorithm.correlation.AbstractCorrelation;
import com.shijingsh.ai.math.algorithm.correlation.MathSimilarity;
import com.shijingsh.ai.math.structure.vector.MathVector;

/**
 * Jaccard相似度
 *
 * @author Birdy
 *
 */
public class JaccardIndexSimilarity extends AbstractCorrelation implements MathSimilarity {

    private float getCoefficient(List<Float2FloatKeyValue> scores) {
        float intersection = 0F;
        float union = scores.size();
        for (Float2FloatKeyValue term : scores) {
            if (term.getKey() == term.getValue()) {
                intersection++;
            }
        }
        return intersection / union;
    }

    @Override
    public float getCoefficient(MathVector leftVector, MathVector rightVector) {
        List<Float2FloatKeyValue> scores = getUnionScores(leftVector, rightVector);
        float coefficient = getCoefficient(scores);
        return coefficient;
    }

}
