/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.MergeSequentialPageNumbers;
import io.github.pcrnkovic.jspfop.attr.MergePagesAcrossIndexKeyReferences;
import io.github.pcrnkovic.jspfop.attr.MergeRangesAcrossIndexKeyReferences;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class IndexPageCitationList extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Inline, 
        Rendered, MergeSequentialPageNumbers, MergeRangesAcrossIndexKeyReferences, MergePagesAcrossIndexKeyReferences {

    public IndexPageCitationList() {
        super("index-page-citation-list", false);
    }
    
}
