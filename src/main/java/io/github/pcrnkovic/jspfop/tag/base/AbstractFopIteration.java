/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

<attribute>
    <name>iterable</name>
    <rtexprvalue>true</rtexprvalue>
</attribute>
<attribute>
    <name>iterableVar</name>
    <rtexprvalue>true</rtexprvalue>
</attribute>
<attribute>
    <name>itemCountVar</name>
    <rtexprvalue>true</rtexprvalue>
</attribute>


 */
package io.github.pcrnkovic.jspfop.tag.base;

import io.github.pcrnkovic.jspfop.attr.FopIteration;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author Pavle
 */
public abstract class AbstractFopIteration extends AbstractFopTag implements IterationTag, FopIteration {

    private Iterator iterator;

    private String iterableVar, itemCountVar;

    public AbstractFopIteration(String name) {
        super(name, false);
    }
    
    private boolean isInIterableMode() {
        return iterator != null && iterableVar != null;
    }

    @Override
    public int doStartTag() throws JspException {
        int returnVal = super.doStartTag(); //To change body of generated methods, choose Tools | Templates.
        if (isInIterableMode() && iterator.hasNext())
            setPageContextAttribute(iterableVar, iterator.next());
        return returnVal;
    }

    @Override
    public int doAfterBody() throws JspException {
        if (!isInIterableMode() || !iterator.hasNext())
            return SKIP_BODY;
        setPageContextAttribute(iterableVar, iterator.next());
        return EVAL_BODY_AGAIN;
    }

    @Override
    public void setIterable(Iterable iterable) {
        
        this.iterator = iterable.iterator();
    }

    @Override
    public void setIterableVar(String iterableVar) {
        this.iterableVar = iterableVar;
        
    }

    @Override
    public void setItemCountVar(String itemCountVar) {
        this.itemCountVar = itemCountVar;
        if (this.itemCountVar != null) {
            setPageContextAttribute(this.itemCountVar, 0);
        }
    }

    @Override
    public void incrementCounter() {
        if (itemCountVar != null) {
            setPageContextAttribute(itemCountVar, ((Integer) getPageContextAttributeValue(itemCountVar)) + 1);
        }
    }

    @Override
    public void setParent(Tag parent) {
        super.setParent(parent);
        iterator = null;
        iterableVar = null;
        itemCountVar = null;
    }
    
    

}
