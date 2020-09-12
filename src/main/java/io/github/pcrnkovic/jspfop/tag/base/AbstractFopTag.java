/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.tag.base;

import io.github.pcrnkovic.jspfop.attr.FopIteration;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author Pavle
 */
public abstract class AbstractFopTag implements FopTag {
    
    private PageContext pageContext;
    
    private Tag parent;
    
    private final Map<String, String> foAttributes;
    
    public final String name;
    
    public final boolean empty;
    
    private boolean rendered;
    
    private final Map<String,Object> savedPageContextAttributes;

    @Override
    public void setFopAttribute(String name, String value) {
        this.foAttributes.put(name, value);
    }

    @Override
    public Object getFopAttributeValue(String name) {
        return this.foAttributes.get(name);
    }
       
    public AbstractFopTag(String name, boolean empty) {
        this.empty = empty;
        this.name = name;
        this.foAttributes = new HashMap<>();
        this.savedPageContextAttributes = new HashMap<>();
    }

    public void setPageContextAttribute(String attrName, Object attrValue) {
        if (attrName != null) {
            if (!savedPageContextAttributes.containsKey(attrValue))
                savedPageContextAttributes.put(attrName, pageContext.getAttribute(attrName));
            pageContext.setAttribute(attrName, attrValue);
        }
    }
    
    public Object getPageContextAttributeValue(String attrName) {
        return this.pageContext.getAttribute(attrName);
    }    
    
    protected void print(String value) throws JspException {
        try {
            pageContext.getOut().print(value);
        }
        catch (IOException e) {
            throw new JspTagException(e);
        }
    }
    
    protected final void printAttributes() throws JspException {
        for (Map.Entry entry: foAttributes.entrySet())
            print(" "+entry.getKey()+"=\""+entry.getValue()+"\"");
    }

    @Override
    public int doStartTag() throws JspException {
        
        if (!rendered)
            return SKIP_BODY;
        
        if (getParent() instanceof FopIteration) {
            ((FopIteration) getParent()).incrementCounter();
        }
        
        print("<"+this.name);
        printAttributes();
        if (this.empty) {
            print("/>");
            return SKIP_BODY;
        }
        else {
            print(">");
            return EVAL_BODY_INCLUDE;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        
        if (!rendered)
            return EVAL_PAGE;
        if (!this.empty) {
            print("</"+this.name+">");
        }
        
        for (Entry<String,Object> entry: savedPageContextAttributes.entrySet()) {
            pageContext.setAttribute(entry.getKey(), entry.getValue());
        }
        savedPageContextAttributes.clear();
        
        return EVAL_PAGE;
    }

    @Override
    public void setPageContext(PageContext pageContext) {        
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag parent) {
        this.parent = parent;
        rendered=true;
        foAttributes.clear();
    }
    
    @Override
    public void release() {}

    @Override
    public Tag getParent() {
        return parent;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {        
        this.rendered = rendered;
    }
    
    

    /*@Override*/
    public void setAbsolutePosition(String absolutePosition) {
        setFopAttribute("absolute-position", absolutePosition);
    }

    public void setActiveState(String activeState) {
        setFopAttribute("active-state", activeState);
    }

    public void setAlignmentAdjust(String alignmentAdjust) {
        setFopAttribute("alignment-adjust", alignmentAdjust);
    }

    public void setAlignmentBaseline(String alignmentBaseline) {
        setFopAttribute("alignment-baseline", alignmentBaseline);
    }

    public void setAllowedHeightScale(String allowedHeightScale) {
        setFopAttribute("allowed-height-scale", allowedHeightScale);
    }

    public void setAllowedWidthScale(String allowedWidthScale) {
        setFopAttribute("allowed-width-scale", allowedWidthScale);
    }

    public void setAutoRestore(String autoRestore) {
        setFopAttribute("auto-restore", autoRestore);
    }

    public void setAzimuth(String azimuth) {
        setFopAttribute("azimuth", azimuth);
    }

    public void setBackground(String background) {
        setFopAttribute("background", background);
    }

    public void setBackgroundAttachment(String backgroundAttachment) {
        setFopAttribute("background-attachment", backgroundAttachment);
    }

    public void setBackgroundColor(String backgroundColor) {
        setFopAttribute("background-color", backgroundColor);
    }

    public void setBackgroundImage(String backgroundImage) {
        setFopAttribute("background-image", backgroundImage);
    }

    public void setBackgroundPosition(String backgroundPosition) {
        setFopAttribute("background-position", backgroundPosition);
    }

    public void setBackgroundPositionHorizontal(String backgroundPositionHorizontal) {
        setFopAttribute("background-position-horizontal", backgroundPositionHorizontal);
    }

    public void setBackgroundPositionVertical(String backgroundPositionVertical) {
        setFopAttribute("background-position-vertical", backgroundPositionVertical);
    }

    public void setBackgroundRepeat(String backgroundRepeat) {
        setFopAttribute("background-repeat", backgroundRepeat);
    }

    public void setBaselineShift(String baselineShift) {
        setFopAttribute("baseline-shift", baselineShift);
    }

    public void setBlankOrNotBlank(String blankOrNotBlank) {
        setFopAttribute("blank-or-not-blank", blankOrNotBlank);
    }

    public void setBlockProgressionDimension(String blockProgressionDimension) {
        setFopAttribute("block-progression-dimension", blockProgressionDimension);
    }

    public void setBorder(String border) {
        setFopAttribute("border", border);
    }

    public void setBorderAfterColor(String borderAfterColor) {
        setFopAttribute("border-after-color", borderAfterColor);
    }

    public void setBorderAfterPrecedence(String borderAfterPrecedence) {
        setFopAttribute("border-after-precedence", borderAfterPrecedence);
    }

    public void setBorderAfterStyle(String borderAfterStyle) {
        setFopAttribute("border-after-style", borderAfterStyle);
    }

    public void setBorderAfterWidth(String borderAfterWidth) {
        setFopAttribute("border-after-width", borderAfterWidth);
    }

    public void setBorderBeforeColor(String borderBeforeColor) {
        setFopAttribute("border-before-color", borderBeforeColor);
    }

    public void setBorderBeforePrecedence(String borderBeforePrecedence) {
        setFopAttribute("border-before-precedence", borderBeforePrecedence);
    }

    public void setBorderBeforeStyle(String borderBeforeStyle) {
        setFopAttribute("border-before-style", borderBeforeStyle);
    }

    public void setBorderBeforeWidth(String borderBeforeWidth) {
        setFopAttribute("border-before-width", borderBeforeWidth);
    }

    public void setBorderBottom(String borderBottom) {
        setFopAttribute("border-bottom", borderBottom);
    }

    public void setBorderBottomColor(String borderBottomColor) {
        setFopAttribute("border-bottom-color", borderBottomColor);
    }

    public void setBorderBottomStyle(String borderBottomStyle) {
        setFopAttribute("border-bottom-style", borderBottomStyle);
    }

    public void setBorderBottomWidth(String borderBottomWidth) {
        setFopAttribute("border-bottom-width", borderBottomWidth);
    }

    public void setBorderCollapse(String borderCollapse) {
        setFopAttribute("border-collapse", borderCollapse);
    }

    public void setBorderColor(String borderColor) {
        setFopAttribute("border-color", borderColor);
    }

    public void setBorderEndColor(String borderEndColor) {
        setFopAttribute("border-end-color", borderEndColor);
    }

    public void setBorderEndPrecedence(String borderEndPrecedence) {
        setFopAttribute("border-end-precedence", borderEndPrecedence);
    }

    public void setBorderEndStyle(String borderEndStyle) {
        setFopAttribute("border-end-style", borderEndStyle);
    }

    public void setBorderEndWidth(String borderEndWidth) {
        setFopAttribute("border-end-width", borderEndWidth);
    }

    public void setBorderLeft(String borderLeft) {
        setFopAttribute("border-left", borderLeft);
    }

    public void setBorderLeftColor(String borderLeftColor) {
        setFopAttribute("border-left-color", borderLeftColor);
    }

    public void setBorderLeftStyle(String borderLeftStyle) {
        setFopAttribute("border-left-style", borderLeftStyle);
    }

    public void setBorderLeftWidth(String borderLeftWidth) {
        setFopAttribute("border-left-width", borderLeftWidth);
    }

    public void setBorderRight(String borderRight) {
        setFopAttribute("border-right", borderRight);
    }

    public void setBorderRightColor(String borderRightColor) {
        setFopAttribute("border-right-color", borderRightColor);
    }

    public void setBorderRightStyle(String borderRightStyle) {
        setFopAttribute("border-right-style", borderRightStyle);
    }

    public void setBorderRightWidth(String borderRightWidth) {
        setFopAttribute("border-right-width", borderRightWidth);
    }

    public void setBorderSeparation(String borderSeparation) {
        setFopAttribute("border-separation", borderSeparation);
    }

    public void setBorderSeparationBlockProgressionDirection(String borderSeparationBlockProgressionDirection) {
        setFopAttribute("border-separation.block-progression-direction", borderSeparationBlockProgressionDirection);
    }

    public void setBorderSeparationInlineProgressionDirection(String borderSeparationInlineProgressionDirection) {
        setFopAttribute("border-separation.inline-progression-direction", borderSeparationInlineProgressionDirection);
    }

    public void setBorderSpacing(String borderSpacing) {
        setFopAttribute("border-spacing", borderSpacing);
    }

    public void setBorderStartColor(String borderStartColor) {
        setFopAttribute("border-start-color", borderStartColor);
    }

    public void setBorderStartPrecedence(String borderStartPrecedence) {
        setFopAttribute("border-start-precedence", borderStartPrecedence);
    }

    public void setBorderStartStyle(String borderStartStyle) {
        setFopAttribute("border-start-style", borderStartStyle);
    }

    public void setBorderStartWidth(String borderStartWidth) {
        setFopAttribute("border-start-width", borderStartWidth);
    }

    public void setBorderStyle(String borderStyle) {
        setFopAttribute("border-style", borderStyle);
    }

    public void setBorderTop(String borderTop) {
        setFopAttribute("border-top", borderTop);
    }

    public void setBorderTopColor(String borderTopColor) {
        setFopAttribute("border-top-color", borderTopColor);
    }

    public void setBorderTopStyle(String borderTopStyle) {
        setFopAttribute("border-top-style", borderTopStyle);
    }

    public void setBorderTopWidth(String borderTopWidth) {
        setFopAttribute("border-top-width", borderTopWidth);
    }

    public void setBorderWidth(String borderWidth) {
        setFopAttribute("border-width", borderWidth);
    }

    public void setBottom(String bottom) {
        setFopAttribute("bottom", bottom);
    }

    public void setBreakAfter(String breakAfter) {
        setFopAttribute("break-after", breakAfter);
    }

    public void setBreakBefore(String breakBefore) {
        setFopAttribute("break-before", breakBefore);
    }

    public void setCaptionSide(String captionSide) {
        setFopAttribute("caption-side", captionSide);
    }

    public void setCaseName(String caseName) {
        setFopAttribute("case-name", caseName);
    }

    public void setCaseTitle(String caseTitle) {
        setFopAttribute("case-title", caseTitle);
    }

    public void setChangeBarClass(String changeBarClass) {
        setFopAttribute("change-bar-class", changeBarClass);
    }

    public void setChangeBarColor(String changeBarColor) {
        setFopAttribute("change-bar-color", changeBarColor);
    }

    public void setChangeBarOffset(String changeBarOffset) {
        setFopAttribute("change-bar-offset", changeBarOffset);
    }

    public void setChangeBarPlacement(String changeBarPlacement) {
        setFopAttribute("change-bar-placement", changeBarPlacement);
    }

    public void setChangeBarStyle(String changeBarStyle) {
        setFopAttribute("change-bar-style", changeBarStyle);
    }

    public void setChangeBarWidth(String changeBarWidth) {
        setFopAttribute("change-bar-width", changeBarWidth);
    }

    public void setCharacter(String character) {
        setFopAttribute("character", character);
    }

    public void setClear(String clear) {
        setFopAttribute("clear", clear);
    }

    public void setClip(String clip) {
        setFopAttribute("clip", clip);
    }

    public void setColor(String color) {
        setFopAttribute("color", color);
    }

    public void setColorProfileName(String colorProfileName) {
        setFopAttribute("color-profile-name", colorProfileName);
    }

    public void setColumnCount(String columnCount) {
        setFopAttribute("column-count", columnCount);
    }

    public void setColumnGap(String columnGap) {
        setFopAttribute("column-gap", columnGap);
    }

    public void setColumnNumber(String columnNumber) {
        setFopAttribute("column-number", columnNumber);
    }

    public void setColumnWidth(String columnWidth) {
        setFopAttribute("column-width", columnWidth);
    }

    public void setContentHeight(String contentHeight) {
        setFopAttribute("content-height", contentHeight);
    }

    public void setContentType(String contentType) {
        setFopAttribute("content-type", contentType);
    }

    public void setContentWidth(String contentWidth) {
        setFopAttribute("content-width", contentWidth);
    }

    public void setCountry(String country) {
        setFopAttribute("country", country);
    }

    public void setCue(String cue) {
        setFopAttribute("cue", cue);
    }

    public void setCueAfter(String cueAfter) {
        setFopAttribute("cue-after", cueAfter);
    }

    public void setCueBefore(String cueBefore) {
        setFopAttribute("cue-before", cueBefore);
    }

    public void setDestinationPlacementOffset(String destinationPlacementOffset) {
        setFopAttribute("destination-placement-offset", destinationPlacementOffset);
    }

    public void setDirection(String direction) {
        setFopAttribute("direction", direction);
    }

    public void setDisplayAlign(String displayAlign) {
        setFopAttribute("display-align", displayAlign);
    }

    public void setDominantBaseline(String dominantBaseline) {
        setFopAttribute("dominant-baseline", dominantBaseline);
    }

    public void setElevation(String elevation) {
        setFopAttribute("elevation", elevation);
    }

    public void setEmptyCells(String emptyCells) {
        setFopAttribute("empty-cells", emptyCells);
    }

    public void setEndIndent(String endIndent) {
        setFopAttribute("end-indent", endIndent);
    }

    public void setEndsRow(String endsRow) {
        setFopAttribute("ends-row", endsRow);
    }

    public void setExtent(String extent) {
        setFopAttribute("extent", extent);
    }

    public void setExternalDestination(String externalDestination) {
        setFopAttribute("external-destination", externalDestination);
    }
    
    public void setFloat(String floatt) {
        setFopAttribute("float", floatt);
    }

    public void setFlowMapName(String flowMapName) {
        setFopAttribute("flow-map-name", flowMapName);
    }

    public void setFlowMapReference(String flowMapReference) {
        setFopAttribute("flow-map-reference", flowMapReference);
    }

    public void setFlowName(String flowName) {
        setFopAttribute("flow-name", flowName);
    }

    public void setFlowNameReference(String flowNameReference) {
        setFopAttribute("flow-name-reference", flowNameReference);
    }

    public void setFont(String font) {
        setFopAttribute("font", font);
    }

    public void setFontFamily(String fontFamily) {
        setFopAttribute("font-family", fontFamily);
    }

    public void setFontSelectionStrategy(String fontSelectionStrategy) {
        setFopAttribute("font-selection-strategy", fontSelectionStrategy);
    }

    public void setFontSize(String fontSize) {
        setFopAttribute("font-size", fontSize);
    }

    public void setFontSizeAdjust(String fontSizeAdjust) {
        setFopAttribute("font-size-adjust", fontSizeAdjust);
    }

    public void setFontStretch(String fontStretch) {
        setFopAttribute("font-stretch", fontStretch);
    }

    public void setFontStyle(String fontStyle) {
        setFopAttribute("font-style", fontStyle);
    }

    public void setFontVariant(String fontVariant) {
        setFopAttribute("font-variant", fontVariant);
    }

    public void setFontWeight(String fontWeight) {
        setFopAttribute("font-weight", fontWeight);
    }

    public void setForcePageCount(String forcePageCount) {
        setFopAttribute("force-page-count", forcePageCount);
    }

    public void setFormat(String format) {
        setFopAttribute("format", format);
    }

    public void setGlyphOrientationHorizontal(String glyphOrientationHorizontal) {
        setFopAttribute("glyph-orientation-horizontal", glyphOrientationHorizontal);
    }

    public void setGlyphOrientationVertical(String glyphOrientationVertical) {
        setFopAttribute("glyph-orientation-vertical", glyphOrientationVertical);
    }

    public void setGroupingSeparator(String groupingSeparator) {
        setFopAttribute("grouping-separator", groupingSeparator);
    }
    
    public void setGroupingSize(String groupingSize) {
        setFopAttribute("grouping-size", groupingSize);
    }

    public void setHeight(String height) {
        setFopAttribute("height", height);
    }

    public void setHyphenate(String hyphenate) {
        setFopAttribute("hyphenate", hyphenate);
    }

    public void setHyphenationCharacter(String hyphenationCharacter) {
        setFopAttribute("hyphenation-character", hyphenationCharacter);
    }

    public void setHyphenationKeep(String hyphenationKeep) {
        setFopAttribute("hyphenation-keep", hyphenationKeep);
    }

    public void setHyphenationLadderCount(String hyphenationLadderCount) {
        setFopAttribute("hyphenation-ladder-count", hyphenationLadderCount);
    }

    public void setHyphenationPushCharacterCount(String hyphenationPushCharacterCount) {
        setFopAttribute("hyphenation-push-character-count", hyphenationPushCharacterCount);
    }

    public void setHyphenationRemainCharacterCount(String hyphenationRemainCharacterCount) {
        setFopAttribute("hyphenation-remain-character-count", hyphenationRemainCharacterCount);
    }

    public void setId(String id) {
        setFopAttribute("id", id);
    }

    public void setIndexClass(String indexClass) {
        setFopAttribute("index-class", indexClass);
    }

    public void setIndexKey(String indexKey) {
        setFopAttribute("index-key", indexKey);
    }

    public void setIndicateDestination(String indicateDestination) {
        setFopAttribute("indicate-destination", indicateDestination);
    }

    public void setInitialPageNumber(String initialPageNumber) {
        setFopAttribute("initial-page-number", initialPageNumber);
    }

    public void setInlineProgressionDimension(String inlineProgressionDimension) {
        setFopAttribute("inline-progression-dimension", inlineProgressionDimension);
    }

    public void setInternalDestination(String internalDestination) {
        setFopAttribute("internal-destination", internalDestination);
    }

    public void setIntrinsicScaleValue(String intrinsicScaleValue) {
        setFopAttribute("intrinsic-scale-value", intrinsicScaleValue);
    }
    
    public void setIntrusionDisplace(String intrusionDisplace) {
        setFopAttribute("intrusion-displace", intrusionDisplace);
    }

    public void setKeepTogether(String keepTogether) {
        setFopAttribute("keep-together", keepTogether);
    }

    public void setKeepTogetherWithinColumn(String keepTogetherWithinColumn) {
        setFopAttribute("keep-together.within-column", keepTogetherWithinColumn);
    }

    public void setKeepTogetherWithinLine(String keepTogetherWithinLine) {
        setFopAttribute("keep-together.within-line", keepTogetherWithinLine);
    }

    public void setKeepTogetherWithinPage(String keepTogetherWithinPage) {
        setFopAttribute("keep-together.within-page", keepTogetherWithinPage);
    }

    public void setKeepWithNext(String keepWithNext) {
        setFopAttribute("keep-with-next", keepWithNext);
    }

    public void setKeepWithNextWithinColumn(String keepWithNextWithinColumn) {
        setFopAttribute("keep-with-next.within-column", keepWithNextWithinColumn);
    }

    public void setKeepWithNextWithinLine(String keepWithNextWithinLine) {
        setFopAttribute("keep-with-next.within-line", keepWithNextWithinLine);
    }

    public void setKeepWithNextWithinPage(String keepWithNextWithinPage) {
        setFopAttribute("keep-with-next.within-page", keepWithNextWithinPage);
    }

    public void setKeepWithPrevious(String keepWithPrevious) {
        setFopAttribute("keep-with-previous", keepWithPrevious);
    }

    public void setKeepWithPreviousWithinColumn(String keepWithPreviousWithinColumn) {
        setFopAttribute("keep-with-previous.within-column", keepWithPreviousWithinColumn);
    }

    public void setKeepWithPreviousWithinLine(String keepWithPreviousWithinLine) {
        setFopAttribute("keep-with-previous.within-line", keepWithPreviousWithinLine);
    }

    public void setKeepWithPreviousWithinPage(String keepWithPreviousWithinPage) {
        setFopAttribute("keep-with-previous.within-page", keepWithPreviousWithinPage);
    }

    public void setLanguage(String language) {
        setFopAttribute("language", language);
    }

    public void setLastLineEndIndent(String lastLineEndIndent) {
        setFopAttribute("last-line-end-indent", lastLineEndIndent);
    }

    public void setLeaderAlignment(String leaderAlignment) {
        setFopAttribute("leader-alignment", leaderAlignment);
    }

    public void setLeaderLength(String leaderLength) {
        setFopAttribute("leader-length", leaderLength);
    }

    public void setLeaderLengthMaximum(String leaderLengthMaximum) {
        setFopAttribute("leader-length.maximum", leaderLengthMaximum);
    }

    public void setLeaderLengthMinimum(String leaderLengthMinimum) {
        setFopAttribute("leader-length.minimum", leaderLengthMinimum);
    }

    public void setLeaderLengthOptimum(String leaderLengthOptimum) {
        setFopAttribute("leader-length.optimum", leaderLengthOptimum);
    }

    public void setLeaderPattern(String leaderPattern) {
        setFopAttribute("leader-pattern", leaderPattern);
    }

    public void setLeaderPatternWidth(String leaderPatternWidth) {
        setFopAttribute("leader-pattern-width", leaderPatternWidth);
    }

    public void setLeft(String left) {
        setFopAttribute("left", left);
    }

    public void setLetterSpacing(String letterSpacing) {
        setFopAttribute("letter-spacing", letterSpacing);
    }

    public void setLetterValue(String letterValue) {
        setFopAttribute("letter-value", letterValue);
    }

    public void setLineHeight(String lineHeight) {
        setFopAttribute("line-height", lineHeight);
    }

    public void setLineHeightShiftAdjustment(String lineHeightShiftAdjustment) {
        setFopAttribute("line-height-shift-adjustment", lineHeightShiftAdjustment);
    }

    public void setLineStackingStrategy(String lineStackingStrategy) {
        setFopAttribute("line-stacking-strategy", lineStackingStrategy);
    }

    public void setLinefeedTreatment(String linefeedTreatment) {
        setFopAttribute("linefeed-treatment", linefeedTreatment);
    }

    public void setMargin(String margin) {
        setFopAttribute("margin", margin);
    }

    public void setMarginBottom(String marginBottom) {
        setFopAttribute("margin-bottom", marginBottom);
    }

    public void setMarginLeft(String marginLeft) {
        setFopAttribute("margin-left", marginLeft);
    }

    public void setMarginRight(String marginRight) {
        setFopAttribute("margin-right", marginRight);
    }

    public void setMarginTop(String marginTop) {
        setFopAttribute("margin-top", marginTop);
    }

    public void setMarkerClassName(String markerClassName) {
        setFopAttribute("marker-class-name", markerClassName);
    }

    public void setMasterName(String masterName) {
        setFopAttribute("master-name", masterName);
    }

    public void setMasterReference(String masterReference) {
        setFopAttribute("master-reference", masterReference);
    }

    public void setMaxHeight(String maxHeight) {
        setFopAttribute("max-height", maxHeight);
    }

    public void setMaxWidth(String maxWidth) {
        setFopAttribute("max-width", maxWidth);
    }

    public void setMaximumRepeats(String maximumRepeats) {
        setFopAttribute("maximum-repeats", maximumRepeats);
    }

    public void setMediaUsage(String mediaUsage) {
        setFopAttribute("media-usage", mediaUsage);
    }

    public void setMergePagesAcrossIndexKeyReferences(String mergePagesAcrossIndexKeyReferences) {
        setFopAttribute("merge-pages-across-index-key-references", mergePagesAcrossIndexKeyReferences);
    }

    public void setMergeRangesAcrossIndexKeyReferences(String mergeRangesAcrossIndexKeyReferences) {
        setFopAttribute("merge-ranges-across-index-key-references", mergeRangesAcrossIndexKeyReferences);
    }

    public void setMergeSequentialPageNumbers(String mergeSequentialPageNumbers) {
        setFopAttribute("merge-sequential-page-numbers", mergeSequentialPageNumbers);
    }

    public void setMinHeight(String minHeight) {
        setFopAttribute("min-height", minHeight);
    }

    public void setMinWidth(String minWidth) {
        setFopAttribute("min-width", minWidth);
    }

    public void setNumberColumnsRepeated(String numberColumnsRepeated) {
        setFopAttribute("number-columns-repeated", numberColumnsRepeated);
    }

    public void setNumberColumnsSpanned(String numberColumnsSpanned) {
        setFopAttribute("number-columns-spanned", numberColumnsSpanned);
    }

    public void setNumberRowsSpanned(String numberRowsSpanned) {
        setFopAttribute("number-rows-spanned", numberRowsSpanned);
    }

    public void setOddOrEven(String oddOrEven) {
        setFopAttribute("odd-or-even", oddOrEven);
    }

    public void setOrphans(String orphans) {
        setFopAttribute("orphans", orphans);
    }

    public void setOverflow(String overflow) {
        setFopAttribute("overflow", overflow);
    }

    public void setPadding(String padding) {
        setFopAttribute("padding", padding);
    }

    public void setPaddingAfter(String paddingAfter) {
        setFopAttribute("padding-after", paddingAfter);
    }

    public void setPaddingBefore(String paddingBefore) {
        setFopAttribute("padding-before", paddingBefore);
    }

    public void setPaddingBottom(String paddingBottom) {
        setFopAttribute("padding-bottom", paddingBottom);
    }

    public void setPaddingEnd(String paddingEnd) {
        setFopAttribute("padding-end", paddingEnd);
    }

    public void setPaddingLeft(String paddingLeft) {
        setFopAttribute("padding-left", paddingLeft);
    }

    public void setPaddingRight(String paddingRight) {
        setFopAttribute("padding-right", paddingRight);
    }

    public void setPaddingStart(String paddingStart) {
        setFopAttribute("padding-start", paddingStart);
    }

    public void setPaddingTop(String paddingTop) {
        setFopAttribute("padding-top", paddingTop);
    }

    public void setPageBreakAfter(String pageBreakAfter) {
        setFopAttribute("page-break-after", pageBreakAfter);
    }

    public void setPageBreakBefore(String pageBreakBefore) {
        setFopAttribute("page-break-before", pageBreakBefore);
    }

    public void setPageBreakInside(String pageBreakInside) {
        setFopAttribute("page-break-inside", pageBreakInside);
    }

    public void setPageCitationStrategy(String pageCitationStrategy) {
        setFopAttribute("page-citation-strategy", pageCitationStrategy);
    }

    public void setPageHeight(String pageHeight) {
        setFopAttribute("page-height", pageHeight);
    }

    public void setPageNumberTreatment(String pageNumberTreatment) {
        setFopAttribute("page-number-treatment", pageNumberTreatment);
    }

    public void setPagePosition(String pagePosition) {
        setFopAttribute("page-position", pagePosition);
    }

    public void setPageWidth(String pageWidth) {
        setFopAttribute("page-width", pageWidth);
    }

    public void setPause(String pause) {
        setFopAttribute("pause", pause);
    }

    public void setPauseAfter(String pauseAfter) {
        setFopAttribute("pause-after", pauseAfter);
    }

    public void setPauseBefore(String pauseBefore) {
        setFopAttribute("pause-before", pauseBefore);
    }

    public void setPitch(String pitch) {
        setFopAttribute("pitch", pitch);
    }

    public void setPitchRange(String pitchRange) {
        setFopAttribute("pitch-range", pitchRange);
    }

    public void setPlayDuring(String playDuring) {
        setFopAttribute("play-during", playDuring);
    }

    public void setPosition(String position) {
        setFopAttribute("position", position);
    }

    public void setPrecedence(String precedence) {
        setFopAttribute("precedence", precedence);
    }

    public void setProvisionalDistanceBetweenStarts(String provisionalDistanceBetweenStarts) {
        setFopAttribute("provisional-distance-between-starts", provisionalDistanceBetweenStarts);
    }

    public void setProvisionalLabelSeparation(String provisionalLabelSeparation) {
        setFopAttribute("provisional-label-separation", provisionalLabelSeparation);
    }

    public void setRefId(String refId) {
        setFopAttribute("ref-id", refId);
    }

    public void setRefIndexKey(String refIndexKey) {
        setFopAttribute("ref-index-key", refIndexKey);
    }

    public void setReferenceOrientation(String referenceOrientation) {
        setFopAttribute("reference-orientation", referenceOrientation);
    }

    public void setRegionName(String regionName) {
        setFopAttribute("region-name", regionName);
    }

    public void setRegionNameReference(String regionNameReference) {
        setFopAttribute("region-name-reference", regionNameReference);
    }

    public void setRelativeAlign(String relativeAlign) {
        setFopAttribute("relative-align", relativeAlign);
    }

    public void setRelativePosition(String relativePosition) {
        setFopAttribute("relative-position", relativePosition);
    }

    public void setRenderingIntent(String renderingIntent) {
        setFopAttribute("rendering-intent", renderingIntent);
    }

    public void setRetrieveBoundary(String retrieveBoundary) {
        setFopAttribute("retrieve-boundary", retrieveBoundary);
    }

    public void setRetrieveBoundaryWithinTable(String retrieveBoundaryWithinTable) {
        setFopAttribute("retrieve-boundary-within-table", retrieveBoundaryWithinTable);
    }

    public void setRetrieveClassName(String retrieveClassName) {
        setFopAttribute("retrieve-class-name", retrieveClassName);
    }

    public void setRetrievePosition(String retrievePosition) {
        setFopAttribute("retrieve-position", retrievePosition);
    }

    public void setRetrievePositionWithinTable(String retrievePositionWithinTable) {
        setFopAttribute("retrieve-position-within-table", retrievePositionWithinTable);
    }

    public void setRichness(String richness) {
        setFopAttribute("richness", richness);
    }

    public void setRight(String right) {
        setFopAttribute("right", right);
    }

    public void setRole(String role) {
        setFopAttribute("role", role);
    }

    public void setRuleStyle(String ruleStyle) {
        setFopAttribute("rule-style", ruleStyle);
    }

    public void setRuleThickness(String ruleThickness) {
        setFopAttribute("rule-thickness", ruleThickness);
    }

    public void setScaleOption(String scaleOption) {
        setFopAttribute("scale-option", scaleOption);
    }

    public void setScaling(String scaling) {
        setFopAttribute("scaling", scaling);
    }

    public void setScalingMethod(String scalingMethod) {
        setFopAttribute("scaling-method", scalingMethod);
    }

    public void setScoreSpaces(String scoreSpaces) {
        setFopAttribute("score-spaces", scoreSpaces);
    }

    public void setScript(String script) {
        setFopAttribute("script", script);
    }

    public void setShowDestination(String showDestination) {
        setFopAttribute("show-destination", showDestination);
    }

    public void setSize(String size) {
        setFopAttribute("size", size);
    }

    public void setSourceDocument(String sourceDocument) {
        setFopAttribute("source-document", sourceDocument);
    }

    public void setSpaceAfter(String spaceAfter) {
        setFopAttribute("space-after", spaceAfter);
    }

    public void setSpaceAfterConditionality(String spaceAfterConditionality) {
        setFopAttribute("space-after.conditionality", spaceAfterConditionality);
    }

    public void setSpaceAfterMaximum(String spaceAfterMaximum) {
        setFopAttribute("space-after.maximum", spaceAfterMaximum);
    }

    public void setSpaceAfterMinimum(String spaceAfterMinimum) {
        setFopAttribute("space-after.minimum", spaceAfterMinimum);
    }

    public void setSpaceAfterOptimum(String spaceAfterOptimum) {
        setFopAttribute("space-after.optimum", spaceAfterOptimum);
    }

    public void setSpaceAfterPrecedence(String spaceAfterPrecedence) {
        setFopAttribute("space-after.precedence", spaceAfterPrecedence);
    }

    public void setSpaceBefore(String spaceBefore) {
        setFopAttribute("space-before", spaceBefore);
    }

    public void setSpaceBeforeConditionality(String spaceBeforeConditionality) {
        setFopAttribute("space-before.conditionality", spaceBeforeConditionality);
    }

    public void setSpaceBeforeMaximum(String spaceBeforeMaximum) {
        setFopAttribute("space-before.maximum", spaceBeforeMaximum);
    }

    public void setSpaceBeforeMinimum(String spaceBeforeMinimum) {
        setFopAttribute("space-before.minimum", spaceBeforeMinimum);
    }

    public void setSpaceBeforeOptimum(String spaceBeforeOptimum) {
        setFopAttribute("space-before.optimum", spaceBeforeOptimum);
    }

    public void setSpaceBeforePrecedence(String spaceBeforePrecedence) {
        setFopAttribute("space-before.precedence", spaceBeforePrecedence);
    }

    public void setSpaceEnd(String spaceEnd) {
        setFopAttribute("space-end", spaceEnd);
    }

    public void setSpaceEndConditionality(String spaceEndConditionality) {
        setFopAttribute("space-end.conditionality", spaceEndConditionality);
    }

    public void setSpaceEndMaximum(String spaceEndMaximum) {
        setFopAttribute("space-end.maximum", spaceEndMaximum);
    }

    public void setSpaceEndMinimum(String spaceEndMinimum) {
        setFopAttribute("space-end.minimum", spaceEndMinimum);
    }

    public void setSpaceEndOptimum(String spaceEndOptimum) {
        setFopAttribute("space-end.optimum", spaceEndOptimum);
    }

    public void setSpaceEndPrecedence(String spaceEndPrecedence) {
        setFopAttribute("space-end.precedence", spaceEndPrecedence);
    }

    public void setSpaceStart(String spaceStart) {
        setFopAttribute("space-start", spaceStart);
    }

    public void setSpaceStartConditionality(String spaceStartConditionality) {
        setFopAttribute("space-start.conditionality", spaceStartConditionality);
    }

    public void setSpaceStartMaximum(String spaceStartMaximum) {
        setFopAttribute("space-start.maximum", spaceStartMaximum);
    }

    public void setSpaceStartMinimum(String spaceStartMinimum) {
        setFopAttribute("space-start.minimum", spaceStartMinimum);
    }

    public void setSpaceStartOptimum(String spaceStartOptimum) {
        setFopAttribute("space-start.optimum", spaceStartOptimum);
    }

    public void setSpaceStartPrecedence(String spaceStartPrecedence) {
        setFopAttribute("space-start.precedence", spaceStartPrecedence);
    }

    public void setSpan(String span) {
        setFopAttribute("span", span);
    }

    public void setSpeak(String speak) {
        setFopAttribute("speak", speak);
    }

    public void setSpeakHeader(String speakHeader) {
        setFopAttribute("speak-header", speakHeader);
    }

    public void setSpeakNumeral(String speakNumeral) {
        setFopAttribute("speak-numeral", speakNumeral);
    }

    public void setSpeakPunctuation(String speakPunctuation) {
        setFopAttribute("speak-punctuation", speakPunctuation);
    }

    public void setSpeechRate(String speechRate) {
        setFopAttribute("speech-rate", speechRate);
    }

    public void setSrc(String src) {
        setFopAttribute("src", src);
    }

    public void setStartIndent(String startIndent) {
        setFopAttribute("start-indent", startIndent);
    }

    public void setStartingState(String startingState) {
        setFopAttribute("starting-state", startingState);
    }

    public void setStartsRow(String startsRow) {
        setFopAttribute("starts-row", startsRow);
    }

    public void setStress(String stress) {
        setFopAttribute("stress", stress);
    }

    public void setSuppressAtLineBreak(String suppressAtLineBreak) {
        setFopAttribute("suppress-at-line-break", suppressAtLineBreak);
    }

    public void setSwitchTo(String switchTo) {
        setFopAttribute("switch-to", switchTo);
    }

    public void setTableLayout(String tableLayout) {
        setFopAttribute("table-layout", tableLayout);
    }

    public void setTableOmitFooterAtBreak(String tableOmitFooterAtBreak) {
        setFopAttribute("table-omit-footer-at-break", tableOmitFooterAtBreak);
    }

    public void setTableOmitHeaderAtBreak(String tableOmitHeaderAtBreak) {
        setFopAttribute("table-omit-header-at-break", tableOmitHeaderAtBreak);
    }

    public void setTargetPresentationContext(String targetPresentationContext) {
        setFopAttribute("target-presentation-context", targetPresentationContext);
    }

    public void setTargetProcessingContext(String targetProcessingContext) {
        setFopAttribute("target-processing-context", targetProcessingContext);
    }

    public void setTargetStylesheet(String targetStylesheet) {
        setFopAttribute("target-stylesheet", targetStylesheet);
    }

    public void setTextAlign(String textAlign) {
        setFopAttribute("text-align", textAlign);
    }

    public void setTextAlignLast(String textAlignLast) {
        setFopAttribute("text-align-last", textAlignLast);
    }

    public void setTextAltitude(String textAltitude) {
        setFopAttribute("text-altitude", textAltitude);
    }

    public void setTextDecoration(String textDecoration) {
        setFopAttribute("text-decoration", textDecoration);
    }

    public void setTextDepth(String textDepth) {
        setFopAttribute("text-depth", textDepth);
    }

    public void setTextIndent(String textIndent) {
        setFopAttribute("text-indent", textIndent);
    }

    public void setTextShadow(String textShadow) {
        setFopAttribute("text-shadow", textShadow);
    }

    public void setTextTransform(String textTransform) {
        setFopAttribute("text-transform", textTransform);
    }

    public void setTop(String top) {
        setFopAttribute("top", top);
    }

    public void setTreatAsWordSpace(String treatAsWordSpace) {
        setFopAttribute("treat-as-word-space", treatAsWordSpace);
    }

    public void setUnicodeBidi(String unicodeBidi) {
        setFopAttribute("unicode-bidi", unicodeBidi);
    }

    public void setVerticalAlign(String verticalAlign) {
        setFopAttribute("vertical-align", verticalAlign);
    }

    public void setVisibility(String visibility) {
        setFopAttribute("visibility", visibility);
    }

    public void setVoiceFamily(String voiceFamily) {
        setFopAttribute("voice-family", voiceFamily);
    }

    public void setVolume(String volume) {
        setFopAttribute("volume", volume);
    }

    public void setWhiteSpace(String whiteSpace) {
        setFopAttribute("white-space", whiteSpace);
    }

    public void setWhiteSpaceCollapse(String whiteSpaceCollapse) {
        setFopAttribute("white-space-collapse", whiteSpaceCollapse);
    }

    public void setWhiteSpaceTreatment(String whiteSpaceTreatment) {
        setFopAttribute("white-space-treatment", whiteSpaceTreatment);
    }

    public void setWidows(String widows) {
        setFopAttribute("widows", widows);
    }

    public void setWidth(String width) {
        setFopAttribute("width", width);
    }

    public void setWordSpacing(String wordSpacing) {
        setFopAttribute("word-spacing", wordSpacing);
    }

    public void setWrapOption(String wrapOption) {
        setFopAttribute("wrap-option", wrapOption);
    }

    public void setWritingMode(String writingMode) {
        setFopAttribute("writing-mode", writingMode);
    }

    public void setZIndex(String zIndex) {
        setFopAttribute("z-index", zIndex);
    }
    
}
