package br.com.jkavdev.hibernate.application.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.jkavdev.hibernate.utils.database.beans.CategoryBean;

public class CategoryGridPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableCategoryModel;

	// modelo da tabela para criar as colunas
	private final DefaultTableModel tableModel;

	public CategoryGridPanel() {

		// nome das colunas
		String[] columnNames = new String[] { "ID", "Name", "Description" };

		// criando o modelo da tabela passando o nome das colunas
		// e informando a quantidade de linhas
		this.tableModel = new DefaultTableModel(columnNames, 0);

		setLayout(new MigLayout("", "[grow]", "[grow]"));

		// cria a tabela com as informacoes passadas da coluna
		tableCategoryModel = new JTable(this.tableModel);

		tableCategoryModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCategoryModel.setCellSelectionEnabled(true);
		add(tableCategoryModel, "cell 0 0 2 2,grow");

		// adiciona o cabeção na posicao superior
		add(this.tableCategoryModel.getTableHeader(), BorderLayout.NORTH);

	}

	//adiciona linha na tabela
	public void addCategoryRow(CategoryBean category) {
		this.tableModel.addRow(
				new String[] { String.valueOf(category.getId()), 
						category.getName(), 
						category.getDescription() });
	}

}
