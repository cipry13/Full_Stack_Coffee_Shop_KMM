import react.*
import kotlinx.coroutines.*
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.ul

private val scope = MainScope()

val App = FC<Props> {
    var coffeeShopsList by useState(emptyList<CoffeeShop>())

    useEffectOnce {
        scope.launch {
            coffeeShopsList = ApiClass().getData()
        }
    }

    h1 {
        +"Coffee Shops List"
    }
    ul {
        coffeeShopsList.forEach { item ->
            li {
                p {
                    +"${item.id}  ${item.name}"
                }
                p {
                    +"${item.x}  ${item.y}"
                }
            }
        }
    }
}