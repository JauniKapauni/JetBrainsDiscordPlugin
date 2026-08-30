package com.github.jaunikapauni.jetbrainsdiscordplugin.startup

import com.intellij.openapi.application.ApplicationInfo
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class MyProjectActivity : ProjectActivity {

    override suspend fun execute(project: Project) {
        //thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
        val ideName = ApplicationInfo.getInstance().versionName
        val projectName = project.name

        println("IDE: $ideName")
        println("Project: $projectName")

    }
}