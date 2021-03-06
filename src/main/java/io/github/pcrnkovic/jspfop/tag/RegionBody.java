/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.Clip;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.ColumnGap;
import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesBlock;
import io.github.pcrnkovic.jspfop.attr.Overflow;
import io.github.pcrnkovic.jspfop.attr.ColumnCount;
import io.github.pcrnkovic.jspfop.attr.ReferenceOrientation;
import io.github.pcrnkovic.jspfop.attr.RegionName;
import io.github.pcrnkovic.jspfop.attr.DisplayAlign;
import io.github.pcrnkovic.jspfop.attr.WritingMode;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class RegionBody extends AbstractFopTag implements 
        Rendered, CommonBorderPaddingBackgroundProperties, CommonMarginPropertiesBlock, Clip, ColumnCount, ColumnGap, DisplayAlign, Overflow, RegionName, ReferenceOrientation, 
        WritingMode {

    public RegionBody() {
        super("region-body", true);
    }
    
}
