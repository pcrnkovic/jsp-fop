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
public interface CommonBorderPaddingBackgroundProperties {

    void setBackgroundAttachment(String value);

    void setBackgroundColor(String value);

    void setBackgroundImage(String value);

    void setBackgroundRepeat(String value);

    void setBackgroundPositionHorizontal(String value);

    void setBackgroundPositionVertical(String value);

    void setBorderBeforeColor(String value);

    void setBorderBeforeStyle(String value);

    void setBorderBeforeWidth(String value);

    void setBorderAfterColor(String value);

    void setBorderAfterStyle(String value);

    void setBorderAfterWidth(String value);

    void setBorderStartColor(String value);

    void setBorderStartStyle(String value);

    void setBorderStartWidth(String value);

    void setBorderEndColor(String value);

    void setBorderEndStyle(String value);

    void setBorderEndWidth(String value);

    void setBorderTopColor(String value);

    void setBorderTopStyle(String value);

    void setBorderTopWidth(String value);

    void setBorderBottomColor(String value);

    void setBorderBottomStyle(String value);

    void setBorderBottomWidth(String value);

    void setBorderLeftColor(String value);

    void setBorderLeftStyle(String value);

    void setBorderLeftWidth(String value);

    void setBorderRightColor(String value);

    void setBorderRightStyle(String value);

    void setBorderRightWidth(String value);

    void setPaddingBefore(String value);

    void setPaddingAfter(String value);

    void setPaddingStart(String value);

    void setPaddingEnd(String value);

    void setPaddingTop(String value);

    void setPaddingBottom(String value);

    void setPaddingLeft(String value);

    void setPaddingRight(String value);

}
