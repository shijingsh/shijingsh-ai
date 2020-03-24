package com.shijingsh.core.storage.lucene.converter.id;

import com.shijingsh.core.common.conversion.json.JsonUtility;
import com.shijingsh.core.storage.lucene.converter.IdConverter;

import java.lang.reflect.Type;

/**
 * JSON标识转换器
 *
 * @author Birdy
 *
 */
public class JsonIdConverter implements IdConverter {

    @Override
    public String convert(Type type, Object id) {
        return JsonUtility.object2String(id);
    }

}
