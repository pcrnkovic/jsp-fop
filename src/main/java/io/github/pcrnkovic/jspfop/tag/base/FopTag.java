/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag.base;

import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author Pavle Crnković
 */
public interface FopTag extends Tag {

    void setFopAttribute(String attrName, String attrValue);

    Object getFopAttributeValue(String attrName);
    
}
