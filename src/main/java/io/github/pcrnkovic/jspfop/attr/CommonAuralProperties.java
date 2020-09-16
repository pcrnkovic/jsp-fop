/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.attr;

import io.github.pcrnkovic.jspfop.tag.base.FopTag;

/**
 * 7.7
 *
 * @author Pavle Crnković
 */
public interface CommonAuralProperties {

    void setAzimuth(String azimuth);

    void setCueAfter(String cureAfter);

    void setCueBefore(String cureBefore);

    void setElevation(String elevation);

    void setPauseAfter(String pauseAfter);

    void setPauseBefore(String pauseBefore);

    void setPitch(String pitch);

    void setPitchRange(String pitchRange);

    void setPlayDuring(String playDuring);

    void setRichness(String richness);

    void setSpeak(String speak);

    void setSpeakHeader(String speakHeader);

    void setSpeakNumeral(String speakNumeral);

    void setSpeakPunctuation(String speakPunctuation);

    void setSpeechRate(String speechRate);

    void setStress(String stress);

    void setVoiceFamily(String voiceFamily);

    void setVolume(String volume);
    
}
