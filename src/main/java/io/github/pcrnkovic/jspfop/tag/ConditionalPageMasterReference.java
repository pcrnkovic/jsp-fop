/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.MasterReference;
import io.github.pcrnkovic.jspfop.attr.OddOrEven;
import io.github.pcrnkovic.jspfop.attr.PagePosition;
import io.github.pcrnkovic.jspfop.attr.BlankOrNotBlank;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class ConditionalPageMasterReference extends AbstractFopTag implements 
        Rendered, MasterReference, PagePosition , OddOrEven, BlankOrNotBlank {

    public ConditionalPageMasterReference() {
        super("conditional-page-master-reference", true);
    }
    
}
