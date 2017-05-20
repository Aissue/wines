function getXhr(){
	var xhr=null;
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest;
	}else{
		xhr=new ActiveXObject('MicroSoft.XMLHttp');
	}
	return xhr;
}

