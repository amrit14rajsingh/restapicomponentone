package com.example.restapicomponentone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

/**
 * All couchbase related configs to be added here. Here EnableCouchbaseRepositories is used when
 * application have multiple couchbase repository packages in dependency libraries.
 */
@Configuration
@EnableCouchbaseRepositories(
    basePackages = {
      "com.example.restapicomponentone.repository"
    })
public class CouchbaseConfig {}
