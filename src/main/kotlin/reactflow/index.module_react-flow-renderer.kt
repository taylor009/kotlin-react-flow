@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION")

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

typealias ElementId = String

typealias Elements = Array<dynamic /* Node | Edge */>

external enum class Position {
    Left /* = "left" */,
    Top /* = "top" */,
    Right /* = "right" */,
    Bottom /* = "bottom" */
}

external interface XYPosition {
    var x: Number
    var y: Number
}

external enum class GridType {
    Lines /* = "lines" */,
    Dots /* = "dots" */
}

external interface NodeTypesType {
    @nativeGetter
    operator fun get(key: String): React.ReactNode?
    @nativeSetter
    operator fun set(key: String, value: React.ReactNode)
}

typealias EdgeTypesType = NodeTypesType

external interface Dimensions {
    var width: Number
    var height: Number
}

external interface Rect : Dimensions, XYPosition

external interface Box : XYPosition {
    var x2: Number
    var y2: Number
}

external interface SelectionRect : Rect {
    var startX: Number
    var startY: Number
    var draw: Boolean
}

external interface Node {
    var id: ElementId
    var position: XYPosition
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
    var __rg: Any?
        get() = definedExternally
        set(value) = definedExternally
    var data: Any?
        get() = definedExternally
        set(value) = definedExternally
    var style: Any?
        get() = definedExternally
        set(value) = definedExternally
    var targetPosition: Position?
        get() = definedExternally
        set(value) = definedExternally
    var sourcePosition: Position?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Edge {
    var id: ElementId
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
    var source: ElementId
    var target: ElementId
    var label: String?
        get() = definedExternally
        set(value) = definedExternally
    var labelStyle: Any?
        get() = definedExternally
        set(value) = definedExternally
    var labelShowBg: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var labelBgStyle: Any?
        get() = definedExternally
        set(value) = definedExternally
    var style: Any?
        get() = definedExternally
        set(value) = definedExternally
    var animated: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EdgeProps {
    var sourceX: Number
    var sourceY: Number
    var targetX: Number
    var targetY: Number
    var label: String?
        get() = definedExternally
        set(value) = definedExternally
    var labelStyle: Any?
        get() = definedExternally
        set(value) = definedExternally
    var labelShowBg: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var labelBgStyle: Any?
        get() = definedExternally
        set(value) = definedExternally
    var style: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EdgeBezierProps : EdgeProps {
    var sourcePosition: Position
    var targetPosition: Position
}

external interface NodeProps {
    var id: ElementId
    var type: String
    var data: Any
    var selected: Boolean
    var targetPosition: Position?
        get() = definedExternally
        set(value) = definedExternally
    var sourcePosition: Position?
        get() = definedExternally
        set(value) = definedExternally
    var style: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface NodeComponentProps {
    var id: ElementId
    var type: String
    var data: Any
    var selected: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var transform: dynamic /* JsTuple<Number, Number, Number> */
        get() = definedExternally
        set(value) = definedExternally
    var xPos: Number?
        get() = definedExternally
        set(value) = definedExternally
    var yPos: Number?
        get() = definedExternally
        set(value) = definedExternally
    var targetPosition: Position?
        get() = definedExternally
        set(value) = definedExternally
    var sourcePosition: Position?
        get() = definedExternally
        set(value) = definedExternally
    var onClick: ((node: Node) -> Unit?)?
        get() = definedExternally
        set(value) = definedExternally
    var onNodeDragStop: (() -> Any)?
        get() = definedExternally
        set(value) = definedExternally
    var style: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface WrapNodeProps {
    var id: ElementId
    var type: String
    var data: Any
    var selected: Boolean
    var transform: dynamic /* JsTuple<Number, Number, Number> */
        get() = definedExternally
        set(value) = definedExternally
    var xPos: Number
    var yPos: Number
    var isInteractive: Boolean
    var onClick: (node: Node) -> Unit?
    var onNodeDragStop: (node: Node) -> Unit
    var style: Any?
        get() = definedExternally
        set(value) = definedExternally
    var sourcePosition: Position?
        get() = definedExternally
        set(value) = definedExternally
    var targetPosition: Position?
        get() = definedExternally
        set(value) = definedExternally
}

external interface FitViewParams {
    var padding: Number
}

typealias FitViewFunc = (fitViewOptions: FitViewParams) -> Unit

external interface OnLoadParams {
    var zoomIn: () -> Unit
    var zoomOut: () -> Unit
    var fitView: FitViewFunc
}

typealias OnLoadFunc = (params: OnLoadParams) -> Unit

external interface Connection {
    var source: ElementId?
        get() = definedExternally
        set(value) = definedExternally
    var target: ElementId?
        get() = definedExternally
        set(value) = definedExternally
}

typealias OnConnectFunc = (params: Connection) -> Unit

external interface HandleElement : XYPosition, Dimensions {
    var id: ElementId?
        get() = definedExternally
        set(value) = definedExternally
    var position: Position
}

external interface EdgeCompProps {
    var id: ElementId
    var source: ElementId
    var target: ElementId
    var type: Any
    var label: String?
        get() = definedExternally
        set(value) = definedExternally
    var labelStyle: Any?
        get() = definedExternally
        set(value) = definedExternally
    var labelShowBg: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var labelBgStyle: Any?
        get() = definedExternally
        set(value) = definedExternally
    var onClick: ((edge: Edge) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var animated: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var selected: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EdgeTextProps {
    var x: Number
    var y: Number
    var label: String?
        get() = definedExternally
        set(value) = definedExternally
    var labelStyle: Any?
        get() = definedExternally
        set(value) = definedExternally
    var labelShowBg: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var labelBgStyle: Any?
        get() = definedExternally
        set(value) = definedExternally
}