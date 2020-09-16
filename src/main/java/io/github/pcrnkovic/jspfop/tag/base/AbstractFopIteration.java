package io.github.pcrnkovic.jspfop.tag.base;

import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author Pavle Crnković
 */
public abstract class AbstractFopIteration extends AbstractFopTag implements IterationTag {

    private Iterator iterator;

    private String itemVar, itemCountVar;

    public AbstractFopIteration(String name) {
        super(name, false);
    }
    
    private boolean isInIterableMode() {
        return iterator != null && itemVar != null;
    }

    @Override
    public int doStartTag() throws JspException {
        int returnVal = super.doStartTag();
        if (isInIterableMode() && iterator.hasNext())
            setPageContextAttribute(itemVar, iterator.next());
        return returnVal;
    }

    @Override
    public int doAfterBody() throws JspException {
        if (!isInIterableMode() || !iterator.hasNext())
            return SKIP_BODY;
        setPageContextAttribute(itemVar, iterator.next());
        return EVAL_BODY_AGAIN;
    }

    public void setIterable(Iterable iterable) {
        this.iterator = iterable.iterator();
    }

    public void setItemVar(String itemVar) {
        this.itemVar = itemVar;
        
    }

    public void setItemCountVar(String itemCountVar) {
        this.itemCountVar = itemCountVar;
        if (this.itemCountVar != null) {
            setPageContextAttribute(this.itemCountVar, 0);
        }
    }

    public void incrementCounter() {
        if (itemCountVar != null) {
            setPageContextAttribute(itemCountVar, ((Integer) getPageContextAttributeValue(itemCountVar)) + 1);
        }
    }

    @Override
    public void setParent(Tag parent) {
        super.setParent(parent);
        iterator = null;
        itemVar = null;
        itemCountVar = null;
    }
    
    

}
