/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.ChangeBarWidth;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.ZIndex;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.ChangeBarPlacement;
import io.github.pcrnkovic.jspfop.attr.ChangeBarStyle;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.ChangeBarClass;
import io.github.pcrnkovic.jspfop.attr.ChangeBarOffset;
import io.github.pcrnkovic.jspfop.attr.ChangeBarColor;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class ChangeBarBegin extends AbstractFopTag implements 
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, 
        ChangeBarClass, ChangeBarColor, ChangeBarOffset, ChangeBarPlacement, ChangeBarStyle, ChangeBarWidth, ZIndex {

    public ChangeBarBegin() {
        super("change-bar-begin", true);
    }
    
}
