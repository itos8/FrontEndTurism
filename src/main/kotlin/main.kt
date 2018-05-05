import kotlinx.html.*
import frontEnd.login
import kotlinx.html.dom.create
import kotlin.browser.document
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement

fun main(args: Array<String>)
{
    val root = document.getElementById("root")

    val home = document.create.div{
        id = "home"

        h1{
            +"HOME"
        }

        br
        input {
            id = "mail"
            type = InputType.text
        }
        br
        input {
            id = "pass"
            type = InputType.text
        }
        br
        input{
            value = "Login"
            type = InputType.submit
            onClickFunction = { val mail = document.getElementById("mail") as HTMLInputElement
                val pass = document.getElementById("pass") as HTMLInputElement
                val login = login(mail.value,
                        pass.value)

                root!!.firstElementChild!!.remove()
            }
        }
    }

    root!!.appendChild(home)
}