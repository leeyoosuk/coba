srtApp.controller('FromController', function($scope, $http, $window){
    $scope.simpan = function(){
        //console.log("nomer" + $scope.srt.nomer);
        //console.log("tanggal" + $scope.srt.tanggal);
        //console.log("nama" + $scope.srt.nama);
        //console.log("perihal" + $scope.srt.perihal);
        $http.post('/tambah data', $scope.srt).then(sukses, gagal);
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