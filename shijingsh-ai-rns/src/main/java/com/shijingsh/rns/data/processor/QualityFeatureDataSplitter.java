package com.shijingsh.rns.data.processor;

import com.shijingsh.ai.data.DataInstance;
import com.shijingsh.ai.data.processor.DataSplitter;

public class QualityFeatureDataSplitter implements DataSplitter {

    private int dimension;

    public QualityFeatureDataSplitter(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public int split(DataInstance instance) {
        return instance.getQualityFeature(dimension);
    }

}
