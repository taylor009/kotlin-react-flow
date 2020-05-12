@file:JsModule("react-flow-renderer")

import react.RClass
import react.RProps

@JsName("default")
external val ReactFlow: RClass<dynamic>

external interface ReactFlowProps : RProps {
    var elements: Array<dynamic>

}
