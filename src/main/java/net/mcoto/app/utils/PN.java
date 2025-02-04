package net.mcoto.app.utils;

import net.mcoto.app.models.PN_Model;

public enum PN {
	
	MAIN(new PN_Model("Bienvenido | StoreMC","/WEB-INF/pages/main-view.jsp","Leccion 1")),
	LOGIN(new PN_Model("Login | StoreMC","/WEB-INF/pages/auth/login-view.jsp","Leccion 2")),
	REGISTER(new PN_Model("Registro | StoreMC","/WEB-INF/pages/auth/register-view.jsp","Leccion 3")),
	ROLE(new PN_Model("Roles | StoreMC","/WEB-INF/pages/auth/role-view.jsp","Leccion 4")),
	PERSON(new PN_Model("Personas | StoreMC","/WEB-INF/pages/persons/person-view.jsp","Leccion 5")),
	PERSON_UPSERT(new PN_Model("Personas Save-Update | StoreMC","/WEB-INF/pages/persons/upsert-view.jsp","Leccion 6")),
	USER(new PN_Model("Usuarios | StoreMC","/WEB-INF/pages/users/users-view.jsp","Leccion 7")),
	USER_UPSERT(new PN_Model("Usuarios Save-Update | StoreMC","/WEB-INF/pages/users/upsert-view.jsp","Leccion 7"));
	
	private final PN_Model model;
	
	private PN(PN_Model model) {
		this.model = model;
	}
	
	public PN_Model getModel() {
		return model;
	}

}
