/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.WrapOption;
import io.github.pcrnkovic.jspfop.attr.Orphans;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.KeepWithPrevious;
import io.github.pcrnkovic.jspfop.attr.KeepTogether;
import io.github.pcrnkovic.jspfop.attr.HyphenationKeep;
import io.github.pcrnkovic.jspfop.attr.LinefeedTreatment;
import io.github.pcrnkovic.jspfop.attr.WhiteSpaceTreatment;
import io.github.pcrnkovic.jspfop.attr.Span;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.TextIndent;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesBlock;
import io.github.pcrnkovic.jspfop.attr.WhiteSpaceCollapse;
import io.github.pcrnkovic.jspfop.attr.TextAlignLast;
import io.github.pcrnkovic.jspfop.attr.LastLineEndIndent;
import io.github.pcrnkovic.jspfop.attr.HyphenationLadderCount;
import io.github.pcrnkovic.jspfop.attr.LineHeight;
import io.github.pcrnkovic.jspfop.attr.TextAlign;
import io.github.pcrnkovic.jspfop.attr.TextDepth;
import io.github.pcrnkovic.jspfop.attr.Widows;
import io.github.pcrnkovic.jspfop.attr.CommonHyphenationProperties;
import io.github.pcrnkovic.jspfop.attr.IntrusionDisplace;
import io.github.pcrnkovic.jspfop.attr.Clear;
import io.github.pcrnkovic.jspfop.attr.TextAltitude;
import io.github.pcrnkovic.jspfop.attr.CommonFontProperties;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.LineStackingStrategy;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.LineHeightShiftAdjustment;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.Visibility;
import io.github.pcrnkovic.jspfop.attr.BreakAfter;
import io.github.pcrnkovic.jspfop.attr.BreakBefore;
import io.github.pcrnkovic.jspfop.attr.Color;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class Block extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Block,
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonFontProperties, 
        CommonHyphenationProperties, CommonMarginPropertiesBlock, CommonRelativePositionProperties, BreakAfter, BreakBefore, Clear, Color, 
        TextDepth, TextAltitude, HyphenationKeep, HyphenationLadderCount, Id, IndexClass, IndexKey, IntrusionDisplace, KeepTogether, KeepWithNext, KeepWithPrevious, 
        LastLineEndIndent, LinefeedTreatment, LineHeight, LineHeightShiftAdjustment, LineStackingStrategy, Orphans, WhiteSpaceTreatment, Span, 
        TextAlign, TextAlignLast, TextIndent, Visibility, WhiteSpaceCollapse, Widows, WrapOption {

    public Block() {
        super("block", false);
    }
    
}
