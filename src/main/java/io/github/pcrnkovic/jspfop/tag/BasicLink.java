/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.LineHeight;
import io.github.pcrnkovic.jspfop.attr.ShowDestination;
import io.github.pcrnkovic.jspfop.attr.TargetProcessingContext;
import io.github.pcrnkovic.jspfop.attr.TargetPresentationContext;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.KeepWithPrevious;
import io.github.pcrnkovic.jspfop.attr.KeepTogether;
import io.github.pcrnkovic.jspfop.attr.InternalDestination;
import io.github.pcrnkovic.jspfop.attr.IndicateDestination;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.ExternalDestination;
import io.github.pcrnkovic.jspfop.attr.AlignmentAdjust;
import io.github.pcrnkovic.jspfop.attr.AlignmentBaseline;
import io.github.pcrnkovic.jspfop.attr.BaselineShift;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.DestinationPlacementOffset;
import io.github.pcrnkovic.jspfop.attr.DominantBaseline;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;
import io.github.pcrnkovic.jspfop.attr.TargetStylesheet;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesInline;

/**
 *
 * @author Pavle
 */
public class BasicLink extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Inline,
        CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonMarginPropertiesInline, CommonRelativePositionProperties, Rendered,
        AlignmentAdjust, AlignmentBaseline, BaselineShift, DestinationPlacementOffset, DominantBaseline, ExternalDestination, Id, IndexClass, 
        IndexKey, IndicateDestination, InternalDestination, KeepTogether, KeepWithNext, KeepWithPrevious, 
        LineHeight, ShowDestination, TargetProcessingContext, TargetPresentationContext, TargetStylesheet {

    public BasicLink() {
        super("basic-link", false);
    }
    
}
