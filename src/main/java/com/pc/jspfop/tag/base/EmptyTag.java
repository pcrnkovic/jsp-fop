/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pc.jspfop.tag.base;

/**
 *
 * @author Pavle
 */
public abstract class EmptyTag extends FopTag {

    @Override
    public boolean isEmpty() {
        return true;
    }
    
}
