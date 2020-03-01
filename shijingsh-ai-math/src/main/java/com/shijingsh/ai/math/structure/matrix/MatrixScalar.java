package com.shijingsh.ai.math.structure.matrix;

import com.shijingsh.ai.math.structure.MathScalar;

/**
 * 矩阵标量
 *
 * @author Birdy
 *
 */
public interface MatrixScalar extends MathScalar {

    /**
     * 获取标量所在行的索引
     *
     * @return
     */
    int getRow();

    /**
     * 获取标量所在列的索引
     *
     * @return
     */
    int getColumn();

}
