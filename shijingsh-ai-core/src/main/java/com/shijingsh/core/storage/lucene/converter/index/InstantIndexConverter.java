package com.shijingsh.core.storage.lucene.converter.index;

import com.shijingsh.core.common.reflection.TypeUtility;
import com.shijingsh.core.resource.exception.StorageException;
import com.shijingsh.core.storage.lucene.annotation.LuceneIndex;
import com.shijingsh.core.storage.lucene.converter.IndexConverter;
import com.shijingsh.core.storage.lucene.converter.LuceneContext;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.index.IndexableField;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.*;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

/**
 * 时间索引转换器
 *
 * @author Birdy
 *
 */
public class InstantIndexConverter implements IndexConverter {

    @Override
    public Iterable<IndexableField> convert(LuceneContext context, String path, Field field, LuceneIndex annotation, Type type, Object data) {
        Collection<IndexableField> indexables = new LinkedList<>();
        Class<?> clazz = TypeUtility.getRawType(type, null);
        if (Instant.class.isAssignableFrom(clazz)) {
            Instant instant = (Instant) data;
            indexables.add(new LongPoint(path, instant.toEpochMilli()));
            return indexables;
        }
        if (Date.class.isAssignableFrom(clazz)) {
            Date instant = (Date) data;
            indexables.add(new LongPoint(path, instant.getTime()));
            return indexables;
        }
        if (LocalDate.class.isAssignableFrom(clazz)) {

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
