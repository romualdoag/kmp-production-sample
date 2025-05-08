import org.gradle.caching.http.HttpBuildCache
import java.net.URI

rootProject.name = "RssReader"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

buildCache {
    remote(HttpBuildCache::class.java) {
        url = URI("https://gradle.romualdoag.com.br/cache/")
        isPush = true 

        credentials {
            username = System.getenv("GRADLE_CACHE_USERNAME") 
            password = System.getenv("GRADLE_CACHE_PASSWORD")
        }
    }
}

include(":shared")
include(":androidApp")
