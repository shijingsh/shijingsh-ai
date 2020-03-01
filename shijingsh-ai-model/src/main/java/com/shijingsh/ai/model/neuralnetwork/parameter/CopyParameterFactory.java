package com.shijingsh.ai.model.neuralnetwork.parameter;

import com.shijingsh.ai.math.structure.MathCalculator;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.shijingsh.ai.math.structure.MathCalculator;
import com.shijingsh.ai.math.structure.matrix.MathMatrix;
import com.shijingsh.ai.modem.ModemDefinition;

@ModemDefinition(value = { "copy" })
public class CopyParameterFactory implements ParameterFactory {

    private MathMatrix copy;

    CopyParameterFactory() {
    }

    public CopyParameterFactory(MathMatrix copy) {
        this.copy = copy;
    }

    @Override
    public void setValues(MathMatrix matrix) {
        matrix.iterateElement(MathCalculator.SERIAL, (scalar) -> {
            scalar.setValue(copy.getValue(scalar.getRow(), scalar.getColumn()));
        });
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
            CopyParameterFactory that = (CopyParameterFactory) object;
            EqualsBuilder equal = new EqualsBuilder();
            equal.append(this.copy, that.copy);
            return equal.isEquals();
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hash = new HashCodeBuilder();
        hash.append(copy);
        return hash.toHashCode();
    }

    @Override
    public String toString() {
        return "CopyParameterFactory(copy=" + copy + ")";
    }

}
