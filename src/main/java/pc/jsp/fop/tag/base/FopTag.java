/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.jsp.fop.tag.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author Pavle
 */
public abstract class FopTag implements Tag {
    
    protected PageContext pageContext;
    
    private Tag parent;
    
    private final Map<String, String> attributes;
    
    public abstract boolean isEmpty();
    
    public abstract String getName();
    
    private boolean rendered;
       
    public FopTag() {
        this.attributes = new HashMap<>();       
    }
    
    public final String getAttribute(String key) {
        return attributes.get(key);
    }
    
    protected void print(String value) throws JspException {
        try {
            pageContext.getOut().print(value);
        }
        catch (IOException e) {
            throw new JspException(e);
        }
    }
    
    protected void printAttributes() throws JspException {
        for (Map.Entry entry: attributes.entrySet())
            print(" "+entry.getKey()+"=\""+entry.getValue()+"\"");
    }

    @Override
    public int doStartTag() throws JspException {
        
        if (!rendered)
            return SKIP_BODY;
        print("<"+getName());
        printAttributes();
        if (isEmpty()) {
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
        if (!isEmpty())
            print("</"+getName()+">");
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
        attributes.clear();
        initAttributes();
    }
    
    protected void initAttributes() {}
    
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

    public void setAbsolutePosition(String absolutePosition) {
        attributes.put("absolute-position", absolutePosition);
    }

    public void setActiveState(String activeState) {
        attributes.put("active-state", activeState);
    }

    public void setAlignmentAdjust(String alignmentAdjust) {
        attributes.put("alignment-adjust", alignmentAdjust);
    }

    public void setAlignmentBaseline(String alignmentBaseline) {
        attributes.put("alignment-baseline", alignmentBaseline);
    }

    public void setAllowedHeightScale(String allowedHeightScale) {
        attributes.put("allowed-height-scale", allowedHeightScale);
    }

    public void setAllowedWidthScale(String allowedWidthScale) {
        attributes.put("allowed-width-scale", allowedWidthScale);
    }

    public void setAutoRestore(String autoRestore) {
        attributes.put("auto-restore", autoRestore);
    }

    public void setAzimuth(String azimuth) {
        attributes.put("azimuth", azimuth);
    }

    public void setBackground(String background) {
        attributes.put("background", background);
    }

    public void setBackgroundAttachment(String backgroundAttachment) {
        attributes.put("background-attachment", backgroundAttachment);
    }

    public void setBackgroundColor(String backgroundColor) {
        attributes.put("background-color", backgroundColor);
    }

    public void setBackgroundImage(String backgroundImage) {
        attributes.put("background-image", backgroundImage);
    }

    public void setBackgroundPosition(String backgroundPosition) {
        attributes.put("background-position", backgroundPosition);
    }

    public void setBackgroundPositionHorizontal(String backgroundPositionHorizontal) {
        attributes.put("background-position-horizontal", backgroundPositionHorizontal);
    }

    public void setBackgroundPositionVertical(String backgroundPositionVertical) {
        attributes.put("background-position-vertical", backgroundPositionVertical);
    }

    public void setBackgroundRepeat(String backgroundRepeat) {
        attributes.put("background-repeat", backgroundRepeat);
    }

    public void setBaselineShift(String baselineShift) {
        attributes.put("baseline-shift", baselineShift);
    }

    public void setBlankOrNotBlank(String blankOrNotBlank) {
        attributes.put("blank-or-not-blank", blankOrNotBlank);
    }

    public void setBlockProgressionDimension(String blockProgressionDimension) {
        attributes.put("block-progression-dimension", blockProgressionDimension);
    }

    public void setBorder(String border) {
        attributes.put("border", border);
    }

    public void setBorderAfterColor(String borderAfterColor) {
        attributes.put("border-after-color", borderAfterColor);
    }

    public void setBorderAfterPrecedence(String borderAfterPrecedence) {
        attributes.put("border-after-precedence", borderAfterPrecedence);
    }

    public void setBorderAfterStyle(String borderAfterStyle) {
        attributes.put("border-after-style", borderAfterStyle);
    }

    public void setBorderAfterWidth(String borderAfterWidth) {
        attributes.put("border-after-width", borderAfterWidth);
    }

    public void setBorderBeforeColor(String borderBeforeColor) {
        attributes.put("border-before-color", borderBeforeColor);
    }

    public void setBorderBeforePrecedence(String borderBeforePrecedence) {
        attributes.put("border-before-precedence", borderBeforePrecedence);
    }

    public void setBorderBeforeStyle(String borderBeforeStyle) {
        attributes.put("border-before-style", borderBeforeStyle);
    }

    public void setBorderBeforeWidth(String borderBeforeWidth) {
        attributes.put("border-before-width", borderBeforeWidth);
    }

    public void setBorderBottom(String borderBottom) {
        attributes.put("border-bottom", borderBottom);
    }

    public void setBorderBottomColor(String borderBottomColor) {
        attributes.put("border-bottom-color", borderBottomColor);
    }

    public void setBorderBottomStyle(String borderBottomStyle) {
        attributes.put("border-bottom-style", borderBottomStyle);
    }

    public void setBorderBottomWidth(String borderBottomWidth) {
        attributes.put("border-bottom-width", borderBottomWidth);
    }

    public void setBorderCollapse(String borderCollapse) {
        attributes.put("border-collapse", borderCollapse);
    }

    public void setBorderColor(String borderColor) {
        attributes.put("border-color", borderColor);
    }

    public void setBorderEndColor(String borderEndColor) {
        attributes.put("border-end-color", borderEndColor);
    }

    public void setBorderEndPrecedence(String borderEndPrecedence) {
        attributes.put("border-end-precedence", borderEndPrecedence);
    }

    public void setBorderEndStyle(String borderEndStyle) {
        attributes.put("border-end-style", borderEndStyle);
    }

    public void setBorderEndWidth(String borderEndWidth) {
        attributes.put("border-end-width", borderEndWidth);
    }

    public void setBorderLeft(String borderLeft) {
        attributes.put("border-left", borderLeft);
    }

    public void setBorderLeftColor(String borderLeftColor) {
        attributes.put("border-left-color", borderLeftColor);
    }

    public void setBorderLeftStyle(String borderLeftStyle) {
        attributes.put("border-left-style", borderLeftStyle);
    }

    public void setBorderLeftWidth(String borderLeftWidth) {
        attributes.put("border-left-width", borderLeftWidth);
    }

    public void setBorderRight(String borderRight) {
        attributes.put("border-right", borderRight);
    }

    public void setBorderRightColor(String borderRightColor) {
        attributes.put("border-right-color", borderRightColor);
    }

    public void setBorderRightStyle(String borderRightStyle) {
        attributes.put("border-right-style", borderRightStyle);
    }

    public void setBorderRightWidth(String borderRightWidth) {
        attributes.put("border-right-width", borderRightWidth);
    }

    public void setBorderSeparation(String borderSeparation) {
        attributes.put("border-separation", borderSeparation);
    }

    public void setBorderSeparationBlockProgressionDirection(String borderSeparationBlockProgressionDirection) {
        attributes.put("border-separation.block-progression-direction", borderSeparationBlockProgressionDirection);
    }

    public void setBorderSeparationInlineProgressionDirection(String borderSeparationInlineProgressionDirection) {
        attributes.put("border-separation.inline-progression-direction", borderSeparationInlineProgressionDirection);
    }

    public void setBorderSpacing(String borderSpacing) {
        attributes.put("border-spacing", borderSpacing);
    }

    public void setBorderStartColor(String borderStartColor) {
        attributes.put("border-start-color", borderStartColor);
    }

    public void setBorderStartPrecedence(String borderStartPrecedence) {
        attributes.put("border-start-precedence", borderStartPrecedence);
    }

    public void setBorderStartStyle(String borderStartStyle) {
        attributes.put("border-start-style", borderStartStyle);
    }

    public void setBorderStartWidth(String borderStartWidth) {
        attributes.put("border-start-width", borderStartWidth);
    }

    public void setBorderStyle(String borderStyle) {
        attributes.put("border-style", borderStyle);
    }

    public void setBorderTop(String borderTop) {
        attributes.put("border-top", borderTop);
    }

    public void setBorderTopColor(String borderTopColor) {
        attributes.put("border-top-color", borderTopColor);
    }

    public void setBorderTopStyle(String borderTopStyle) {
        attributes.put("border-top-style", borderTopStyle);
    }

    public void setBorderTopWidth(String borderTopWidth) {
        attributes.put("border-top-width", borderTopWidth);
    }

    public void setBorderWidth(String borderWidth) {
        attributes.put("border-width", borderWidth);
    }

    public void setBottom(String bottom) {
        attributes.put("bottom", bottom);
    }

    public void setBreakAfter(String breakAfter) {
        attributes.put("break-after", breakAfter);
    }

    public void setBreakBefore(String breakBefore) {
        attributes.put("break-before", breakBefore);
    }

    public void setCaptionSide(String captionSide) {
        attributes.put("caption-side", captionSide);
    }

    public void setCaseName(String caseName) {
        attributes.put("case-name", caseName);
    }

    public void setCaseTitle(String caseTitle) {
        attributes.put("case-title", caseTitle);
    }

    public void setChangeBarClass(String changeBarClass) {
        attributes.put("change-bar-class", changeBarClass);
    }

    public void setChangeBarColor(String changeBarColor) {
        attributes.put("change-bar-color", changeBarColor);
    }

    public void setChangeBarOffset(String changeBarOffset) {
        attributes.put("change-bar-offset", changeBarOffset);
    }

    public void setChangeBarPlacement(String changeBarPlacement) {
        attributes.put("change-bar-placement", changeBarPlacement);
    }

    public void setChangeBarStyle(String changeBarStyle) {
        attributes.put("change-bar-style", changeBarStyle);
    }

    public void setChangeBarWidth(String changeBarWidth) {
        attributes.put("change-bar-width", changeBarWidth);
    }

    public void setCharacter(String character) {
        attributes.put("character", character);
    }

    public void setClear(String clear) {
        attributes.put("clear", clear);
    }

    public void setClip(String clip) {
        attributes.put("clip", clip);
    }

    public void setColor(String color) {
        attributes.put("color", color);
    }

    public void setColorProfileName(String colorProfileName) {
        attributes.put("color-profile-name", colorProfileName);
    }

    public void setColumnCount(String columnCount) {
        attributes.put("column-count", columnCount);
    }

    public void setColumnGap(String columnGap) {
        attributes.put("column-gap", columnGap);
    }

    public void setColumnNumber(String columnNumber) {
        attributes.put("column-number", columnNumber);
    }

    public void setColumnWidth(String columnWidth) {
        attributes.put("column-width", columnWidth);
    }

    public void setContentHeight(String contentHeight) {
        attributes.put("content-height", contentHeight);
    }

    public void setContentType(String contentType) {
        attributes.put("content-type", contentType);
    }

    public void setContentWidth(String contentWidth) {
        attributes.put("content-width", contentWidth);
    }

    public void setCountry(String country) {
        attributes.put("country", country);
    }

    public void setCue(String cue) {
        attributes.put("cue", cue);
    }

    public void setCueAfter(String cueAfter) {
        attributes.put("cue-after", cueAfter);
    }

    public void setCueBefore(String cueBefore) {
        attributes.put("cue-before", cueBefore);
    }

    public void setDestinationPlacementOffset(String destinationPlacementOffset) {
        attributes.put("destination-placement-offset", destinationPlacementOffset);
    }

    public void setDirection(String direction) {
        attributes.put("direction", direction);
    }

    public void setDisplayAlign(String displayAlign) {
        attributes.put("display-align", displayAlign);
    }

    public void setDominantBaseline(String dominantBaseline) {
        attributes.put("dominant-baseline", dominantBaseline);
    }

    public void setElevation(String elevation) {
        attributes.put("elevation", elevation);
    }

    public void setEmptyCells(String emptyCells) {
        attributes.put("empty-cells", emptyCells);
    }

    public void setEndIndent(String endIndent) {
        attributes.put("end-indent", endIndent);
    }

    public void setEndsRow(String endsRow) {
        attributes.put("ends-row", endsRow);
    }

    public void setExtent(String extent) {
        attributes.put("extent", extent);
    }

    public void setExternalDestination(String externalDestination) {
        attributes.put("external-destination", externalDestination);
    }
    
    public void setFloat(String floatt) {
        attributes.put("float", floatt);
    }

    public void setFlowMapName(String flowMapName) {
        attributes.put("flow-map-name", flowMapName);
    }

    public void setFlowMapReference(String flowMapReference) {
        attributes.put("flow-map-reference", flowMapReference);
    }

    public void setFlowName(String flowName) {
        attributes.put("flow-name", flowName);
    }

    public void setFlowNameReference(String flowNameReference) {
        attributes.put("flow-name-reference", flowNameReference);
    }

    public void setFont(String font) {
        attributes.put("font", font);
    }

    public void setFontFamily(String fontFamily) {
        attributes.put("font-family", fontFamily);
    }

    public void setFontSelectionStrategy(String fontSelectionStrategy) {
        attributes.put("font-selection-strategy", fontSelectionStrategy);
    }

    public void setFontSize(String fontSize) {
        attributes.put("font-size", fontSize);
    }

    public void setFontSizeAdjust(String fontSizeAdjust) {
        attributes.put("font-size-adjust", fontSizeAdjust);
    }

    public void setFontStretch(String fontStretch) {
        attributes.put("font-stretch", fontStretch);
    }

    public void setFontStyle(String fontStyle) {
        attributes.put("font-style", fontStyle);
    }

    public void setFontVariant(String fontVariant) {
        attributes.put("font-variant", fontVariant);
    }

    public void setFontWeight(String fontWeight) {
        attributes.put("font-weight", fontWeight);
    }

    public void setForcePageCount(String forcePageCount) {
        attributes.put("force-page-count", forcePageCount);
    }

    public void setFormat(String format) {
        attributes.put("format", format);
    }

    public void setGlyphOrientationHorizontal(String glyphOrientationHorizontal) {
        attributes.put("glyph-orientation-horizontal", glyphOrientationHorizontal);
    }

    public void setGlyphOrientationVertical(String glyphOrientationVertical) {
        attributes.put("glyph-orientation-vertical", glyphOrientationVertical);
    }

    public void setGroupingSeparator(String groupingSeparator) {
        attributes.put("grouping-separator", groupingSeparator);
    }
    
    public void setGroupingSize(String groupingSize) {
        attributes.put("grouping-size", groupingSize);
    }

    public void setHeight(String height) {
        attributes.put("height", height);
    }

    public void setHyphenate(String hyphenate) {
        attributes.put("hyphenate", hyphenate);
    }

    public void setHyphenationCharacter(String hyphenationCharacter) {
        attributes.put("hyphenation-character", hyphenationCharacter);
    }

    public void setHyphenationKeep(String hyphenationKeep) {
        attributes.put("hyphenation-keep", hyphenationKeep);
    }

    public void setHyphenationLadderCount(String hyphenationLadderCount) {
        attributes.put("hyphenation-ladder-count", hyphenationLadderCount);
    }

    public void setHyphenationPushCharacterCount(String hyphenationPushCharacterCount) {
        attributes.put("hyphenation-push-character-count", hyphenationPushCharacterCount);
    }

    public void setHyphenationRemainCharacterCount(String hyphenationRemainCharacterCount) {
        attributes.put("hyphenation-remain-character-count", hyphenationRemainCharacterCount);
    }

    public void setId(String id) {
        attributes.put("id", id);
    }

    public void setIndexClass(String indexClass) {
        attributes.put("index-class", indexClass);
    }

    public void setIndexKey(String indexKey) {
        attributes.put("index-key", indexKey);
    }

    public void setIndicateDestination(String indicateDestination) {
        attributes.put("indicate-destination", indicateDestination);
    }

    public void setInitialPageNumber(String initialPageNumber) {
        attributes.put("initial-page-number", initialPageNumber);
    }

    public void setInlineProgressionDimension(String inlineProgressionDimension) {
        attributes.put("inline-progression-dimension", inlineProgressionDimension);
    }

    public void setInternalDestination(String internalDestination) {
        attributes.put("internal-destination", internalDestination);
    }

    public void setIntrinsicScaleValue(String intrinsicScaleValue) {
        attributes.put("intrinsic-scale-value", intrinsicScaleValue);
    }
    
    public void setIntrusionDisplace(String intrusionDisplace) {
        attributes.put("intrusion-displace", intrusionDisplace);
    }

    public void setKeepTogether(String keepTogether) {
        attributes.put("keep-together", keepTogether);
    }

    public void setKeepTogetherWithinColumn(String keepTogetherWithinColumn) {
        attributes.put("keep-together.within-column", keepTogetherWithinColumn);
    }

    public void setKeepTogetherWithinLine(String keepTogetherWithinLine) {
        attributes.put("keep-together.within-line", keepTogetherWithinLine);
    }

    public void setKeepTogetherWithinPage(String keepTogetherWithinPage) {
        attributes.put("keep-together.within-page", keepTogetherWithinPage);
    }

    public void setKeepWithNext(String keepWithNext) {
        attributes.put("keep-with-next", keepWithNext);
    }

    public void setKeepWithNextWithinColumn(String keepWithNextWithinColumn) {
        attributes.put("keep-with-next.within-column", keepWithNextWithinColumn);
    }

    public void setKeepWithNextWithinLine(String keepWithNextWithinLine) {
        attributes.put("keep-with-next.within-line", keepWithNextWithinLine);
    }

    public void setKeepWithNextWithinPage(String keepWithNextWithinPage) {
        attributes.put("keep-with-next.within-page", keepWithNextWithinPage);
    }

    public void setKeepWithPrevious(String keepWithPrevious) {
        attributes.put("keep-with-previous", keepWithPrevious);
    }

    public void setKeepWithPreviousWithinColumn(String keepWithPreviousWithinColumn) {
        attributes.put("keep-with-previous.within-column", keepWithPreviousWithinColumn);
    }

    public void setKeepWithPreviousWithinLine(String keepWithPreviousWithinLine) {
        attributes.put("keep-with-previous.within-line", keepWithPreviousWithinLine);
    }

    public void setKeepWithPreviousWithinPage(String keepWithPreviousWithinPage) {
        attributes.put("keep-with-previous.within-page", keepWithPreviousWithinPage);
    }

    public void setLanguage(String language) {
        attributes.put("language", language);
    }

    public void setLastLineEndIndent(String lastLineEndIndent) {
        attributes.put("last-line-end-indent", lastLineEndIndent);
    }

    public void setLeaderAlignment(String leaderAlignment) {
        attributes.put("leader-alignment", leaderAlignment);
    }

    public void setLeaderLength(String leaderLength) {
        attributes.put("leader-length", leaderLength);
    }

    public void setLeaderLengthMaximum(String leaderLengthMaximum) {
        attributes.put("leader-length.maximum", leaderLengthMaximum);
    }

    public void setLeaderLengthMinimum(String leaderLengthMinimum) {
        attributes.put("leader-length.minimum", leaderLengthMinimum);
    }

    public void setLeaderLengthOptimum(String leaderLengthOptimum) {
        attributes.put("leader-length.optimum", leaderLengthOptimum);
    }

    public void setLeaderPattern(String leaderPattern) {
        attributes.put("leader-pattern", leaderPattern);
    }

    public void setLeaderPatternWidth(String leaderPatternWidth) {
        attributes.put("leader-pattern-width", leaderPatternWidth);
    }

    public void setLeft(String left) {
        attributes.put("left", left);
    }

    public void setLetterSpacing(String letterSpacing) {
        attributes.put("letter-spacing", letterSpacing);
    }

    public void setLetterValue(String letterValue) {
        attributes.put("letter-value", letterValue);
    }

    public void setLineHeight(String lineHeight) {
        attributes.put("line-height", lineHeight);
    }

    public void setLineHeightShiftAdjustment(String lineHeightShiftAdjustment) {
        attributes.put("line-height-shift-adjustment", lineHeightShiftAdjustment);
    }

    public void setLineStackingStrategy(String lineStackingStrategy) {
        attributes.put("line-stacking-strategy", lineStackingStrategy);
    }

    public void setLinefeedTreatment(String linefeedTreatment) {
        attributes.put("linefeed-treatment", linefeedTreatment);
    }

    public void setMargin(String margin) {
        attributes.put("margin", margin);
    }

    public void setMarginBottom(String marginBottom) {
        attributes.put("margin-bottom", marginBottom);
    }

    public void setMarginLeft(String marginLeft) {
        attributes.put("margin-left", marginLeft);
    }

    public void setMarginRight(String marginRight) {
        attributes.put("margin-right", marginRight);
    }

    public void setMarginTop(String marginTop) {
        attributes.put("margin-top", marginTop);
    }

    public void setMarkerClassName(String markerClassName) {
        attributes.put("marker-class-name", markerClassName);
    }

    public void setMasterName(String masterName) {
        attributes.put("master-name", masterName);
    }

    public void setMasterReference(String masterReference) {
        attributes.put("master-reference", masterReference);
    }

    public void setMaxHeight(String maxHeight) {
        attributes.put("max-height", maxHeight);
    }

    public void setMaxWidth(String maxWidth) {
        attributes.put("max-width", maxWidth);
    }

    public void setMaximumRepeats(String maximumRepeats) {
        attributes.put("maximum-repeats", maximumRepeats);
    }

    public void setMediaUsage(String mediaUsage) {
        attributes.put("media-usage", mediaUsage);
    }

    public void setMergePagesAcrossIndexKeyReferences(String mergePagesAcrossIndexKeyReferences) {
        attributes.put("merge-pages-across-index-key-references", mergePagesAcrossIndexKeyReferences);
    }

    public void setMergeRangesAcrossIndexKeyReferences(String mergeRangesAcrossIndexKeyReferences) {
        attributes.put("merge-ranges-across-index-key-references", mergeRangesAcrossIndexKeyReferences);
    }

    public void setMergeSequentialPageNumbers(String mergeSequentialPageNumbers) {
        attributes.put("merge-sequential-page-numbers", mergeSequentialPageNumbers);
    }

    public void setMinHeight(String minHeight) {
        attributes.put("min-height", minHeight);
    }

    public void setMinWidth(String minWidth) {
        attributes.put("min-width", minWidth);
    }

    public void setNumberColumnsRepeated(String numberColumnsRepeated) {
        attributes.put("number-columns-repeated", numberColumnsRepeated);
    }

    public void setNumberColumnsSpanned(String numberColumnsSpanned) {
        attributes.put("number-columns-spanned", numberColumnsSpanned);
    }

    public void setNumberRowsSpanned(String numberRowsSpanned) {
        attributes.put("number-rows-spanned", numberRowsSpanned);
    }

    public void setOddOrEven(String oddOrEven) {
        attributes.put("odd-or-even", oddOrEven);
    }

    public void setOrphans(String orphans) {
        attributes.put("orphans", orphans);
    }

    public void setOverflow(String overflow) {
        attributes.put("overflow", overflow);
    }

    public void setPadding(String padding) {
        attributes.put("padding", padding);
    }

    public void setPaddingAfter(String paddingAfter) {
        attributes.put("padding-after", paddingAfter);
    }

    public void setPaddingBefore(String paddingBefore) {
        attributes.put("padding-before", paddingBefore);
    }

    public void setPaddingBottom(String paddingBottom) {
        attributes.put("padding-bottom", paddingBottom);
    }

    public void setPaddingEnd(String paddingEnd) {
        attributes.put("padding-end", paddingEnd);
    }

    public void setPaddingLeft(String paddingLeft) {
        attributes.put("padding-left", paddingLeft);
    }

    public void setPaddingRight(String paddingRight) {
        attributes.put("padding-right", paddingRight);
    }

    public void setPaddingStart(String paddingStart) {
        attributes.put("padding-start", paddingStart);
    }

    public void setPaddingTop(String paddingTop) {
        attributes.put("padding-top", paddingTop);
    }

    public void setPageBreakAfter(String pageBreakAfter) {
        attributes.put("page-break-after", pageBreakAfter);
    }

    public void setPageBreakBefore(String pageBreakBefore) {
        attributes.put("page-break-before", pageBreakBefore);
    }

    public void setPageBreakInside(String pageBreakInside) {
        attributes.put("page-break-inside", pageBreakInside);
    }

    public void setPageCitationStrategy(String pageCitationStrategy) {
        attributes.put("page-citation-strategy", pageCitationStrategy);
    }

    public void setPageHeight(String pageHeight) {
        attributes.put("page-height", pageHeight);
    }

    public void setPageNumberTreatment(String pageNumberTreatment) {
        attributes.put("page-number-treatment", pageNumberTreatment);
    }

    public void setPagePosition(String pagePosition) {
        attributes.put("page-position", pagePosition);
    }

    public void setPageWidth(String pageWidth) {
        attributes.put("page-width", pageWidth);
    }

    public void setPause(String pause) {
        attributes.put("pause", pause);
    }

    public void setPauseAfter(String pauseAfter) {
        attributes.put("pause-after", pauseAfter);
    }

    public void setPauseBefore(String pauseBefore) {
        attributes.put("pause-before", pauseBefore);
    }

    public void setPitch(String pitch) {
        attributes.put("pitch", pitch);
    }

    public void setPitchRange(String pitchRange) {
        attributes.put("pitch-range", pitchRange);
    }

    public void setPlayDuring(String playDuring) {
        attributes.put("play-during", playDuring);
    }

    public void setPosition(String position) {
        attributes.put("position", position);
    }

    public void setPrecedence(String precedence) {
        attributes.put("precedence", precedence);
    }

    public void setProvisionalDistanceBetweenStarts(String provisionalDistanceBetweenStarts) {
        attributes.put("provisional-distance-between-starts", provisionalDistanceBetweenStarts);
    }

    public void setProvisionalLabelSeparation(String provisionalLabelSeparation) {
        attributes.put("provisional-label-separation", provisionalLabelSeparation);
    }

    public void setRefId(String refId) {
        attributes.put("ref-id", refId);
    }

    public void setRefIndexKey(String refIndexKey) {
        attributes.put("ref-index-key", refIndexKey);
    }

    public void setReferenceOrientation(String referenceOrientation) {
        attributes.put("reference-orientation", referenceOrientation);
    }

    public void setRegionName(String regionName) {
        attributes.put("region-name", regionName);
    }

    public void setRegionNameReference(String regionNameReference) {
        attributes.put("region-name-reference", regionNameReference);
    }

    public void setRelativeAlign(String relativeAlign) {
        attributes.put("relative-align", relativeAlign);
    }

    public void setRelativePosition(String relativePosition) {
        attributes.put("relative-position", relativePosition);
    }

    public void setRenderingIntent(String renderingIntent) {
        attributes.put("rendering-intent", renderingIntent);
    }

    public void setRetrieveBoundary(String retrieveBoundary) {
        attributes.put("retrieve-boundary", retrieveBoundary);
    }

    public void setRetrieveBoundaryWithinTable(String retrieveBoundaryWithinTable) {
        attributes.put("retrieve-boundary-within-table", retrieveBoundaryWithinTable);
    }

    public void setRetrieveClassName(String retrieveClassName) {
        attributes.put("retrieve-class-name", retrieveClassName);
    }

    public void setRetrievePosition(String retrievePosition) {
        attributes.put("retrieve-position", retrievePosition);
    }

    public void setRetrievePositionWithinTable(String retrievePositionWithinTable) {
        attributes.put("retrieve-position-within-table", retrievePositionWithinTable);
    }

    public void setRichness(String richness) {
        attributes.put("richness", richness);
    }

    public void setRight(String right) {
        attributes.put("right", right);
    }

    public void setRole(String role) {
        attributes.put("role", role);
    }

    public void setRuleStyle(String ruleStyle) {
        attributes.put("rule-style", ruleStyle);
    }

    public void setRuleThickness(String ruleThickness) {
        attributes.put("rule-thickness", ruleThickness);
    }

    public void setScaleOption(String scaleOption) {
        attributes.put("scale-option", scaleOption);
    }

    public void setScaling(String scaling) {
        attributes.put("scaling", scaling);
    }

    public void setScalingMethod(String scalingMethod) {
        attributes.put("scaling-method", scalingMethod);
    }

    public void setScoreSpaces(String scoreSpaces) {
        attributes.put("score-spaces", scoreSpaces);
    }

    public void setScript(String script) {
        attributes.put("script", script);
    }

    public void setShowDestination(String showDestination) {
        attributes.put("show-destination", showDestination);
    }

    public void setSize(String size) {
        attributes.put("size", size);
    }

    public void setSourceDocument(String sourceDocument) {
        attributes.put("source-document", sourceDocument);
    }

    public void setSpaceAfter(String spaceAfter) {
        attributes.put("space-after", spaceAfter);
    }

    public void setSpaceAfterConditionality(String spaceAfterConditionality) {
        attributes.put("space-after.conditionality", spaceAfterConditionality);
    }

    public void setSpaceAfterMaximum(String spaceAfterMaximum) {
        attributes.put("space-after.maximum", spaceAfterMaximum);
    }

    public void setSpaceAfterMinimum(String spaceAfterMinimum) {
        attributes.put("space-after.minimum", spaceAfterMinimum);
    }

    public void setSpaceAfterOptimum(String spaceAfterOptimum) {
        attributes.put("space-after.optimum", spaceAfterOptimum);
    }

    public void setSpaceAfterPrecedence(String spaceAfterPrecedence) {
        attributes.put("space-after.precedence", spaceAfterPrecedence);
    }

    public void setSpaceBefore(String spaceBefore) {
        attributes.put("space-before", spaceBefore);
    }

    public void setSpaceBeforeConditionality(String spaceBeforeConditionality) {
        attributes.put("space-before.conditionality", spaceBeforeConditionality);
    }

    public void setSpaceBeforeMaximum(String spaceBeforeMaximum) {
        attributes.put("space-before.maximum", spaceBeforeMaximum);
    }

    public void setSpaceBeforeMinimum(String spaceBeforeMinimum) {
        attributes.put("space-before.minimum", spaceBeforeMinimum);
    }

    public void setSpaceBeforeOptimum(String spaceBeforeOptimum) {
        attributes.put("space-before.optimum", spaceBeforeOptimum);
    }

    public void setSpaceBeforePrecedence(String spaceBeforePrecedence) {
        attributes.put("space-before.precedence", spaceBeforePrecedence);
    }

    public void setSpaceEnd(String spaceEnd) {
        attributes.put("space-end", spaceEnd);
    }

    public void setSpaceEndConditionality(String spaceEndConditionality) {
        attributes.put("space-end.conditionality", spaceEndConditionality);
    }

    public void setSpaceEndMaximum(String spaceEndMaximum) {
        attributes.put("space-end.maximum", spaceEndMaximum);
    }

    public void setSpaceEndMinimum(String spaceEndMinimum) {
        attributes.put("space-end.minimum", spaceEndMinimum);
    }

    public void setSpaceEndOptimum(String spaceEndOptimum) {
        attributes.put("space-end.optimum", spaceEndOptimum);
    }

    public void setSpaceEndPrecedence(String spaceEndPrecedence) {
        attributes.put("space-end.precedence", spaceEndPrecedence);
    }

    public void setSpaceStart(String spaceStart) {
        attributes.put("space-start", spaceStart);
    }

    public void setSpaceStartConditionality(String spaceStartConditionality) {
        attributes.put("space-start.conditionality", spaceStartConditionality);
    }

    public void setSpaceStartMaximum(String spaceStartMaximum) {
        attributes.put("space-start.maximum", spaceStartMaximum);
    }

    public void setSpaceStartMinimum(String spaceStartMinimum) {
        attributes.put("space-start.minimum", spaceStartMinimum);
    }

    public void setSpaceStartOptimum(String spaceStartOptimum) {
        attributes.put("space-start.optimum", spaceStartOptimum);
    }

    public void setSpaceStartPrecedence(String spaceStartPrecedence) {
        attributes.put("space-start.precedence", spaceStartPrecedence);
    }

    public void setSpan(String span) {
        attributes.put("span", span);
    }

    public void setSpeak(String speak) {
        attributes.put("speak", speak);
    }

    public void setSpeakHeader(String speakHeader) {
        attributes.put("speak-header", speakHeader);
    }

    public void setSpeakNumeral(String speakNumeral) {
        attributes.put("speak-numeral", speakNumeral);
    }

    public void setSpeakPunctuation(String speakPunctuation) {
        attributes.put("speak-punctuation", speakPunctuation);
    }

    public void setSpeechRate(String speechRate) {
        attributes.put("speech-rate", speechRate);
    }

    public void setSrc(String src) {
        attributes.put("src", src);
    }

    public void setStartIndent(String startIndent) {
        attributes.put("start-indent", startIndent);
    }

    public void setStartingState(String startingState) {
        attributes.put("starting-state", startingState);
    }

    public void setStartsRow(String startsRow) {
        attributes.put("starts-row", startsRow);
    }

    public void setStress(String stress) {
        attributes.put("stress", stress);
    }

    public void setSuppressAtLineBreak(String suppressAtLineBreak) {
        attributes.put("suppress-at-line-break", suppressAtLineBreak);
    }

    public void setSwitchTo(String switchTo) {
        attributes.put("switch-to", switchTo);
    }

    public void setTableLayout(String tableLayout) {
        attributes.put("table-layout", tableLayout);
    }

    public void setTableOmitFooterAtBreak(String tableOmitFooterAtBreak) {
        attributes.put("table-omit-footer-at-break", tableOmitFooterAtBreak);
    }

    public void setTableOmitHeaderAtBreak(String tableOmitHeaderAtBreak) {
        attributes.put("table-omit-header-at-break", tableOmitHeaderAtBreak);
    }

    public void setTargetPresentationContext(String targetPresentationContext) {
        attributes.put("target-presentation-context", targetPresentationContext);
    }

    public void setTargetProcessingContext(String targetProcessingContext) {
        attributes.put("target-processing-context", targetProcessingContext);
    }

    public void setTargetStylesheet(String targetStylesheet) {
        attributes.put("target-stylesheet", targetStylesheet);
    }

    public void setTextAlign(String textAlign) {
        attributes.put("text-align", textAlign);
    }

    public void setTextAlignLast(String textAlignLast) {
        attributes.put("text-align-last", textAlignLast);
    }

    public void setTextAltitude(String textAltitude) {
        attributes.put("text-altitude", textAltitude);
    }

    public void setTextDecoration(String textDecoration) {
        attributes.put("text-decoration", textDecoration);
    }

    public void setTextDepth(String textDepth) {
        attributes.put("text-depth", textDepth);
    }

    public void setTextIndent(String textIndent) {
        attributes.put("text-indent", textIndent);
    }

    public void setTextShadow(String textShadow) {
        attributes.put("text-shadow", textShadow);
    }

    public void setTextTransform(String textTransform) {
        attributes.put("text-transform", textTransform);
    }

    public void setTop(String top) {
        attributes.put("top", top);
    }

    public void setTreatAsWordSpace(String treatAsWordSpace) {
        attributes.put("treat-as-word-space", treatAsWordSpace);
    }

    public void setUnicodeBidi(String unicodeBidi) {
        attributes.put("unicode-bidi", unicodeBidi);
    }

    public void setVerticalAlign(String verticalAlign) {
        attributes.put("vertical-align", verticalAlign);
    }

    public void setVisibility(String visibility) {
        attributes.put("visibility", visibility);
    }

    public void setVoiceFamily(String voiceFamily) {
        attributes.put("voice-family", voiceFamily);
    }

    public void setVolume(String volume) {
        attributes.put("volume", volume);
    }

    public void setWhiteSpace(String whiteSpace) {
        attributes.put("white-space", whiteSpace);
    }

    public void setWhiteSpaceCollapse(String whiteSpaceCollapse) {
        attributes.put("white-space-collapse", whiteSpaceCollapse);
    }

    public void setWhiteSpaceTreatment(String whiteSpaceTreatment) {
        attributes.put("white-space-treatment", whiteSpaceTreatment);
    }

    public void setWidows(String widows) {
        attributes.put("widows", widows);
    }

    public void setWidth(String width) {
        attributes.put("width", width);
    }

    public void setWordSpacing(String wordSpacing) {
        attributes.put("word-spacing", wordSpacing);
    }

    public void setWrapOption(String wrapOption) {
        attributes.put("wrap-option", wrapOption);
    }

    public void setWritingMode(String writingMode) {
        attributes.put("writing-mode", writingMode);
    }

    public void setZIndex(String zIndex) {
        attributes.put("z-index", zIndex);
    }
    
}
