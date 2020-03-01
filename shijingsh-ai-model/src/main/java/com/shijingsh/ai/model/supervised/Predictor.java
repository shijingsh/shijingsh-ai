package com.shijingsh.ai.model.supervised;

import com.shijingsh.ai.data.DataInstance;

/**
 * 预测器
 *
 * @author Birdy
 *
 */
public interface Predictor {

    /**
     * 预测
     *
     * @param instance
     * @param contexts
     */
    void predict(DataInstance instance, DataInstance... contexts);

}
