(function() {
  var app = angular.module('gemStore', []);

app.controller('StoreController',['$http', function($http){
    var store = this;
    store.nombre = '';
    store.sueldo = '';
    store.jsonRemoto = [];
    store.mostrarDatos = false;
    //var x2js = new X2JS(); Se usa para convertir de xml a json

    this.consultar = function(){
    	$http.get('http://localhost:8080/WebService2/rs/service2/angular?nombre='+store.nombre+
    			'&sueldo='+store.sueldo)
        .success(function(data){
      	  store.jsonRemoto = data;
      	  store.mostrarDatos = true;
        });
    }
      
  }]);

})();