/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.Clip;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.Extent;
import io.github.pcrnkovic.jspfop.attr.Overflow;
import io.github.pcrnkovic.jspfop.attr.ReferenceOrientation;
import io.github.pcrnkovic.jspfop.attr.RegionName;
import io.github.pcrnkovic.jspfop.attr.DisplayAlign;
import io.github.pcrnkovic.jspfop.attr.WritingMode;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class RegionEnd extends AbstractFopTag implements Rendered, 
        CommonBorderPaddingBackgroundProperties, Clip, DisplayAlign, Extent, Overflow, RegionName, ReferenceOrientation, WritingMode {

    public RegionEnd() {
        super("region-end", true);
    }
    
}
