package com.dx.ss.plugins.ptree.main;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "gen", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class PTreeGeneratorMojo extends AbstractMojo {
	
	/**
     * Maven Project.
     */
    @Parameter(property="project", required=true, readonly=true)
    private MavenProject project;

    /**
     * Location of the configuration file.
     */
    @Parameter(property="ptree.generator.configurationFile", defaultValue="${project.basedir}/src/main/resources/ptreeConfig.xml", required=true)
    private File configurationFile;
    
    
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("ptree code generating...");
	}

}
