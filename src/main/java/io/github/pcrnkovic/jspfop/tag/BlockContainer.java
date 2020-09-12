/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;


import io.github.pcrnkovic.jspfop.attr.Clip;
import io.github.pcrnkovic.jspfop.attr.ZIndex;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.Height;
import io.github.pcrnkovic.jspfop.attr.Width;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.KeepWithPrevious;
import io.github.pcrnkovic.jspfop.attr.KeepTogether;
import io.github.pcrnkovic.jspfop.attr.IntrusionDisplace;
import io.github.pcrnkovic.jspfop.attr.ReferenceOrientation;
import io.github.pcrnkovic.jspfop.attr.Clear;
import io.github.pcrnkovic.jspfop.attr.WritingMode;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.Span;
import io.github.pcrnkovic.jspfop.attr.KeepWithNext;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesBlock;
import io.github.pcrnkovic.jspfop.attr.InlineProgressionDimension;
import io.github.pcrnkovic.jspfop.attr.CommonAbsolutePositionProperties;
import io.github.pcrnkovic.jspfop.attr.Overflow;
import io.github.pcrnkovic.jspfop.attr.DisplayAlign;
import io.github.pcrnkovic.jspfop.attr.BreakAfter;
import io.github.pcrnkovic.jspfop.attr.BreakBefore;
import io.github.pcrnkovic.jspfop.attr.BlockProgressionDimension;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class BlockContainer extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Block,
        CommonAbsolutePositionProperties, CommonBorderPaddingBackgroundProperties, CommonMarginPropertiesBlock,
        BlockProgressionDimension, BreakAfter, BreakBefore, Clear, Clip, DisplayAlign, Height, Id, IndexClass, IndexKey, 
        InlineProgressionDimension, IntrusionDisplace, KeepTogether, KeepWithNext, KeepWithPrevious, Overflow, ReferenceOrientation, 
        Span, Width, WritingMode, ZIndex {

    public BlockContainer() {
        super("block-container", false);
    }
    
}
