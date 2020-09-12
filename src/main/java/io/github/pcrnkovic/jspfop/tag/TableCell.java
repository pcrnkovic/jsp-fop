/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.CommonRelativePositionProperties;
import io.github.pcrnkovic.jspfop.attr.CommonBorderPaddingBackgroundProperties;
import io.github.pcrnkovic.jspfop.attr.Height;
import io.github.pcrnkovic.jspfop.attr.Width;
import io.github.pcrnkovic.jspfop.attr.IndexClass;
import io.github.pcrnkovic.jspfop.attr.RelativeAlign;
import io.github.pcrnkovic.jspfop.attr.ColumnNumber;
import io.github.pcrnkovic.jspfop.attr.EndsRow;
import io.github.pcrnkovic.jspfop.attr.IndexKey;
import io.github.pcrnkovic.jspfop.attr.StartsRow;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.NumberColumnsSpanned;
import io.github.pcrnkovic.jspfop.attr.Id;
import io.github.pcrnkovic.jspfop.attr.InlineProgressionDimension;
import io.github.pcrnkovic.jspfop.attr.CommonAuralProperties;
import io.github.pcrnkovic.jspfop.attr.EmptyCells;
import io.github.pcrnkovic.jspfop.attr.CommonAccessibilityProperties;
import io.github.pcrnkovic.jspfop.attr.DisplayAlign;
import io.github.pcrnkovic.jspfop.attr.NumberRowsSpanned;
import io.github.pcrnkovic.jspfop.attr.BorderEndPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderStartPrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderBeforePrecedence;
import io.github.pcrnkovic.jspfop.attr.BorderAfterPrecedence;
import io.github.pcrnkovic.jspfop.attr.BlockProgressionDimension;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle
 */
public class TableCell extends AbstractFopTag implements 
        Rendered, CommonAccessibilityProperties, CommonAuralProperties, CommonBorderPaddingBackgroundProperties, CommonRelativePositionProperties, 
        BorderAfterPrecedence, BorderBeforePrecedence, BorderEndPrecedence, BorderStartPrecedence, BlockProgressionDimension, ColumnNumber, DisplayAlign, 
        RelativeAlign, EmptyCells, EndsRow, Height, Id, IndexClass, IndexKey, InlineProgressionDimension, NumberColumnsSpanned, NumberRowsSpanned, 
        StartsRow, Width
{

    public TableCell() {
        super("table-cell", false);
    }
    
}
