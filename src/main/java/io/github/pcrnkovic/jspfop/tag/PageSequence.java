/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.LetterValue;
import io.github.pcrnkovic.jspfop.attr.GroupingSeparator;
import io.github.pcrnkovic.jspfop.attr.MasterReference;
import io.github.pcrnkovic.jspfop.attr.ForcePageCount;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.Format;
import io.github.pcrnkovic.jspfop.attr.ReferenceOrientation;
import io.github.pcrnkovic.jspfop.attr.WritingMode;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.FlowMapReference;
import io.github.pcrnkovic.jspfop.attr.Country;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.Language;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.InitialPageNumber;
import io.github.pcrnkovic.jspfop.attr.GroupingSize;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class PageSequence extends AbstractFopTag implements 
        Rendered, Country, FlowMapReference, Format, Language, LetterValue, GroupingSeparator, GroupingSize, 
        Id, IndexClass, IndexKey, InitialPageNumber, ForcePageCount, MasterReference, ReferenceOrientation, WritingMode {

    public PageSequence() {
        super("page-sequence", false);
    }
    
}
