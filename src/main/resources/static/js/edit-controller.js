suratApp.controller('EditController', 
        function($scope, $http, $window) {
    
    $scope.surat = {};

    $scope.init = function() {
        var param = $window.location.search.split("&");
        for(i=0; i<param.length; i++) {
            var data = param[i].split("=");
            console.log(data);
            switch(i) {
                case 0: $scope.surat.nomer = data[1];
                case 1: $scope.surat.tanggal = data[1];
                case 2: $scope.surat.nama = data[1];
                case 3: $scope.surat.perihal = data[1];
            }
        }
    }

    $scope.simpan = function() {
        $http.post("/api/tambah", $scope.surat)
            .then(sukses, gagal);

        function sukses(response) {
            $window.location.href = "/";    
        };

        function gagal(response) {
            console.log(response);
        };
    }

    $scope.batal = function() {
        $window.location.href = "/";
    }

    $scope.init();

});