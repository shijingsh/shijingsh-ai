package com.shijingsh.core.storage.lucene.converter.store;

import com.shijingsh.core.storage.lucene.annotation.LuceneStore;
import com.shijingsh.core.storage.lucene.converter.LuceneContext;
import com.shijingsh.core.storage.lucene.converter.StoreConverter;
import org.apache.lucene.index.IndexableField;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.NavigableMap;

/**
 * 布尔存储转换器
 *
 * @author Birdy
 *
 */
public class BooleanStoreConverter implements StoreConverter {

    @Override
    public Object decode(LuceneContext context, String path, Field field, LuceneStore annotation, Type type, NavigableMap<String, IndexableField> indexables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NavigableMap<String, IndexableField> encode(LuceneContext context, String path, Field field, LuceneStore annotation, Type type, Object instance) {
        // TODO Auto-generated method stub
        return null;
    }

}
