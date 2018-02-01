/**
 * LoginController
 * @param $scope
 * @returns
 */
angular_material.controller('login', function($scope, $state, $UnitMBHttp) {
	
	$scope.user = {
		userName:'',
		passWord:''
	};
	$scope.isLoading = false;
	/**
	 * 登录事件
	 */
	$scope.login = function(){
		if(!$scope.isLoading){
			$scope.isLoading = true;
			$UnitMBHttp.postFrom('user/login', $scope.user)
			.success(function(data, status, headers, config){
				if(data.data){
					$state.go('home');
				}
			}).error(function(data, status, headers, config){
				console.log(data);
			}).finally(function() {
				$scope.isLoading = false;
	        });
		}
	};
});