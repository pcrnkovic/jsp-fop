/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.attr;

import io.github.pcrnkovic.jspfop.tag.base.FopTag;

/**
 *
 * @author Pavle Crnković
 */
public interface CommonFontProperties {

    void setFontFamily(String value);

    void setFontSelectionStrategy(String value);

    void setFontSize(String value);

    void setFontStretch(String value);

    void setFontSizeAdjust(String value);

    void setFontStyle(String value);

    void setFontVariant(String value);

    void setFontWeight(String value);
    
}
