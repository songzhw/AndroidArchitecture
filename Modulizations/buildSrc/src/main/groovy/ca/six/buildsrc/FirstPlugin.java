package ca.six.buildsrc;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class FirstPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.println("this is songzhw's G1 plugin");
    }
}