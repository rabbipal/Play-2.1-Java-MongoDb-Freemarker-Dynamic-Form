package controllers;

import play.mvc.*;
import play.data.*;

import models.*;

public class Application extends Controller {
	static Form<Template> templateForm = Form.form(Template.class);

	public static Result index() {
		return redirect(routes.Application.templates());
	}

	public static Result templates() {
		return ok(views.html.index.render(Template.all(), templateForm));
	}

	public static Result newTemplate() {
		Form<Template> filledForm = templateForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Template.all(),
					filledForm));
		} else {
			Template.create(filledForm.get());
			return redirect(routes.Application.templates());
		}
	}

	public static Result deleteTemplate(String id) {
		Template.delete(id);
		return redirect(routes.Application.templates());
	}

	public static Result viewTemplate(String id) {
		return redirect(routes.ApplicationFTL.index(id));
	}

}
