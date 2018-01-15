srtApp.controller('EditController', function($scope, $http, $window) {

	$scope.simpan = function() {
		$http.post('/tambah-data', $scope.srt).then(sukses, gagal);

		function sukses(response) {
			$window.location.href = "/";	
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.batal = function() {
		$window.location.href = "/";
	};

	$scope.init = function() {
		var nomer = $window.location.search.split("=")[1];

		$http.get('/ambil-data-srt/' + nomer).then(sukses, gagal);

		function sukses(response) {
			//console.log(response);
			$scope.srt = response.data;
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.init();

});