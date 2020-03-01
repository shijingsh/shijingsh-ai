package com.shijingsh.rns.model.content.rating;

import com.shijingsh.ai.data.DataInstance;
import com.shijingsh.rns.model.content.EFMModel;
import com.shijingsh.rns.model.content.EFMModel;

/**
 *
 * User KNN推荐器
 *
 * <pre>
 * Explicit factor models for explainable recommendation based on phrase-level sentiment analysis
 * 参考LibRec团队
 * </pre>
 *
 * @author Birdy
 *
 */
public class EFMRatingModel extends EFMModel {

    @Override
    public void predict(DataInstance instance) {
        int userIndex = instance.getQualityFeature(userDimension);
        int itemIndex = instance.getQualityFeature(itemDimension);
        float value = predict(userIndex, itemIndex);
        instance.setQuantityMark(value);
    }

}
