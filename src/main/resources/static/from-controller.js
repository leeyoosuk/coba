mhsApp.controller('FromController', function($scope, $http, $window){
    $scope.simpan = function(){
        //console.log("nim" + $scope.mhs.nim);
        //console.log("nama" + $scope.mhs.nama);
        //console.log("jurusan" + $scope.mhs.jurusan);
        $http.post('/tambah data', $scope.mhs).then(sukses, gagal);
        function sukses(response){
            $window.location.href = "/";    
        };
        function gagal(response){
        console.log(response);    
        };
        
        
    };
    $scope.batal = function(){
        $window.location.href="/";
    };
});