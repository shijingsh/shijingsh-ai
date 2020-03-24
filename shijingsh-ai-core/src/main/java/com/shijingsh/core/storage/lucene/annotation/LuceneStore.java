package com.shijingsh.core.storage.lucene.annotation;

import com.shijingsh.core.storage.lucene.converter.StoreConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Lucene存储
 *
 * @author Birdy
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface LuceneStore {

    /** 存储转换器 */
    Class<? extends StoreConverter> clazz() default StoreConverter.class;

}
