/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.KeepWithPrevious;
import io.github.pcrnkovic.jspfop.attr.KeepTogether;
import io.github.pcrnkovic.jspfop.attr.IntrusionDisplace;
import io.github.pcrnkovic.jspfop.attr.Clear;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesBlock;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.BreakAfter;
import io.github.pcrnkovic.jspfop.attr.BreakBefore;
import io.github.pcrnkovic.jspfop.attr.CaptionSide;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class TableAndCaption extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Block,
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, 
        CommonMarginPropertiesBlock, CommonRelativePositionProperties, BreakAfter, BreakBefore, CaptionSide, Clear, 
        Id, IndexClass, IndexKey, IntrusionDisplace, KeepTogether, KeepWithNext, KeepWithPrevious{

    public TableAndCaption() {
        super("table-and-caption", false);
    }
    
}
