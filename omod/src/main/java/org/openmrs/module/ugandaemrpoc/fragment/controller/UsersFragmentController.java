package org.openmrs.module.ugandaemrpoc.fragment.controller;

import org.openmrs.api.UserService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

public class UsersFragmentController {
	
	public UsersFragmentController() {
	}
	
	public void controller(FragmentModel model, @SpringBean("userService") UserService service) {
		model.addAttribute("users", service.getAllUsers());
	}
}
