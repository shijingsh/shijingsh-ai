package com.shijingsh.core.storage.lucene.converter.sort;

import com.shijingsh.core.common.reflection.TypeUtility;
import com.shijingsh.core.storage.exception.StorageException;
import com.shijingsh.core.storage.lucene.annotation.LuceneSort;
import com.shijingsh.core.storage.lucene.converter.LuceneContext;
import com.shijingsh.core.storage.lucene.converter.SortConverter;
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.index.IndexableField;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

/**
 * 时间排序转换器
 *
 * @author Birdy
 *
 */
public class InstantSortConverter implements SortConverter {

    @Override
    public Iterable<IndexableField> convert(LuceneContext context, String path, Field field, LuceneSort annotation, Type type, Object data) {
        Collection<IndexableField> indexables = new LinkedList<>();
        Class<?> clazz = TypeUtility.getRawType(type, null);
        if (Instant.class.isAssignableFrom(clazz)) {
            Instant instant = (Instant) data;
            indexables.add(new NumericDocValuesField(path, instant.toEpochMilli()));
            return indexables;
        }
        if (Date.class.isAssignableFrom(clazz)) {
            Date instant = (Date) data;
            indexables.add(new NumericDocValuesField(path, instant.getTime()));
            return indexables;
        }
        if (LocalDate.class.isAssignableFrom(clazz)) {
            LocalDate instant = (LocalDate) data;
            indexables.add(new NumericDocValuesField(path, instant.getLong(ChronoField.EPOCH_DAY)));
            return indexables;
        }
        if (LocalTime.class.isAssignableFrom(clazz)) {

        }
        if (LocalDateTime.class.isAssignableFrom(clazz)) {

        }
        if (ZonedDateTime.class.isAssignableFrom(clazz)) {

        }
        if (ZoneOffset.class.isAssignableFrom(clazz)) {

        }
        throw new StorageException();
    }

}
