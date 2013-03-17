package com.oracle.shopforkids.sessions;

import com.oracle.shopforkids.entities.Product;
import com.oracle.shopforkids.entities.ShArticle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "SearchArticle", mappedName = "ShopForKids-ShopForKidsEJB-SearchArticle")
public class SearchArticle
        implements SearchArticleLocal, SearchArticleRemote
{

    /**
     * @generated DT_ID=none
     */
    @PersistenceContext(unitName="ShopForKidsEJB")
    private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public SearchArticle() {
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

}
