package cn.nikeo.jsonbuilder

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class JsonBuilderTest {

    @Test
    fun testJsonArray() {
        val json = buildJSONArray {
            for (index in 0..3) int(index)
        }
        assertThat(json).isEqualTo("[0,1,2,3]")
    }

    @Test
    fun testJsonObject() {
        val school = buildJSONObject {
            "university_name" to "Tsinghua University"
            "university_address" to "Beijing"
        }

        assertThat(school).isEqualTo("{\"university_address\":\"Beijing\",\"university_name\":\"Tsinghua University\"}")
    }
}