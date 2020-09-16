/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.FlowNameReference;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class FlowNameSpecifier extends AbstractFopTag implements 
        Rendered, FlowNameReference {

    public FlowNameSpecifier() {
        super("flow-name-specifier", true);
    }

}
