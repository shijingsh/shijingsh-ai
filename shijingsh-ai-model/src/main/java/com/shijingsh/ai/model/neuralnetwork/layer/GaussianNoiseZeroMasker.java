package com.shijingsh.ai.model.neuralnetwork.layer;

import com.shijingsh.ai.math.algorithm.probability.QuantityProbability;
import com.shijingsh.ai.math.structure.MathCalculator;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.model.neuralnetwork.schedule.Schedule;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.random.Well19937c;

import com.shijingsh.ai.math.algorithm.probability.QuantityProbability;
import com.shijingsh.ai.math.structure.MathCalculator;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.model.neuralnetwork.schedule.Schedule;

/**
 * GaussianNoiseZero掩码器
 *
 * <pre>
 * 参考Deeplearning4j团队
 * </pre>
 *
 * @author Birdy
 *
 */
public class GaussianNoiseZeroMasker implements Masker {

    private Schedule schedule;

    public GaussianNoiseZeroMasker(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public void mask(MathMatrix matrix, int iteration, int epoch) {
        float current = schedule.valueAt(iteration, epoch);

        QuantityProbability probability = new QuantityProbability(Well19937c.class, 0, NormalDistribution.class, 0F, current);
        matrix.iterateElement(MathCalculator.PARALLEL, (scalar) -> {
            float value = scalar.getValue();
            scalar.setValue(value + probability.sample().floatValue());
        });
    }

}
