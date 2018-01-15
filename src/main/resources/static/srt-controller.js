/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

srtApp.controller('SrtController', function($scope, $http) {
	$scope.daftarSrt = [];

	$scope.ambilDaftarMahasiswa = function() {
		$http.get('/list-surat').then(sukses, gagal);

		function sukses(response) {
			console.log(response);
			console.log(response.data);
			$scope.daftarSrt = response.data;
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.ambilRekamSurat();
});
