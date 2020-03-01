package com.shijingsh.ai.model.supervised;

import com.shijingsh.ai.data.DataModule;

/**
 * 训练器
 *
 * @author Birdy
 *
 */
public interface Practicer {

    /**
     * 训练
     *
     * @param module
     * @param contexts
     */
    void practice(DataModule module, DataModule... contexts);

}
