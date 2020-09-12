/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.attr;

import io.github.pcrnkovic.jspfop.tag.base.FopTag;

/**
 *
 * @author Pavle
 */
public interface CommonMarginPropertiesInline {
    
    void setMarginTop(String value);

    void setMarginBottom(String value);

    void setMarginLeft(String value);

    void setMarginRight(String value);
    
    void setSpaceEnd(String value);
    
    void setSpaceStart(String value);
    
}