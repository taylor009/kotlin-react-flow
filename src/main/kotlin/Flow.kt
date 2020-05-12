@file:JsModule("react-flow-renderer")
@file:JsNonModule

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import react.RClass
import react.RProps

@JsName("default")
external val ReactFlow: RClass<ReactFlowProps>

external interface ReactFlowProps : RProps {
    var elements: Array<MyElem>
    var styles: Any?
}
