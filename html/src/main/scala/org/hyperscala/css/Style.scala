package org.hyperscala.css

import attributes._
import org.hyperscala.html.attributes.Direction
import org.powerscala.Color
import org.powerscala.enum.{EnumEntry, Enumerated}
import org.hyperscala.persistence._

/**
 * @author Matt Hicks <mhicks@outr.com>
 */
class Style[T](val cssName: String)(implicit val manifest: Manifest[T], val persistence: ValuePersistence[T]) extends EnumEntry {
  def value(v: T) = persistence.toString(v, cssName, manifest.runtimeClass)

  def assignment(value: T) = StyleAssignment(this, value)
}

case class StyleAssignment[T](style: Style[T], value: T)

object Style extends Enumerated[Style[_]] {
  val alignmentAdjust = new Style[String]("alignment-adjust")
  val alignmentBaseline = new Style[String]("alignment-baseline")
  val animation = new Style[String]("animation")
  val animationDelay = new Style[String]("animation-delay")
  val animationDirection = new Style[String]("animation-direction")
  val animationDuration = new Style[String]("animation-duration")
  val animationIterationCount = new Style[String]("animation-iteration-count")
  val animationName = new Style[String]("animation-name")
  val animationPlayState = new Style[String]("animation-play-state")
  val animationTimingFunction = new Style[String]("animation-timing-function")
  val appearance = new Style[String]("appearance")
  val backfaceVisibility = new Style[String]("backface-visibility")
  val background = new Style[String]("background")
  val backgroundAttachment = new Style[Attachment]("background-attachment")
  val backgroundClip = new Style[Origin]("background-clip")
  val backgroundColor = new Style[Color]("background-color")
  val backgroundImage = new Style[Resource]("background-image")
  val backgroundOrigin = new Style[Origin]("background-origin")
  val backgroundPosition = new Style[BackgroundPosition]("background-position")
  val backgroundRepeat = new Style[BackgroundRepeat]("background-repeat")
  val backgroundSize = new Style[BackgroundSize]("background-size")
  val baselineShift = new Style[String]("baseline-shift")
  val bookmarkLabel = new Style[String]("bookmark-label")
  val bookmarkLevel = new Style[String]("bookmark-level")
  val bookmarkTarget = new Style[String]("bookmark-target")
  val border = new Style[String]("border")
  val borderBottom = new Style[String]("border-bottom")
  val borderBottomColor = new Style[Color]("border-bottom-color")
  val borderBottomLeftRadius = new Style[Length]("border-bottom-left-radius")
  val borderBottomRightRadius = new Style[Length]("border-bottom-right-radius")
  val borderBottomStyle = new Style[LineStyle]("border-bottom-style")
  val borderBottomWidth = new Style[Length]("border-bottom-width")
  val borderCollapse = new Style[BorderCollapse]("border-collapse")
  val borderColor = new Style[Color]("border-color")
  val borderImage = new Style[String]("border-image")
  val borderImageOutset = new Style[String]("border-image-outset")
  val borderImageRepeat = new Style[String]("border-image-repeat")
  val borderImageSlice = new Style[String]("border-image-slice")
  val borderImageSource = new Style[String]("border-image-source")
  val borderImageWidth = new Style[Length]("border-image-width")
  val borderLeft = new Style[String]("border-left")
  val borderLeftColor = new Style[Color]("border-left-color")
  val borderLeftStyle = new Style[LineStyle]("border-left-style")
  val borderLeftWidth = new Style[Length]("border-left-width")
  val borderRadius = new Style[Length]("border-radius")
  val borderRight = new Style[String]("border-right")
  val borderRightColor = new Style[Color]("border-right-color")
  val borderRightStyle = new Style[LineStyle]("border-right-style")
  val borderRightWidth = new Style[Length]("border-right-width")
  val borderSpacing = new Style[String]("border-spacing")
  val borderStyle = new Style[LineStyle]("border-style")
  val borderTop = new Style[String]("border-top")
  val borderTopColor = new Style[Color]("border-top-color")
  val borderTopLeftRadius = new Style[Length]("border-top-left-radius")
  val borderTopRightRadius = new Style[Length]("border-top-right-radius")
  val borderTopStyle = new Style[LineStyle]("border-top-style")
  val borderTopWidth = new Style[Length]("border-top-width")
  val borderWidth = new Style[Length]("border-width")
  val bottom = new Style[Length]("bottom")
  val boxAlign = new Style[String]("box-align")
  val boxDecorationBreak = new Style[String]("box-decoration-break")
  val boxDirection = new Style[String]("box-direction")
  val boxFlex = new Style[String]("box-flex")
  val boxFlexGroup = new Style[String]("box-flex-group")
  val boxLines = new Style[String]("box-lines")
  val boxOrdinalGroup = new Style[String]("box-ordinal-group")
  val boxOrient = new Style[String]("box-orient")
  val boxPack = new Style[String]("box-pack")
  val boxShadow = new Style[String]("box-shadow")
  val boxSizing = new Style[String]("box-sizing")
  val captionSide = new Style[String]("caption-side")
  val clear = new Style[Clear]("clear")
  val clip = new Style[Rect]("clip")
  val color = new Style[Color]("color")
  val colorProfile = new Style[String]("color-profile")
  val columnCount = new Style[String]("column-count")
  val columnFill = new Style[String]("column-fill")
  val columnGap = new Style[String]("column-gap")
  val columnRule = new Style[String]("column-rule")
  val columnRuleColor = new Style[Color]("column-rule-color")
  val columnRuleStyle = new Style[String]("column-rule-style")
  val columnRuleWidth = new Style[Length]("column-rule-width")
  val columnSpan = new Style[String]("column-span")
  val columnWidth = new Style[Length]("column-width")
  val columns = new Style[String]("columns")
  val content = new Style[String]("content")
  val counterIncrement = new Style[String]("counter-increment")
  val counterReset = new Style[String]("counter-reset")
  val crop = new Style[String]("crop")
  val cursor = new Style[String]("cursor")
  val direction = new Style[Direction]("direction")
  val display = new Style[Display]("display")
  val dominantBaseline = new Style[String]("dominant-baseline")
  val dropInitialAfterAdjust = new Style[String]("drop-initial-after-adjust")
  val dropInitialAfterAlign = new Style[String]("drop-initial-after-align")
  val dropInitialBeforeAdjust = new Style[String]("drop-initial-before-adjust")
  val dropInitialBeforeAlign = new Style[String]("drop-initial-before-align")
  val dropInitialSize = new Style[String]("drop-initial-size")
  val dropInitialValue = new Style[String]("drop-initial-value")
  val emptyCells = new Style[String]("empty-cells")
  val fit = new Style[String]("fit")
  val fitPosition = new Style[String]("fit-position")
  val float = new Style[Float]("float")
  val floatOffset = new Style[String]("float-offset")
  val font = new Style[String]("font")
  val fontFamily = new Style[String]("font-family")
  val fontSize = new Style[FontSize]("font-size")
  val fontSizeAdjust = new Style[String]("font-size-adjust")
  val fontStretch = new Style[String]("font-stretch")
  val fontStyle = new Style[FontStyle]("font-style")
  val fontVariant = new Style[FontVariant]("font-variant")
  val fontWeight = new Style[FontWeight]("font-weight")
  val gridColumns = new Style[String]("grid-columns")
  val gridRows = new Style[String]("grid-rows")
  val hangingPunctuation = new Style[String]("hanging-punctuation")
  val height = new Style[Length]("height")
  val hyphenateAfter = new Style[String]("hyphenate-after")
  val hyphenateBefore = new Style[String]("hyphenate-before")
  val hyphenateCharacter = new Style[String]("hyphenate-character")
  val hyphenateLines = new Style[String]("hyphenate-lines")
  val hyphenateResource = new Style[String]("hyphenate-resource")
  val hyphens = new Style[String]("hyphens")
  val icon = new Style[String]("icon")
  val imageOrientation = new Style[String]("image-orientation")
  val imageResolution = new Style[String]("image-resolution")
  val inlineBoxAlign = new Style[String]("inline-box-align")
  val left = new Style[Length]("left")
  val letterSpacing = new Style[Length]("letter-spacing")
  val lineHeight = new Style[Length]("line-height")
  val lineStacking = new Style[String]("line-stacking")
  val lineStackingRuby = new Style[String]("line-stacking-ruby")
  val lineStackingShift = new Style[String]("line-stacking-shift")
  val lineStackingStrategy = new Style[String]("line-stacking-strategy")
  val listStyle = new Style[String]("list-style")
  val listStyleImage = new Style[String]("list-style-image")
  val listStylePosition = new Style[String]("list-style-position")
  val listStyleType = new Style[ListStyleType]("list-style-type")
  val margin = new Style[String]("margin")
  val marginBottom = new Style[Length]("margin-bottom")
  val marginLeft = new Style[Length]("margin-left")
  val marginRight = new Style[Length]("margin-right")
  val marginTop = new Style[Length]("margin-top")
  val mark = new Style[String]("mark")
  val markAfter = new Style[String]("mark-after")
  val markBefore = new Style[String]("mark-before")
  val marks = new Style[String]("marks")
  val marqueeDirection = new Style[String]("marquee-direction")
  val marqueePlayCount = new Style[String]("marquee-play-count")
  val marqueeSpeed = new Style[String]("marquee-speed")
  val marqueeStyle = new Style[String]("marquee-style")
  val maxHeight = new Style[Length]("max-height")
  val maxWidth = new Style[Length]("max-width")
  val minHeight = new Style[Length]("min-height")
  val minWidth = new Style[Length]("min-width")
  val moveTo = new Style[String]("move-to")
  val navDown = new Style[String]("nav-down")
  val navIndex = new Style[String]("nav-index")
  val navLeft = new Style[String]("nav-left")
  val navRight = new Style[String]("nav-right")
  val navUp = new Style[String]("nav-up")
  val opacity = new Style[Opacity]("opacity")
  val orphans = new Style[String]("orphans")
  val outline = new Style[String]("outline")
  val outlineColor = new Style[Color]("outline-color")
  val outlineOffset = new Style[Length]("outline-offset")
  val outlineStyle = new Style[LineStyle]("outline-style")
  val outlineWidth = new Style[Length]("outline-width")
  val overflow = new Style[Overflow]("overflow")
  val overflowStyle = new Style[String]("overflow-style")
  val overflowX = new Style[Overflow]("overflow-x")
  val overflowY = new Style[Overflow]("overflow-y")
  val padding = new Style[String]("padding")
  val paddingBottom = new Style[Length]("padding-bottom")
  val paddingLeft = new Style[Length]("padding-left")
  val paddingRight = new Style[Length]("padding-right")
  val paddingTop = new Style[Length]("padding-top")
  val page = new Style[String]("page")
  val pageBreakAfter = new Style[String]("page-break-after")
  val pageBreakBefore = new Style[String]("page-break-before")
  val pageBreakInside = new Style[String]("page-break-inside")
  val pagePolicy = new Style[String]("page-policy")
  val perspective = new Style[String]("perspective")
  val perspectiveOrigin = new Style[String]("perspective-origin")
  val phonemes = new Style[String]("phonemes")
  val position = new Style[Position]("position")
  val punctuationTrim = new Style[String]("punctuation-trim")
  val quotes = new Style[String]("quotes")
  val renderingIntent = new Style[String]("rendering-intent")
  val resize = new Style[String]("resize")
  val rest = new Style[String]("rest")
  val restAfter = new Style[String]("rest-after")
  val restBefore = new Style[String]("rest-before")
  val right = new Style[Length]("right")
  val rotation = new Style[String]("rotation")
  val rotationPoint = new Style[String]("rotation-point")
  val rubyAlign = new Style[String]("ruby-align")
  val rubyOverhang = new Style[String]("ruby-overhang")
  val rubyPosition = new Style[String]("ruby-position")
  val rubySpan = new Style[String]("ruby-span")
  val size = new Style[String]("size")
  val stringSet = new Style[String]("string-set")
  val tableLayout = new Style[String]("table-layout")
  val target = new Style[String]("target")
  val targetName = new Style[String]("target-name")
  val targetNew = new Style[String]("target-new")
  val targetPosition = new Style[String]("target-position")
  val textAlign = new Style[Alignment]("text-align")
  val textAlignLast = new Style[Alignment]("text-align-last")
  val textDecoration = new Style[Decoration]("text-decoration")
  val textHeight = new Style[String]("text-height")
  val textIndent = new Style[Length]("text-indent")
  val textJustify = new Style[String]("text-justify")
  val textOutline = new Style[String]("text-outline")
  val textOverflow = new Style[TextClip]("text-overflow")
  val textShadow = new Style[TextShadow]("text-shadow")
  val textTransform = new Style[TextTransform]("text-transform")
  val textWrap = new Style[String]("text-wrap")
  val top = new Style[Length]("top")
  val transform = new Style[String]("transform")
  val transformOrigin = new Style[String]("transform-origin")
  val transformStyle = new Style[String]("transform-style")
  val transition = new Style[String]("transition")
  val transitionDelay = new Style[String]("transition-delay")
  val transitionDuration = new Style[String]("transition-duration")
  val transitionProperty = new Style[String]("transition-property")
  val transitionTimingFunction = new Style[String]("transition-timing-function")
  val unicodeBidi = new Style[String]("unicode-bidi")
  val verticalAlign = new Style[VerticalAlignment]("vertical-align")
  val visibility = new Style[Visibility]("visibility")
  val voiceBalance = new Style[String]("voice-balance")
  val voiceDuration = new Style[String]("voice-duration")
  val voicePitch = new Style[String]("voice-pitch")
  val voicePitchRange = new Style[String]("voice-pitch-range")
  val voiceRate = new Style[String]("voice-rate")
  val voiceStress = new Style[String]("voice-stress")
  val voiceVolume = new Style[String]("voice-volume")
  val whiteSpace = new Style[WhiteSpace]("white-space")
  val widows = new Style[String]("widows")
  val width = new Style[Length]("width")
  val wordBreak = new Style[String]("word-break")
  val wordSpacing = new Style[String]("word-spacing")
  val wordWrap = new Style[String]("word-wrap")
  val zIndex = new Style[ZIndex]("z-index")

  def byCSSName(name: String) = values.find(s => s.cssName == name)
}