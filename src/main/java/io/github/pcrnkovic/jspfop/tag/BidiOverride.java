/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.LineHeight;
import io.github.pcrnkovic.jspfop.attr.LetterSpacing;
import io.github.pcrnkovic.jspfop.attr.Direction;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.CommonFontProperties;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.WordSpacing;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.ScoreSpaces;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.UnicodeBidi;
import io.github.pcrnkovic.jspfop.attr.Color;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class BidiOverride extends AbstractFopTag implements io.github.pcrnkovic.jspfop.tag.group.Inline, 
        Rendered, CommonAuralProperties, CommonFontProperties, CommonRelativePositionProperties, Color, Direction, Id, IndexClass, IndexKey, 
        LetterSpacing, LineHeight, ScoreSpaces, UnicodeBidi, WordSpacing {

    public BidiOverride() {
        super("bidi-override", false);
    }

    
    
}
