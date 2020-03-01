package com.shijingsh.ai.model.neuralnetwork.layer;

import com.shijingsh.ai.math.structure.MathCalculator;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.model.neuralnetwork.schedule.Schedule;
import com.shijingsh.core.utility.RandomUtility;
import com.shijingsh.ai.math.structure.MathCalculator;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.model.neuralnetwork.schedule.Schedule;

/**
 * 默认掩码器
 *
 * <pre>
 * 参考Deeplearning4j团队
 * </pre>
 *
 * @author Birdy
 *
 */
public class DefaultMasker implements Masker {

    private Schedule schedule;

    public DefaultMasker(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public void mask(MathMatrix matrix, int iteration, int epoch) {
        float current = schedule.valueAt(iteration, epoch);

        matrix.iterateElement(MathCalculator.PARALLEL, (scalar) -> {
            float value = scalar.getValue();
            scalar.setValue(RandomUtility.randomFloat(1F) < current ? 0F : value);
        });
    }

}
