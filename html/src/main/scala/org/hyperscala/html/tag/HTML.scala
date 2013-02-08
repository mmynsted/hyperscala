package org.hyperscala.html.tag

import org.hyperscala._
import css.StyleSheet
import html.HTMLTag
import org.hyperscala.html.attributes._
import org.hyperscala.html.constraints._
import scala.Some

/**
 * NOTE: This file has been generated. Do not modify directly!
 * @author Matt Hicks <mhicks@hyperscala.org>
 */
class HTML extends Container[HTMLChild] with HTMLTag {
  lazy val xmlLabel = "html"
  override def xmlExpanded = true

  def this(name: String = null,
           accessKey: java.lang.Character = null,
           clazz: List[String] = null,
           contentEditable: ContentEditable = null,
           contextMenu: String = null,
           dir: Direction = null,
           draggable: Draggable = null,
           dropZone: DropZone = null,
           hidden: java.lang.Boolean = null,
           id: String = null,
           lang: String = null,
           spellCheck: java.lang.Boolean = null,
           style: StyleSheet = null,
           tabIndex: java.lang.Integer = null,
           titleText: String = null,
           manifest: String = null,
           xmlns: String = null,
           content: HTMLChild = null) = {
    this()
    up(this.name, name)
    up(this.accessKey, accessKey)
    up(this.clazz, clazz)
    up(this.contentEditable, contentEditable)
    up(this.contextMenu, contextMenu)
    up(this.dir, dir)
    up(this.draggable, draggable)
    up(this.dropZone, dropZone)
    up(this.hidden, hidden)
    up(this.id, id)
    up(this.lang, lang)
    up(this.spellCheck, spellCheck)
    up(this.style, style)
    up(this.tabIndex, tabIndex)
    up(this.titleText, titleText)
    up(this.manifest, manifest)
    up(this.xmlns, xmlns)
    if (content != null) contents += content
  }

  val manifest = PropertyAttribute[String]("manifest", null)
  val xmlns = PropertyAttribute[String]("xmlns", null)

  def head = synchronized {
    contents.collectFirst {
      case h: Head => h
    } match {
      case Some(h) => h
      case None => {
        val h = new Head
        contents.insert(0, h)
        h
      }
    }
  }

  def body = synchronized {
    contents.collectFirst {
      case b: Body => b
    } match {
      case Some(b) => b
      case None => {
        val b = new Body
        contents += b
        b
      }
    }
  }

  override protected def generateChildFromTagName(name: String) = {
    contents.find(c => c.xmlLabel == name) match {
      case Some(tag) => tag
      case None => super.generateChildFromTagName(name)
    }
  }
}