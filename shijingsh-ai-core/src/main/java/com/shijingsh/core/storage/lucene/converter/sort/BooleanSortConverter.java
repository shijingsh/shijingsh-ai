package com.shijingsh.core.storage.lucene.converter.sort;

import com.shijingsh.core.common.reflection.TypeUtility;
import com.shijingsh.core.storage.exception.StorageException;
import com.shijingsh.core.storage.lucene.annotation.LuceneSort;
import com.shijingsh.core.storage.lucene.converter.LuceneContext;
import com.shijingsh.core.storage.lucene.converter.SortConverter;
import com.shijingsh.core.utility.ClassUtility;
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.index.IndexableField;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 布尔排序转换器
 *
 * @author Birdy
 *
 */
public class BooleanSortConverter implements SortConverter {

    @Override
    public Iterable<IndexableField> convert(LuceneContext context, String path, Field field, LuceneSort annotation, Type type, Object data) {
        Collection<IndexableField> indexables = new LinkedList<>();
        Class<?> clazz = TypeUtility.getRawType(type, null);
        clazz = ClassUtility.primitiveToWrapper(clazz);
        if (AtomicBoolean.class.isAssignableFrom(clazz)) {
            indexables.add(new NumericDocValuesField(path, AtomicBoolean.class.cast(data).get() ? 1L : 0L));
            return indexables;
        }
        if (Boolean.class.isAssignableFrom(clazz)) {
            indexables.add(new NumericDocValuesField(path, Boolean.class.cast(data) ? 1L : 0L));
            return indexables;
        }
        throw new StorageException();
    }

}
