/**
 * %SVN.HEADER%
 */
package com.shijingsh.ai.math.algorithm.correlation.similarity;

import java.util.List;

import com.shijingsh.ai.math.algorithm.correlation.AbstractCorrelation;
import com.shijingsh.ai.math.algorithm.correlation.MathDistance;
import com.shijingsh.ai.math.algorithm.correlation.MathSimilarity;
import com.shijingsh.ai.math.structure.vector.MathVector;
import com.jstarcraft.core.utility.Float2FloatKeyValue;
import com.shijingsh.ai.math.algorithm.correlation.AbstractCorrelation;
import com.shijingsh.ai.math.algorithm.correlation.MathSimilarity;
import com.shijingsh.ai.math.structure.vector.MathVector;

/**
 * 斯皮尔曼等级相关性
 * http://en.wikipedia.org/wiki/Spearman's_rank_correlation_coefficient
 *
 * @author Birdy
 *
 */
public class SpearmanRankCorrelation extends AbstractCorrelation implements MathSimilarity {

    private float getCoefficient(List<Float2FloatKeyValue> scores) {
        float coefficient = 0F;
        for (Float2FloatKeyValue term : scores) {
            float distance = term.getKey() - term.getValue();
            coefficient += distance * distance;
        }
        return coefficient;
    }

    @Override
    public float getCoefficient(MathVector leftVector, MathVector rightVector) {
        List<Float2FloatKeyValue> scores = getIntersectionScores(leftVector, rightVector);
        float numerator = getCoefficient(scores);
        int size = leftVector.getDimensionSize();
        float denominator = size * (size * size - 1);
        return 1F - 6F * numerator / denominator;
    }

}
