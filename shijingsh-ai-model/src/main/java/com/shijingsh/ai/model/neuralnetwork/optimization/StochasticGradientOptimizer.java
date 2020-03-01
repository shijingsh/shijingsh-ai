package com.shijingsh.ai.model.neuralnetwork.optimization;

import java.util.Map;
import java.util.concurrent.Callable;

import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.model.neuralnetwork.condition.Condition;
import com.shijingsh.ai.model.neuralnetwork.step.NegativeGradientStepFunction;
import com.shijingsh.ai.model.neuralnetwork.step.StepFunction;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;

/**
 * Stochastic Gradient Descent优化器
 *
 * <pre>
 * 参考Deeplearning4j团队
 * </pre>
 *
 * @author Birdy
 *
 */
public class StochasticGradientOptimizer extends AbstractOptimizer {

    protected Map<String, MathMatrix> gradients, parameters;

    protected StochasticGradientOptimizer() {
    }

    public StochasticGradientOptimizer(Condition... conditions) {
        this(new NegativeGradientStepFunction(), conditions);
    }

    public StochasticGradientOptimizer(StepFunction stepFunction, Condition... terminationConditions) {
        super(stepFunction, terminationConditions);
    }

    @Override
    public void doCache(Callable<Float> scorer, Map<String, MathMatrix> gradients, Map<String, MathMatrix> parameters) {
        this.gradients = gradients;
        this.parameters = parameters;
    }

    @Override
    public boolean optimize(float score) {
        oldScore = newScore;
        newScore = score;

        // 使用梯度更新参数
        stepFunction.step(1F, gradients, parameters);

        for (Condition condition : conditions) {
            if (condition.stop(newScore, oldScore, gradients)) {
                return true;
            }
        }
        return false;
    }

}
