package com.shijingsh.ai.data.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import com.shijingsh.ai.data.DataModule;
import com.shijingsh.ai.data.attribute.QualityAttribute;
import com.shijingsh.ai.data.attribute.QuantityAttribute;
import com.shijingsh.ai.data.exception.DataException;
import com.shijingsh.ai.data.DataModule;
import com.shijingsh.ai.data.attribute.QualityAttribute;
import com.shijingsh.ai.data.attribute.QuantityAttribute;

/**
 * 流式转换器
 *
 * @author Birdy
 *
 */
public abstract class StreamConverter extends AbstractConverter<InputStream> {

    protected StreamConverter(Collection<QualityAttribute> qualityAttributes, Collection<QuantityAttribute> quantityAttributes) {
        super(qualityAttributes, quantityAttributes);
    }

    protected abstract int parseData(DataModule module, BufferedReader buffer) throws IOException;

    @Override
    public int convert(DataModule module, InputStream iterator) {
        try {
            try (InputStreamReader reader = new InputStreamReader(iterator); BufferedReader buffer = new BufferedReader(reader)) {
                return parseData(module, buffer);
            }
        } catch (Exception exception) {
            // TODO 处理日志.
            throw new DataException(exception);
        }
    }

}