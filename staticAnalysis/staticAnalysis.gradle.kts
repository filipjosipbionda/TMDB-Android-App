apply(from = "$rootDir/staticAnalysis/detekt/detekt.gradle")
apply(from = "$rootDir/staticAnalysis/ktlint/ktlint.gradle")

val staticAnalysis by tasks.registering {
    group = "verification"
    description = "Generate StaticAnalysis reports."

    dependsOn(tasks.named("ktlint"))
    dependsOn(tasks.named("detekt"))
}
