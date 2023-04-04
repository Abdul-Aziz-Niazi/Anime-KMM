import java.net.URI

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven ( url =  "https://oss.sonatype.org/content/repositories/snapshots/" )

    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AnimeKMM"
include(":androidApp")
include(":shared")