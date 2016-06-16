package br.com.jkavdev.hibernate.application.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.jkavdev.hibernate.utils.database.beans.CategoryBean;
import net.miginfocom.swing.MigLayout;

public class CategoryGridPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final JTable tableCategoryModel;
	private final DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public CategoryGridPanel() {

		String[] columnNames = new String[] { "ID", "Name", "Description" };

		this.tableModel = new DefaultTableModel(columnNames, 0);

		setLayout(new MigLayout("", "[grow]", "[grow]"));

		tableCategoryModel = new JTable(this.tableModel);
		tableCategoryModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCategoryModel.setCellSelectionEnabled(true);
		
		add(tableCategoryModel, "cell 0 0 2 2,grow");
		add(this.tableCategoryModel.getTableHeader(), BorderLayout.NORTH);

	}

	public void addCategoryRow(CategoryBean category) {
		this.tableModel.addRow(new String[] { 
				String.valueOf(category.getId()), 
				category.getName(), 
				category.getDescription() });
	}

}
