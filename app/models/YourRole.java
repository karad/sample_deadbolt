package models;

import be.objectify.deadbolt.core.models.Role;

/**
 * DESCRIPTION
 *
 * @author harakazuhiro
 * @since 2013/05/17 17:02
 */
public class YourRole implements Role {
    @Override
    public String getName() {
        return "HIRO";
    }
}
