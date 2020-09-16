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
import io.github.pcrnkovic.jspfop.attr.ScalingMethod;
import io.github.pcrnkovic.jspfop.attr.ContentWidth;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.InlineProgressionDimension;
import io.github.pcrnkovic.jspfop.attr.Overflow;
import io.github.pcrnkovic.jspfop.attr.Scaling;
import io.github.pcrnkovic.jspfop.attr.DisplayAlign;
import io.github.pcrnkovic.jspfop.attr.ContentType;
import io.github.pcrnkovic.jspfop.attr.LineHeight;
import io.github.pcrnkovic.jspfop.attr.TextAlign;
import io.github.pcrnkovic.jspfop.attr.Clip;
import io.github.pcrnkovic.jspfop.attr.Height;
import io.github.pcrnkovic.jspfop.attr.Width;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.ContentHeight;
import io.github.pcrnkovic.jspfop.attr.DominantBaseline;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.AlignmentAdjust;
import io.github.pcrnkovic.jspfop.attr.AllowedHeightScale;
import io.github.pcrnkovic.jspfop.attr.BaselineShift;
import io.github.pcrnkovic.jspfop.attr.AlignmentBaseline;
import io.github.pcrnkovic.jspfop.attr.BlockProgressionDimension;
import io.github.pcrnkovic.jspfop.attr.AllowedWidthScale;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class InstreamForeignObject extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Inline,
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonMarginPropertiesInline, CommonRelativePositionProperties, 
        AlignmentAdjust, AlignmentBaseline, AllowedHeightScale, AllowedWidthScale, BaselineShift, BlockProgressionDimension, Clip, ContentHeight, ContentType, ContentWidth, 
        DisplayAlign, DominantBaseline, Height, Id, IndexClass, IndexKey, InlineProgressionDimension, KeepWithNext, KeepWithPrevious, LineHeight, Overflow, Scaling, ScalingMethod, 
        TextAlign, Width {

    public InstreamForeignObject() {
        super("instream-foreign-object", true);
    }
    
}
