/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.TableOmitFooterAtBreak;
import io.github.pcrnkovic.jspfop.attr.Height;
import io.github.pcrnkovic.jspfop.attr.Width;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.KeepWithPrevious;
import io.github.pcrnkovic.jspfop.attr.KeepTogether;
import io.github.pcrnkovic.jspfop.attr.IntrusionDisplace;
import io.github.pcrnkovic.jspfop.attr.Clear;
import io.github.pcrnkovic.jspfop.attr.WritingMode;
import io.github.pcrnkovic.jspfop.attr.TableOmitHeaderAtBreak;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.TableLayout;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesBlock;
import io.github.pcrnkovic.jspfop.attr.InlineProgressionDimension;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.BorderEndPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderStartPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderSeparation;
import io.github.pcrnkovic.jspfop.attr.BorderBeforePrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderCollapse;
import io.github.pcrnkovic.jspfop.attr.BreakAfter;
import io.github.pcrnkovic.jspfop.attr.BreakBefore;
import io.github.pcrnkovic.jspfop.attr.BorderAfterPrecedence;
import io.github.pcrnkovic.jspfop.attr.BlockProgressionDimension;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class Table extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Block,
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonMarginPropertiesBlock, CommonRelativePositionProperties, 
        BlockProgressionDimension, BorderAfterPrecedence, BorderBeforePrecedence, BorderCollapse, BorderEndPrecedence, BorderSeparation, BorderStartPrecedence, 
        BreakAfter, BreakBefore, Clear, Id, IndexClass, IndexKey, InlineProgressionDimension, IntrusionDisplace, Height, KeepTogether, KeepWithNext, KeepWithPrevious, 
        TableLayout, TableOmitFooterAtBreak, TableOmitHeaderAtBreak, Width, WritingMode {

    public Table() {
        super("table", false);
    }
    
}
