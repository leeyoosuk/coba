suratApp.controller('DaftarController',
        function($scope, $http, $window) {

    $scope.daftarSurat = [];
    
    $scope.updateDaftar = function() {
        $http.get('/daftar-surat').then(sukses, gagal);

        function sukses(response) {
            console.log(response.data);
            $scope.daftarSurat = response.data;
        };

        function gagal(response) {};
    };

    $scope.tambah = function() {
        $window.location.href = "/tambah-ui";
    }

    $scope.edit = function(surat) {
        //console.log(surat.nomer);
        //console.log(surat.tanggal);
        //console.log(surat.nama);
        //console.log(surat.perihal);
        $window.location.href = "edit-ui?nomer=" + surat.nomer +
                "&tanggal=" + surat.tanggal + 
                "&nama=" + buku.nama +
                "&perihal=" + surat.perihal ;
    }

    $scope.hapus = function(surat) {
        $http.delete('/api/hapus/' + surat.nomer).then(sukses, gagal);

        function sukses(response) {
            $scope.updateDaftar();        
        }

        function gagal(response) {}
    }

    $scope.updateDaftar();

});