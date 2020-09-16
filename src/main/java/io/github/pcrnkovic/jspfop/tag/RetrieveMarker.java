/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.RetrieveBoundary;
import io.github.pcrnkovic.jspfop.attr.RetrievePosition;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.RetrieveClassName;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class RetrieveMarker extends AbstractFopTag implements 
        Rendered, RetrieveClassName, RetrievePosition, RetrieveBoundary {

    public RetrieveMarker() {
        super("retrieve-marker", true);
    }
    
}
