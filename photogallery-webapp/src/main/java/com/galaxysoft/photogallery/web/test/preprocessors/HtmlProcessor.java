package com.galaxysoft.photogallery.web.test.preprocessors;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IModel;
import org.thymeleaf.processor.element.*;
import org.thymeleaf.standard.expression.FragmentSelectionUtils;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Created by astrohome on 12/7/15.
 */
public class HtmlProcessor extends AbstractAttributeModelProcessor {

    public static final int PRECEDENCE = 100000;

    // Only HTML tag could declare the layout to use
    public static final String ELEMENT_NAME = "html";
    public static final String ATTRIBUTE_NAME = "layout";

    public HtmlProcessor(IProcessorDialect dialect, String dialectPrefix) {
        super(dialect, TemplateMode.HTML, dialectPrefix, ELEMENT_NAME, false, ATTRIBUTE_NAME, true, PRECEDENCE, true);
    }

    @Override
    protected void doProcess(ITemplateContext context, IModel model, AttributeName attributeName, String attributeValue, String attributeTemplateName, int attributeLine, int attributeCol, IElementModelStructureHandler structureHandler) {
        FragmentSelectionUtils.(context, attributeTemplateName,attributeCol);
        System.out.println("test test test");
    }
}
