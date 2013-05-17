package controllers;

import be.objectify.deadbolt.java.DeadboltHandler;
import be.objectify.deadbolt.java.actions.*;
import play.*;
import play.mvc.*;

import security.MyDeadboltHandler;
import views.html.*;

/**
 * クラス全体で認証が必要な場合は
 * @ BeforeAccessをつける
 */
public class Application extends Controller {

    /**
     * @ BeforeAccess(deferred = true)をつけるとDeadBoltを適用しない
     * @return
     */
    @BeforeAccess(deferred = true)
    public static Result index() {
        return ok(index.render("TOP"));
    }

    /**
     * @ BeforeAccessは、beforeAuthCheckを呼び出す
     * @return
     */
    @BeforeAccess
    public static Result index2() {
        return ok(index.render("TOP2"));
    }

    /**
     * 共通の判定による処理
     * ユーザーがいるかいないか程度
     * @return
     */
    @SubjectPresent
    public static Result allOk() {
        return ok(accessOk.render("@SubjectPresent"));
    }

    /**
     * Subjectの返り値がある場合のみ
     * @return
     */
    @SubjectNotPresent
    public static Result allNg() {
        return ok(accessOk.render("@SubjectNotPresent"));
    }

    /**
     * SubjectのRoleに含まれている場合
     * @return
     */
    @Restrict("KAZU")
    public static Result kazuOk() {
        return ok(accessOk.render("@Restrict"));
    }

    /**
     * 両方含まれている場合
     * @return
     */
    @Restrict({"HIRO", "KAZU"})
    public static Result hiroAndKazuOk() {
        return ok(accessOk.render("@Restrict"));
    }

    /**
     * 両方のうちどちらかが含まれている場合
     * @return
     */
    @Restrictions({@And("HIRO"), @And("KAZU")})
    public static Result kazuOrHiroOk() {
        return ok(accessOk.render("@Restrict"));
    }

}
