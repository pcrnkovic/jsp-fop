/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.FlowMapName;
import io.github.pcrnkovic.jspfop.attr.FopIteration;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopIteration;

/**
 *
 * @author Pavle Crnković
 */
public class FlowMap extends AbstractFopIteration implements Rendered, FlowMapName, FopIteration {

    public FlowMap() {
        super("flow-map");
    }
    
}
