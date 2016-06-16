package br.com.jkavdev.hibernate.application.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;

import br.com.jkavdev.hibernate.database.ServiceFactory;
import br.com.jkavdev.hibernate.utils.database.beans.CategoryBean;
import br.com.jkavdev.hibernate.utils.database.interfaces.IServiceFactory;
import net.miginfocom.swing.MigLayout;


public class ApplicationWindow {

	private JFrame frame;
	private CategoryGridPanel categoryGridPanel;
	private IServiceFactory services = new ServiceFactory();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
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
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Hibernate Sample");
		frame.setBounds(100, 100, 800, 600);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));

		categoryGridPanel = new CategoryGridPanel();
		frame.getContentPane().add(categoryGridPanel, "cell 0 0,grow");
		
		loadCategories();
	}

	public void loadCategories() {
		List<CategoryBean> categories = services.getCategoryServices().findAllCategories();
		
		for (CategoryBean categoryBean : categories) {
			categoryGridPanel.addCategoryRow(categoryBean);
		}
	}

}
