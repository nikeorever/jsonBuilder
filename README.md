jsonBuilder
===========

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/cn.nikeo.jsonBuilder/jsonBuilder/badge.svg)](https://maven-badges.herokuapp.com/maven-central/cn.nikeo.jsonBuilder/jsonBuilder)

A Kotlin DSL and Kotlin builder API for constructing json.

DSL:
```kotlin
obj {
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
```
JSON(After formatting):
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

Download
--------

#### Gradle Kotlin Script
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("cn.nikeo.jsonBuilder:jsonBuilder:0.2.0")
}
```

#### Maven
```xml
<dependency>
  <groupId>cn.nikeo.jsonBuilder</groupId>
  <artifactId>jsonBuilder</artifactId>
  <version>0.2.0</version>
  <type>module</type>
</dependency>
```

License
-------

Apache License, Version 2.0, ([LICENSE](https://github.com/nikeorever/jsonBuilder/blob/trunk/LICENSE) or [https://www.apache.org/licenses/LICENSE-2.0](https://www.apache.org/licenses/LICENSE-2.0))

