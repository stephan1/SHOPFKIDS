package com.oracle.shopforkids.sessions;

import com.oracle.shopforkids.entities.Continent;
import com.oracle.shopforkids.entities.Country;
import com.oracle.shopforkids.entities.ShRegion;
import javax.ejb.Remote;


/**
 * @generated DT_ID=none
 */
@Remote
public interface Nos_Shop_Locali_SBRemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Continent persistContinent(Continent continent);

    /**
     * @generated DT_ID=none
     */
    public Continent mergeContinent(Continent continent);

    /**
     * @generated DT_ID=none
     */
    public void removeContinent(Continent continent);

    /**
     * @generated DT_ID=none
     */
    public Country persistCountry(Country country);

    /**
     * @generated DT_ID=none
     */
    public Country mergeCountry(Country country);

    /**
     * @generated DT_ID=none
     */
    public void removeCountry(Country country);

    /**
     * @generated DT_ID=none
     */
    public ShRegion persistShRegion(ShRegion shRegion);

    /**
     * @generated DT_ID=none
     */
    public ShRegion mergeShRegion(ShRegion shRegion);

    /**
     * @generated DT_ID=none
     */
    public void removeShRegion(ShRegion shRegion);

}
