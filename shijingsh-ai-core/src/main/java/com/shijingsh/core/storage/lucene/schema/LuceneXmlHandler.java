package com.shijingsh.core.storage.lucene.schema;

import com.shijingsh.core.storage.lucene.schema.LuceneXmlParser.ElementDefinition;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * LuceneXML处理器
 *
 * @author Birdy
 */
public class LuceneXmlHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser(ElementDefinition.CONFIGURATION.getName(), new LuceneXmlParser());
    }

}
