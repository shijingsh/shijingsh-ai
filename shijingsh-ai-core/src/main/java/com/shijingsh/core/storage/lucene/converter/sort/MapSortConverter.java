package com.shijingsh.core.storage.lucene.converter.sort;

import com.shijingsh.core.storage.exception.StorageException;
import com.shijingsh.core.storage.lucene.annotation.LuceneSort;
import com.shijingsh.core.storage.lucene.converter.LuceneContext;
import com.shijingsh.core.storage.lucene.converter.SortConverter;
import org.apache.lucene.index.IndexableField;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 映射排序转换器
 *
 * @author Birdy
 *
 */
public class MapSortConverter implements SortConverter {

    @Override
    public Iterable<IndexableField> convert(LuceneContext context, String path, Field field, LuceneSort annotation, Type type, Object data) {
        Collection<IndexableField> indexables = new LinkedList<>();
        ParameterizedType parameterizedType = ParameterizedType.class.cast(type);
        Type[] types = parameterizedType.getActualTypeArguments();
        throw new StorageException();
    }

}
