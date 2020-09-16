/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.TextDecoration;
import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.LineHeight;
import io.github.pcrnkovic.jspfop.attr.LetterSpacing;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.CommonFontProperties;
import io.github.pcrnkovic.jspfop.attr.TextShadow;
import io.github.pcrnkovic.jspfop.attr.WordSpacing;
import io.github.pcrnkovic.jspfop.attr.Color;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.ScoreSpaces;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.TextTransform;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class InitialPropertySet extends AbstractFopTag implements 
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonFontProperties, CommonRelativePositionProperties, 
        Color, LetterSpacing, LineHeight, ScoreSpaces, TextDecoration, TextShadow, TextTransform, WordSpacing {

    public InitialPropertySet() {
        super("initial-property-set", true);
    }
    
}
