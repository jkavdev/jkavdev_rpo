package br.com.jkavdev.hibernate.application.gui;

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import br.com.jkavdev.hibernate.database.ServicesFactory;
import br.com.jkavdev.hibernate.utils.database.beans.CategoryBean;
import br.com.jkavdev.hibernate.utils.database.interfaces.IServiceFactory;
import net.miginfocom.swing.MigLayout;

public class HibernateApplicationWindow {

	private JFrame frame;
	CategoryGridPanel categoryGridPanel;
	// deixa muito atrelado quem eh a implementacao dos servicos com a camada de
	// visao, change this please
	private IServiceFactory services = new ServicesFactory();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HibernateApplicationWindow window = new HibernateApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HibernateApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));

		categoryGridPanel = new CategoryGridPanel();
		
		loadCategories();
		
		frame.getContentPane().add(categoryGridPanel, "cell 0 0,grow");
	}

	//carrega categorias
	private void loadCategories() {
		List<CategoryBean> categories = services.getCategoryServices().findAllcategories();

		//passamos as categorias para adicionar as linhas
		for (CategoryBean category : categories) {
			categoryGridPanel.addCategoryRow(category);
		}
	}

}
