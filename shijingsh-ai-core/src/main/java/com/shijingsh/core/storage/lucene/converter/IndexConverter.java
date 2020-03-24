package com.shijingsh.core.storage.lucene.converter;

import com.shijingsh.core.storage.StorageCondition;
import com.shijingsh.core.storage.lucene.annotation.LuceneIndex;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.Query;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * 索引转换器
 *
 * @author Birdy
 *
 */
public interface IndexConverter {

    /**
     * 转换索引
     *
     * @param context
     * @param path
     * @param field
     * @param annotation
     * @param name
     * @param type
     * @param data
     * @return
     */
    Iterable<IndexableField> convert(LuceneContext context, String path, Field field, LuceneIndex annotation, Type type, Object data);

    default Query query(LuceneContext context, String path, Field field, LuceneIndex annotation, Type type, StorageCondition condition, Object... data) {
        throw new UnsupportedOperationException();
    }

}
