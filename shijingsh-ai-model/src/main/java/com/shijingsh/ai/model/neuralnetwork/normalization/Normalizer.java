package com.shijingsh.ai.model.neuralnetwork.normalization;

import java.util.Map;

import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;

/**
 * 标准器
 *
 * @author Birdy
 *
 */
public interface Normalizer {

    public enum Mode {

        GLOBAL,

        LOCAL;

    }

    void normalize(Map<String, MathMatrix> gradients);

}
