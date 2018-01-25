package com.request.network.lib.artifacts

import com.request.network.lib.exception.RequestArtifactMissingException
import play.api.libs.json._

trait RequestArtifact[A] {

  implicit val jsonFormat: Format[A] =
    Format[A](
      Reads {
        (json: JsValue) => JsSuccess(this(json.asInstanceOf[JsString].value.toLowerCase()))
      },
      Writes {
        (value: A) => JsString(value.toString)
      }
    )

  def apply(value: String): A = valueToObject.getOrElse(value,
    throw RequestArtifactMissingException(s"Unrecognized abi input type: $value"))

  val knownValues: List[A]

  protected val valueToObject: Map[String, A] =
    Map(knownValues.map(value => value.toString.toLowerCase -> value):_*)

}
