/**
 * @author Sun yan
 * @param $scope
 * @returns
 */
angular_material.controller('home', function($scope, $state, $mdDialog, $UnitMBHttp) {
	/**
	 * 获取左侧菜单
	 */
	$UnitMBHttp.post('menu/list').success(function(data, status, headers, config){
		$scope.menuList = data.data;
	});
	
	$scope.user = {
		userName:'孙严'	
	};
	/**
	 * 退出系统
	 */
    $scope.signOut = function(event){
		var confirm = $mdDialog.confirm()
			.title('退出系统')
			.textContent('您确定要退出系统吗？')
		    .targetEvent(event)
		    .ok('确定')
			.cancel('取消');
		$mdDialog.show(confirm).then(function() {
			console.log('确定');
		}, function() {
			console.log('取消');
		});
    };
    /**
     * 打开主菜单
     */
    $scope.openChildMenuList = function(event, menu){
    	if($scope.parentMenuId == menu.menuId){
    		$scope.parentMenuId = undefined;
    	}else{
    		$scope.parentMenuId = menu.menuId;
    	}
    };
    /**
     * 点击子菜单
     */
    $scope.clickChildMenu = function(event, index, menu){
    	$state.go('home.doc', {id:menu.menuId});
    };
});