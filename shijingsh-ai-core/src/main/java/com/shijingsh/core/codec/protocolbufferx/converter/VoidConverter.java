package com.shijingsh.core.codec.protocolbufferx.converter;

import java.io.IOException;
import java.lang.reflect.Type;

import com.shijingsh.core.codec.protocolbufferx.ProtocolReader;
import com.shijingsh.core.codec.protocolbufferx.ProtocolWriter;
import com.shijingsh.core.codec.specification.ClassDefinition;

/**
 * Void转换器
 *
 * @author Birdy
 *
 */
public class VoidConverter extends ProtocolConverter<Object> {

    @Override
    public Object readValueFrom(ProtocolReader context, Type type, ClassDefinition definition) throws IOException {
        return null;
    }

    @Override
    public void writeValueTo(ProtocolWriter context, Type type, ClassDefinition definition, Object value) throws IOException {
    }

}
