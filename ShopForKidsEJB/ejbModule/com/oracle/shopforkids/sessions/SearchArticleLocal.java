package com.oracle.shopforkids.sessions;

import com.oracle.shopforkids.entities.Product;
import com.oracle.shopforkids.entities.ShArticle;
import javax.ejb.Local;


/**
 * @generated DT_ID=none
 */
@Local
public interface SearchArticleLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

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
    public Product persistProduct(Product product);

    /**
     * @generated DT_ID=none
     */
    public Product mergeProduct(Product product);

    /**
     * @generated DT_ID=none
     */
    public void removeProduct(Product product);

}
