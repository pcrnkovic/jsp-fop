/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.attr;

/**
 *
 * @author Pavle
 */
public interface CommonMarginPropertiesBlock {
    
    void setMarginTop(String marginTop); 
    
    void setMarginBottom(String marginBottom); 
    
    void setMarginLeft(String marginLeft); 
    
    void setMarginRight(String marginRight) ;
    
    void setSpaceBefore(String spaceBefore) ;
    
    void setSpaceAfter(String spaceAfter); 
    
    void setStartIndent(String startIndent); 
    
    void setEndIndent(String endIndent);
    
}
