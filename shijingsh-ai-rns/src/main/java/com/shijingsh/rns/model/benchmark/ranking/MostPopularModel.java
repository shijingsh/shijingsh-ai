package com.shijingsh.rns.model.benchmark.ranking;

import com.shijingsh.ai.data.DataInstance;
import com.shijingsh.ai.data.DataModule;
import com.shijingsh.ai.data.DataSpace;
import com.shijingsh.ai.modem.ModemDefinition;
import com.shijingsh.core.utility.Configurator;
import com.shijingsh.rns.model.AbstractModel;

/**
 *
 * Most Popular推荐器
 *
 * <pre>
 * 参考LibRec团队
 * </pre>
 *
 * @author Birdy
 *
 */
@ModemDefinition(value = { "itemDimension", "populars" })
public class MostPopularModel extends AbstractModel {

    private int[] populars;

    @Override
    public void prepare(Configurator configuration, DataModule model, DataSpace space) {
        super.prepare(configuration, model, space);
        populars = new int[itemSize];
    }

    @Override
    protected void doPractice() {
        for (int itemIndex = 0; itemIndex < itemSize; itemIndex++) {
            populars[itemIndex] = scoreMatrix.getColumnScope(itemIndex);
        }
    }

    @Override
    public void predict(DataInstance instance) {
        int itemIndex = instance.getQualityFeature(itemDimension);
        instance.setQuantityMark(populars[itemIndex]);
    }

}
