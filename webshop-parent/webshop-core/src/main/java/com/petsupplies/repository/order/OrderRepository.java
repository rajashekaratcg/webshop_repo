/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rajassub
 ** Copyright: (c) Jun 29, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.petsupplies.repository.order;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.petsupplies.model.order.Order;

/**
 * Orders related DAO services.
 *
 * @author rajassub (c) Jun 29, 2015, Sogeti B.V.
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, Long>
{

}
