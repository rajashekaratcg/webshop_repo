/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rajassub
 ** Copyright: (c) Jun 24, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.petsupplies.repository.category;

import org.springframework.data.repository.CrudRepository;

import com.petsupplies.model.role.Role;

/**
 * Dao services for {@link Role}
 *
 * @author rajassub (c) Jun 24, 2015, Sogeti B.V.
 */
public interface RoleRepository extends CrudRepository<Role, Long>
{
   Role findByName(String name);
}
