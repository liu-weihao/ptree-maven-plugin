package com.dx.ss.plugins.ptree.main;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.dx.ss.plugins.ptree.config.BaseConfiguration;
import com.dx.ss.plugins.ptree.config.xml.ConfigurationParser;
import com.dx.ss.plugins.ptree.generate.Mybatis3Generator;

/**
 * Generator Mojo. Only configuration file will be supported.
 * @author Frank
 */
@Mojo(name = "gen", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class PTreeGeneratorMojo extends AbstractMojo {
	
	private Log log = getLog();
	
	/**
     * Maven Project.
     */
    @Parameter(property="project", required=true, readonly=true)
    private MavenProject project;
    
    /**
     * Output Directory.
     */
    @Parameter(property="mybatis.generator.outputDirectory", defaultValue="${project.build.directory}/generated-sources/ptree-generator", required=true)
    private File outputDirectory;
    
    /**
     * Location of the configuration file.
     */
    @Parameter(property="ptree.generator.configurationFile", defaultValue="${project.basedir}/src/main/resources/ptree-mybatis3.xml", required=true)
    private File configurationFile;
    
    
	public void execute() throws MojoExecutionException, MojoFailureException {
		log.info("ptree code generating...");
		ConfigurationParser parser = new ConfigurationParser();
		try {
			//Parse xml configuration file.
			BaseConfiguration configuration = parser.parseConfiguration(configurationFile);
			log.info(configuration.toString());
			
			MavenShellCallback mavenShellCallback = new MavenShellCallback(this);
			Mybatis3Generator generator = new Mybatis3Generator(mavenShellCallback, configuration);
			generator.generate();//generate and write files
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("generate completely! ");
	}

	public File getOutputDirectory() {
		return outputDirectory;
	}

}
