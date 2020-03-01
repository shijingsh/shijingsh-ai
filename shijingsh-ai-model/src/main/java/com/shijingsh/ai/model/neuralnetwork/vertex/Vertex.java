package com.shijingsh.ai.model.neuralnetwork.vertex;

import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.model.neuralnetwork.Model;
import com.jstarcraft.core.utility.KeyValue;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.model.neuralnetwork.Model;

/**
 * 节点
 *
 * @author Birdy
 *
 */
public interface Vertex extends Model {

    /**
     * 根据指定的样本分配缓存(每次epoch调用)
     *
     * @param samples
     */
    void doCache(KeyValue<MathMatrix, MathMatrix>... samples);

    /**
     * 获取名称
     *
     * @return
     */
    String getVertexName();

    /**
     * 获取输入数据与梯度
     *
     * @param position
     * @return
     */
    KeyValue<MathMatrix, MathMatrix> getInputKeyValue(int position);

    /**
     * 获取输出数据与梯度
     *
     * @return
     */
    KeyValue<MathMatrix, MathMatrix> getOutputKeyValue();

}
