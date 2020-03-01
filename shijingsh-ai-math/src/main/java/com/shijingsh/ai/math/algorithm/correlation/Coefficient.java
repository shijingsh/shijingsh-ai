package com.shijingsh.ai.math.algorithm.correlation;

import com.shijingsh.ai.math.structure.vector.VectorScalar;

/**
 * 系数
 *
 * @author Birdy
 *
 */
public interface Coefficient {

    /**
     * 计算系数
     *
     * @param leftScalar
     * @param rightScalar
     */
    void calculateScore(VectorScalar leftScalar, VectorScalar rightScalar);

    /**
     * 获取系数
     *
     * @return
     */
    float getScore();

}
