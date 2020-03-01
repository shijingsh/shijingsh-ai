package com.shijingsh.ai.model.neuralnetwork;

public interface EpochMonitor {

    void beforeForward();

    void afterForward();

    void beforeBackward();

    void afterBackward();

}
