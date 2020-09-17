package cn.nikeo.jsonbuilder

import org.json.JSONObject

internal class JSONObjectDslImpl : JSONObjectDsl {
    val jsonObject = JSONObject()

    override fun String.to(value: Double) {
        jsonObject.put(this, value)
    }

    override fun String.to(value: Float) {
        jsonObject.put(this, value)
    }

    override fun String.to(value: Int) {
        jsonObject.put(this, value)
    }

    override fun String.to(value: Long) {
        jsonObject.put(this, value)
    }

    override fun String.to(value: Any) {
        jsonObject.put(this, value)
    }

    override fun String.to(value: String) {
        jsonObject.put(this, value)
    }

    override fun String.to(value: Boolean) {
        jsonObject.put(this, value)
    }

    override fun String.to(value: Arr) {
        val impl = JSONArrayDslImpl()
        impl.apply(value.content)
        jsonObject.put(this, impl.jsonArray)
    }

    override fun String.to(value: Obj) {
        val impl = JSONObjectDslImpl()
        impl.apply(value.content)
        jsonObject.put(this, impl.jsonObject)
    }

    override fun toString(): String = jsonObject.toString()
}
