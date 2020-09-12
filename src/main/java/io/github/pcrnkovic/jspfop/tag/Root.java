/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.MediaUsage;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import javax.servlet.jsp.JspException;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class Root extends AbstractFopTag implements Rendered, CommonAccessibilityProperties, Id, IndexClass, IndexKey, MediaUsage {

    public Root() {
        super("root", false);
    }

    @Override
    public int doStartTag() throws JspException {
        if (!isRendered())
            return SKIP_BODY;
        print("<root xmlns=\"http://www.w3.org/1999/XSL/Format\"");
        printAttributes();
        print(">");
        return EVAL_BODY_INCLUDE;
    }
    
}
