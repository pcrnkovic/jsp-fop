/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.Visibility;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.BorderEndPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderStartPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderBeforePrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderAfterPrecedence;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopIteration;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class TableBody extends AbstractFopIteration implements 
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonRelativePositionProperties,
        BorderAfterPrecedence, BorderBeforePrecedence, BorderEndPrecedence, BorderStartPrecedence, Id, IndexClass, IndexKey, Visibility {

    public TableBody() {
        super("table-body");
    }
    
}
