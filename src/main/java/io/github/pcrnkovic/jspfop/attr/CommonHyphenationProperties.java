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
public interface CommonHyphenationProperties {

    void setCountry(String value);

    void setLanguage(String value);

    void setScript(String value);

    void setHyphenate(String value);

    void setHyphenationCharacter(String value);

    void setHyphenationPushCharacterCount(String value);

    void setHyphenationRemainCharacterCount(String value);

}
