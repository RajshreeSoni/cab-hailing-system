package com.cab.hailing.system;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;

/**
 * Starter class.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SuppressWarnings({"PMD.UseUtilityClass"})
public class Starter extends SpringBootServletInitializer {

  @Autowired
  private Environment environment;

  /**
   * Configure.
   * @param builder {@link SpringApplicationBuilder}.
   * @return {@link SpringApplicationBuilder}.
   */
  @Override
  protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {

    if (!Arrays.asList(environment.getActiveProfiles()).contains("test")) {
      builder.banner(new ResourceBanner(new DefaultResourceLoader().getResource("banner.txt")));
    }

    builder.sources(Starter.class);

    return builder;
  }

  /**
   * main.
   * @param args {@link String} args.
   */
  public static void main(final String... args) {
    SpringApplication.run(Starter.class, args);
  }
}

