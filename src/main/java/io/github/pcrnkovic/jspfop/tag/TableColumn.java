/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.NumberColumnsSpanned;
import io.github.pcrnkovic.jspfop.attr.NumberColumnsRepeated;
import io.github.pcrnkovic.jspfop.attr.ColumnNumber;
import io.github.pcrnkovic.jspfop.attr.Visibility;
import io.github.pcrnkovic.jspfop.attr.ColumnWidth;
import io.github.pcrnkovic.jspfop.attr.BorderEndPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderStartPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderBeforePrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderAfterPrecedence;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class TableColumn extends AbstractFopTag implements
        Rendered, CommonBorderPaddingBackgroundProperties, BorderAfterPrecedence, BorderBeforePrecedence, BorderEndPrecedence, BorderStartPrecedence, 
        ColumnNumber, ColumnWidth, NumberColumnsRepeated, NumberColumnsSpanned, Visibility {

    public TableColumn() {
        super("table-column", false);
    }
    
}
