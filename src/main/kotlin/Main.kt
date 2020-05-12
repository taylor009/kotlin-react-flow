import react.*
import react.dom.button
import react.dom.h1
import react.dom.render
import styled.css
import styled.styledDiv
import kotlin.browser.document



fun main() {
    render(document.getElementById("root")) {
        h1 {
            +"React Flow Demo"
        }

        styledDiv {
            css {

            }
            button {
                +"Hello"
            }
        }
    }
}