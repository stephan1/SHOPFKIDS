package com.oracle.shopforkids.sessions;

import com.oracle.shopforkids.entities.Oneorder;
import com.oracle.shopforkids.entities.ShCartecredit;
import com.oracle.shopforkids.entities.ShOrder;
import com.oracle.shopforkids.entities.Warehouse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "OrderSBean", mappedName = "ShopForKids-ShopForKidsEJB-OrderSBean")
public class OrderSBean
        implements OrderSBeanLocal, OrderSBeanRemote
{

    /**
     * @generated DT_ID=none
     */
    @PersistenceContext(unitName="ShopForKidsEJB")
    private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public OrderSBean() {
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
    public Oneorder persistOneorder(Oneorder oneorder) {
        em.persist(oneorder);
        return oneorder;
    }

    /**
     * @generated DT_ID=none
     */
    public Oneorder mergeOneorder(Oneorder oneorder) {
        return em.merge(oneorder);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeOneorder(Oneorder oneorder) {
        oneorder = em.find(Oneorder.class, oneorder.getIdOneorder());
        em.remove(oneorder);
    }

    /**
     * @generated DT_ID=none
     */
    public ShOrder persistShOrder(ShOrder shOrder) {
        em.persist(shOrder);
        return shOrder;
    }

    /**
     * @generated DT_ID=none
     */
    public ShOrder mergeShOrder(ShOrder shOrder) {
        return em.merge(shOrder);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeShOrder(ShOrder shOrder) {
        shOrder = em.find(ShOrder.class, shOrder.getIdOrder());
        em.remove(shOrder);
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

    /**
     * @generated DT_ID=none
     */
    public ShCartecredit persistShCartecredit(ShCartecredit shCartecredit) {
        em.persist(shCartecredit);
        return shCartecredit;
    }

    /**
     * @generated DT_ID=none
     */
    public ShCartecredit mergeShCartecredit(ShCartecredit shCartecredit) {
        return em.merge(shCartecredit);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeShCartecredit(ShCartecredit shCartecredit) {
        shCartecredit = em.find(ShCartecredit.class, shCartecredit.getIdCredit());
        em.remove(shCartecredit);
    }

}
