package models;

import be.objectify.deadbolt.core.models.Permission;
import be.objectify.deadbolt.core.models.Role;
import be.objectify.deadbolt.core.models.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author harakazuhiro
 * @since 2013/05/17 15:57
 */
public class MySubject implements Subject {

    @Override
    public List<? extends Role> getRoles() {
        return new ArrayList<Role>(){{
            add(new MyRole());
            add(new YourRole());
        }};
    }

    @Override
    public List<? extends Permission> getPermissions() {
        return null;
    }

    @Override
    public String getIdentifier() {
        return "1";
    }
}
