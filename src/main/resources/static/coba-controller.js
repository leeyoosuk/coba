cobaApp.controller('CobaController', 
	function($scope, $http) {

		$scope.daftarNama = [];

		$scope.tambah = function() {
			$scope.daftarNama.push($scope.nama);
		};

		$scope.ambilData = function() {
			$http.get('/ambil-data').then(sukses, gagal);

			function sukses(response) {
				console.log(response);
				console.log(response.data);
				$scope.user = response.data.nama;
			}

			function gagal(response) {
				console.log(response);
			}
		};
	}
);