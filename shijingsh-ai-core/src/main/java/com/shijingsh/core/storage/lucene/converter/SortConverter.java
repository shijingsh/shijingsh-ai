package com.shijingsh.core.storage.lucene.converter;

import com.shijingsh.core.storage.lucene.annotation.LuceneSort;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.Sort;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * 排序转换器
 *
 * @author Birdy
 *
 */
public interface SortConverter {

    /**
     * 转换排序
     *
     * @param context
     * @param path
     * @param annotation
     * @param field
     * @param data
     * @return
     */
    Iterable<IndexableField> convert(LuceneContext context, String path, Field field, LuceneSort annotation, Type type, Object data);

    default Sort sort(LuceneContext context, String path, Field field, LuceneSort annotation, Type type, boolean scend) {
        throw new UnsupportedOperationException();
    }

}
