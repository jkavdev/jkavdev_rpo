package br.com.jkavdev.wpattern.spring.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class Dataset {

	private static List<ContactBean> contacts = new ArrayList<>();

	private static int id = 0;

	static {
		contacts.add(new ContactBean(id++, "jhonatan", "kolen", "jhonatan@gmail.com", "123"));
		contacts.add(new ContactBean(id++, "luvas", "santos", "lucas@gmail.com", "15"));
		contacts.add(new ContactBean(id++, "douglas", "neves", "douglas@gmail.com", "125"));
		contacts.add(new ContactBean(id++, "marcio", "alves", "marcio@gmail.com", "143"));
	}

	public static List<ContactBean> getContacts() {
		return contacts;
	}

	public static void setContacts(List<ContactBean> contacts) {
		Dataset.contacts = contacts;
	}

	public static void addContact(ContactBean contactBean) {
		contactBean.setId(id++);
		contacts.add(contactBean);
	}

	public static void updateContact(ContactBean contactBean) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getId() == contactBean.getId()) {
				contacts.set(i, contactBean);
			}

		}
	}

}
