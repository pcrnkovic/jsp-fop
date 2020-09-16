/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.Height;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.KeepWithPrevious;
import io.github.pcrnkovic.jspfop.attr.KeepTogether;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.Visibility;
import io.github.pcrnkovic.jspfop.attr.BorderEndPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderStartPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderBeforePrecedence;
import io.github.pcrnkovic.jspfop.attr.BreakAfter;
import io.github.pcrnkovic.jspfop.attr.BreakBefore;
import io.github.pcrnkovic.jspfop.attr.BorderAfterPrecedence;
import io.github.pcrnkovic.jspfop.attr.BlockProgressionDimension;
import io.github.pcrnkovic.jspfop.attr.FopIteration;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopIteration;

/**
 *
 * @author Pavle Crnković
 */
public class TableRow extends AbstractFopIteration implements FopIteration,
        Rendered, CommonAccessibilityProperties, BlockProgressionDimension, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonRelativePositionProperties, 
        BorderAfterPrecedence, BorderBeforePrecedence, BorderEndPrecedence, BorderStartPrecedence, BreakAfter, BreakBefore, Id, IndexClass, IndexKey, Height, 
        KeepTogether, KeepWithNext, KeepWithPrevious, Visibility {

    public TableRow() {
        super("table-row");
    }
    
}
