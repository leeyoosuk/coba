/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
srtApp.controller('SrtController', 
		function($scope, $http, $window) {
	$scope.daftarSrt = [];

	$scope.ambilDaftarSurat = function() {
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

	$scope.bukaForm = function() {
		$window.location.href = "/form";
	};

	$scope.ubah = function(srt) {
		//console.log("nomer : " + srt.nomer);
                //console.log("tanggal : " + srt.tanggal);
		//console.log("nama : " + srt.nama);
		//console.log("perihal : " + srt.perihal);
		$window.location.href = "/form-edit?nim=" + srt.nomer;
	};

	$scope.hapus = function(srt) {
		//console.log("nomer : " + srt.nomer + " akan dihapus.");
                //console.log("tanggal : " + srt.tanggal);
		//console.log("nama : " + srt.nama);
		//console.log("perihal : " + srt.perihal);
		$http.delete('/hapus-data/' + srt.nim).then(sukses, gagal);

		function sukses(response) {
			$scope.ambilDaftarSurat();			
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.keluar = function() {
		$http.get("/keluar").then(sukses, gagal);

		function sukses(response) {
			$window.location.href = "/";
		}

		function gagal(response) {}
	};

	$scope.ambilDaftarSurat();
});