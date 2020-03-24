package com.shijingsh.core.storage.lucene.schema;

import com.shijingsh.core.storage.lucene.LuceneAccessor;
import com.shijingsh.core.storage.lucene.LuceneEngine;
import com.shijingsh.core.storage.lucene.converter.IdConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.util.Collection;

/**
 * Lucene访问器工厂
 *
 * @author Birdy
 *
 */
public class LuceneAccessorFactory implements FactoryBean<LuceneAccessor> {

    private static final Logger logger = LoggerFactory.getLogger(LuceneAccessorFactory.class);

    public static final String CLASSES = "classes";

    private LuceneAccessor accessor;

    private Collection<Class<?>> classes;

    private IdConverter converter;

    private LuceneEngine engine;

    @Override
    public LuceneAccessor getObject() {
        if (accessor == null) {
            accessor = new LuceneAccessor(classes, converter, engine);
        }
        return accessor;
    }

    @Override
    public Class<?> getObjectType() {
        return LuceneAccessor.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setClasses(Collection<Class<?>> classes) {
        this.classes = classes;
    }

    public void setConverter(IdConverter converter) {
        this.converter = converter;
    }

    public void setEngine(LuceneEngine engine) {
        this.engine = engine;
    }

}
