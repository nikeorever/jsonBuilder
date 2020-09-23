package cn.nikeo.jsonbuilder

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class JsonBuilderTest {

    @Test
    fun testJsonArray() {

        val obj = obj {
            "book_category" to "Programming and development"
            "book_ratings" to 5
            "book_language" to "English"
            "books" to arr {
                obj {
                    "book_name" to "Orphan Black Classified Clone Reports: The Secret Files of Dr. Delphine Cormier (English Edition)"
                    "book_author" to "Delphine Cormier"
                    "book_price" to 280
                }
                obj {
                    "book_name" to "HTML5 Canvas: Native Interactivity and Animation for the Web (English Edition)"
                    "book_author" to "Steve Fulton , Jeff Fulton"
                    "book_price" to 296.5
                }
            }
        }
        println(obj)
        val json = arr {
            for (index in 0..3) int(index)
        }
        assertThat(json.toString()).isEqualTo("[0,1,2,3]")
    }

    @Test
    fun testJsonObject() {
        val school = obj {
            "university_name" to "Tsinghua University"
            "university_address" to "Beijing"
        }

        assertThat(school.toString()).isEqualTo("{\"university_address\":\"Beijing\",\"university_name\":\"Tsinghua University\"}")
    }
}