package org.hyperscala.css

import org.hyperscala.{Markup, InclusionMode, PropertyAttribute}
import org.powerscala.property.Property
import org.hyperscala.io.HTMLWriter

/**
 * @author Matt Hicks <matt@outr.com>
 */
class StyleSheetAttribute[T](val style: Style[T],
                             inclusion: InclusionMode = InclusionMode.NotEmpty)
                            (implicit val ss: StyleSheet, manifest: Manifest[T])
                            extends PropertyAttribute[T](style.cssName,
                                                         null.asInstanceOf[T],
                                                         inclusion)(style.persistence,
                                                                    ss,
                                                                    manifest) {
  private var _importantInitialized = false
  lazy val important = new Property[Boolean](default = Some(false)) {
    _importantInitialized = true
  }

  ss.addAttribute(this)

  override def write(markup: Markup, writer: HTMLWriter) {
    // Ignore write request - HTMLTag writes the style itself
  }

  def isImportant = _importantInitialized && important()

  def valueString = {
    val vs = style.persistence.toString(value, style.cssName, manifest.runtimeClass)
    if (isImportant) {
      s"$vs !important"
    } else {
      vs
    }
  }
}

object StyleSheetAttribute {
  val ImportantRegex = """(.*) !\s*important""".r

  def extractImportant(value: String) = value match {
    case ImportantRegex(v) => v -> true
    case _ => value -> false
  }
}