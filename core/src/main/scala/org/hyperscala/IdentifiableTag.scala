package org.hyperscala

import org.hyperscala.event.BrowserEvent
import org.hyperscala.event.processor.EventReceivedProcessor
import org.powerscala.event.Intercept
import org.hyperscala.io.HTMLWriter
import org.powerscala.Unique

/**
 * @author Matt Hicks <mhicks@outr.com>
 */
trait IdentifiableTag extends Tag {
  val eventReceived = new EventReceivedProcessor()

  val id = PropertyAttribute[String]("id", null)

  /**
   * Gets the id value and sets it to a unique value if it's null.
   */
  def identity = id() match {
    case null => {
      val uuid = Unique()
      id := uuid
      uuid
    }
    case value => value
  }

  /**
   * Convenience method to inject support for received ClientEvents of a specific type.
   *
   * @param f the handler function for a matching type.
   * @param manifest the manifest of the ClientEvent subclass.
   * @tparam E the ClientEvent type
   * @return Unit
   */
  def handle[E <: BrowserEvent](f: E => Unit, condition: E => Boolean = (e: E) => true)(implicit manifest: Manifest[E]): Unit = eventReceived.on {
    case evt => if (manifest.runtimeClass.isAssignableFrom(evt.getClass)) {
      val e = evt.asInstanceOf[E]
      if (condition(e)) {
        f(e)
        Intercept.Stop
      } else {
        Intercept.Continue
      }
    } else {
      Intercept.Continue
    }
  }

  override protected def writeAttribute(writer: HTMLWriter, attribute: XMLAttribute) {
    if (attribute.name != "id" || !IdentifiableTag.ignoreIds) {   // Don't write ids if ignoreIds is true
      super.writeAttribute(writer, attribute)
    }
  }
}

object IdentifiableTag {
  private val _ignoreIds = new ThreadLocal[Boolean] {
    override def initialValue() = false
  }

  def reId[T <: IdentifiableTag](t: T, newId: String = Unique()) = {
    t.id := newId
    t
  }

  /**
   * Writing HTML within this block will ignore ids.
   *
   * @param f the function to ignore ids within
   * @tparam T the return type
   * @return T
   */
  def ignoreIds[T](f: => T): T = {
    ignoreIdsStart()
    try {
      f
    } finally {
      ignoreIdsStop()
    }
  }

  def ignoreIdsStart() = _ignoreIds.set(true)

  def ignoreIdsStop() = _ignoreIds.set(false)

  /**
   * Are we currently ignoring ids?
   */
  def ignoreIds = _ignoreIds.get()
}