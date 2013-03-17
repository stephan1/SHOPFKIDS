package com.oracle.shopforkids.sessions;

import com.oracle.shopforkids.entities.Continent;
import com.oracle.shopforkids.entities.Country;
import com.oracle.shopforkids.entities.ShRegion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "Nos_Shop_Locali_SB", mappedName = "ShopForKids-ShopForKidsEJB-Nos_Shop_Locali_SB")
public class Nos_Shop_Locali_SB
        implements Nos_Shop_Locali_SBLocal, Nos_Shop_Locali_SBRemote
{

    /**
     * @generated DT_ID=none
     */
    @PersistenceContext(unitName="ShopForKidsEJB")
    private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public Nos_Shop_Locali_SB() {
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
    public Continent persistContinent(Continent continent) {
        em.persist(continent);
        return continent;
    }

    /**
     * @generated DT_ID=none
     */
    public Continent mergeContinent(Continent continent) {
        return em.merge(continent);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeContinent(Continent continent) {
        continent = em.find(Continent.class, continent.getContinentId());
        em.remove(continent);
    }

    /**
     * @generated DT_ID=none
     */
    public Country persistCountry(Country country) {
        em.persist(country);
        return country;
    }

    /**
     * @generated DT_ID=none
     */
    public Country mergeCountry(Country country) {
        return em.merge(country);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeCountry(Country country) {
        country = em.find(Country.class, country.getCountryId());
        em.remove(country);
    }

    /**
     * @generated DT_ID=none
     */
    public ShRegion persistShRegion(ShRegion shRegion) {
        em.persist(shRegion);
        return shRegion;
    }

    /**
     * @generated DT_ID=none
     */
    public ShRegion mergeShRegion(ShRegion shRegion) {
        return em.merge(shRegion);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeShRegion(ShRegion shRegion) {
        shRegion = em.find(ShRegion.class, shRegion.getRegionId());
        em.remove(shRegion);
    }

}
