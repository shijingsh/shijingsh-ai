package com.shijingsh.ai.data.converter;

import com.shijingsh.ai.data.*;
import com.shijingsh.ai.data.attribute.QualityAttribute;
import com.shijingsh.ai.data.attribute.QuantityAttribute;
import com.shijingsh.ai.data.exception.DataException;
import com.shijingsh.core.common.conversion.csv.ConversionUtility;
import com.shijingsh.core.utility.KeyValue;
import it.unimi.dsi.fastutil.ints.Int2FloatRBTreeMap;
import it.unimi.dsi.fastutil.ints.Int2FloatSortedMap;
import it.unimi.dsi.fastutil.ints.Int2IntRBTreeMap;
import it.unimi.dsi.fastutil.ints.Int2IntSortedMap;
import org.apache.avro.generic.GenericRecord;
import org.apache.parquet.hadoop.ParquetReader;

import java.io.IOException;
import java.util.Collection;
import java.util.Map.Entry;

/**
 * 列式转换器
 *
 * @author Birdy
 *
 */
public class ParquetConverter extends AbstractConverter<ParquetReader> {

    public ParquetConverter(Collection<QualityAttribute> qualityAttributes, Collection<QuantityAttribute> quantityAttributes) {
        super(qualityAttributes, quantityAttributes);
    }

    protected int parseData(DataModule module, ParquetReader iterator) throws IOException {
        int count = 0;
        Int2IntSortedMap qualityFeatures = new Int2IntRBTreeMap();
        Int2FloatSortedMap quantityFeatures = new Int2FloatRBTreeMap();
        int size = module.getQualityOrder() + module.getQuantityOrder();
        try {
            while (true) {
                GenericRecord datas = (GenericRecord) iterator.read();
                if (datas == null) {
                    break;
                }
                for (int index = 0; index < size; index++) {
                    Object data = datas.get(index);
                    // TODO 考虑区分稠密模块与稀疏模块的处理方式
                    if (data == null) {
                        continue;
                    }
                    Entry<Integer, KeyValue<String, Boolean>> term = module.getOuterKeyValue(index);
                    KeyValue<String, Boolean> keyValue = term.getValue();
                    if (keyValue.getValue()) {
                        QualityAttribute attribute = qualityAttributes.get(keyValue.getKey());
                        data = ConversionUtility.convert(data, attribute.getType());
                        int feature = attribute.convertData((Comparable) data);
                        qualityFeatures.put(module.getQualityInner(keyValue.getKey()) + index - term.getKey(), feature);
                    } else {
                        QuantityAttribute attribute = quantityAttributes.get(keyValue.getKey());
                        data = ConversionUtility.convert(data, attribute.getType());
                        float feature = attribute.convertData((Number) data);
                        quantityFeatures.put(module.getQuantityInner(keyValue.getKey()) + index - term.getKey(), feature);
                    }
                }
                module.associateInstance(qualityFeatures, quantityFeatures);
                qualityFeatures.clear();
                quantityFeatures.clear();
                count++;
            }
            return count;
        } catch (Exception exception) {
            // TODO 处理日志.
            throw new RuntimeException(exception);
        }
    }

    @Override
    public int convert(DataModule module, ParquetReader iterator) {
        try {
            return parseData(module, iterator);
        } catch (Exception exception) {
            // TODO 处理日志.
            throw new DataException(exception);
        }
    }

}
