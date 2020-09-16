/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.RefIndexKey;
import io.github.pcrnkovic.jspfop.attr.PageNumberTreatment;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class IndexKeyReference extends AbstractFopTag implements 
        Rendered, PageNumberTreatment, RefIndexKey {

    public IndexKeyReference() {
        super("index-key-reference", false);
    }
    
}
