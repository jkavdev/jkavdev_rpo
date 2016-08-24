function exibeNome(){
	var elNome = document.getElementById('nome');
	var nome = elNome.value;
	var elDisplay = document.getElementById('display');

	elDisplay.innerText = nome;

	console.log(nome);

}

function novoContato(){
	var elListaContatos = document.getElementById('listaContatos');
	var inputContato = document.createElement('input');
	var labelContato = document.createElement('label');
	var br = document.createElement('br');
	var input = document.createElement('input');
	var divLinha = document.createElement('div');

	inputContato.setAttribute('name', 'nomeContato')
	labelContato.innerText = 'Contato: ';

	input.setAttribute('type', 'button');
	input.setAttribute('value', '-');
	input.onclick=function(){
		elListaContatos.removeChild(divLinha);
	}

	divLinha.appendChild(labelContato);
	divLinha.appendChild(inputContato);
	divLinha.appendChild(input);
	divLinha.appendChild(br);

	elListaContatos.appendChild(divLinha);
}

function imprimirDados(){
	//array de inputs
	var arrContatos = document.frmContatos.nomeContato;

	var saidaContatos = document.getElementById('saidaContatos');
	var saida = '';

	//iterando no array
	for (var i = 0; i < arrContatos.length; i++) {
		saida += arrContatos[i].value + '<br />';
	};

	saidaContatos.innerHTML = saida;
}