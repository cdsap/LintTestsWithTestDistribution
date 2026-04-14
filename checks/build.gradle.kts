plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.android.lint)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

lint {
    htmlReport = true
    htmlOutput = file("lint-report.html")
    textReport = true
    absolutePaths = false
    ignoreTestSources = true
}

dependencies {
    // For a description of the below dependencies, see the main project README
    compileOnly(libs.bundles.lint.api)
    testImplementation(libs.bundles.lint.tests)
    testImplementation(libs.bundles.lint.api)
testImplementation("org.junit.vintage:junit-vintage-engine:6.0.3")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
     
    develocity.testDistribution {
        enabled.set(true) 
         maxLocalExecutors.set(0)
          maxRemoteExecutors.set(3)
    }
}