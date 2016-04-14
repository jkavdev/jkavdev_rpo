/*desabilitando botoes*/
function disableButtons() {
	updateButton.disable();
	deleteButton.disable();
}

/*habilitando botoes*/
function enableButtons() {
	updateButton.enable();
	deleteButton.enable();
}

/*desabilitando botoes*/
function unselectRows() {
	disableButtons();
	dataTable.unselectAllRows();
}
