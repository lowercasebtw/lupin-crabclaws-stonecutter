plugins {
    id("dev.kikugie.stonecutter")
    alias(libs.plugins.publishing)
}

stonecutter active "1.21.10-neoforge" /* [SC] DO NOT EDIT */

stonecutter tasks {
    order("publishMods", versionComparator)
}

stonecutter parameters {
    val loader = node.project.property("loom.platform")
    constants["fabric"] = loader == "fabric"
    constants["forge"] = loader == "forge"
    constants["neoforge"] = loader == "neoforge"
    constants["forge-like"] = loader == "neoforge" || loader == "forge"
}

tasks.named("publishMods") {
    group = "build"
}
