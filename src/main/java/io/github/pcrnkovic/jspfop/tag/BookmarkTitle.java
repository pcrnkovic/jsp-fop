/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.FontWeight;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.FontStyle;
import io.github.pcrnkovic.jspfop.attr.Color;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class BookmarkTitle extends AbstractFopTag implements Rendered, CommonAccessibilityProperties, Color, FontStyle, FontWeight {

    public BookmarkTitle() {
        super("bookmark-title", false);
    }
    
}
