@file:JsModule("react-flow-renderer")
@file:JsNonModule
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

external interface EdgeWrapperProps {
    var id: Any
    var source: Any
    var target: Any
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
    var labelBgStyle: Any
    var onClick: (edge: Edge) -> Unit
    var animated: Boolean
    var selected: Boolean
    var isInteractive: Boolean
}

@JsName("default")
external var _default: (EdgeComponent: React.ComponentType<EdgeCompProps>) -> React.MemoExoticComponent<(__0: EdgeWrapperProps) -> JSX.Element>