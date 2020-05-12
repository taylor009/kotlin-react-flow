import org.w3c.dom.css.CSS
import react.*
import react.dom.button
import react.dom.h1
import react.dom.render
import styled.css
import styled.styledDiv
import kotlin.browser.document

/*
  { id: '1', data: { label: 'Node 1' }, position: { x: 250, y: 5 } },
  { id: '2', data: { label: 'Node 2' }, position: { x: 100, y: 100 } },
  { id: 'e1-2', source: '1', target: '2', animated: true },
 */
var elementsTo = arrayOf<Map<Any,Any>>(
    mapOf("1" to "id", "data" to mapOf("label" to  "node1"), "position" to mapOf(50 to "x", 5 to "y"))
    )


fun main() {
    render(document.getElementById("root")) {
        h1 {
            +"React Flow Demo"
        }

        styledDiv {
            css {

            }
            ReactFlow{
                attrs {
                    elements = elementsTo
                }
            }
        }
    }
}