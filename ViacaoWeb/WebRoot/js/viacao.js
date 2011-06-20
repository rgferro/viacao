function somenteNumeroLetra(obj,e,numero,letra){
	var tecla=(window.event)?event.keyCode:e.which;
	if (tecla == 13) {
		obj.focus();  obj.select();
		return true
	}
	if(letra){
		if((tecla > 96 && tecla < 123) || (tecla > 64 && tecla < 91)){ 
			return true;
		}
	}
	if(numero){
		if((tecla > 47 && tecla < 58)){ 
			return true;
		}
	}
	if((tecla == 9)) return true;
	if ((tecla == 8)) return true;
	if ((tecla == 0)) return true;
	return false;
}

function formataPlaca(obj,e,menos){
	var tecla=(window.event)?event.keyCode:e.which;
	var teste = obj.value.search("[-]");
	
	if(obj.value.length < 3){
		return somenteNumeroLetra(obj,e,false,true);
	} else
	if(obj.value.length == 3 && teste == -1){
		if((tecla == 9)) return true;
		if ((tecla == 8)) return true;
		if ((tecla == 0)) return true;
		obj.value = obj.value + "-";
		return somenteNumeroLetra(obj,e,true,false);
	} else
	if(obj.value.length > 3){
		if(teste == -1 && tecla == 45){
			return true;
		}
		var cont = 0;
		for(var i=0 ; i < 3; i++){
			if(obj.value.substring(0,3)[i].search("[a-z^A-Z]") < 0){
				cont++;
			}
		}
		if(cont > 4){
			return somenteNumeroLetra(obj,e,false,true);
			
		}else{
			return somenteNumeroLetra(obj,e,true,false);
		}
	} else{
		return false;
	}
}

function somenteNumero(obj,e,ast,virg,ponto){
	var tecla=(window.event)?event.keyCode:e.which;
	if (tecla == 13) {
		obj.focus();  obj.select();
		return true
	}
	if((tecla > 47 && tecla < 58)){ 
		return true;
	}else{
		if((tecla == 9)) return true;
		if ((tecla == 8)) return true;
		if ((tecla == 0)) return true;
		if ((tecla == 42)&&(ast)) return true; //permite asterísco
		if ((tecla == 44)&&(virg)) return true; //permite vírgula
		if ((tecla == 46)&&(ponto)) return true; //permite ponto
		return false;
	}
}