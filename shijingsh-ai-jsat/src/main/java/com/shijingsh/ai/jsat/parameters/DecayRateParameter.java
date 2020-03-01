package com.shijingsh.ai.jsat.parameters;

import java.util.Arrays;
import java.util.List;

import com.shijingsh.ai.jsat.math.decayrates.DecayRate;
import com.shijingsh.ai.jsat.math.decayrates.ExponetialDecay;
import com.shijingsh.ai.jsat.math.decayrates.InverseDecay;
import com.shijingsh.ai.jsat.math.decayrates.LinearDecay;
import com.shijingsh.ai.jsat.math.decayrates.NoDecay;
import com.shijingsh.ai.jsat.math.decayrates.*;

/**
 * A parameter for changing between the default {@link DecayRate decay rates}.
 *
 * @author Edward Raff
 */
public abstract class DecayRateParameter extends ObjectParameter<DecayRate> {

    private static final long serialVersionUID = -3751128637789053385L;

    @Override
    public List<DecayRate> parameterOptions() {
        return Arrays.asList(new NoDecay(), new LinearDecay(), new ExponetialDecay(), new InverseDecay());
    }

    @Override
    public String getASCIIName() {
        return "Decay Rate";
    }
}
