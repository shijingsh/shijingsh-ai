package com.shijingsh.ai.math.structure;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.math.structure.matrix.Nd4jMatrix;
import com.shijingsh.ai.math.structure.vector.MathVector;
import com.shijingsh.ai.math.structure.vector.Nd4jVector;

public class Nd4jCache implements MathCache {

    @Override
    public MathMatrix makeMatrix(int rowSize, int columnSize) {
        INDArray array = Nd4j.zeros(rowSize, columnSize);
        Nd4jMatrix matrix = new Nd4jMatrix(array);
        return matrix;
    }

    @Override
    public MathVector makeVector(int capacitySize) {
        INDArray array = Nd4j.zeros(capacitySize);
        Nd4jVector vector = new Nd4jVector(array);
        return vector;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Nd4jMatrixFactory()";
    }

}
