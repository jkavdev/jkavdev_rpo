$(function() {
	
	var settings = {
			type: 'json',
			filelimit: 1,
			allow: '*.(jpg|jpeg|png)',
			action: '/fotos/',
			complete: function(resposta){
				console.log('........ resposta', resposta);
			}
	};
	
	UIkit.uploadSelect($('#upload-select'), settings);
	UIkit.uploadDrop($('#upload-drop'), settings);
	
});