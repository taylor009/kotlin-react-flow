import kotlinx.css.*
import kotlinx.serialization.json.Json
import react.dom.h1
import react.dom.render
import styled.css
import styled.styledDiv
import kotlin.browser.document

data class MyXyPosition(override var x: Number, override var y: Number): XYPosition
interface ReactFlowElement

data class Labels(val label: String)
data class MyNode(var id: String, var position: Any, var data: Any?): ReactFlowElement // :Node
data class MyEdge(
    var id: ElementId,
    var source: ElementId,
    var target: ElementId,
    var animated: Boolean? = true
): ReactFlowElement//, Edge

    var elementsTo = arrayOf<Map<Any,Any>>(
    mapOf("id" to "1", "data" to mapOf("label" to  "node1"), "position" to mapOf("x" to 50, "y" to 5)),
    mapOf("id" to "2", "data" to mapOf("label" to "node2"), "position" to mapOf("x" to 100, "y" to 100)),
    mapOf("id" to "e1-2", "source" to "1", "target" to "2", "animated" to true)
    )
fun main() {
    render(document.getElementById("root")) {
        println("j $elementsTo ${elementsTo::class}")
        h1 {
            +"React Flow Demo"
        }
        +elementsTo.toString()
        styledDiv {
            css {

            }
            ReactFlow {
                attrs {
                    elements = arrayOf<ReactFlowElement>(
                        MyNode("22", MyXyPosition(100, 100), Labels("Node 1")),
                        MyNode("23", MyXyPosition(50, 50), Labels("Node 2")),
                        MyEdge("1111", "22", "23")

                    )
                    styles = this@styledDiv.css {
                        height = 500.pt
                        width = 500.pt
                        backgroundColor = Color.whiteSmoke
                    }
                }
            }
        }
    }
}