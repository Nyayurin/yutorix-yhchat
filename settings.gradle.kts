rootProject.name = "Yutorix-Yhchat"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/Nyayurin/yutori")
            credentials {
                username = providers.gradleProperty("gpr.actor").orNull ?: System.getenv("GITHUB_ACTOR")
                password = providers.gradleProperty("gpr.token").orNull ?: System.getenv("GITHUB_TOKEN")
            }
        }
        google()
        mavenCentral()
    }
}

include(":core")
include(":adapter")
findProject(":core")!!.name = "yutorix-yhchat-core"
findProject(":adapter")!!.name = "yutorix-yhchat-adapter"