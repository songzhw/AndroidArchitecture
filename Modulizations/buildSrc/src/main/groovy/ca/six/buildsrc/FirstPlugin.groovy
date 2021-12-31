package ca.six.buildsrc;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

class FirstPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        println "this is songzhw's G1 plugin"
        project.task("s1") {
            doLast {
                println "songzhw s1"
            }
        }
    }
}