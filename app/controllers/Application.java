package controllers;

import static play.data.Form.form;
import play.*;
import play.data.Form;
import java.util.List;
import play.data.validation.Constraints.Max;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;
import play.mvc.*;
import models.Parent;
import models.Account;
import play.db.ebean.Model.Finder;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	
    	/*
    	Account account = new Account();
    	account.loginId = "buzzcam";
    	account.password = "Buzz4113";
    	account.save();
    	*/
    	
        // 現在のParentを全検索して表示
        Finder<Long, Parent> finder = new Finder<Long, Parent>(Long.class,
                Parent.class);
        List<Parent> parents = finder.all();
    	
        StringBuilder msg = new StringBuilder();
        for (Parent parent : parents) {
            msg.append(parent.toString()).append("\n");
        }
        
        System.out.println(msg);
    	
        return ok(index.render(form(LoginForm.class)));
    }
    

    public static Result campaignList() {
    	
    	return ok(campaignList.render("りすとー"));
    }
    
    public static class LoginForm {
        @Required public String id;
        @Required public String password;
        
    }
    
    public static Result login() {
    	
    	Form<LoginForm> form = form(LoginForm.class).bindFromRequest();
    	LoginForm data = form.get();
    	
    	String loginId = data.id;
    	String password = data.password;
    	
    	
    	// 現在のParentを全検索して表示
        Finder<Long, Account> finder = new Finder<Long, Account>(Long.class,
                Account.class);
        List<Account> account = finder.all();
        
        System.out.println(account.get(0).loginId);
        System.out.println(loginId);
        
        if (account.get(0).loginId.equals(loginId)) {
        	
        	if(account.get(0).password.equals(password)) {
        		System.out.println("成功");
        		return ok(campaignList.render("ログイン成功！"));
        	}
        	
        	System.out.println("失敗");
        	return ok(index.render(form(LoginForm.class)));
        } else {
        	System.out.println("失敗");
        	return ok(index.render(form(LoginForm.class)));
        }
        
        
        
    	/*
        StringBuilder msg = new StringBuilder();
        for (Parent parent : parents) {
            msg.append(parent.toString()).append("\n");
    	*/
    	/*
        Form<LoginForm> form = form(LoginForm.class).bindFromRequest();
        if(form.hasErrors()) {
        	
            return badRequest(index.render(form));
        } else {
            LoginForm data = form.get();
            return ok(login.render(data.id, data.password));
            
        }
        */
    }
    
    

}
