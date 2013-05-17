package security;

import be.objectify.deadbolt.core.models.Subject;
import be.objectify.deadbolt.java.AbstractDeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;
import models.MySubject;
import play.mvc.Http;
import play.mvc.Result;
import views.html.accessNG;

/**
 * DESCRIPTION
 *
 * @author harakazuhiro
 * @since 2013/05/17 15:52
 */
public class MyDeadboltHandler extends AbstractDeadboltHandler {
    @Override
    public Result beforeAuthCheck(Http.Context context) {
        String username = "Hara";
        System.out.println("AUTH");
        if(!username.equals("Hara")) {
            System.out.println("AUTH ERROR");
            return redirect("/");
        }
        return null;
        //return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Subject getSubject(Http.Context context) {
        System.out.println("SUBJECT");
        MySubject mySubject = new MySubject();
        System.out.println(mySubject.getRoles());
        return mySubject;
        //return null;
    }

    @Override
    public Result onAccessFailure(Http.Context context, String s) {
        System.out.println("ACCESS FAILURE");
        return ok(accessNG.render("ERROR"));
    }

    @Override
    public DynamicResourceHandler getDynamicResourceHandler(Http.Context context) {
        return null;
    }
}
