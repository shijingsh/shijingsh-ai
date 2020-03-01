package com.shijingsh.ai.model.neuralnetwork.parameter;

import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;

/**
 * 参数工厂
 *
 * @author Birdy
 *
 */
public interface ParameterFactory {

    /**
     * 设置参数值
     *
     * @param matrix
     */
    void setValues(MathMatrix matrix);

}
