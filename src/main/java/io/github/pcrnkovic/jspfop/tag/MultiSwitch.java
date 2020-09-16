/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.AutoRestore;
import io.github.pcrnkovic.jspfop.attr.FopIteration;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopIteration;

/**
 *
 * @author Pavle Crnković
 */
public class MultiSwitch extends AbstractFopIteration implements FopIteration, Rendered, CommonAccessibilityProperties, AutoRestore, Id, IndexClass, IndexKey {

    public MultiSwitch() {
        super("multi-switch");
    }
    
}
