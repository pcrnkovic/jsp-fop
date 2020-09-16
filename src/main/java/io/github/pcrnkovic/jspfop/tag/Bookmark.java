/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.InternalDestination;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.StartingState;
import io.github.pcrnkovic.jspfop.attr.ExternalDestination;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class Bookmark extends AbstractFopTag implements Rendered, CommonAccessibilityProperties, ExternalDestination, InternalDestination, StartingState {

    public Bookmark() {
        super("bookmark", false);
    }
    
}
