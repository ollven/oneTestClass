import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.projectFeatures.spaceConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2023.11"

project {

    buildType(Build)

    features {
        spaceConnection {
            id = "PROJECT_EXT_43"
            displayName = "TCfour project"
            serverUrl = "https://tcollvenfour.jetbrains.space"
            clientId = "f095580a-3320-43cd-978c-d0d65654fe63"
            clientSecret = "credentialsJSON:fbb8b741-86f6-4bdf-9303-6b1fd39c8c44"
        }
    }
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
        win64TestBuildStep {}
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
        commitStatusPublisher {
            publisher = space {
                authType = connection {
                    connectionId = "PROJECT_EXT_43"
                }
            }
        }
    }
})
fun BuildSteps.win64TestBuildStep(init: ScriptBuildStep.() -> Unit): ScriptBuildStep {
    val result = ScriptBuildStep(init)

    result.name = "Test"
    result.scriptContent =
        """echo Do Stuff"""
    result.formatStderrAsError = true
    step(result)

    return result

}