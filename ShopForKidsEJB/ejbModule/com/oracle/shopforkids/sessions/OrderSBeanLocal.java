package com.oracle.shopforkids.sessions;

import com.oracle.shopforkids.entities.Oneorder;
import com.oracle.shopforkids.entities.ShCartecredit;
import com.oracle.shopforkids.entities.ShOrder;
import com.oracle.shopforkids.entities.Warehouse;
import javax.ejb.Local;


/**
 * @generated DT_ID=none
 */
@Local
public interface OrderSBeanLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Oneorder persistOneorder(Oneorder oneorder);

    /**
     * @generated DT_ID=none
     */
    public Oneorder mergeOneorder(Oneorder oneorder);

    /**
     * @generated DT_ID=none
     */
    public void removeOneorder(Oneorder oneorder);

    /**
     * @generated DT_ID=none
     */
    public ShOrder persistShOrder(ShOrder shOrder);

    /**
     * @generated DT_ID=none
     */
    public ShOrder mergeShOrder(ShOrder shOrder);

    /**
     * @generated DT_ID=none
     */
    public void removeShOrder(ShOrder shOrder);

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

    /**
     * @generated DT_ID=none
     */
    public ShCartecredit persistShCartecredit(ShCartecredit shCartecredit);

    /**
     * @generated DT_ID=none
     */
    public ShCartecredit mergeShCartecredit(ShCartecredit shCartecredit);

    /**
     * @generated DT_ID=none
     */
    public void removeShCartecredit(ShCartecredit shCartecredit);

}
