package com.shijingsh.rns.model.benchmark;

import com.shijingsh.ai.data.DataInstance;
import com.shijingsh.ai.modem.ModemDefinition;
import com.shijingsh.core.utility.RandomUtility;
import com.shijingsh.rns.model.AbstractModel;

/**
 *
 * Random Guess推荐器
 *
 * <pre>
 * 参考LibRec团队
 * </pre>
 *
 * @author Birdy
 *
 */
@ModemDefinition(value = { "userDimension", "itemDimension", "numberOfItems", "minimumOfScore", "maximumOfScore" })
public class RandomGuessModel extends AbstractModel {

    @Override
    protected void doPractice() {
    }

    @Override
    public synchronized void predict(DataInstance instance) {
        int userIndex = instance.getQualityFeature(userDimension);
        int itemIndex = instance.getQualityFeature(itemDimension);
        RandomUtility.setSeed(userIndex * itemSize + itemIndex);
        instance.setQuantityMark(RandomUtility.randomFloat(minimumScore, maximumScore));
    }

}
