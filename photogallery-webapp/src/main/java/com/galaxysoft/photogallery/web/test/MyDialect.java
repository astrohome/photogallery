package com.galaxysoft.photogallery.web.test;

import com.galaxysoft.photogallery.web.test.preprocessors.HtmlProcessor;
import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by astrohome on 12/7/15.
 */
public class MyDialect implements IProcessorDialect {
    @Override
    public String getPrefix() {
        return "cosmos";
    }

    @Override
    public int getDialectProcessorPrecedence() {
        return 0;
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        IProcessorDialect dialect = this;
        return new HashSet<IProcessor>() {{
            add(new HtmlProcessor(dialect, getPrefix()));
        }};
    }

    @Override
    public String getName() {
        return "Cosmos - Tiling engine for ThymeLeaf";
    }
}
