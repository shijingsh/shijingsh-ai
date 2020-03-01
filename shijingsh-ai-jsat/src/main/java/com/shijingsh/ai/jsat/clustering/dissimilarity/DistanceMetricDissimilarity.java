
package com.shijingsh.ai.jsat.clustering.dissimilarity;

import com.shijingsh.ai.jsat.classifiers.DataPoint;
import com.shijingsh.ai.jsat.linear.distancemetrics.DistanceMetric;
import com.shijingsh.ai.jsat.classifiers.DataPoint;

/**
 * A base class for Dissimilarity measures that are build ontop the use of some
 * {@link DistanceMetric distance metric}.
 *
 * @author Edward Raff
 */
public abstract class DistanceMetricDissimilarity extends AbstractClusterDissimilarity {
    /**
     * The distance metric that will back this dissimilarity measure.
     */
    protected final DistanceMetric dm;

    public DistanceMetricDissimilarity(DistanceMetric dm) {
        this.dm = dm;
    }

    @Override
    public double distance(DataPoint a, DataPoint b) {
        return dm.dist(a.getNumericalValues(), b.getNumericalValues());
    }

    @Override
    abstract public DistanceMetricDissimilarity clone();
}
