import kotlinx.css.*
import kotlinx.serialization.json.Json
import org.w3c.dom.css.CSS
import react.*
import react.dom.button
import react.dom.h1
import react.dom.render
import styled.css
import styled.styledDiv
import kotlin.browser.document
import kotlin.js.json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject


/*
  { id: '1', data: { label: 'Node 1' }, position: { x: 250, y: 5 } },
  { id: '2', data: { label: 'Node 2' }, position: { x: 100, y: 100 } },
  { id: 'e1-2', source: '1', target: '2', animated: true },
 */

val n1 = Json.parseJson("""[{ "id": "1", "position":{"x":100, "y":100} }]""")  //, \"data\": { \"label\": \"Node 1\" }, position: {\"x\": 250, \"y\": 5 }

data class Coords(val x: Int, val y: Int)
data class Labels(val label: String)
data class MyElem(val id: String, val position: Coords, val data: Labels)

var elementsTo = arrayOf<Map<Any,Any>>(
    mapOf("id" to "1", "data" to mapOf("label" to  "node1"), "position" to mapOf("x" to 50, "y" to 5)),
    mapOf("id" to "2", "data" to mapOf("label" to "node2"), "position" to mapOf("x" to 100, "y" to 100)),
    mapOf("id" to "e1-2", "source" to "1", "target" to "2", "animated" to true)
    )

//var elementsTo = <Map<Any,Any>>(
//    mapOf("id" to "1", "data" to mapOf("label" to  "node1"), "position" to mapOf("x" to 50, "y" to 5)),
//    mapOf("id" to "2", "data" to mapOf("label" to "node2"), "position" to mapOf("x" to 100, "y" to 100)),
//    mapOf("id" to "e1-2", "source" to "1", "target" to "2", "animated" to true)
//)
fun main() {
println("n1 $n1")


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
                    elements = arrayOf(
                        MyElem("22", Coords(100, 100), Labels("Node 1")),
                        MyElem("23", Coords(50, 50), Labels("Node 2"))
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