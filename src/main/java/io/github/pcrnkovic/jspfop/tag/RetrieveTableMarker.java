/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.RetrieveBoundaryWithinTable;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.RetrieveClassName;
import io.github.pcrnkovic.jspfop.attr.RetrievePositionWithinTable;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class RetrieveTableMarker extends AbstractFopTag implements Rendered, RetrieveClassName, RetrievePositionWithinTable, RetrieveBoundaryWithinTable {

    public RetrieveTableMarker() {
        super("retrieve-table-marker", true);
    }
    
}
