plugins {
    java
    id("com.vanniktech.maven.publish") version "0.36.0"
    signing
}

group = "io.github.takenoko4096"
version = "0.1.0"

java {
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jspecify:jspecify:1.0.0")
}

val signingKey: String by project
val signingPassword: String by project

signing {
    useInMemoryPgpKeys(signingKey, signingPassword)
}

mavenPublishing {
    publishToMavenCentral()

    pom {
        name.set("mojangson-bridge")
        description.set("library of mojangson")
        url.set("https://github.com/takenoko4096/mojangson-bridge")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("takenoko4096")
                name.set("takenoko4096")
                url.set("https://github.com/takenoko4096/")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/takenoko4096/mojangson-bridge.git")
            developerConnection.set("scm:git:ssh://github.com/takenoko4096/mojangson-bridge.git")
            url.set("https://github.com/takenoko4096/mojangson-bridge/")
        }
    }
}
