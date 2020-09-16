/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesInline;
import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.LeaderLength;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.KeepWithPrevious;
import io.github.pcrnkovic.jspfop.attr.RuleStyle;
import io.github.pcrnkovic.jspfop.attr.TextShadow;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.LeaderAlignment;
import io.github.pcrnkovic.jspfop.attr.LeaderPattern;
import io.github.pcrnkovic.jspfop.attr.LineHeight;
import io.github.pcrnkovic.jspfop.attr.LetterSpacing;
import io.github.pcrnkovic.jspfop.attr.TextDepth;
import io.github.pcrnkovic.jspfop.attr.TextAltitude;
import io.github.pcrnkovic.jspfop.attr.CommonFontProperties;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.WordSpacing;
import io.github.pcrnkovic.jspfop.attr.Color;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.RuleThickness;
import io.github.pcrnkovic.jspfop.attr.DominantBaseline;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.Visibility;
import io.github.pcrnkovic.jspfop.attr.LeaderPatternWidth;
import io.github.pcrnkovic.jspfop.attr.AlignmentAdjust;
import io.github.pcrnkovic.jspfop.attr.BaselineShift;
import io.github.pcrnkovic.jspfop.attr.AlignmentBaseline;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class Leader extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Inline,
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonFontProperties, CommonMarginPropertiesInline, 
        CommonRelativePositionProperties, AlignmentAdjust, AlignmentBaseline, BaselineShift, Color, DominantBaseline, TextDepth, TextAltitude, Id, IndexClass, IndexKey, 
        KeepWithNext, KeepWithPrevious, LeaderAlignment, LeaderLength, LeaderPattern, LeaderPatternWidth, RuleStyle, RuleThickness, LetterSpacing, LineHeight, 
        TextShadow, Visibility, WordSpacing{

    public Leader() {
        super("leader", false);
    }
    
}
