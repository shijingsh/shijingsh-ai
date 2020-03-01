package com.shijingsh.ai.model.neuralnetwork.schedule;

public interface Schedule {

    float valueAt(int iteration, int epoch);

}
