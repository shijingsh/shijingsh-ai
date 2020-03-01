/*
 * Copyright (C) 2018 Edward Raff
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.shijingsh.ai.jsat.distributions.multivariate;

import java.util.List;

import com.shijingsh.ai.jsat.linear.DenseMatrix;
import com.shijingsh.ai.jsat.linear.DenseVector;
import com.shijingsh.ai.jsat.linear.Matrix;
import com.shijingsh.ai.jsat.linear.MatrixStatistics;
import com.shijingsh.ai.jsat.linear.Vec;
import com.shijingsh.ai.jsat.DataSet;

/**
 * This class implements the Multivariate Normal Distribution, but augments it
 * so that {@link #setUsingData(DataSet, boolean)
 * fitting} the distribution uses a robust estimate of the distribution
 * parameters. This comes at increased cost that is cubic with respect to the
 * number of variables.
 *
 * @author Edward Raff
 */
public class NormalMR extends NormalM {

    @Override
    public <V extends Vec> boolean setUsingData(List<V> dataSet, boolean parallel) {
        try {
            Vec mean = new DenseVector(dataSet.get(0).length());
            Matrix cov = new DenseMatrix(mean.length(), mean.length());
            MatrixStatistics.FastMCD(mean, cov, dataSet, parallel);

            setMeanCovariance(mean, cov);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
