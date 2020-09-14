/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.ChangeBarClass;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class ChangeBarEnd extends AbstractFopTag implements 
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, ChangeBarClass {

    public ChangeBarEnd() {
        super("change-bar-end", true);
    }
    
}