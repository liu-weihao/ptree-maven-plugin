package com.dx.ss.plugins.ptree.main;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "generate")
public class MainTree extends AbstractMojo {

	/**
     * JDBC Driver to use if a sql.script.file is specified.
     */
    @Parameter(property="ptree.generator.jdbcDriver")
    private String jdbcDriver;

    /**
     * JDBC URL to use if a sql.script.file is specified.
     */
    @Parameter(property="ptree.generator.jdbcURL")
    private String jdbcURL;

    /**
     * JDBC user ID to use if a sql.script.file is specified.
     */
    @Parameter(property="ptree.generator.jdbcUserId")
    private String jdbcUserId;

    /**
     * JDBC password to use if a sql.script.file is specified.
     */
    @Parameter(property="ptree.generator.jdbcPassword")
    private String jdbcPassword;

    /**
     * Comma delimited list of table names to generate.
     */
    @Parameter(property="ptree.generator.tableNames")
    private String tableNames;

    
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("ptree-maven-plugin execute...");
	}

}
