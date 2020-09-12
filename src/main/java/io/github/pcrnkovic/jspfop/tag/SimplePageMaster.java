/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.MasterName;
import io.github.pcrnkovic.jspfop.attr.PageWidth;
import io.github.pcrnkovic.jspfop.attr.PageHeight;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.CommonMarginPropertiesBlock;
import io.github.pcrnkovic.jspfop.attr.ReferenceOrientation;
import io.github.pcrnkovic.jspfop.attr.WritingMode;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class SimplePageMaster extends AbstractFopTag implements 
        Rendered, CommonMarginPropertiesBlock, MasterName, PageHeight, PageWidth, ReferenceOrientation, WritingMode {

    public SimplePageMaster() {
        super("simple-page-master", false);
    }
    
}
