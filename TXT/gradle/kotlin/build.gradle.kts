// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        jcenter()
    }
    dependencies {
        runtimeOnly(group = "org.springframework", name = "spring-core", version = "2.5")
		classpath("org.springframework:spring-aop:2.5")
		testRuntimeOnly("commons-io:commons-io:1.8.7") {
			isTransitive = true
		}
		implementation(group = "org.hibernate", name = "hibernate", version = "3.0.5") {
			isTransitive = true
		}
    }
}

apply from: rootProject.file('gradle/check.gradle')