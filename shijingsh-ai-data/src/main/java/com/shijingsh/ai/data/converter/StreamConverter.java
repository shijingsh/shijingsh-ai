package com.shijingsh.ai.data.converter;

import com.shijingsh.ai.data.*;
import com.shijingsh.ai.data.attribute.QualityAttribute;
import com.shijingsh.ai.data.attribute.QuantityAttribute;
import com.shijingsh.ai.data.exception.DataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * 流式转换器
 *
 * @author Birdy
 *
 */
public abstract class StreamConverter extends AbstractConverter<InputStream> {

    public StreamConverter(Collection<QualityAttribute> qualityAttributes, Collection<QuantityAttribute> quantityAttributes) {
        super(qualityAttributes, quantityAttributes);
    }

    public abstract int parseData(DataModule module, BufferedReader buffer) throws IOException;

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
