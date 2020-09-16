/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag;

import io.github.pcrnkovic.jspfop.attr.RenderingIntent;
import io.github.pcrnkovic.jspfop.attr.Rendered;
import io.github.pcrnkovic.jspfop.attr.ColorProfileName;
import io.github.pcrnkovic.jspfop.attr.Src;
import io.github.pcrnkovic.jspfop.tag.base.AbstractFopTag;

/**
 *
 * @author Pavle Crnković
 */
public class ColorProfile extends AbstractFopTag implements 
        Rendered, Src, ColorProfileName, RenderingIntent {

    public ColorProfile() {
        super("color-profile", true);
    }
    
}
