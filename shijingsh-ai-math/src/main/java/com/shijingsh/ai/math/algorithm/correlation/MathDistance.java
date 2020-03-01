package com.shijingsh.ai.math.algorithm.correlation;

/**
 * 抽象距离
 *
 * @author Birdy
 *
 */
public interface MathDistance extends MathCorrelation {

    @Override
    default float getIdentical() {
        return 0F;
    }

}
