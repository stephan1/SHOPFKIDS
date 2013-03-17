package com.oracle.shopforkids.sessions;

import com.oracle.shopforkids.entities.Fournisseur;
import com.oracle.shopforkids.entities.Product;
import com.oracle.shopforkids.entities.ShArticle;
import com.oracle.shopforkids.entities.ShCatalog;
import com.oracle.shopforkids.entities.ShCategory;
import com.oracle.shopforkids.entities.Warehouse;
import javax.ejb.Local;


/**
 * @generated DT_ID=none
 */
@Local
public interface CatalogsSBLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Product persistProduct(Product product);

    /**
     * @generated DT_ID=none
     */
    public Product mergeProduct(Product product);

    /**
     * @generated DT_ID=none
     */
    public void removeProduct(Product product);

    /**
     * @generated DT_ID=none
     */
    public Fournisseur persistFournisseur(Fournisseur fournisseur);

    /**
     * @generated DT_ID=none
     */
    public Fournisseur mergeFournisseur(Fournisseur fournisseur);

    /**
     * @generated DT_ID=none
     */
    public void removeFournisseur(Fournisseur fournisseur);

    /**
     * @generated DT_ID=none
     */
    public ShArticle persistShArticle(ShArticle shArticle);

    /**
     * @generated DT_ID=none
     */
    public ShArticle mergeShArticle(ShArticle shArticle);

    /**
     * @generated DT_ID=none
     */
    public void removeShArticle(ShArticle shArticle);

    /**
     * @generated DT_ID=none
     */
    public ShCatalog persistShCatalog(ShCatalog shCatalog);

    /**
     * @generated DT_ID=none
     */
    public ShCatalog mergeShCatalog(ShCatalog shCatalog);

    /**
     * @generated DT_ID=none
     */
    public void removeShCatalog(ShCatalog shCatalog);

    /**
     * @generated DT_ID=none
     */
    public ShCategory persistShCategory(ShCategory shCategory);

    /**
     * @generated DT_ID=none
     */
    public ShCategory mergeShCategory(ShCategory shCategory);

    /**
     * @generated DT_ID=none
     */
    public void removeShCategory(ShCategory shCategory);

    /**
     * @generated DT_ID=none
     */
    public Warehouse persistWarehouse(Warehouse warehouse);

    /**
     * @generated DT_ID=none
     */
    public Warehouse mergeWarehouse(Warehouse warehouse);

    /**
     * @generated DT_ID=none
     */
    public void removeWarehouse(Warehouse warehouse);

}
