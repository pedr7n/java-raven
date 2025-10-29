package com.pedro.javaRaven.document;

import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RavenConfig {

    @Value("${raven.url}")
    private String ravenUrl;

    @Value("${raven.database}")
    private String dataBaseName;

    @Bean
    public IDocumentStore documentStore() {
        DocumentStore store = new DocumentStore(ravenUrl, dataBaseName);
        store.initialize();
        return store;
    }

    @Bean
    public IDocumentSession documentSession(IDocumentStore store){
        return store.openSession();
    }
}
