@file:JsModule("react-flow-renderer")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("default")
external val ReactFlow: RClass<ReactFlowProps>

external interface ReactFlowProps : RProps {
    var elements: Array<ReactFlowElement>
    var styles: Any?
}
