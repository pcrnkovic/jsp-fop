/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesInline;
import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.KeepWithPrevious;
import io.github.pcrnkovic.jspfop.attr.GlyphOrientationVertical;
import io.github.pcrnkovic.jspfop.attr.TextShadow;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.ScoreSpaces;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.TextTransform;
import io.github.pcrnkovic.jspfop.attr.GlyphOrientationHorizontal;
import io.github.pcrnkovic.jspfop.attr.TextDecoration;
import io.github.pcrnkovic.jspfop.attr.SuppressAtLineBreak;
import io.github.pcrnkovic.jspfop.attr.LineHeight;
import io.github.pcrnkovic.jspfop.attr.LetterSpacing;
import io.github.pcrnkovic.jspfop.attr.TextDepth;
import io.github.pcrnkovic.jspfop.attr.CommonHyphenationProperties;
import io.github.pcrnkovic.jspfop.attr.TextAltitude;
import io.github.pcrnkovic.jspfop.attr.CommonFontProperties;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.WordSpacing;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.DominantBaseline;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.Visibility;
import io.github.pcrnkovic.jspfop.attr.TreatAsWordSpace;
import io.github.pcrnkovic.jspfop.attr.AlignmentAdjust;
import io.github.pcrnkovic.jspfop.attr.BaselineShift;
import io.github.pcrnkovic.jspfop.attr.AlignmentBaseline;
import io.github.pcrnkovic.jspfop.attr.Color;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class Character extends AbstractFopTag implements Rendered, io.github.pcrnkovic.jspfop.tag.group.Inline,
        CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonFontProperties, 
        CommonHyphenationProperties, CommonMarginPropertiesInline, CommonRelativePositionProperties,
        AlignmentAdjust, TreatAsWordSpace, AlignmentBaseline, BaselineShift, 
        io.github.pcrnkovic.jspfop.attr.Character, Color, DominantBaseline, 
        TextDepth, TextAltitude, GlyphOrientationHorizontal, GlyphOrientationVertical, Id, IndexClass, IndexKey, 
        KeepWithNext, KeepWithPrevious, LetterSpacing, LineHeight, ScoreSpaces, SuppressAtLineBreak, 
        TextDecoration, TextTransform, TextShadow, Visibility, WordSpacing {

    public Character() {
        super("character", true);
    }
    
}
