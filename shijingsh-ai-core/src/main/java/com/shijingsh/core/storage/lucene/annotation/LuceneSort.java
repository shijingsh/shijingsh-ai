package com.shijingsh.core.storage.lucene.annotation;

import com.shijingsh.core.storage.lucene.converter.SortConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Lucene排序
 *
 * @author Birdy
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface LuceneSort {

    /** 排序转换器 */
    Class<? extends SortConverter> clazz() default SortConverter.class;

}
