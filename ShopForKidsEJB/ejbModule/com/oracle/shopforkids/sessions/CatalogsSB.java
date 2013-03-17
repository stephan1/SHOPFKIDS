package com.oracle.shopforkids.sessions;

import com.oracle.shopforkids.entities.Fournisseur;
import com.oracle.shopforkids.entities.Product;
import com.oracle.shopforkids.entities.ShArticle;
import com.oracle.shopforkids.entities.ShCatalog;
import com.oracle.shopforkids.entities.ShCategory;
import com.oracle.shopforkids.entities.Warehouse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "CatalogsSB", mappedName = "ShopForKids-ShopForKidsEJB-CatalogsSB")
public class CatalogsSB
        implements CatalogsSBLocal, CatalogsSBRemote
{

    /**
     * @generated DT_ID=none
     */
    @PersistenceContext(unitName="ShopForKidsEJB")
    private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public CatalogsSB() {
    }

    /**
     * @generated DT_ID=none
     */
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public Product persistProduct(Product product) {
        em.persist(product);
        return product;
    }

    /**
     * @generated DT_ID=none
     */
    public Product mergeProduct(Product product) {
        return em.merge(product);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeProduct(Product product) {
        product = em.find(Product.class, product.getIdProd());
        em.remove(product);
    }

    /**
     * @generated DT_ID=none
     */
    public Fournisseur persistFournisseur(Fournisseur fournisseur) {
        em.persist(fournisseur);
        return fournisseur;
    }

    /**
     * @generated DT_ID=none
     */
    public Fournisseur mergeFournisseur(Fournisseur fournisseur) {
        return em.merge(fournisseur);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeFournisseur(Fournisseur fournisseur) {
        fournisseur = em.find(Fournisseur.class, fournisseur.getIdSupplier());
        em.remove(fournisseur);
    }

    /**
     * @generated DT_ID=none
     */
    public ShArticle persistShArticle(ShArticle shArticle) {
        em.persist(shArticle);
        return shArticle;
    }

    /**
     * @generated DT_ID=none
     */
    public ShArticle mergeShArticle(ShArticle shArticle) {
        return em.merge(shArticle);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeShArticle(ShArticle shArticle) {
        shArticle = em.find(ShArticle.class, shArticle.getIdArticle());
        em.remove(shArticle);
    }

    /**
     * @generated DT_ID=none
     */
    public ShCatalog persistShCatalog(ShCatalog shCatalog) {
        em.persist(shCatalog);
        return shCatalog;
    }

    /**
     * @generated DT_ID=none
     */
    public ShCatalog mergeShCatalog(ShCatalog shCatalog) {
        return em.merge(shCatalog);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeShCatalog(ShCatalog shCatalog) {
        shCatalog = em.find(ShCatalog.class, shCatalog.getIdCatalogss());
        em.remove(shCatalog);
    }

    /**
     * @generated DT_ID=none
     */
    public ShCategory persistShCategory(ShCategory shCategory) {
        em.persist(shCategory);
        return shCategory;
    }

    /**
     * @generated DT_ID=none
     */
    public ShCategory mergeShCategory(ShCategory shCategory) {
        return em.merge(shCategory);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeShCategory(ShCategory shCategory) {
        shCategory = em.find(ShCategory.class, shCategory.getIdCategories());
        em.remove(shCategory);
    }

    /**
     * @generated DT_ID=none
     */
    public Warehouse persistWarehouse(Warehouse warehouse) {
        em.persist(warehouse);
        return warehouse;
    }

    /**
     * @generated DT_ID=none
     */
    public Warehouse mergeWarehouse(Warehouse warehouse) {
        return em.merge(warehouse);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeWarehouse(Warehouse warehouse) {
        warehouse = em.find(Warehouse.class, warehouse.getIdWarehouse());
        em.remove(warehouse);
    }

}
