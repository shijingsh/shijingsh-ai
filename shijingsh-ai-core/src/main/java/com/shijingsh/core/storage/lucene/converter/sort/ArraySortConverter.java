package com.shijingsh.core.storage.lucene.converter.sort;


import com.shijingsh.core.common.reflection.TypeUtility;
import com.shijingsh.core.resource.exception.StorageException;
import com.shijingsh.core.storage.lucene.annotation.LuceneSort;
import com.shijingsh.core.storage.lucene.converter.LuceneContext;
import com.shijingsh.core.storage.lucene.converter.SortConverter;
import org.apache.lucene.index.IndexableField;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 数组排序转换器
 *
 * @author Birdy
 *
 */
public class ArraySortConverter implements SortConverter {

    @Override
    public Iterable<IndexableField> convert(LuceneContext context, String path, Field field, LuceneSort annotation, Type type, Object data) {
        Collection<IndexableField> indexables = new LinkedList<>();
        Class<?> componentClass = null;
        Type componentType = null;
        if (type instanceof GenericArrayType) {
            GenericArrayType genericArrayType = GenericArrayType.class.cast(type);
            componentType = genericArrayType.getGenericComponentType();
            componentClass = TypeUtility.getRawType(componentType, null);
        } else {
            Class<?> clazz = TypeUtility.getRawType(type, null);
            componentType = clazz.getComponentType();
            componentClass = clazz.getComponentType();
        }
        throw new StorageException();
    }

}
