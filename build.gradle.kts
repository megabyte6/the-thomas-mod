plugins {
    id("fabric-loom") version "1.9-SNAPSHOT"
    id("com.modrinth.minotaur") version "2.+"
}

project.version = providers.gradleProperty("mod_version").get()
project.group = providers.gradleProperty("maven_group").get()

base {
    archivesName = providers.gradleProperty("archives_base_name")
}

repositories {
    // Add repositories to retrieve artifacts from in here.
    // You should only use this when depending on other mods because
    // Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
    // See https://docs.gradle.org/current/userguide/declaring_repositories.html
    // for more information about repositories.

    maven {
        name = "Terraformers"
        url = uri("https://maven.terraformersmc.com/")
    }
}

loom {
    splitEnvironmentSourceSets()

    mods {
        create("thethomasmod") {
            sourceSet(sourceSets["main"])
            sourceSet(sourceSets["client"])
        }
    }

}

fabricApi {
    configureDataGeneration {
        client = true
    }
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:${providers.gradleProperty("minecraft_version").get()}")
    mappings("net.fabricmc:yarn:${providers.gradleProperty("yarn_mappings").get()}:v2")
    modImplementation("net.fabricmc:fabric-loader:${providers.gradleProperty("loader_version").get()}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${providers.gradleProperty("fabric_version").get()}")
    modImplementation("com.terraformersmc:modmenu:${providers.gradleProperty("modmenu_version").get()}")
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

modrinth {
    // Remember to have the MODRINTH_TOKEN environment variable set or else this will fail - just make sure it stays private!
    token.set(System.getenv("MODRINTH_TOKEN"))
    projectId.set("ueOBZDS1")
    versionType.set(providers.gradleProperty("modrinth_version_type"))
    uploadFile.set(tasks.jar)
    gameVersions.addAll(providers.gradleProperty("modrinth_release_game_versions").get().split(",").map(String::trim))
    syncBodyFrom.set(rootProject.file("README.md").readText())
}

tasks {
    build {
        dependsOn(processResources)
    }

    processResources {
        filesMatching("fabric.mod.json") {
            expand(project.properties)
        }
    }

    jar {
        from("LICENSE") {
            rename { "${it}_${project.base.archivesName.get()}" }
        }
    }

    withType<JavaCompile>().configureEach {
        options.release = providers.gradleProperty("jdk_target").map { it.toInt() }
    }

    modrinth.get().dependsOn(modrinthSyncBody)
}
