package com.shijingsh.ai.model.neuralnetwork.parameter;

import com.shijingsh.ai.math.structure.MathCalculator;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import org.apache.commons.math3.util.FastMath;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import com.shijingsh.ai.math.structure.MathCalculator;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;

public class XavierParameterFactory implements ParameterFactory {

    @Override
    public void setValues(MathMatrix matrix) {
        INDArray ndArray = Nd4j.randn(new int[] { matrix.getRowSize(), matrix.getColumnSize() }).muli(FastMath.sqrt(2D / (matrix.getRowSize() + matrix.getColumnSize())));
        matrix.iterateElement(MathCalculator.SERIAL, (scalar) -> {
            scalar.setValue(ndArray.getFloat(scalar.getRow(), scalar.getColumn()));
        });
    }

}
