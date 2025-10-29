package com.pedro.javaRaven.repositories;

import com.pedro.javaRaven.models.ProductDocument;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductRepository {
    private final IDocumentSession session;

    @Autowired
    public ProductRepository(IDocumentSession session){
        this.session = session;
    }

    public void save(ProductDocument product){
        session.store(product);
        session.saveChanges();
    }

    public ProductDocument findById(String id){
        return session.load(ProductDocument.class, id);
    }

    public List<ProductDocument> findAll(){
        return session.query(ProductDocument.class).toList();
    }

    public void delete(String id){
        var product = session.load(ProductDocument.class, id);
        if(product != null){
            session.delete(product);
            session.saveChanges();
        }
    }

}
