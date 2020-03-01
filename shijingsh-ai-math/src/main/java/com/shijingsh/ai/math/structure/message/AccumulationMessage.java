package com.shijingsh.ai.math.structure.message;

import com.shijingsh.ai.math.structure.MathMessage;

public interface AccumulationMessage<T> extends MathMessage<T> {

    void accumulateValue(float value);

    T getValue();

}
