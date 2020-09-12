/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.attr;

import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author Pavle
 */
public interface FopIteration {
     
    void incrementCounter();
    
    void setIterable(Iterable iterable);
    
    void setIterableVar(String iterableVar);
    
    void setItemCountVar(String itemCountVar);
}
