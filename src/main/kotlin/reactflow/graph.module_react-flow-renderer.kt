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

external var isEdge: (element: dynamic /* Node | Edge */) -> Boolean

external var isNode: (element: dynamic /* Node | Edge */) -> Boolean

external var getOutgoers: (node: Node, elements: Elements) -> Elements

external var removeElements: (elementsToRemove: Elements, elements: Elements) -> Elements

external var addEdge: (edgeParams: Edge, elements: Elements) -> Elements

external var parseElement: (element: dynamic /* Node | Edge */, transform: Transform, snapToGrid: Boolean, snapGrid: dynamic /* JsTuple<Number, Number> */) -> dynamic

external var getBoundsofRects: (rect1: Rect, rect2: Rect) -> Rect

external var getRectOfNodes: (nodes: Array<Node>) -> Rect

external var graphPosToZoomedPos: (__0: XYPosition, __1: Transform) -> XYPosition

external var getNodesInside: (nodes: Array<Node>, rect: Rect, __2: Transform, partially: Boolean) -> Array<Node>

external var getConnectedEdges: (nodes: Array<Node>, edges: Array<Edge>) -> Array<Edge>

external var fitView: (__0: FitViewParams) -> Unit

external var zoomIn: () -> Unit

external var zoomOut: () -> Unit