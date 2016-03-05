function getXmlHttpRequestObject()
{
var xmlHttp = false;
if (window.XMLHttpRequest)
{
return new XMLHttpRequest(); //To support the browsers IE7+, Firefox, Chrome, Opera, Safari
}
else if(window.ActiveXObject)
{
return new ActiveXObject("Microsoft.XMLHTTP"); // For the browsers IE6, IE5 
}
else
{
alert("Error due to old verion of browser upgrade your browser");
}
}

var xmlhttp = new getXmlHttpRequestObject(); //xmlhttp holds the ajax object
function productEdit(parameter) {
	alert(parameter);
if(xmlhttp) { 

var url ="/reco-webapp/findProduct.do" + "?query=" + parameter;

xmlhttp.open("GET",url,true);
//xmlhttp.onreadystatechange = handleserverCall;

xmlhttp.send(); 
}
}

function handleserverCall() {
if (xmlhttp.readyState == 4) {
if(xmlhttp.status == 200) {
document.innerHTML=xmlhttp.responseText; 
}
else {
	alert(xmlhttp.responseText);
alert("Ajax calling error");
}
}
}
