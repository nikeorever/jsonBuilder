jsonBuilder
===========

A Kotlin DSL and Kotlin builder API for constructing json.

DSL:
```kotlin
buildJSONObject {
    "book_category" to "Programming and development"
    "book_ratings" to 5
    "book_language" to "English"
    "books" to Arr {
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
```
```json
{
  "book_category": "Programming and development",
  "book_ratings": 5,
  "book_language": "English",
  "books": [
    {
      "book_name": "Orphan Black Classified Clone Reports: The Secret Files of Dr. Delphine Cormier (English Edition)",
      "book_author": "Delphine Cormier",
      "book_price": 280
    },
    {
      "book_name": "HTML5 Canvas: Native Interactivity and Animation for the Web (English Edition)",
      "book_author": "Steve Fulton , Jeff Fulton",
      "book_price": 296.5
    }
  ]
}
```
