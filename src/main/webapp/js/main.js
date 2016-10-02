
function AutoComplete(cidade){

var xmlhttp = new XMLHttpRequest();
var url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + cidade + "&components=country:br&key=AIzaSyA2V2S8vEIwzutwR027iSSP1MYe6dNv6Eg";

xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        var obj = JSON.parse(this.responseText);
            Lista(obj);
       
    }
};

xmlhttp.open("GET", url, true);
xmlhttp.send();

}

function Lista(obj){
    var out = "<datalist id='cidades'>";
    for(i = 0; i < obj.results.length; i++){
        out += "<option value='" + obj.results[i].address_components[1].long_name + " - " + obj.results[i].address_components[2].short_name + "'>";
    }
    out += "</datalist>";
    
    document.getElementById("id01").innerHTML = out;
}