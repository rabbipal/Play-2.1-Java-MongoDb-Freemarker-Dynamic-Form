package controllers;

import static play.data.Form.form;
import static views.Freemarker._;
import static views.Freemarker.view;
import models.Product;
import models.Template;
import play.mvc.Controller;
import play.mvc.Result;

public class ApplicationFTL extends Controller {

	public static Result index(String id) {
		Template template = Template.view(id);
		String s = template.htmlText;
		if (s.contains(".ftl")) {
			return ok(view(s, _("user", session("user")),
					_("products", Product.all())));

		} else {
			response().setContentType("text/html");
			return ok(s);
		}
	}

	/*
	 * private static String getStringFromInputStream(InputStream is) {
	 * java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	 * String str = s.hasNext() ? s.next() : ""; System.out.println(str); return
	 * str; }
	 */

	public static Result product(Long id) {
		Product product = Product.byId(id);
		if (product == null) {
			return notFound();
		} else {
			return ok(view("product.ftl", _("user", session("user")),
					_("product", product)));
		}
	}

	public static Result login() {
		String user = form().bindFromRequest().get("user");
		session("user", user);
		return redirect(routes.Application.index());
	}

	public static Result logout() {
		session().clear();
		return redirect(routes.Application.index());
	}

}