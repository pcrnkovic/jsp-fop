/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.jsp.fop.tag;

import javax.servlet.jsp.JspException;
import pc.jsp.fop.tag.base.NonEmptyTag;

/**
 *
 * @author Pavle
 */
public class Root extends NonEmptyTag {

    @Override
    public String getName() {
        return "root";
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
