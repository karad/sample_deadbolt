package models;

import be.objectify.deadbolt.core.models.Role;

/**
 * DESCRIPTION
 *
 * @author harakazuhiro
 * @since 2013/05/17 17:02
 */
public class MyRole implements Role {
    @Override
    public String getName() {
        return "KAZU";
    }
}
