package com.shijingsh.ai.model.neuralnetwork.activation;

import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.math.structure.vector.MathVector;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.math.structure.vector.MathVector;

/**
 * 激活函数
 *
 * @author Birdy
 *
 */
public interface ActivationFunction {

    /**
     * 向前传播
     *
     * @param input  输入 => {batchSize, inputSize}
     * @param output 输出 => {batchSize, inputSize}
     */
    void forward(MathMatrix input, MathMatrix output);

    void forward(MathVector input, MathVector output);

    /**
     * 向后传播
     *
     * @param input  输入 => {batchSize, inputSize}
     * @param error  导数(dL/da) => {batchSize, inputSize}
     * @param output 梯度(dL/dz) => {batchSize, inputSize}
     */
    void backward(MathMatrix input, MathMatrix error, MathMatrix output);

    void backward(MathVector input, MathVector error, MathVector output);

}
