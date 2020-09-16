/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesInline;
import io.github.pcrnkovic.jspfop.attr.LetterValue;
import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.WrapOption;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.Format;
import io.github.pcrnkovic.jspfop.attr.KeepWithPrevious;
import io.github.pcrnkovic.jspfop.attr.IntrinsicScaleValue;
import io.github.pcrnkovic.jspfop.attr.TextShadow;
import io.github.pcrnkovic.jspfop.attr.ScaleOption;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.Country;
import io.github.pcrnkovic.jspfop.attr.Language;
import io.github.pcrnkovic.jspfop.attr.ScoreSpaces;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.TextTransform;
import io.github.pcrnkovic.jspfop.attr.RefId;
import io.github.pcrnkovic.jspfop.attr.GroupingSize;
import io.github.pcrnkovic.jspfop.attr.TextDecoration;
import io.github.pcrnkovic.jspfop.attr.LineHeight;
import io.github.pcrnkovic.jspfop.attr.GroupingSeparator;
import io.github.pcrnkovic.jspfop.attr.TextDepth;
import io.github.pcrnkovic.jspfop.attr.LetterSpacing;
import io.github.pcrnkovic.jspfop.attr.TextAltitude;
import io.github.pcrnkovic.jspfop.attr.CommonFontProperties;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.WordSpacing;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.DominantBaseline;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.Visibility;
import io.github.pcrnkovic.jspfop.attr.AlignmentAdjust;
import io.github.pcrnkovic.jspfop.attr.BaselineShift;
import io.github.pcrnkovic.jspfop.attr.AlignmentBaseline;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class ScalingValueCitation extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Inline, 
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonFontProperties, 
        CommonMarginPropertiesInline, CommonRelativePositionProperties, AlignmentAdjust, AlignmentBaseline, BaselineShift, Country, 
        DominantBaseline, Format, GroupingSeparator, GroupingSize, Id, IndexClass, IndexKey, KeepWithNext, KeepWithPrevious, Language, 
        LetterSpacing, LetterValue, LineHeight, IntrinsicScaleValue, RefId, ScoreSpaces, ScaleOption, TextAltitude, TextDecoration, 
        TextDepth, TextShadow, TextTransform, Visibility, WordSpacing, WrapOption{

    public ScalingValueCitation() {
        super("scaling-value-citation", true);
    }
    
}
